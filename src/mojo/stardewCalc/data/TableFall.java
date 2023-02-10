package mojo.stardewCalc.data;

import java.util.LinkedHashMap;

public class TableFall {
	static LinkedHashMap<String, Double> mapCost = new LinkedHashMap<>();
	static LinkedHashMap<String, Double> mapProfit = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> mapDaysToGrow = new LinkedHashMap<>();
	static int[] daysToGrow = {7,4,12,13,8,4,10,14,7,5,10,6,8};
	static double[] profitPerDay = {11.5, 7.5, 7.5, 17, -15, 3.75, 10, 2, 19, 11, 16, 13.5, 16.5};
	static double[] profitPerItem = {150,80,290,320,80,25,160,50,150,60,80,100,160};
	static double[] pricePerItem = {70,50,200,100,200,10,60,150,240,20,60,20,30};
	static String[] plantNames = {"Amaranth", "Bok Choy", "Fairy Rose", "Pumpkin", "Sunflower", "Wheat", "Sweet Potato", "Corn", "Cranberries", "Eggplant", "Grapes", "Beetroot", "Artichoke"};
	
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
	
	public static LinkedHashMap<String, Double> GetMapCost(){
		return mapCost;	
	}
	
	public static LinkedHashMap<String, Integer> GetMapDaysToGrow() {
		return mapDaysToGrow;
	}
}
