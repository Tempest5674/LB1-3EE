package classes.beans;

import javax.ejb.*;
import java.util.concurrent.Future;

@Stateless
@EJB(beanInterface = SimpleAsyncEJB.class,name = "SimpleAsyncEJB")
@Local
@Asynchronous
public class SimpleAsyncEJB {

    public Future<Integer> addNumbers(int n1, int n2) {
        Integer result;

        result = n1 + n2;
        try {
            // имитации запросов JPA
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return new AsyncResult(result);

    }
}