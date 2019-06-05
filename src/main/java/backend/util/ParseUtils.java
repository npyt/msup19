package backend.util;

public class ParseUtils {
    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException ex) {
            return false;
        }
        return true;
    }
}
