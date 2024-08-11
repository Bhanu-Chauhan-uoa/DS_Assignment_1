//Imports the remote interface
import java.rmi.Remote;

//Imports the remote exception to handle remote communication errors
import java.rmi.RemoteException;

//Declares the "SimpleCalculator" interface which extends remote, indicating that this interface can be called remotely.
public interface SimpleCalculator extends Remote {
//    Declaring method for pushing a value into the stack
    String pushValue(int val) throws RemoteException;

//    Method for pushing an operation into the stack
    int pushOperation(String operation) throws RemoteException;

//    Method for popping the top most element in the stack
    int popValue() throws RemoteException;

//    Check if the stack is empty
    boolean isEmpty() throws Exception;

//    Delay pop
    int delayPop(int s) throws RemoteException;
}