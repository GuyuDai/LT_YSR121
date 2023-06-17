//Rekursion  Recursion  递归
public class V7 {
    public static void main(String[] args) {
        System.out.println(jiecheng(5));
        System.out.println(fib(5));
    }

    public static int jiecheng(int input){
        if(input == 0 || input == 1){
            return 1;
        }else {
            return input * jiecheng(input-1);
        }
    }

    public static int fib(int n){
        if(n >= 3){
            return fib(n-2) + fib(n-1);
        }else if(n == 2){
            return 2;
        }else{
            return 1;
        }
    }
}

class Node{
    public int value;
    public Node pre;
    public Node nex;

    public Node(int value, Node nex, Node pre){
        this.value = value;
        this.pre = pre;
        this.nex = nex;
    }

    public Node(int value){
        this.value = value;
    }

    public void add(Node n){
        if(this.nex == null){
            this.nex = n;
            n.pre = this;
        }else {
            this.nex.add(n);
        }
    }

    public void delete(int index){
        if(index == 0){
            this.pre.nex = this.nex;
            this.nex.pre = this.pre;
        }else{
            if(this.nex == null){
                System.out.println("index out of bound");
            }else {
                this.nex.delete(index-1);
            }
        }
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
            this.head.add(n);
        }
    }

    public void delete(int index){
        if(this.head == null){
            System.out.println("index out of bound");
        }else {
            this.head.delete(index);
        }
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
