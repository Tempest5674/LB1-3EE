package classes.beans;

import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Singleton
public class TestAsync {
    @EJB
    SimpleAsyncEJB ejb;

    @Test
    public void start() {
        try {
            Future<Integer> future = ejb.addNumbers(10, 20);
            System.out.println("Client is working ...");
            Thread.sleep(1000);

            if (!future.isDone()) {
                System.out.println("Response not ready yet ...");
            }

            System.out.println("Client is working again ...");
            Thread.sleep(1000);

            if (!future.isDone()) {
                System.out.println("Response not ready yet ...");
            }

            System.out.println("Client is working ...");
            Thread.sleep(1000);

            if (!future.isDone()) {
                System.out.println("Response not ready yet ...");
            } else {
                System.out.println("Response is now ready");
            }

            Integer result = future.get();

            System.out.println("The result is: " + result);
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}

