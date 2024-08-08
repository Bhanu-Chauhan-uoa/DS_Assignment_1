import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class SimpleCalculatorImpl extends UnicastRemoteObject implements SimpleCalculator {
    protected SimpleCalculatorImpl() throws RemoteException {
        super();
    }
    Stack<Integer> stack = new Stack<Integer>();

    @Override
    public String pushValue(int val) throws RemoteException {
        stack.push(val);
        return "Successully Pushed " + val;
    }
    public int pushOperation(String operation) throws RemoteException {
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
            return max;
        }
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
            return min;
        }
        return -1;
    }
    public int popValue() throws RemoteException {
        return stack.pop();
    }
    public boolean
}