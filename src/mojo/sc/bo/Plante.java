package mojo.sc.bo;

public class Plante {
	protected int id;
	protected String name;
	protected int timeToGrow;
	protected int priceToBuy;
	protected int priceToSell;
	protected int season;
	
	public Plante(int id, String name, int timeToGrow, int priceToBuy, int priceToSell, int season) {
		this.setId(id);
		this.setName(name);
		this.setPriceToBuy(priceToBuy);
		this.setPriceToSell(priceToSell);
		this.setTimeToGrow(timeToGrow);
		this.setSeason(season);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getTimeToGrow() {
		return timeToGrow;
	}

	public int getPriceToBuy() {
		return priceToBuy;
	}

	public int getPriceToSell() {
		return priceToSell;
	}

	public int getSeason() {
		return season;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}

	public void setTimeToGrow(int timeToGrow) {
		this.timeToGrow = timeToGrow;
	}

	public void setPriceToBuy(int priceToBuy) {
		this.priceToBuy = priceToBuy;
	}

	public void setPriceToSell(int priceToSell) {
		this.priceToSell = priceToSell;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "\nPlante [id=" + id + ", name=" + name + ", timeToGrow=" + timeToGrow + ", priceToBuy=" + priceToBuy
				+ ", priceToSell=" + priceToSell + ", season=" + season + "]";
	}		
	
	
}
