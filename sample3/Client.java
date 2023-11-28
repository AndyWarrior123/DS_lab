import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        out.writeInt(5);  // num1
        out.writeInt(3);  // num2
        out.writeInt(1);  // operation: 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division

        int result = in.readInt();
        System.out.println("Result: " + result);

        socket.close();
    }
}
