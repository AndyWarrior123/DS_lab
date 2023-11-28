
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

            new Thread(new MatrixAdditionRequestHandler(clientSocket)).start();
        }
    }
}

class MatrixAdditionRequestHandler implements Runnable {

    private Socket clientSocket;

    public MatrixAdditionRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            int matrixSize = ois.readInt();

            int[][] matrixA = (int[][]) ois.readObject();
            int[][] matrixB = (int[][]) ois.readObject();

            int[][] resultMatrix = addMatrices(matrixA, matrixB);

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(resultMatrix);

            ois.close();
            oos.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int[][] resultMatrix = new int[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
    }
}
