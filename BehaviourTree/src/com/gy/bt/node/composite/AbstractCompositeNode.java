package com.gy.bt.node.composite;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gy.bt.node.BaseNode;
import com.gy.bt.node.BehaviourTreeNode;
import com.gy.bt.node.condition.ConditionNode;

/**
 * 组合节点抽象类
 * @author pangjiawei
 * @date 2017年7月29日 上午11:54:28 
 * @param <T>
 */
public abstract class AbstractCompositeNode extends BaseNode implements CompositeNode {
	
	protected final static Logger log = LoggerFactory.getLogger(AbstractCompositeNode.class);

	protected List<BehaviourTreeNode> nodes = new ArrayList<>();
	protected List<ConditionNode> conditions = new ArrayList<>();
	protected int curNodeIndex = 0;
	
	public AbstractCompositeNode(String name) {
		super(name);
	}
	
	/**
	 * 检查子节点数据是否正确，条件是否全部达成
	 * @return
	 */
	protected boolean checkNodeAndCondition() {
		if(nodes.size() < 1) {
			log.error(this.name + " has no nodes!");
			return false;
		}
		return this.checkCondition();
	}
	
	public static void main(String[] args) {
		AbstractCompositeNode node = new SequenceCompositeNode();
		node.checkNodeAndCondition();
	}
	
	/**
	 * 检查所有条件节点是否达成
	 * @return
	 */
	protected boolean checkCondition() {
		for (ConditionNode con : conditions) {
			if(!con.isCondition()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 获得当前处理的节点
	 * @return
	 */
	protected BehaviourTreeNode getCurNode() {
		return this.nodes.get(this.curNodeIndex);
	}
	
	

	@Override
	public void setParent(BehaviourTreeNode node) {
		this.parent = node;
	}

	@Override
	public void addNode(BehaviourTreeNode node) {
		node.setParent(this);
		this.nodes.add(node);
	}

	@Override
	public void removeNode(BehaviourTreeNode node) {
		this.nodes.remove(node);
	}

	@Override
	public void addCondition(ConditionNode condition) {
		this.conditions.add(condition);
	}

	@Override
	public void removeCondition(ConditionNode condition) {
		this.conditions.remove(condition);
	}

	@Override
	public boolean leave(Object obj) {
//		BehaviourTreeNode node = this.nodes.get(this.curNodeIndex);
//		node.leave(obj);
		this.curNodeIndex = 0;
		return true;
	}
	
	@Override
	public boolean tick(Object obj) {
		boolean check = this.checkCondition();//检查所有条件，失败则退出并返回false
		if(!check) {
			this.leave(obj);
			return false;
		}
		
		return this.exec(obj);
	}
	
	/**
	 * 条件判断完成后执行子节点逻辑
	 * @param obj
	 * @return
	 */
	public abstract boolean exec(Object obj);
	
}
