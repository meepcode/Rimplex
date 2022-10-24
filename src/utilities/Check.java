package utilities;

import java.util.List;

/**
 * A utility class that performs checks of various kinds.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class Check
{
  /**
   * Check to see if an array of String objects contains a particular
   * String.
   * 
   * @param haystack  The array of String objects to search through
   * @param needle The String object to search for
   * @return true if haystack contains needle; false otherwise
   */
  public static boolean forContains(final String[] haystack, final String needle)
  {
    if (haystack == null) return false;

    for (int i=0; i<haystack.length; i++)
    {
      if (haystack[i].equals(needle)) return true;
    }
    return false;
  }
  
  /**
   * Step 36
   * 
<<<<<<< HEAD* 
   * Check to see if an list of String objects contains a particular
   * String.
   * 
   * 
   * @param haystack  The array of String objects to search through
   * @param s The String object to search for
   * @return true if haystack contains needle; false otherwise
   */
  public static boolean forContainsIgnoresCase(List<String> haystack, String s) {
	  if (haystack == null) return false;

	    for (int i=0; i<haystack.size(); i++)
	    {
	      if (haystack.get(i).equalsIgnoreCase(s)) return true;
	    }
	    return false;
  }
  /*
   * Frank Step 37.
   * @param it Iterable<String>
   * @param s String 
   * @return true or false
   */
  public static boolean forContains(final Iterable<String> it, final String s) {
	  for (String word : it) {
		  if (word.equals(s)) {
			  return true;
		  }
	  }
	  return false;
//>>>>>>> branch 'main' of https://github.com/bernstdh/F22TeamD
  }
}
