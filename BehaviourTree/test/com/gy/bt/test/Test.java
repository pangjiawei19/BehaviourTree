package com.gy.bt.test;

import com.gy.bt.BehaviourTree;
import com.gy.bt.ef.ExternalFunction;
import com.gy.bt.node.composite.CompositeNode;
import com.gy.bt.node.composite.SelectorCompositeNode;
import com.gy.bt.node.composite.SequenceCompositeNode;
import com.gy.bt.node.condition.ConditionNode;
import com.gy.bt.node.condition.PreNotConditionNode;
import com.gy.bt.node.condition.PreOkConditionNode;

public class Test {
	
public static void main(String[] args) {
		
		Player player = new Player();
		player.vitality = 30;
		player.fullValue = 0;
		
		ExternalFunction hasVitalityEF = new HasVitalityEF(player);
		ExternalFunction hungryEF = new HungryEF(player);
		
		ConditionNode hv = new PreOkConditionNode(hasVitalityEF);
		ConditionNode nhv = new PreNotConditionNode(hasVitalityEF);
		
		ConditionNode hg = new PreOkConditionNode(hungryEF);
//		ConditionNode nhg = new PreNotConditionNode(hungryEF);
		
		CompositeNode sleep = new SelectorCompositeNode();
		sleep.addCondition(nhv);
		sleep.addNode(new SleepAction(player));
		
		CompositeNode run = new SelectorCompositeNode();
		run.addCondition(hv);
		run.addNode(new RunAction(player));
		
		CompositeNode eat = new SequenceCompositeNode();
		eat.addCondition(hv);
		eat.addCondition(hg);
		eat.addNode(new EatAction(player));
		eat.addNode(new HiccupAction(player));
		
		
		BehaviourTree bt = new BehaviourTree();
		bt.addNode(sleep);
		bt.addNode(run);
		bt.addNode(eat);
		
		
		while(true) {
			
			bt.update(null);
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
