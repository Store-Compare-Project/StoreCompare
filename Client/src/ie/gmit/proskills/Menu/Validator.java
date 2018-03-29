package ie.gmit.proskills.Menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	// Variables
	private static Pattern pattern;
	private static Matcher matcher;
	  
	// RegEx 
    private static final String USERNAME_PATTERN = "^[a-z0-9_@.]{3,15}$";

    /**
	   * Validate username with regular expression
	   * @param username username for validation
	   * @return true valid username, false invalid username
	   */
	  public static boolean validateUsername(String username){
		  
		  // Deubg
		  System.out.println("Inside validate function");
		  
		  pattern = Pattern.compile(USERNAME_PATTERN);

		  matcher = pattern.matcher(username);
		  return matcher.matches();
	    	    
	  }
}
