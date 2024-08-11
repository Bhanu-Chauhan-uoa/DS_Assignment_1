import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the remote object
            SimpleCalculator obj = (SimpleCalculator) Naming.lookup("rmi://localhost/Server");

            // Create and start threads for four clients
            Thread client1 = new Thread(() -> runClientCalculations(obj, 1));
            Thread client2 = new Thread(() -> runClientCalculations(obj, 2));
            Thread client3 = new Thread(() -> runClientCalculations(obj, 3));
            Thread client4 = new Thread(() -> runClientCalculations(obj, 4));

            client1.start();
            client2.start();
            client3.start();
            client4.start();

            // Wait for all clients to finish their operations
            client1.join();
            client2.join();
            client3.join();
            client4.join();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void runClientCalculations(SimpleCalculator obj, int clientId) {
        try {
            System.out.println("Client " + clientId + " is starting operations.");
            String clientName = Integer.toString(clientId);
            // Each client performs a set of operations
            obj.pushValue(clientName, 15 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 15 * clientId);

            obj.pushValue(clientName, 25 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 25 * clientId);

            obj.pushValue(clientName,45 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 45 * clientId);

            // Perform some operations
            int max = obj.pushOperation(clientName,"max");
            System.out.println("Client " + clientId + " performed max operation and max value is: " + max);

            int popValue = obj.popValue(clientName);
            System.out.println("Client " + clientId + " popped value: " + popValue);

            boolean isEmpty = obj.isEmpty(clientName);
            System.out.println("Client " + clientId + " stack is empty: " + isEmpty);

            obj.pushValue(clientName, 5 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 5 * clientId);

            obj.pushValue(clientName, 10 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 10 * clientId);

            obj.pushValue(clientName,20 * clientId);
            System.out.println("Client " + clientId + " pushed value: " + 20 * clientId);

//            Get the lcm
            int lcm = obj.pushOperation(clientName, "lcm");
            System.out.println("Client " + clientId + " lcm is: " + lcm);

//          Delay pop operation with 5 seconds
            int delayedPop = obj.delayPop(clientName, 5);
            System.out.println("Client " + clientId + " popped value after delay: " + delayedPop);

            boolean isEmpty2 = obj.isEmpty(clientName);
            System.out.println("Client " + clientId + " stack is empty: " + isEmpty2);

        } catch (Exception e) {
            System.err.println("Client " + clientId + " exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
