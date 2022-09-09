package common;

public class validate {
    public static final String REGEX_STR = "^[a-zA-Z\\s\\W|_]+$";
    public static final String REGEX_VILLA = "^(SVVL)-\\d{4}$";
    public static final String REGEX_HOUSE = "^(SVHO)-\\d{4}$";
    public static final String REGEX_ROOM = "^(SVRO)-\\d{4}$";
    public static final String REGEX_AREA = "^([3-9][0-9]\\.*\\d*|\\d{3,}\\.*\\d*)$";
    public static final String REGEX_RENTALCOSTS = "^\\d+\\.*\\d*$";
    public static final String REGEX_MAXPEOPLE = "^([1-9]|1[0-9])$";
    public static final String REGEX_FLOORS = "^\\d+$";
    public static final String REGEX_PHONE_NUMBER = "^(\\+84|0)\\d{9}$";
    public static final String REGEX_EMAIL = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com$";
    public static final String REGEX_BIRTHDAY = "^([0-2][0-9]|3[0|1])\\/(0[1-9]|1[0-2])\\/\\d{4}$";
    public static final String REGEX_NUMBERDOUBLE = "^\\d+\\.*\\d*$";
    public static final String REGEX_NUMBER = "^\\d+$";
    public boolean check_birthday(String birthday){
        return birthday.matches(REGEX_BIRTHDAY);
    }
}
