public class V4 {

}

class Node{
    public int value;
    public Node nex;

    public Node(int value, Node nex){
        this.value = value;
        this.nex = nex;
    }

    public Node(int value){
        this.value = value;
    }
}

class Shuzu{
    public Node head;

    public Shuzu(){}

    public void add(int value){
        Node n = new Node(value);
        if(this.head == null){
            this.head = n;
        }else {
            Node temp = this.head;
            while (true){
                if(temp.nex == null){
                    temp.nex = n;
                    break;
                }else {
                    temp = temp.nex;
                }
            }
        }
    }
}
