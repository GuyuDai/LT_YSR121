import java.util.Random;

public class V3 {
    public static void main(String[] args) {
        Random rm = new Random();
        Card[] deck = new Card[54];
        int i = 1;  // index of color  1~4
        deck[52] = new SmallJoker();
        deck[53] = new BigJoker();
        while (i <= 4){
            int j = 1;  // index of number 1~13
            while (j <= 13){
                int x = rm.nextInt(10);
                if(i == 1){
                    if(x < 4){
                        deck[i*j-1] = new AttackCard(j, Color.HEITAO);  //i*j-1: index of deck
                        j++;
                    }else {
                        deck[i*j-1] = new MoveCard(j, Color.HEITAO);
                        j++;
                    }
                }
                if(i == 2){
                    if(x < 4){
                        deck[i*j-1] = new AttackCard(j, Color.CAOHUA);  //i*j-1: index of deck
                        j++;
                    }else {
                        deck[i*j-1] = new MoveCard(j, Color.CAOHUA);
                        j++;
                    }
                }
                if(i == 3){
                    if(x < 4){
                        deck[i*j-1] = new AttackCard(j, Color.HONGTAO);  //i*j-1: index of deck
                        j++;
                    }else {
                        deck[i*j-1] = new MoveCard(j, Color.HONGTAO);
                        j++;
                    }
                }
                if(i == 4){
                    if(x < 4){
                        deck[i*j-1] = new AttackCard(j, Color.FANGPIAN);  //i*j-1: index of deck
                        j++;
                    }else {
                        deck[i*j-1] = new MoveCard(j, Color.FANGPIAN);
                        j++;
                    }
                }
            }
            i++;
        }

        Card[] hands = new Card[3];
        int y = 0;
        while (y < 3){
            Card temp = deck[rm.nextInt(54)];
            if(y == 0){
                deck[y] = temp;
            } else if(temp != deck[y-1]){
                deck[y] = temp;
            }else {
                y--;
            }
            y++;
        }

        for(Card c : hands){
            if(c instanceof BigJoker){
                BigJoker bj = (BigJoker) c;
                bj.func();
            }
            if(c instanceof SmallJoker){
                SmallJoker sj = (SmallJoker) c;
                sj.func();
            }
            if(c instanceof MoveCard){
                MoveCard mc = (MoveCard) c;
                mc.move();
            }
            if(c instanceof AttackCard){
                AttackCard ac = (AttackCard) c;
                ac.attack();
            }
            /*
            if(c.color == Color.HEITAO){
                System.out.println("color is heitao, life points decrease " + c.number);
            }
            if(c.color == Color.CAOHUA){
                System.out.println("color is caohua, move backwards " + c.number);
            }
            if(c.color == Color.HONGTAO){
                System.out.println("color is hongtao, life points increase " + c.number);
            }
            if(c.color == Color.FANGPIAN){
                System.out.println("color is fangpian, move forwards " + c.number);
            }

             */
            switch (c.color){
                case HEITAO:
                    System.out.println("color is heitao, life points decrease " + c.number);
                    break;
                case CAOHUA:
                    System.out.println("color is caohua, move backwards " + c.number);
                    break;
                case HONGTAO:
                    System.out.println("color is hongtao, life points increase " + c.number);
                    break;
                case FANGPIAN:
                    System.out.println("color is fangpian, move forwards " + c.number);
                    break;
                default:
                    System.out.println("color not exist");
                    break;
            }
        }
    }
}
enum Color{
    HEITAO, CAOHUA, HONGTAO, FANGPIAN
}
class Card{
    public int number;
    public Color color;

    public Card(int number, Color color){
        this.number = number;
        this.color = color;
    }
}

interface Move{
    public abstract void move();

}

interface Attack{
    public abstract void attack();

}

class MoveCard extends Card implements Move{

    public MoveCard(int number, Color color) {
        super(number, color);
    }

    @Override
    public void move() {
        System.out.println("method move()");
    }
}


class AttackCard extends Card implements Attack{

    public AttackCard(int number, Color color) {
        super(number, color);
    }

    @Override
    public void attack() {
        System.out.println("method attack()");
    }
}

class SmallJoker extends Card{
    public SmallJoker() {
        super(0,null);
    }

    public void func() {
        System.out.println("method func() from smallJ");
    }
}

class BigJoker extends Card{
    public BigJoker() {
        super(0,null);
    }

    public void func(){
        System.out.println("method func() from bigJ");
    }
}