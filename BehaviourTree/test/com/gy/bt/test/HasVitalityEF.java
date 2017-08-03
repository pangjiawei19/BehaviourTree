package com.gy.bt.test;

import com.gy.bt.ef.ExternalFunction;

public class HasVitalityEF implements ExternalFunction {

	public Player player;
	
	public HasVitalityEF(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean func() {
		return player.hasVitality();
	}

}
