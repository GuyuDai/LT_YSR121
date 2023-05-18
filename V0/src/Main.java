public class Main {
    public static void main(String[] args) {
        byte b = Byte.MAX_VALUE;  //8bit
        byte a = Byte.MAX_VALUE;
        b += 3;
        short sh = 1;  //16bit
        int x = Integer.MAX_VALUE;  //32bit  =2^31-1
        long l = 1;  //64bit
        float f = 1.0f;  //32
        double d = 1.9;  //64
        boolean is = true;  //1
        char c = 'c';  //32
        //System.out.println(a+3);
        //System.out.println("number: " + b);
        //System.out.println((int)d);
        //System.out.println((int)1.2+3.7);  //4.7
        //System.out.println((int)(1.2+3.7));  //4
        System.out.println(c);  //String <=> char[]
        String s = "c";  //char[1] = ['c']
    }
}

// 小数据类型 -> 大数据类型：自动类型转换
// 大数据类型 -> 小数据类型：强制类型转换  **损失精度
//
