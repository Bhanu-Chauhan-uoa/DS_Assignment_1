import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;

public class SimpleCalculatorImpl extends UnicastRemoteObject implements SimpleCalculator {
    protected SimpleCalculatorImpl() throws RemoteException {
        super();
    }
//    Stack<Integer> stack = new Stack<Integer>();
    private final Map<String, Stack<Integer>> clientStacks = new HashMap<>();

    @Override
    public synchronized String pushValue(String clientName, int val) throws RemoteException {
        Stack<Integer> stack = getClientStack(clientName);
        stack.push(val);
        return "Successfully Pushed " + val;
    }

//    implementing the logic for pushOperation
    public synchronized int pushOperation(String clientName, String operation) throws RemoteException {
        Stack<Integer> stack = getClientStack(clientName);
//        for finding the max
        if(operation.equals("max")){
            if(stack.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int max = Integer.MIN_VALUE;
            while (!stack.isEmpty()) {
                int poppedElement = stack.pop();
                if(poppedElement > max){
                    max = poppedElement;
                }
            }
            stack.push(max);
            return max;
        }

//        for finding the min
        else if(operation.equals("min")){
            if(stack.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int min = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int poppedElement = stack.pop();
                if(poppedElement < min){
                    min = poppedElement;
                }
            }
            stack.push(min);
            return min;
        }

//        for finding the gcd
        else if(operation.equals("gcd")){
            int firstElement = stack.pop();
            while(!stack.empty()){
                int poppedElement = stack.pop();
                firstElement = gcd(firstElement, poppedElement);
            }
            stack.push(firstElement);
            return firstElement;
        }

//            for finding the lcm
        else if(operation.equals("lcm")){
            int firstElement = stack.pop();
            while(!stack.empty()){
                firstElement = lcm(firstElement, stack.pop());
            }
            stack.push(firstElement);
            return firstElement;
        }
        return -1;
    }

//    Implementation for popping the top most element in the stack
    public synchronized int popValue(String clientName) throws RemoteException {
        Stack<Integer> stack = getClientStack(clientName);
        return stack.pop();
    }

//    Implementation to check if the stack is empty
    public synchronized boolean isEmpty(String clientName) throws RemoteException {
        Stack<Integer> stack = getClientStack(clientName);
        return stack.empty();
    }

//    Implementation to delay pop function
    public synchronized int delayPop(String clientName, int s) throws RemoteException{
        Stack<Integer> stack = getClientStack(clientName);
        try {
            Thread.sleep(s*1000); // Sleep for the given seconds
        } catch (InterruptedException e) {
            // Handle the InterruptedException
            throw new RemoteException("Thread was interrupted during sleep", e);
        }
        if (stack.empty()) {
            throw new RemoteException("Stack is empty");
        }
        return stack.pop(); // Return the popped value after delay
    }

//    function to calculate gcd
    public static int gcd(int a, int b) throws RemoteException {
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //    function to calculate lcm
    public static int lcm(int a, int b) throws RemoteException {
        return (a*b)/gcd(a,b);
    }

//    function to get the user stack
    private Stack<Integer> getClientStack(String clientName) {
        return clientStacks.computeIfAbsent(clientName, k -> new Stack<>());
    }
}