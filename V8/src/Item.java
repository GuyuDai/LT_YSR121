import java.util.Random;

public class Item{
    public Map map;
    public Item(){}

    @Override
    public String toString() {
        if(this instanceof Person){
            return "P";
        }
        if(this instanceof Baum){
            return "B";
        }
        if(this instanceof Frame){
            return "+";
        }
        if(this instanceof Blank){
            return " ";
        }
        return null;
    }
}
