package com.gy.bt.node.composite;

import com.gy.bt.node.BehaviourTreeNode;

/**
 * 顺序节点<p>
 * 该节点会从左到右的依次执行其子节点，只要子节点返回“成功”，就继续执行后面的节点，
 * 直到有一个节点返回“失败”时，会停止后续节点的运行，并且向父节点返回“失败”，
 * 如果所有子节点都返回“成功”则向父节点返回“成功”。
 * @author pangjiawei
 * @date 2017年8月1日 下午5:58:19
 */
public class SequenceCompositeNode extends AbstractCompositeNode {

	public SequenceCompositeNode() {
		super(SequenceCompositeNode.class.getSimpleName());
	}


	@Override
	public boolean enter(Object obj) {
		//检查子节点数和所有条件节点
		boolean check = this.checkNodeAndCondition();
		if(!check) {
			this.leave(obj);
			return false;
		}
		
		//仅尝试进入当前子节点，如果进入失败，则表示这个顺序节点执行失败，直接返回
		BehaviourTreeNode node = this.getCurNode();
		check = node.enter(obj);
		if(!check) {
			this.leave(obj);
			return false;
		}
		
		//当前子节点进入成功，则需要准备好开始运行
		return true;
	}


	@Override
	public boolean exec(Object obj) {
		try {
			BehaviourTreeNode runningNode = this.getCurNode();//获得当前子节点
			boolean rst = runningNode.tick(obj);//子节点执行
			if(!rst) {//当前子节点tick失败，停止向后继续执行，返回false
				return false;
			}else {//当前子节点tick成功，向后执行，找下一个，递归调用
				runningNode.leave(obj);
				
				this.curNodeIndex ++;
				if(this.curNodeIndex >= this.nodes.size()) {
					//该节点的子节点已经遍历完，没有找到失败的子节点，返回true
					return true;
				}
				BehaviourTreeNode nextNode = this.getCurNode();
				boolean check = nextNode.enter(obj);
				if(!check) {//下一个子节点进入失败，停止向后继续执行，返回false
					return false;
				}
				
				//递归调用
				boolean result = this.exec(obj);
				return result;
			}
		} finally {
			//本次执行结束，需要退出节点，无论结果如何
			this.leave(obj);
		}
	}
	

}
