package ss3_array.bai_tap;

import java.util.Scanner;

public class CountCharacter {
//        public static int countCharacterInString(String text.txt, String target){
//        int count = 0;
//        String[] newString = text.txt.split("");
//        for (String i: newString){
//            if(i.toLowerCase().equals(target.toLowerCase())){
//                count++;
//            }
//        }
//        return count;
//    }

    public static int countCharacterInString(String text, char target) {
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your text.txt: ");
        String text = scanner.nextLine();
        System.out.print("Input character: ");
        char value = scanner.nextLine().charAt(0);
        System.out.printf("%s has %d in %s", value, countCharacterInString(text, value), text);
    }
}
