public class P3_InterThreadCommunicationSample {
    public static void main(String args[]){
        Customer c = new Customer();
        new Thread(){
            public void run(){c.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();

    }
}
