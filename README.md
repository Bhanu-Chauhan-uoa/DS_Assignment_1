# DS_Assignment_1

1. Understanding my code
   I have used 4 files.
   a. SimpleCalculator.java
      Purpose: This file defines the SimpleCalculator remote interface, which declares the methods that can be invoked 
               remotely by clients.
   
   b. SimpleCalculatorImpl.java
      Purpose: This file provides the implementation of the SimpleCalculator interface.
      Methods: pushValue(int val): Pushes a value onto the stack.
               pushOperation(String operation): Executes the specified operation (max, min, gcd, lcm) on the stack.
               popValue(): Removes and returns the top value from the stack.
               isEmpty(): Checks if the stack is empty.
               delayPop(int ms): Delays for a specified number of milliseconds before popping the top value from the stack.

  c. Server.java
     Purpose: This file contains the main method that starts the RMI server.
     Steps: Creates an instance of SimpleCalculatorImpl, which implements the remote interface.
            Creates an RMI registry on port 1099.
            Binds the remote object to the name "Server" in the RMI registry.
            The server is ready to accept client requests.

  d. Client.java
     Purpose: This file contains the client-side code for interacting with the RMI server.
     Steps: Connects to the RMI server using Naming.lookup.
            Provides a command-line interface for the user to interact with the calculator service.
            Handles various operations such as inserting values, performing operations on the stack, popping values, 
            checking if the stack is empty, and delaying the pop operation.

2. Detailed Breakdown
   Remote Object Lookup: The client first looks up the remote object SimpleCalculator using  
   Naming.lookup("rmi://localhost/Server"). This allows the client to interact with the remote calculator service.

   pushValue: Handles inserting values into the stack.
   pushOperation: Handles performing operations on the stack (max, min, gcd, lcm).
   popValue: Pops the topmost value from the stack and prints the result.
   isEmpty: Checks if the stack is empty and prints the result.
   delayPop: Handles popping an element after a specified delay.

   Exception Handling: The try-catch block catches and prints any exceptions that occur during RMI operations or user input 
   processing.

3. Intructions to test
   1. Compile the SimpleCalculatorImpl.java file
   2. Compile the Server.java file
   3. Compile the Client.java file
   4. Run the Server (It creates the rmi registry at port 1099, please do not run `start rmiregistry` command to start the 
      registry)
   5. Run the Client

4. Individual Stack
   Please note that I have implemented the individual stack for each of the user.
   I have used Hashmaps for implementing this functionality.

