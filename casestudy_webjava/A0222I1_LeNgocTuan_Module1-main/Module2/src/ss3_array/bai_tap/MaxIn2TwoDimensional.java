package ss3_array.bai_tap;

public class MaxIn2TwoDimensional {
    public static int findMaxInNums(int[][] nums){
        int MAX = -19999;
        for(int i = 0; i< nums.length; i++){
            for(int value: nums[i]){
                if( MAX < value){
                    MAX = value;
                }
            }
        }
        return MAX;
    }
    public static void main(String[] args) {
        int[][] numbers = {
                {11, 112, 15, 14, 16},
                {44, 21, 42, 32, 41},
                {8, 34, 64, 21, 53}
        };
        System.out.printf("MAX in number: %d",findMaxInNums(numbers));
    }
}
