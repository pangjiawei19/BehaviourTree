package com.gy.bt.node.composite;

import com.gy.bt.node.BehaviourTreeNode;
import com.gy.bt.node.condition.ConditionNode;

/**
 * 组合节点
 * @author pangjiawei
 * @date 2017年7月29日 上午10:53:42
 */
public interface CompositeNode extends BehaviourTreeNode {
	
	/**
	 * 增加子节点
	 * @param node
	 */
	public void addNode(BehaviourTreeNode node);
	/**
	 * 移除子节点
	 * @param node
	 */
	public void removeNode(BehaviourTreeNode node);
	
	/**
	 * 增加条件节点
	 * @param condition
	 */
	public void addCondition(ConditionNode condition);
	/**
	 * 移除条件节点
	 * @param condition
	 */
	public void removeCondition(ConditionNode condition);

}
