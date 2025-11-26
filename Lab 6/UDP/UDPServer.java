import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 8080;
        final int MAXLINE = 1024;

        DatagramSocket socket = new DatagramSocket(PORT);
        byte[] receiveBuffer = new byte[MAXLINE];

        System.out.println("Server is running and waiting for client message...");

        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket); // blocking call

        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();
        String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Client: " + clientMessage);

        String hello = "Hello from server";
        byte[] sendBuffer = hello.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
        socket.send(sendPacket);

        System.out.println("Hello message sent.");

        socket.close();
    }
}

