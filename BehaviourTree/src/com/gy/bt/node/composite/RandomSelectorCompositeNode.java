package com.gy.bt.node.composite;

import java.util.Collections;

/**
 * 随机选择节点<p>
 * 选择节点是有优先级顺序的，而随机选择节点的执行顺序是随机的。
 * 但每个节点只会执行一次，比如包含子节点：A、B、C、D、E；使用随机选择节点，执行顺序可能是：D、E、A、C、B或其他组合。其它规则同选择节点一致。
 * @author pangjiawei
 * @date 2017年8月1日 下午7:41:06
 */
public class RandomSelectorCompositeNode extends SelectorCompositeNode {

	public RandomSelectorCompositeNode() {
		super(RandomSelectorCompositeNode.class.getSimpleName());
	}

	@Override
	public boolean enter(Object obj) {
		Collections.shuffle(this.nodes);//每次进入节点时打乱子节点顺序
		return super.enter(obj);
	}

	
	
}
