import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner s = new Scanner(System.in);
        //System.out.println(s.next());  //以空格作为终止
        //System.out.println(s.nextLine());  //以换行作为终止（/n）
        while (true){
            System.out.println("which day:");
            int n = s.nextInt();
            if(n > 0){
                System.out.println(fib(n));
            }else {
                break;
            }
        }
        s.close();

         */
        //luckynumber();
        //game();
        Map map = new Map(12);
        map.draw();
        map.move();
    }

    public static int fib(int n){
        if(n >= 3){
            return fib(n-2) + fib(n-1);
        }else if(n == 2){
            return 2;
        }else{
            return 1;
        }
    }

    public static void bmi(){
        Scanner s = new Scanner(System.in);
        System.out.println("your kg");
        double x = s.nextDouble();
        System.out.println("your cm");
        double y = s.nextDouble();
        double bmi = x / (y*y);
        if(bmi < 18.5){
            System.out.println("under weight");
        } else if (bmi >= 18.5 && bmi < 24) {
            System.out.println("standard");
        } else if (bmi >= 24 && bmi < 27) {
            System.out.println("over weight");
        }else {
            System.out.println("fat");
        }
        s.close();
    }

    public static void luckynumber(){
        Scanner l = new Scanner(System.in);
        System.out.println("year of your birthday");
        int x = l.nextInt();
        System.out.println("month of your birthday");
        int y = l.nextInt();
        System.out.println("day of your birthday");
        int z = l.nextInt();
        int luckynumber = (x+y*2)*157 % 100;
        System.out.println("your lucky number is " + luckynumber + " !");
        l.close();
    }

    public static void game(){
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("the initial number:");
        int ini = s.nextInt();
        while(true){
            System.out.println("your turn");
            int min = s.nextInt();
            int temp = ini - min;
            System.out.println(ini + " - " + min + " = " + temp);
            ini = temp;
            if(ini == 0){
                System.out.println("you win!");
                break;
            }
            System.out.println("my turn");
            if(ini < 7){
                min = ini;
                System.out.println(ini + " - " + min + " = " + 0);
                System.out.println("I win, I'm a smart AI!");
                break;
            }else {
                min = r.nextInt(5) + 1;
                temp = ini - min;
                System.out.println(ini + " - " + min + " = " + temp);
                ini = temp;
            }
        }
        s.close();
    }
}

