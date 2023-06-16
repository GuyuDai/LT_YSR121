import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(5);
        Map m = new Map(6);
        Item i1 = new Item(map);
        Item i2 = new Item(map);
        Item i3 = new Item(m);
        System.out.println(i1.distance(i2));
        System.out.println(i1.distance(i3));
    }
}

class Item{
    public Map map;

    public Item(){}

    public Item(Map map){
        this.map = map;
        Random rm = new Random();
        while (true){
            int x = rm.nextInt(this.map.field.length);
            int y = rm.nextInt(this.map.field.length);
            if(this.map.field[x][y] == null){
                this.map.field[x][y] = this;
                break;
            }
        }
    }

    public int distance(Item another){
        if(this.map == another.map){
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;

            outer: while(x1 < this.map.field.length){
                inner: while (y1 < this.map.field.length){
                    if(this.map.field[x1][y1] == this){
                        break outer;
                    }
                    y1++;
                }
                y1 = 0;
                x1++;
            }

            System.out.println(x1 + "," + y1);

            outer: while(x2 < this.map.field.length){
                inner: while (y2 < this.map.field.length){
                    if(this.map.field[x2][y2] == another){
                        break outer;
                    }
                    y2++;
                }
                y2 = 0;
                x2++;
            }

            System.out.println(x2 + "," + y2);

            return Math.abs(x1-x2)+Math.abs(y1-y2);
        }else {
            return -1;
        }
    }
}

class Map{
    public Item[][] field;

    public Map(int size){
        this.field = new Item[size][size];
    }
}