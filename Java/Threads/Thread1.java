public class Thread1 extends Thread{
    public void run(){
        System.out.println("From Thread1!"+this.getName());
        // System.out.println(10/0);
    }

}
