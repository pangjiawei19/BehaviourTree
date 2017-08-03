package com.gy.bt.node.condition;

import com.gy.bt.ef.ExternalFunction;

/**
 * 前置条件不满足条件节点
 * @author pangjiawei
 * @date 2017年7月29日 下午2:05:08
 */
public class PreNotConditionNode extends AbstractConditionNode {
	
	public PreNotConditionNode(ExternalFunction ef) {
		super(ef);
	}

	@Override
	public boolean isCondition() {
		if(this.ef == null) {
			return false;
		}
		return !this.ef.func();
	}

}
