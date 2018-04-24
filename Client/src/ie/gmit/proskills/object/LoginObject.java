package ie.gmit.proskills.object;

/**
 * This class is simpy the LoginObject.<br>
 * 
 * @author Cian Gannon
 * @author Danielis Joniškis
 * @author Eddie Eldridge
 */

public class LoginObject {
	
	/**
	 * This Login object checks if the user has logged in successfully.
	 * 
	 */
	public static Boolean login;

	public static Boolean getLogin() {
		return login;
	}

	public static void setLogin(Boolean check) {
		login = check;
	}
}
