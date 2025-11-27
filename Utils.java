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
}
