public class Thread2 implements Runnable{
        public void run()
        {
            //System.out.println("From Thread2!");
            System.out.println(10/0);
        }
}
