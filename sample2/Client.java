
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 12345);
        System.out.println("Client connected to server: " + clientSocket.getRemoteSocketAddress());

        int[][] matrixA = {{4, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8, 9}, {10, 11, 12}};

        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        oos.writeInt(matrixA.length);

        oos.writeObject(matrixA);
        oos.writeObject(matrixB);

        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        int[][] resultMatrix = (int[][]) ois.readObject();

        System.out.println("Result matrix:");
        for (int[] row : resultMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        oos.close();
        ois.close();
        clientSocket.close();
    }
}
