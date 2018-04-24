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

	public void setEbayAVG(double ebayAVG) {
		this.ebayAVG += ebayAVG;
	}

	public void setDoneDealAVG(double doneDealAVG) {
		this.doneDealAVG += doneDealAVG;
	}
}
