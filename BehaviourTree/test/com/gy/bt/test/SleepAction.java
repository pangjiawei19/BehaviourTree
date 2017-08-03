package com.gy.bt.test;

import com.gy.bt.node.action.AbstractActionNode;

public class SleepAction extends AbstractActionNode {

	public Player player;
	
	public SleepAction(Player player) {
		super(SleepAction.class.getSimpleName());
		this.player = player;
	}
	
	@Override
	public boolean tick(Object obj) {
		player.addVitality();
		System.out.println("睡觉，增加体力（饱值：" + player.fullValue + "，体力：" + player.vitality + "）");
		return true;
	}

}
