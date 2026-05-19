import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started, waiting for client connection...");
            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            // Set up input and output streams for communication with client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            String messageFromClient;
            // Read the message from client and send a response
            while ((messageFromClient = input.readLine()) != null) {
                System.out.println("Message from client: " + messageFromClient);
                output.println("Hello from server! You said: " + messageFromClient);
            }
            // Close the connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}