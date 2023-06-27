/*
public class Map {
    private int breit;
    private int heitght;
    public String[][] map;

    public Map(int breit, int height){
        Random r = new Random();
        this.breit = breit;
        this.heitght = height;
        this.map = new String[height][breit];
        for(int i = 0; i< map.length; i++){  //height
            for (int j = 0; j < map[0].length; j++){  //breit
                if((i == 0 || i == this.heitght-1) && (j == 0 || j == this.breit-1)){
                    this.map[i][j] = "+";
                }else if((i == 0 || i == this.heitght-1) && (j != 0 && j != this.breit-1)){
                    this.map[i][j] = "-";
                }else if((i != 0 && i != this.heitght-1) && (j == 0 || j == this.breit-1)){
                    this.map[i][j] = "|";
                } else if (i == 1 && j == 1) {
                    map[i][j] = "P";
                } else {
                    int x = r.nextInt(10);
                    if(x <= 2){
                        this.map[i][j] = "B";
                    }else {
                        this.map[i][j] = " ";
                    }
                }
            }
        }
    }

    public void draw(){
        for(String[] ss : map){
            for (String s : ss){
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void move(){
        Scanner s = new Scanner(System.in);
        m: while(true){

            int x = 1;  //竖
            int y = 1;  //横
            outer: while(x < this.heitght){
                inner: while (y < this.breit){
                    if(this.map[x][y].equals("P")){
                        break outer;
                    }
                    y++;
                }
                y = 0;
                x++;
            }

            System.out.println("direction:");
            String d = s.nextLine();
            switch (d){
                case "w":
                    int temp_y = y-1;
                    if(!(temp_y <= 0 || map[x][temp_y].equals("B"))){
                        y = temp_y;
                    }
                    break;

                case "a":
                    int temp_x = x-1;
                    if(!(temp_x <= 0 || map[temp_x][y].equals("B"))){
                        x = temp_x;
                    }
                    break;

                case "s":
                    int temp_y2 = y+1;
                    if(!(temp_y2 >= breit || map[x][temp_y2].equals("B"))){
                        y = temp_y2;
                    }
                    break;

                case "d":
                    int temp_x2 = x+1;
                    if(!(temp_x2 >= heitght || map[temp_x2][y].equals("B"))){
                        x = temp_x2;
                    }
                    break;

                default:
                    break m;
            }
            draw();
        }
        s.close();
    }
}

 */

import java.util.Random;
import java.util.Scanner;

public class Map{
    public Item[][] map;

    public Map(int size){
        Random r = new Random();

        this.map = new Item[size][size];
        for(int i = 0; i< size; i++) {  //height
            for (int j = 0; j < size; j++) {  //breit
                if ((i == 0 || i == size - 1) || (j == 0 || j == size - 1)) {
                    this.map[i][j] = new Frame(this);
                } else if (i == 1 && j == 1) {
                    map[i][j] = new Person();
                } else {
                    int x = r.nextInt(10);
                    if (x <= 2) {
                        this.map[i][j] = new Baum();
                    } else {
                        this.map[i][j] = new Blank();
                    }
                }
            }
        }
    }

    public void draw(){
        for(Item[] is : map){
            for (Item i : is){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public void move(){
        Scanner s = new Scanner(System.in);
        m: while(true){

            int x = 1;  //竖
            int y = 1;  //横
            outer: while(x < map.length){
                inner: while (y < map.length){
                    if(this.map[x][y] instanceof Person){
                        break outer;
                    }
                    y++;
                }
                y = 0;
                x++;
            }
            map[x][y] = new Blank();

            System.out.println("direction:");
            String d = s.nextLine();
            switch (d){
                case "w":
                    int temp_y = y-1;
                    if(!(temp_y <= 0 || map[x][temp_y] instanceof Baum)){
                        y = temp_y;
                    }
                    break;

                case "a":
                    int temp_x = x-1;
                    if(!(temp_x <= 0 || map[temp_x][y] instanceof Baum)){
                        x = temp_x;
                    }
                    break;

                case "s":
                    int temp_y2 = y+1;
                    if(!(temp_y2 >= map.length || map[x][temp_y2] instanceof Baum)){
                        y = temp_y2;
                    }
                    break;

                case "d":
                    int temp_x2 = x+1;
                    if(!(temp_x2 >= map.length || map[temp_x2][y] instanceof Baum)){
                        x = temp_x2;
                    }
                    break;

                default:
                    break m;
            }
            map[x][y] = new Person();
            draw();
        }
        s.close();
    }
}