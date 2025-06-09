package utils;

public class ColorUtil 
{

	public static String getColorFromRGBValue(String rgba) {
	    if (rgba == null) return null;
	    
	    rgba = rgba.replaceAll("\\s+", ""); 

	    switch (rgba) {
	        case "rgba(35,35,35,1)":
	            return "DarkGray";
	        case "rgba(35,35,36,1)":
	        case "rgba(0,122,195,1)":
	            return "Blue";
	        case "rgba(255,0,0,1)":
	            return "Red";
	        case "rgba(0,128,0,1)":
	            return "Green";
	        default:
	            return null;
	    }
	}

}

