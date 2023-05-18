public class Main {
    public static void main(String[] args) {    //public static void main(String[] args){}: 程序的入口
        int x = 10; //16 bits
        long l = 111; //32 bits
        double d = 9.82; //64 bits = 32 bits 整数部分 + 32 bits 小数部分
        boolean bl = true; //1 bit
        char c = 'x'; //32 bits ASCII code

        //类型转换
        //1. 自动类型转换: 当小数据类型和大数据类型运算时，小的向大的自动转换
        int x1 = Integer.MAX_VALUE; // 2^15-1
        x1 += 2; //x1依然是int -> 溢出(-2147483647)   expected: 2^15+1
        System.out.println(x1);
        int x2 = Integer.MAX_VALUE;
        long l1 = 2;
        System.out.println(x2 + l1); //2147483649 自动数据类型转换: x2+l1 是一个long
        //2. 强制类型转移: 将大数据类型强制转换为小数据类型，会损失精度/信息
        //（目标数据类型）需转移的数据
        int dd = (int)d; //向下取整
        System.out.println(dd); //9

    }
}