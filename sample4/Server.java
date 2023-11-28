import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            new ClientHandler(socket).start();
            System.err.println(socket.getPort());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String fileName;
            while ((fileName = input.readLine()) != null) {
                File file = new File(fileName);
                if (file.exists() && !file.isDirectory()) {
                    output.println("File exists");
                } else {
                    output.println("File does not exist");
                }
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
