package ie.StoreCompare.storage;

public class ConsoleChoice {

	public enum Sony {
		PS2, PS3, PS4, PSP, PSV
	}

	Sony sChoice;
	
	public ConsoleChoice(Sony sChoice) {
        this.sChoice = sChoice;
    }
	
	public int SonyChoice() {
        switch (sChoice) {
			case PS2:
				return 403; // PS2 Games store code
			        
			case PS3:
				return 403; // PS2 Games store code
			             
			case PS4:
				System.out.println("PS4");
				break;
			    
			case PSP:
				System.out.println("PSP");
				break;
				
			case PSV:
				System.out.println("PSV");
				break;
                        
            default:
                System.out.println("Not valid option");
                break;
        }
		return 0;
    }
	
	public static int main() {
		ConsoleChoice PS2 = new ConsoleChoice(Sony.PS2);
		return PS2.SonyChoice();
	}
}
