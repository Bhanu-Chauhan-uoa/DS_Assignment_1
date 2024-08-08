import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the remote object
            SimpleCalculator obj = (SimpleCalculator) Naming.lookup("rmi://localhost/Server");

            // Call the remote method
            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("Enter 1 to insert an element");
                System.out.println("Enter 2 to insert an perform operations");
                System.out.println("Enter 3 to pop an element");
                System.out.println("Enter 4 to check if the stack is empty");
                System.out.println("Enter 5 to pop an element after a delay");
                System.out.print("Your input: ");
                int input = sc.nextInt();
                sc.nextLine();

                switch (input) {
                    case 1:
                        while(true){
                            System.out.println("Enter the value to insert: ");
                            int val = sc.nextInt();
                            System.out.println("Response: " + obj.pushValue(val));
                            System.out.println("Press 1 to keep inserting or 0 to exit");
                            int dec = sc.nextInt();
                            sc.nextLine();
                            if(dec==0) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the operation: ");
                        String operation = sc.nextLine();
                        System.out.println("Response: " + obj.pushOperation(operation));
                        break;
                    case 3:
                        System.out.println("Response: " + obj.popValue());
                        break;
                    case 4:
                        System.out.println("Thursday");
                        break;
                    case 5:
                        System.out.println("Friday");
                        break;
                    default:
                        System.out.println("Invalid day number. Please enter a number between 1 and 7.");
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
