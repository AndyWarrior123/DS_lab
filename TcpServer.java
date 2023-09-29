package lab1;

import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket ss = new ServerSocket(8088)) {
            System.out.println("Server is ready!!");
            Socket ls = ss.accept();
            while(true) {
                System.out.println("Client Port is " + ls.getPort());
                InputStream is = ls.getInputStream();
                byte data[] = new byte[50];
                is.read(data);

                // MFC: message from client
                String mfc = new String(data);
                mfc = mfc.trim();

                // MFS: message from server
                String mfs = "Hello:" + mfc;
                OutputStream os = ls.getOutputStream();
                os.write(mfs.getBytes());
            }
        }
    }
}

