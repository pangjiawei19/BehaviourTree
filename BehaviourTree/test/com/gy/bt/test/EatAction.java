package com.gy.bt.test;

import com.gy.bt.node.action.AbstractActionNode;

public class EatAction extends AbstractActionNode {

	public Player player;
	
	public EatAction(Player player) {
		super(EatAction.class.getSimpleName());
		this.player = player;
	}
	
	@Override
	public boolean tick(Object obj) {
		player.eat();
		System.out.println("吃饭，增加饱值（饱值：" + player.fullValue + "，体力：" + player.vitality + "）");
		return true;
	}

}
