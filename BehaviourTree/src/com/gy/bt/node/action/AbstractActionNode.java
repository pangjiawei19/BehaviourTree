package com.gy.bt.node.action;

import com.gy.bt.node.BaseNode;
import com.gy.bt.node.BehaviourTreeNode;

/**
 * 行为节点抽象类
 * @author pangjiawei
 * @date 2017年8月1日 下午5:44:27
 */
public abstract class AbstractActionNode extends BaseNode implements ActionNode {

	public AbstractActionNode(String name) {
		super(name);
	}

	@Override
	public boolean enter(Object obj) {
		return true;
	}

	@Override
	public boolean leave(Object obj) {
		return true;
	}

	@Override
	public void setParent(BehaviourTreeNode node) {
		this.parent = node;
	}
	
}
