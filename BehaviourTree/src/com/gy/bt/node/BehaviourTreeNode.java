package com.gy.bt.node;


/**
 * 行为树节点接口
 * @author pangjiawei
 * @date 2017年7月29日 上午10:53:13
 */
public interface BehaviourTreeNode {
	
	/**
	 * 进入节点
	 * @param obj
	 * @return
	 */
	public boolean enter(Object obj);
	
	/**
	 * 执行完退出节点
	 * @param obj
	 * @return
	 */
	public boolean leave(Object obj);
	
	/**
	 * 节点执行一次
	 * @param obj
	 * @return
	 */
	public boolean tick(Object obj);
	
	/**
	 * 设置父类节点
	 * @param node
	 */
	public void setParent(BehaviourTreeNode node);

}
