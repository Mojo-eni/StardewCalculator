package mojo.stardewCalc.data;

import java.util.LinkedHashMap;

public class TableSpring {
	static LinkedHashMap<String, Double> mapCost = new LinkedHashMap<>();
	static LinkedHashMap<String, Double> mapProfit = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> mapDaysToGrow = new LinkedHashMap<>();
	static int[] daysToGrow = {4,6,7,12,6,6,10,6,8,13,4};
	static double[] profitPerDay = {3.75, 8.33, 2.86, 7.62, 6.67, 1.67, 6.67, -1.67, 11.67, 9.23, 5};
	static double[] pricePerItem = {20, 50, 30, 80, 70, 20, 60, 40, 100, 100, 40};
	static double[] profitPerItem = {35,80*1.25,50,175,110,30,40,30,120*1.02,220,60};
	static String[] plantNames = {"Parsnip", "Potato", "Blue Jazz", "Cauliflower", "Kale", "Tulip", "Peas", "Rice", "Strawberries", "Rhubarb", "Garlic"};
	
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
	
	public static LinkedHashMap<String, Integer> GetMapDaysToGrow() {
		return mapDaysToGrow;
	}
	
	public static LinkedHashMap<String, Double> GetMapCost(){
		return mapCost;	
	}
}
