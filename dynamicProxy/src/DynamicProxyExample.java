import java.lang.reflect.*;

// Step 1: Define an interface
interface Service {
    void performTask();
}

// Step 2: Define the real implementation of the interface
class ServiceImpl implements Service {
    @Override
    public void performTask() {
        System.out.println("Task performed by ServiceImpl.");
    }
}

// Step 3: Create an InvocationHandler to handle method calls
class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Method " + method.getName() + " is being called.");
        Object result = method.invoke(target, args); // Call the real method
        System.out.println("Logging: Method " + method.getName() + " finished.");
        return result;
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Step 4: Create the real service
        Service service = new ServiceImpl();

        // Step 5: Create a dynamic proxy for the service
        Service proxy = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class[]{Service.class},
                new LoggingHandler(service)
        );

        // Step 6: Call methods on the proxy object
        proxy.performTask();
    }
}
