import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }
}

class Client{
    public int id;
    public Server server;

    public Client(Server server){
        if(server.getClients().size() <= 5){
            this.server = server;
            int x = 1001;
            while (x < 1006){
                if(this.server.getClients().containsKey(x)){
                    x++;
                }else {
                    this.id = x;
                    this.server.getClients().put(x,this);
                }
            }
        }else {
            System.out.println("Server is full");
        }
    }

    public void leave(){
        this.server.getClients().remove(this.id);
    }

    /*
    public Client(Server server){
        if(server.getClients().size() <= 5){
            this.server = server;
            this.id = this.server.getCount();
            this.server.setCount(this.server.getCount()+1);
            this.server.getClients().add(this);
        }else {
            System.out.println("Server is full");
        }
    }

    public void leave(){
        this.server.getClients().remove(this);
    }

     */
}

/*
class Server{
    public static final int port = 10086;
    private int count = 1000;
    private ArrayList<Client> clients = new ArrayList<>();

    public Server(){

    }

    public int getCount() {
        return count;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

 */

class Server{
    public static final int port = 10086;
    private HashMap<Integer, Client> clients = new HashMap<>();

    public Server(){}

    public HashMap<Integer, Client> getClients() {
        return clients;
    }
}
