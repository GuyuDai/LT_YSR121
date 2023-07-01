import static java.lang.Thread.sleep;

public class Main2 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w, "T-w1");
        Thread t2 = new Thread(w, "T-w2");
        Thread t3 = new Thread(w, "T-w3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*
1. class A implements Runnable
2. override run()
3. A a = new A()
4. Thread a_thread = new Thread(a) or Thread a_thread = new Thread(a, name)
 */

/*
同步(synchronized):

1. 将一个method标记为synchronized
1.1 非静态方法:
synchronized(this){
    同步代码
}
1.2 静态方法:
synchronized(class.class){
    同步代码
}

2. synchronized(锁){
    同步代码
}
2.1 锁是一个对象(object)
2.2 锁必须唯一
 */
class Window2 implements Runnable{
    int count = 1;
    final String locker = "haha";

    @Override
    public void run() {
        sell();
    }

    /*
    public synchronized void sell(){
        while (count <= 10){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ticket " + count + " from " + Thread.currentThread().getName());
            count++;
        }
    }
     */

    public void sell(){
        synchronized (locker){
            while (count <= 10){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ticket " + count + " from " + Thread.currentThread().getName());
                count++;
            }
        }
    }
}