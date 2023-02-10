package mojo.stardewCalc.tools;

import java.util.LinkedHashMap;

import mojo.stardewCalc.data.TableRegrow;

public class Calcul {
	//Constantes
	final static int DAYS_IN_SEASON = 28;
	final static int PLOTS_PER_SPRINKLER[] = {4, 8, 24};
	
	
	public static int GetDaysRemaining(int day) {
		int daysRemaining = 0;
		for (int i = day; i < DAYS_IN_SEASON; i++) {
			daysRemaining++;
		}
		return daysRemaining;		
	}
	
	public static int GetNbSprinklerPlots(int[] sprinklerArray) {
		int nbOfPlots = 0;
		for (int i = 0; i < sprinklerArray.length; i++) {
			nbOfPlots += sprinklerArray[i]*PLOTS_PER_SPRINKLER[i];
		}
		return nbOfPlots;
	}
	
	public static int GetHarvestNumber(LinkedHashMap<String, Integer> map,
			String plant, int daysRemaining, int daysOfGrowth) {
		int harvests = daysRemaining/daysOfGrowth;
		return harvests;		
	}
	
	public static int GetHarvestNumberRegrow(LinkedHashMap<String, Integer> map,
			String plant, int daysRemaining, int daysOfGrowth) {
		LinkedHashMap<String, Integer> mapRegrow = TableRegrow.GetMapDaysToGrow();
		//System.out.println("Before calculus, list size : " + mapRegrow.size() + " Plante : " + plant + " days : " + daysRemaining);
		int daysAfterGrowth = daysRemaining-(daysOfGrowth);
		int harvests = daysAfterGrowth/(mapRegrow.get(plant));
		return harvests;		
	}
	
	public static double GetTotalProfitPerCrop(int harvest, double profit, double cost, boolean regrow) {
		double totalProfit = 0;
		if (regrow) {
			totalProfit = (profit-cost)+profit*(harvest-1);
		}else {
			totalProfit = (profit-cost)*harvest;
		}						
		return totalProfit;
	}
	
}
