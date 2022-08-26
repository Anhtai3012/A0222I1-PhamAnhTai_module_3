package common;

public class Validation {
    private final static String REGEXEMAIL ="(^[a-z]\\w{2,}@gmail.com)$";
    public static boolean checkEmail(String email){
        return email.matches(REGEXEMAIL);
    }
}
