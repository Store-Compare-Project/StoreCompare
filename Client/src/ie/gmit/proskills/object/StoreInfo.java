package ie.gmit.proskills.object;

public class StoreInfo {

	private static String ebayAVG = "";
	private static String doneDealAVG = "";
	private static String neweggAVG = "";

	public static String getEbayAVG() {
		
		if(ebayAVG.isEmpty()){
			ebayAVG = "0.00";
		}
		
		return ebayAVG;
	}

	public static String getDoneDealAVG() {
		
		if(doneDealAVG.isEmpty()){
			doneDealAVG = "0.00";
		}
		
		return doneDealAVG;
	}

	public static String getNeweggAVG() {
		
		if(neweggAVG.isEmpty()){
			neweggAVG = "0.00";
		}
		
		return neweggAVG;
	}
	
	public static void setEbayAVG(String ebayAVGSet) {
		ebayAVG = ebayAVGSet;
	}

	public static void setDoneDealAVG(String doneDealAVGSet) {
		doneDealAVG = doneDealAVGSet;
	}

	public static void setNeweggAvg(String neweggAVGSet) {
		neweggAVG = neweggAVGSet;		
	}
}
