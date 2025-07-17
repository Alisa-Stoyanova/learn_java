package codecademy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 60000);
        DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
        toServer.writeUTF("Hello, World!");

        toServer.flush();
        toServer.close();
        clientSocket.close();
    }
}
