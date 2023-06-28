import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*
        MBTI mbti = new MBTI();
        try {
            mbti.run();
        }catch (ToBig | ToSmall e){
            System.out.println(e.getMessage());
        }

         */
        game();
    }

    public static void game(){
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("the initial number:");
        int ini = s.nextInt();
        /*
        try {
            while(true){
                System.out.println("your turn");
                int min = s.nextInt();
                if(min > 6){
                    throw new RuntimeException("don't cheat!!!");
                }
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
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }finally {
            s.close();
        }
         */
        while(true){
            System.out.println("your turn");
            int min = s.nextInt();
            try {
                if(min > 6){
                    throw new RuntimeException("don't cheat!!!");
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
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

class MBTI{
    public int ei = 0;
    public int ns = 0;
    public int tf = 0;
    public int jp = 0;

    public MBTI(){}

    public void run() throws ToSmall, ToBig {
        Scanner s = new Scanner(System.in);
        int counter = 1;
        while (counter <= 20){
            System.out.println("Question " + counter + ":");
            int x = s.nextInt();
            /*
            条件判断{
                // 生成相关的exception
                throw new 相关的exception的实例
            }
             */
            if(x < -5){
                throw new ToSmall();
            }
            if(x > 5){
                throw new ToBig();
            }
            if(counter <= 5 && counter >= 1){
                this.ei += x;
            }
            if(counter <= 10 && counter >= 6){
                this.ns += x;
            }
            if(counter <= 15 && counter >= 11){
                this.tf += x;
            }
            if(counter >= 16){
                this.jp += x;
            }
            counter++;
        }
        s.close();
        System.out.println(this);
    }

    @Override
    public String toString() {
        String ei;
        String ns;
        String tf;
        String jp;
        if(this.ei <= 0){
            ei = "E";
        }else {
            ei = "I";
        }

        if(this.ns <= 0){
            ns = "N";
        }else {
            ns = "S";
        }

        if(this.tf <= 0){
            tf = "T";
        }else {
            tf = "F";
        }

        if(this.jp <= 0){
            jp = "J";
        }else {
            jp = "P";
        }

        return "you are " + ei + ns + tf + jp;
    }
}

class ToBig extends Exception{

    @Override
    public String getMessage() {
        return "input muss smaller than 5";
    }
}

class ToSmall extends Exception{

    @Override
    public String getMessage() {
        return "input muss greater than -5";
    }
}