package codecademy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(60000);
            Socket connectionSocket = welcomeSocket.accept();

            DataInputStream fromClient = new DataInputStream(connectionSocket.getInputStream());

            String fromClientAsString = (String) fromClient.readUTF();
            System.out.println("Request: " + fromClientAsString);

            connectionSocket.close();
            welcomeSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
