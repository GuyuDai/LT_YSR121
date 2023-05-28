import java.util.Arrays;

public class Schleifel {
    public static void main(String[] args) {
        //数组
        String s = "hi";
        char[] cs = {'h', 'i'};  //数据类型[] = {内容}  java的数组只能存一种数据类型
        int[] ints = {12, 13, 14, 15, 16, 17};
        System.out.println(s);  //hi
        System.out.println(cs);  //hi  char[]等价于String
        System.out.println(ints); // [I@7ef20235(地址)
        System.out.println(Arrays.toString(ints));  //想要输出数组内容时使用
        Person p1 = new Person();
        Person p2 = new Person("Mike");
        Person[] persons = {p1, p2};
        System.out.println(persons);  //[LPerson;@4f3f5b24
        System.out.println(Arrays.toString(persons));  //[Person@15aeb7ab, Person@7b23ec81]
        System.out.println(ints[0]);  //获取ints中第一个元素  java从0开始数数
        Person[] persons2 = new Person[5];  //创建一个长度为5的Person数组
        //java的数组不能改变长度 -> 数据类型[]形式的数组没有增加/删除元素的方法
        System.out.println(Arrays.toString(persons2));  //[null, null, null, null, null]
        persons2[2] = new Person("John");
        System.out.println(Arrays.toString(persons2));
        persons2[2] = p1;
        System.out.println(Arrays.toString(persons2));
        //数组的数组：二维数组
        int[][] matrix = {{0, 1}, {2, 3}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(matrix[1][0]);  //matrix第二个数组的第一个元素

        //while(boolean表达式){循环体} -> 在boolean表达式为true时，执行循环体
        String[] ss = {"num1", "num2", "num3", "num4", "num5", "num6"};
        int i = 0;
        /*
        while(i < 5){  //等价于后面的for循环
            System.out.println(ss[i]);
            i++;  // i += 1
        }

         */
        /*
        while(true){
            System.out.println(ss[i]);
            i++;
            if(i > 2){
                break;  //break跳出循环
            }
        }

         */
        /*
        outter:while (true){  //给循环加标签
            inner:while(i < 5){
                System.out.println(ss[i]);
                i++;
                if(i > 2){
                    break outter;  //跳出标记的循环， 否则跳出break所在的循环
                }
            }
        }

         */
        //do{循环体}while（boolean表达式） -> 循环体会先被执行以此，然后再做while的判断，为true的话循环，否则离开
        do {
            System.out.println(ss[i]);
        } while (false);

        //for(初始化指针; boolean表达式; 移动指针){循环体}
        for (int index = 0; index < 5; index++) {  //等价于上面的while循环
            System.out.println(ss[index]);
        }

        for (int index = ss.length - 1; index >= 0; index--) {  //倒序
            System.out.println(ss[index]);
        }

        //创建一个String[]，等于ss的倒序
        String[] ss1 = new String[ss.length];  //造一个新盒子
        int index_for_ss1 = 0;  //新盒子的指针
        for (int index = ss.length - 1; index >= 0; index--) {
            ss1[index_for_ss1] = ss[index];  //ss倒序的元素放入新盒子所指的位置
            index_for_ss1++;  //新盒子的指针移动
        }
        System.out.println(Arrays.toString(ss1));

        String[] ss2 = new String[ss.length];
        int l = 0;
        int index = ss.length - 1;
        while (index >= 0) {
            ss2[l] = ss[index];
            l++;
            index--;
        }
        System.out.println(Arrays.toString(ss2));

        //foreach循环：某个可迭代对象的所有元素按顺序迭代一遍
        //for(数据类型 变量名：迭代对象){...}

        for (Person p : persons) {
            p.name = "Rose";
        }
        System.out.println(Arrays.toString(persons));

        //if(boolean表达式){...} else if(){} else{}
        //如果boolean表达式为true，则进入大括号
        //else if 可以没有，可以多个
        //else为if和else if的补集（剩下的）可以没有
        for (int in : ints) {
            if(in >= 15) {
                System.out.println("in");
            }
            else {
                System.out.println(in);
            }

        }

    }
}


class Person{
    String name = "Hans";

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    //toString（）默认输出地址
    @Override
    public String toString() {  //自定义数据类型，可以重写toString（）方法，来使得输出值为return的内容
        return this.name;
    }
}