package ie.gmit.proskills.object;

public class History {

	private static String[] item;
	private static String[] priceAVG;
	private static String[] date;
	
	
	public static String[] getItem() {
		return item;
	}
	public static String[] getPriceAVG() {
		return priceAVG;
	}
	public static String[] getDate() {
		return date;
	}
	public static void setItem(String[] item) {
		History.item = item;
	}
	public static void setPriceAVG(String[] priceAVG) {
		History.priceAVG = priceAVG;
	}
	public static void setDate(String[] date) {
		History.date = date;
	}
}
