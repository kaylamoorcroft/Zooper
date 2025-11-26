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

    //converts given string to matching location value
    public static Location stringToLocation(String target) {
    	if(target.equals("AFRICA")) {return Location.AFRICA;}
		else if(target.equals("NORTH AMERICA")) {return Location.NORTH_AMERICA;}
		else if(target.equals("SOUTH AMERICA")) {return Location.SOUTH_AMERICA;}
		else if(target.equals("ASIA")) {return Location.ASIA;}
		else if(target.equals("ANTARCTICA")) {return Location.ANTARCTICA;}
		else if(target.equals("AUSTRALIA")) {return Location.AUSTRALIA;}
		else if(target.equals("EUROPE")) {return Location.EUROPE;}
		else if(target.equals("UNKNOWN")) {return Location.UNKNOWN;}
		else {
			System.out.println("Invalid continent entered");
			return Location.UNKNOWN;
		}
    }
}
