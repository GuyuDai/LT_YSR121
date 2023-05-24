public class Singleton {
    private Singleton instance = null;

    private Singleton(){};

    public Singleton getInstance() {
        if(this.instance == null){
            this.instance = new Singleton();
        }
        return this.instance;
    }
}

