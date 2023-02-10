package mojo.stardewCalc.data;

import java.util.LinkedHashMap;

public class TableRegrow {
	static LinkedHashMap<String, Double> mapCost = new LinkedHashMap<>();
	static LinkedHashMap<String, Double> mapProfit = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> mapDaysToGrow = new LinkedHashMap<>();
	static int[] daysToGrow = {4,4,1,3,3,4,5,5,3};
	static double[] profitPerDay = {21, 7.5, 13.5, 11, 14, 5.5, 8.5, 5, -15, 9.5, 4, 27, 18};
	static double[] profitPerItem = {150,50,25,40,40,120*1.02,2*75,60,80};
	static double[] pricePerItem = {80,150,60,40,60,100,240,20,60};
	static String[] plantNames = {"Blueberries", "Corn", "Hops", "Chili", "Peas", "Strawberries", "Cranberries", "Eggplant", "Grapes"};
	
	public static void FillMap() {
		for (int i = 0; i < daysToGrow.length; i++) {
			mapProfit.put(plantNames[i], profitPerDay[i]);
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
