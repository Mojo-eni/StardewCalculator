package mojo.stardewCalc.data;

import java.util.LinkedHashMap;

public class TableSummer {
	static LinkedHashMap<String, Double> mapProfit = new LinkedHashMap<>();
	static LinkedHashMap<String, Double> mapCost = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> mapDaysToGrow = new LinkedHashMap<>();
	static int[] daysToGrow = {13,14,11,5,12,7,6,8,8,11,4,13,9};
	static double[] profitPerDay = {21, 7.5, 13.5, 11, 14, 5.5, 8.5, 5, -15, 9.5, 4, 27, 18};
	static double[] pricePerItem = {80,150,60,40,80,100,40,50,125,50,10,400,100};
	static double[] profitPerItem = {150,50,25,40,250,140,90,90,80,60,25,750,260};
	static String[] plantNames = {"Blueberries", "Corn", "Hops", "Chili", "Cantaloup", "Poppies", "Radish", "Summer Spangle", "Sunflowers", "Tomato", "Wheat", "Starfruit", "Red Cabbage"};
	
	public static void FillMap() {
		for (int i = 0; i < daysToGrow.length; i++) {
			mapProfit.put(plantNames[i], profitPerItem[i]);
			mapCost.put(plantNames[i], pricePerItem[i]);
			mapDaysToGrow.put(plantNames[i], daysToGrow[i]);
		}
	}
	
	public static LinkedHashMap<String, Double> GetMapProfit(){
		return mapProfit;	
	}
	
	public static LinkedHashMap<String, Double> GetMapCost(){
		return mapCost;	
	}
	
	public static LinkedHashMap<String, Integer> GetMapDaysToGrow() {
		return mapDaysToGrow;
	}
}
