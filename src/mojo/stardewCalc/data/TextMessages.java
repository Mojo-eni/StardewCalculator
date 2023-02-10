package mojo.stardewCalc.data;

public class TextMessages {
	private static String season = "Which season? Spring [1], Summer [2], Fall [3],";

	public static String getSeasonMessage() {
		return season;
	}

	private static String plots = "How many growing spots available?";

	public static String getPlotsMessage() {
		return plots;
	}

	private static String day = "What day is it?";

	public static String getDayMessage() {
		return day;
	}
	
	private static String sprinklers = "How many sprinklers of type ";

	public static String getSprinklersMessage(int i) {		
		return sprinklers + (i);
	}

}
