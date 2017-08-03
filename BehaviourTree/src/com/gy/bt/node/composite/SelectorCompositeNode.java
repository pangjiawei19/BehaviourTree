package com.gy.bt.node.composite;

import com.gy.bt.node.BehaviourTreeNode;

/**
 * 选择节点<p>
 * 该节点会从左到右的依次执行其子节点，只要子节点返回“失败”，就继续执行后面的节点，直到有一个节点返回“成功”时，会停止后续节点的运行，
 * 并且向父节点返回“成功”，如果所有子节点都返回“失败”则向父节点返回“失败”。
 * @author pangjiawei
 * @date 2017年7月29日 下午2:35:48
 */
public class SelectorCompositeNode extends AbstractCompositeNode {

	public SelectorCompositeNode() {
		this(SelectorCompositeNode.class.getSimpleName());
	}
	
	public SelectorCompositeNode(String name) {
		super(name);
	}


	@Override
	public boolean enter(Object obj) {
		
		//检查子节点数和所有条件子节点
		boolean check = this.checkNodeAndCondition();
		if(!check) {
			this.leave(obj);
			return false;
		}
		
		//从当前子节点开始循环遍历所有子节点
		do {
			BehaviourTreeNode node = this.getCurNode();
			check = node.enter(obj);
			if(check) {
				//遇到准备成功的子节点，进入成功，跳出返回
				break;
			}
			this.curNodeIndex ++;
			if(this.curNodeIndex >= this.nodes.size()) {
				//遍历所有子节点均没有准备成功，返回失败
				this.leave(obj);
				return false;
			}
		} while (!check);
		
		return true;
	}


	@Override
	public boolean exec(Object obj) {
		try {
			
			BehaviourTreeNode runningNode = this.getCurNode();//获得当前子节点
			boolean rst = runningNode.tick(obj);//子节点执行
			if(rst) {//当前子节点tick成功，停止向后执行，返回true
				return true;
			}else {//当前子节点tick失败，向后执行，找下一个，递归调用
				runningNode.leave(obj);
				int count = 1000;
				while(count-- > 0) {//循环找到可以成功进入的子节点，防止死循环
					this.curNodeIndex ++;
					if(this.curNodeIndex >= this.nodes.size()) {
						//该节点的子节点已经遍历完，没有找到成功的子节点，返回false
						return false;
					}
					BehaviourTreeNode nextNode = this.getCurNode();
					boolean check = nextNode.enter(obj);
					if(check) {//下一个子节点进入成功，停止开始执行
						break;
					}
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
