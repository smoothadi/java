import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost and port 1234
            Socket socket = new Socket("localhost", 1234);
            // Set up input and output streams for communication
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messageToServer;
            String responseFromServer;
            // Read user input and send to server
            while (true) {
                System.out.print("Enter message to send to server: ");
                messageToServer = userInput.readLine();
                // Send message to server
                output.println(messageToServer);
                // Get response from server
                responseFromServer = input.readLine();
                System.out.println("Response from server: " + responseFromServer);
                // Exit condition
                if (messageToServer.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}