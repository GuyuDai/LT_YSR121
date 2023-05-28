public class V3 {
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
    public BigJoker(int number, Color color) {
        super(0,null);
    }

    public void func(){
        System.out.println("method func() from bigJ");
    }
}