package codecheck;

import java.util.ArrayList;

public class SummonList {
	ArrayList<Summon> summonList = new ArrayList<>();
	int allPower = 0;
	int allCost = 0;

	public int getAllPower() {
		return allPower;
	}

	public int getAllCost() {
		return allCost;
	}

	public void setSummon(Summon tmp) {
		this.summonList.add(tmp);
		allPower = allPower + tmp.getPower();
		allCost = allCost + tmp.getCost();
	}
}
