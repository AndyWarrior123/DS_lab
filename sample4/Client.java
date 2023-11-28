import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        while ((fileName = reader.readLine()) != null) {
            output.println(fileName);
            System.out.println(input.readLine());
        }

        socket.close();
    }
}
