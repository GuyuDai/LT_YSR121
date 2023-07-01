public class Main1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1("w1");
        Window1 w2 = new Window1("w2");
        Window1 w3 = new Window1("w3");

        w1.start();
        w1.setPriority(Thread.MIN_PRIORITY);
        w2.start();
        w2.setPriority(10);
        w3.start();


        //w1.run();
        //w2.run();
        //w3.run();
    }
}

/*
1. class A extends Thread
2. override run() : 这个thread执行时干什么
3. A a = new A() -> a.start() : thread a 开始执行run()中的内容
 */

class Window1 extends Thread{
    public String name;
    int count = 1;

    public Window1(String name){
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("T-" + this.name);
        sell();
    }

    public synchronized void sell(){

        while (count <= 10){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + " sold ticket " + count + " from " + Thread.currentThread().getName());
            count++;
        }
        System.out.println(Thread.currentThread().isAlive());
    }
}