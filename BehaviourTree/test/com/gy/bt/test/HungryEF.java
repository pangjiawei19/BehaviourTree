package com.gy.bt.test;

import com.gy.bt.ef.ExternalFunction;

public class HungryEF implements ExternalFunction {

	public Player player;
	
	public HungryEF(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean func() {
		return !player.hasFullValue();
	}

}
