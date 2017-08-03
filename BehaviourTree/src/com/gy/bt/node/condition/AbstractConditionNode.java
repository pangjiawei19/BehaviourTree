package com.gy.bt.node.condition;

import com.gy.bt.ef.ExternalFunction;

/**
 * 条件节点抽象类
 * @author pangjiawei
 * @date 2017年7月29日 下午1:51:47 
 * @param <T>
 */
public abstract class AbstractConditionNode implements ConditionNode {
	
	/** 用于判断该节点是否满足的外部功能 */
	protected ExternalFunction ef;
	
	public AbstractConditionNode(ExternalFunction ef) {
		this.ef = ef;
	}

}
