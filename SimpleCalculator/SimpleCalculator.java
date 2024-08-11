//Imports the remote interface
import java.rmi.Remote;

//Imports the remote exception to handle remote communication errors
import java.rmi.RemoteException;

//Declares the "SimpleCalculator" interface which extends remote, indicating that this interface can be called remotely.
public interface SimpleCalculator extends Remote {
//    Declaring method for pushing a value into the stack
    String pushValue(String clientName, int val) throws RemoteException;

//    Method for pushing an operation into the stack
    int pushOperation(String clientName, String operation) throws RemoteException;

//    Method for popping the top most element in the stack
    int popValue(String clientName) throws RemoteException;

//    Check if the stack is empty
    boolean isEmpty(String clientName) throws Exception;

//    Delay pop
    int delayPop(String clientName, int s) throws RemoteException;
}