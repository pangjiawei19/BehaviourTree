package com.gy.bt;

import java.util.List;

import com.gy.bt.node.BehaviourTreeNode;
import com.gy.bt.node.composite.RandomSelectorCompositeNode;
import com.gy.bt.node.composite.SelectorCompositeNode;

/**
 * 行为树<p>
 * 该行为树根节点默认采用随机选择节点实现
 * @author pangjiawei
 * @date 2017年8月1日 下午7:43:02
 */
public class BehaviourTree {
	
	/** 根节点 */
	private SelectorCompositeNode root = new RandomSelectorCompositeNode();
	
	public void addNode(BehaviourTreeNode node) {
		root.addNode(node);
	}
	
	public void addNodes(List<BehaviourTreeNode> nodes) {
		for (BehaviourTreeNode node : nodes) {
			this.addNode(node);
		}
	}
	
	/**
	 * 行为树执行一次
	 * @param obj
	 * @return
	 */
	public boolean update(Object obj) {
		//root是一个select节点
		if(root.enter(obj)) {
			return root.tick(obj);
		}
		return false;
	}

}
