import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] arr= {1,2,3,4,5,6,7,8,9};
        //System.out.println(Arrays.toString(Main.filter(arr, 3)));
        int[][] result1 = hui(5);
        printHui(result1);
        System.out.println("-------------------我是分割线-------------------");
        int[][] result2 = hui(6);
        printHui(result2);
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

            if(direction.equals("right") && j < length && result[i][j] == 0){  // 填充数字的条件
            //判断方向，边界，填没填
                result[i][j] = number;  //填充数字
                number++;  //数字递增
                j++;  //指针移动
                if(j >= length || result[i][j] != 0){  // 切换到下一个方向的条件
                // j>= length是为了防止index out of bound导致外层if语句中result[][]报错
                    direction = "down";
                    j--;  // 防止越界
                    i++;  // 换到下一行
                }
            }

            if(direction.equals("down") && i < length && result[i][j] == 0){
                result[i][j] = number;
                number++;
                i++;
                if(i >= length || result[i][j] != 0){
                    direction = "left";
                    i--;
                    j--;
                }
            }

            if(direction.equals("left") && j >= 0 && result[i][j] == 0){
                result[i][j] = number;
                number++;
                j--;
                if(j < 0 || result[i][j] != 0){
                    direction = "up";
                    j++;
                    i--;
                }
            }

            if(direction.equals("up") && i >= 0 && result[i][j] == 0){
                result[i][j] = number;
                number++;
                i--;
                if(i < 0 || result[i][j] != 0){
                    direction = "right";
                    i++;
                    j++;
                }
            }
        }
        return result;
    }

    public static void printHui(int[][] input){
        for(int[] ints : input){
            for(int i : ints){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}