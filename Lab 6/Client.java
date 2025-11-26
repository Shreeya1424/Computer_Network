import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; 
        int port = 9090; 
        try (
            Socket socket = new Socket(serverAddress, port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String message = "Hello from client";
            out.println(message);
            System.out.println("Hello message sent");

            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

