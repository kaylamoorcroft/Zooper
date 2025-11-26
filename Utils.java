public abstract class Utils {
    public static String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    public static String tagToString(String tag) {
        String[] words = tag.split("_");
        String result = "";
        for (String w : words) {
            result += toTitleCase(w) + " ";
        }
        return result;
    }

    //converts given int to matching location value
    public static Location intToLocation(int target) {
    	if(target == 1) {return Location.AFRICA;}
		else if(target == 2) {return Location.ANTARCTICA;}
		else if(target == 3) {return Location.ASIA;}
		else if(target == 4) {return Location.AUSTRALIA;}
		else if(target == 5) {return Location.EUROPE;}
		else if(target == 6) {return Location.NORTH_AMERICA;}
		else if(target == 7) {return Location.SOUTH_AMERICA;}
		else if(target == 8) {return Location.UNKNOWN;}
		else {
			System.out.println("Invalid continent entered");
			return Location.UNKNOWN;
		}
    }
}
