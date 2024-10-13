package TCPServer;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] str) throws Exception {
        ServerSocket firstServerSocket = new ServerSocket(6789);

        while (true) {
            Socket connection = firstServerSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());
            byte[] arr = readMessage(dataInputStream);
            writeBytes("C:/Users/ASUS/Pictures/string7.png", arr);
        }
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(data);
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("Done");
    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLength = din.readInt();
        byte[] msg = new byte[msgLength];

        din.readFully(msg);
        return msg;
    }

}
