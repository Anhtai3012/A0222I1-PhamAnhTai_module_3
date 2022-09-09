package ss3_array.thuc_hanh;

public class MaxInArray {
    public static void main(String[] args) {
        byte[] numbers = new byte[]{16, 12, 53, 41, 52, 62, 37, 58};
        short max = -10000;
        for(short i : numbers){
            if(max < i){
                max = i;
            }
        }
        System.out.print("NewList number: ");
        for(byte i :numbers){
            System.out.printf("%d\t",i);
        }
        System.out.printf("with max: %d",max);
    }
}
