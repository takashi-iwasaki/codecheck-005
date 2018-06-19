package codecheck;

public class Summon {
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	int power;
	int cost;

	public double getPaformance() {
		return  power/cost;
	}

}
