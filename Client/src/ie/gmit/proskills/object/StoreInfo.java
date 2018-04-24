package ie.gmit.proskills.object;

public class StoreInfo {

	private static double ebayAVG;
	private static double doneDealAVG;

	public static String getEbayAVG() {
		return Double.toString(ebayAVG);
	}

	public static String getDoneDealAVG() {
		return Double.toString(doneDealAVG);
	}

	public static void setEbayAVG(double ebayAVGSet) {
		ebayAVG += ebayAVGSet;
	}

	public void setDoneDealAVG(double doneDealAVGSet) {
		doneDealAVG += doneDealAVGSet;
	}
}
