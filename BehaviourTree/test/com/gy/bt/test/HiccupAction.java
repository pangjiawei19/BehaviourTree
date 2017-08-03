package com.gy.bt.test;

import com.gy.bt.node.action.AbstractActionNode;

public class HiccupAction extends AbstractActionNode {

	public Player player;
	
	public HiccupAction(Player player) {
		super(HiccupAction.class.getSimpleName());
		this.player = player;
	}
	
	@Override
	public boolean tick(Object obj) {
		System.out.println("打个嗝 ~~~~~~~~~~~~");
		return true;
	}

}
