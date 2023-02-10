package mojo.stardewCalc.main;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import mojo.stardewCalc.tools.Calcul;
import mojo.stardewCalc.tools.Message;
import mojo.stardewCalc.data.TableFall;
import mojo.stardewCalc.data.TableRegrow;
import mojo.stardewCalc.data.TableSpring;
import mojo.stardewCalc.data.TableSummer;
import mojo.stardewCalc.data.TextMessages;

public class DataCollect {

	public static void main(String[] args) {
		// Fill data maps for crops/profit
		TableSpring.FillMap();
		TableFall.FillMap();
		TableSummer.FillMap();
		TableRegrow.FillMap();
		System.out.println(TableRegrow.GetMapDaysToGrow().toString());
		// Open Scanner, launch data collection method then closes Scanner
		Scanner scan = new Scanner(System.in);
		InputData(scan);
		scan.close();
	}

	private static void InputData(Scanner sc) {
		// Constantes

		// Enums
		enum Season {
			Spring, Summer, Fall
		}
		;

		// Variables
		Season season = Season.Spring;
		int seasonInt = 0;
		int[] sprinklersPerLevel = new int[3];
		// int numberOfPlots = 0;
		int numberOfSprinklerPlots = 0;
		int currentDay = 0;
		int daysRemaining = 0;
		// Scan Season
		Message.DebugLog(TextMessages.getSeasonMessage());
		seasonInt = sc.nextInt();
		switch (seasonInt) {
		case 1:
			season = Season.Spring;
			break;
		case 2:
			season = Season.Summer;
			break;
		case 3:
			season = Season.Fall;
			break;
		default:
			InputData(sc);
		}

		// Scan for each Sprinklers type then calls
		for (int i = 0; i < sprinklersPerLevel.length; i++) {
			Message.DebugLog(TextMessages.getSprinklersMessage(i + 1));
			sprinklersPerLevel[i] = sc.nextInt();
		}
		numberOfSprinklerPlots = Calcul.GetNbSprinklerPlots(sprinklersPerLevel);
		System.out.printf("You have %d automated plots \n", numberOfSprinklerPlots);

//		Message.DebugLog(TextMessages.getPlotsMessage());
//		numberOfPlots = sc.nextInt();

		Message.DebugLog(TextMessages.getDayMessage());
		currentDay = sc.nextInt();
		daysRemaining = Calcul.GetDaysRemaining(currentDay);
		System.out.printf("There are %d days left in %s season \n", daysRemaining, season);

		LinkedHashMap<String, Double> mapProfit = null;
		LinkedHashMap<String, Double> mapCost = null;
		LinkedHashMap<String, Integer> mapDays = null;
		switch (season) {
		case Spring:
			mapCost = TableSpring.GetMapCost();
			mapProfit = TableSpring.GetMapProfit();
			mapDays = TableSpring.GetMapDaysToGrow();
			if (currentDay < 11) {
				mapProfit.remove("Strawberries");
				mapDays.remove("Strawberries");				
			}
			break;
		case Summer:
			mapCost = TableSummer.GetMapCost();
			mapProfit = TableSummer.GetMapProfit();
			mapDays = TableSummer.GetMapDaysToGrow();
			break;
		case Fall:
			mapCost = TableFall.GetMapCost();
			mapProfit = TableFall.GetMapProfit();
			mapDays = TableFall.GetMapDaysToGrow();
			break;
		default:
			break;
		}

		System.out.printf("There are %d crops available in %s with profit per crop : \n", mapProfit.size(), season);
		for (Entry<String, Double> entry : mapProfit.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			System.out.println(key + " " + val);
		}

		for (Entry<String, Integer> entry : mapDays.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			boolean isRegrow = TableRegrow.GetMapDaysToGrow().containsKey(key);
			int harvestNumber = Calcul.GetHarvestNumber(mapDays, key, daysRemaining, val);
			if (isRegrow) {
				System.out.printf("With %d days remaining, it's possible to harvest %s %d times \n Total profit will be : %.2f £ \n",
						daysRemaining, 
						key,
						Calcul.GetHarvestNumberRegrow(mapDays, key, daysRemaining, val),
						Calcul.GetTotalProfitPerCrop(Calcul.GetHarvestNumberRegrow(mapDays, key, daysRemaining, val), TableRegrow.GetMapProfit().get(key), TableRegrow.GetMapCost().get(key),true)*numberOfSprinklerPlots);
			} else {
				System.out.printf("With %d days remaining, it's possible to harvest %s %d times \n Total profit will be : %.2f £ \n",
						daysRemaining, 
						key,
						harvestNumber,
						Calcul.GetTotalProfitPerCrop(harvestNumber, mapProfit.get(key), mapCost.get(key),false)*numberOfSprinklerPlots);
			}
		}
	}
}
