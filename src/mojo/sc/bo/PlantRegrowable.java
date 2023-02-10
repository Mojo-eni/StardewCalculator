package mojo.sc.bo;

public class PlantRegrowable extends Plante{

	private int timeToRegrow;
	
	public PlantRegrowable(int id, String name, int timeToGrow, int priceToBuy, int priceToSell, int season) {
		super(id, name, timeToGrow, priceToBuy, priceToSell, season);
		this.setTimeToRegrow(timeToGrow);
	}

	public int getTimeToRegrow() {
		return this.timeToRegrow;
	}
	
	
	public void setTimeToRegrow(int timeToRegrow) {
		this.timeToRegrow = timeToRegrow;
	}

	@Override
	public String toString() {
		return super.toString() + "PlantRegrowable [timeToRegrow=" + timeToRegrow + "]";
	}
}
