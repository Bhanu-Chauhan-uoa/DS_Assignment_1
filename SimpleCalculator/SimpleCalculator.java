//Imports the remote interface
import java.rmi.Remote;

//Imports the remote exception to handle remote communication errors
import java.rmi.RemoteException;

//Declares the "SimpleCalculator" interface which extends remote, indicating that this interface can be called remotely.
public interface SimpleCalculator extends Remote {
    String pushValue(int val) throws RemoteException;
    int pushOperation(String operation) throws RemoteException;
    int popValue() throws RemoteException;
    boolean isEmpty() throws Exception;
}