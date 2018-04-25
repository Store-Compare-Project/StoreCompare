package ie.gmit.proskills.Processes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	// Variables
	private static Pattern pattern;
	private static Matcher matcher;
	  
	// RegEx Patterns
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*${3,15}$";
    private static final String PASSWORD_PATTERN = "^[^\\s]+$";


       /**
	   * Validate username with regular expression
	   * @param username username for validation
	   * @return true valid username, false invalid username
	   */
	  public static boolean validateUsername(String username)
	  {
		  
		  // Deubg
		  //System.out.println("Inside validate function");
		  
		  pattern = Pattern.compile(USERNAME_PATTERN);

		  matcher = pattern.matcher(username);
		  return matcher.matches();
	    	    
	  }
	  
	  
	   /**
	    * Validate password with regular expression
		   * @param  password for validation
		   * @return true valid password, false invalid password
		   */
		  public static boolean validatePassword(String password)
		  {
			  
			  // Deubg
			  //System.out.println("Inside validate function");
			  
			  pattern = Pattern.compile(PASSWORD_PATTERN);

			  matcher = pattern.matcher(password);
			  return matcher.matches();	    	    
		  }
}
