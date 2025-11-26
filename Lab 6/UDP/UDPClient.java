import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        final int PORT = 8080;
        final int MAXLINE = 1024;
        String message = "Hello from client";

        DatagramSocket socket = new DatagramSocket();

        InetAddress serverAddress = InetAddress.getByName("localhost");

        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, PORT);
        socket.send(sendPacket);
        System.out.println("Hello message sent.");

        byte[] receiveBuffer = new byte[MAXLINE];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server: " + serverResponse);

        socket.close();
    }
}
