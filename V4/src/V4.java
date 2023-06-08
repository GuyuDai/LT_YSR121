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

    public Node delete(int index){
        int pointer = 0;
        Node pre = null;
        Node temp = this.head;
        while (pointer != index){
            if(temp.nex == null){
                System.out.println("index out of bound");
                return null;
            }
            pre = temp;
            temp = temp.nex;
            pointer++;
        }
        if(pre == null){
            this.head = temp.nex;
        }else {
            pre.nex = temp.nex;
        }
        return temp;
    }

    public void change(int index, int value){
        int pointer = 0;
        Node temp = this.head;
        while (pointer != index){
            if(temp.nex == null){
                System.out.println("index out of bound");
            }
            temp = temp.nex;
            pointer++;
        }
        temp.value = value;
    }

    public Node search(int index){
        int pointer = 0;
        Node temp = this.head;
        while (pointer != index){
            if(temp.nex == null){
                System.out.println("index out of bound");
                return null;
            }
            temp = temp.nex;
            pointer++;
        }
        return temp;
    }
}

class Queue{
    public Node first;

    public Queue(){}

    public void push(int value){
        Node n = new Node(value);
        if(this.first == null){
            this.first = n;
        }else {
            Node temp = this.first;
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

    public Node pop(){
        Node result = this.first;
        this.first = this.first.nex;
        return result;
    }
}
class Stack{
    public Node last;
    public Node first;

    public Stack(){}

    public void push(int value){
        Node n = new Node(value);
        if(this.last == null){
            this.last = n;
            this.first = n;
        }else {
            this.last.nex = n;
            this.last = n;
        }
    }

    public Node pop(){
        Node result = this.last;
        if(this.first == this.last){
            this.first = null;
            this.last = null;
            return result;
        }
        Node pre = this.first;
        while (pre.nex != this.last) {
            pre = pre.nex;
        }
        this.last = pre;
        return result;
    }


}

