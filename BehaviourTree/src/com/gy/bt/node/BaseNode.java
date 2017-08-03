package com.gy.bt.node;

import com.gy.bt.state.RunState;

/**
 * 节点基础类
 * @author pangjiawei
 * @date 2017年7月29日 下午1:28:23
 */
public class BaseNode {

	/** 节点名 */
	protected String name;
	/** 节点状态（暂时不用） */
	protected RunState state = RunState.Completed;
	/** 父节点 */
	protected BehaviourTreeNode parent;
	
	
	public BaseNode(String name) {
		this.name = name;
	}
}
