package ie.gmit.proskills.object;

/**
 * This class handles the users search history.<br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */
public class History {

	
	private static String history;

	public static String getHistory() {
		return history;
	}

	public static void setHistory(String history) {
		History.history = history;
	}
}
