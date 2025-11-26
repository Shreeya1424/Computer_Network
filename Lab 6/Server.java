import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 9090; // Changed from 8080 to avoid "Address already in use" error
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageFromClient = in.readLine();
            System.out.println("Received from client: " + messageFromClient);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String response = "Hello from server";
            out.println(response);
            System.out.println("Response sent to client");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
