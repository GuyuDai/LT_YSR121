import java.util.Scanner;

public class Balance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BeitragsKonto beitragsKonto = new BeitragsKonto();
        while (true){
            try {
                System.out.println("please transfer:");
                int x = s.nextInt();
                beitragsKonto.hochladen(x);
                System.out.println("time pass...");
                beitragsKonto.timePass();
            }catch (RuntimeException | Hochladung e){
                System.out.println(e.getMessage());
                //s.close();
                break;
            }
        }
        s.close();
    }
}

class BeitragsKonto{
    public String address;

    private int balance;

    public void timePass() throws Hochladung{
        balance -= 100;
        if (balance < 0){
            throw new Hochladung(-this.balance);
        }
    }

    public void hochladen(int x) throws RuntimeException{
        if (x < 0){
            throw new RuntimeException("transfer should greater than 0");
        }
        balance += x;
    }

    public int getBalance() {
        return balance;
    }
}

class Hochladung extends Exception{
    public int balance;

    public Hochladung(int balance){
        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "you should transfer at least " + balance + " to ZDF";
    }
}