package src;
public enum Location {
    AFRICA(1), NORTH_AMERICA(2), SOUTH_AMERICA(3), ASIA(4), AUSTRALIA(5), EUROPE(6), ANTARCTICA(7), UNKNOWN(8);
    private final int locationNumber; 

    Location(int locationNumber) {
        this.locationNumber = locationNumber; // associate int value with enum
    }

    // convert Location to int
    public int getLocationNumber() {
        return locationNumber;
    }
    // convert Location to String
    public String toString() {
        return tagToString(this.name());
    }
    // convert int to Location
    public static Location getLocation(int intValue) {
        for (Location loc : Location.values()) {
            if (loc.locationNumber == intValue) {
                return loc;
            }
        }
        throw new IllegalArgumentException("No Location with number " + intValue);
    }

    // helper functions for string manipulation
    
    private String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    private String tagToString(String tag) {
        String[] words = tag.split("_");
        String result = "";
        for (String w : words) {
            result += toTitleCase(w) + " ";
        }
        return result;
    }
}
