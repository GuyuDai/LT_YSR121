public class Client {
    public Server server;
    public int id;
    public String name;

    public Client(Server server, String name){
        this.server = server;
        this.name = name;
        this.id = server.getCounter();
        server.setCounter(server.getCounter()+1);
    }

    public void sendMessage(String msg){
        // send msg to server
    }

    public void sendPrivateMessage(String msg, String name){
        // send msg to server, name represent the target client to receive this msg
    }
}
