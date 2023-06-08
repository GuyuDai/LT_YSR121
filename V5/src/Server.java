public class Server {
    private int counter = 1000;
    private static Server instance = null;
    private final Client[] clients;

    private Server(){
        this.clients = new Client[3];
    }

    public static Server getInstance() {
        if(Server.instance == null){
            Server.instance = new Server();
        }
        return Server.instance;
    }

    public Client getClientByName(String name){
        //usage: 通过name获取具体的client
        for(Client c : clients){
            if(c.name.equals(name)){
                return c;
            }
        }
        //send back an error message to the sender
        return null;
    }

    public void sendMessage(String msg){
        //将从sender处接受到的msg传输给全部client
        for (Client c : clients){
            sendMessageTo(msg, c);
        }
    }

    public void sendMessageTo(String msg, Client target){
        //将msg传输给target
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
