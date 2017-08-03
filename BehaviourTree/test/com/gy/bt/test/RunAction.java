package com.gy.bt.test;

import com.gy.bt.node.action.AbstractActionNode;

public class RunAction extends AbstractActionNode {

	
	public Player player;
	
	public RunAction(Player player) {
		super(RunAction.class.getSimpleName());
		this.player = player;
	}
	
	@Override
	public boolean tick(Object obj) {
		player.decVitality();
		player.decFullValue();
		System.out.println("跑步，消耗体力&饱值（饱值：" + player.fullValue + "，体力：" + player.vitality + "）");
		return true;
	}

}
