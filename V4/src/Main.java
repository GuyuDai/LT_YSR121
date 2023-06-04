import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] arr= {1,2,3,4,5,6,7,8,9};
        //System.out.println(Arrays.toString(Main.filter(arr, 3)));
        System.out.println(Arrays.deepToString(hui(5)));
    }

    public static int[] filter(int[] input, int n){  //以数组的形式输出input中为能整除n的数
        //使用取余 '%' : 7%3 = 1, 9%3 = 0
        int counter = 0;
        for(int i : input){
            if(i%n == 0){
                counter++;
            }
        }
        int[] result = new int[counter];
        int index = 0;
        for(int i : input){
            if(i%n == 0){
               result[index] = i;
               index++;
            }
        }
        return result;
    }

    public static int[][] hui(int length){
        int[][] result = new int[length][length];
        int bound = length*length;
        int number = 1;
        String direction = "right";
        int i = 0;  //纵轴
        int j = 0;  //横轴
        // int[i][j]
        while (number <= bound){
            switch (direction){
                case "right":
                    if(j < length && result[i][j] == 0){  //判断方向，边界，填没填
                        result[i][j] = number;
                        number++;
                        j++;
                        if(j >= length){
                            direction = "down";
                            j--;  // 防止越界
                        }
                    }
                    break;
                case "down":
                    if(i < length && result[i][j] == 0){
                        result[i][j] = number;
                        number++;
                        i++;
                        if(i >= length){
                            direction = "left";
                            i--;
                        }
                    }
                    break;
                case "left":
                    if(j >= 0 && result[i][j] == 0){
                        result[i][j] = number;
                        number++;
                        j--;
                        if(j < 0){
                            direction = "up";
                            j++;
                        }
                    }
                    break;
                case "up":
                    if(i >= 0 && result[i][j] == 0){
                        result[i][j] = number;
                        number++;
                        i--;
                        if(i < 0){
                            direction = "right";
                            i++;
                        }
                    }
            }
        }
        return result;
    }
}