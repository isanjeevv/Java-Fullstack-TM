import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            ArrayListTask a =  new ArrayListTask();
            LinkedListTask l = new LinkedListTask();
            VectorTask v = new VectorTask();
            StackTask s = new StackTask();

            new Thread(){
                public void run(){
                    a.arraylist();
                }
            }.start();

            new Thread(){
                public void run() {
                    l.linkedlist();
                }
            }.start();

            new Thread(){
                public void run(){
                    v.vector();
                }
            }.start();

            new Thread(){
                public void run(){
                    s.stack();
                }
            }.start();
        }
}
