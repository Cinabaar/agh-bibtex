package pl.edu.agh.toik.aghbibtex.util;

public class StringUtil {
	
	public static String capitalizeFirstLetter(String original){
	    if(original.length() == 0)
	        return original;
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	public static String lowerFirstLetter(String original){
	    if(original.length() == 0)
	        return original;
	    return original.substring(0, 1).toLowerCase() + original.substring(1);
	}
}
