import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int num1 = in.readInt();
            int num2 = in.readInt();
            int operation = in.readInt();

            int result;
            switch (operation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }

            out.writeInt(result);
            socket.close();
        }
    }
}
