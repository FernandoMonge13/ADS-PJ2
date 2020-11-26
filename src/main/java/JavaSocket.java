import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class JavaSocket {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3925);
        System.out.println("recieving");
        Socket socket = serverSocket.accept();
        System.out.println("received");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // Receiving
        byte[] lenBytes = new byte[4];
        inputStream.read(lenBytes, 0, 4);
        int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
        byte[] receivedBytes = new byte[len];
        inputStream.read(receivedBytes, 0, len);
        String received_string = new String(receivedBytes, 0, len);
        System.out.println("Server received: " + received_string);

        // String received message to Object
        Message message = Jason.stringToObject(received_string);
        System.out.println("Salute: " + message.getSalute());


        //Object to String
        message.setSalute("HELLO IT´S ME MARIO");
        String object_in_string = Jason.objectToString(message);

        // Sending
        String toSend = object_in_string;
        byte[] toSendBytes = toSend.getBytes();
        int toSendLen = toSendBytes.length;
        byte[] toSendLenBytes = new byte[4];
        toSendLenBytes[0] = (byte)(toSendLen & 0xff);
        toSendLenBytes[1] = (byte)((toSendLen >> 8) & 0xff);
        toSendLenBytes[2] = (byte)((toSendLen >> 16) & 0xff);
        toSendLenBytes[3] = (byte)((toSendLen >> 24) & 0xff);
        outputStream.write(toSendLenBytes);
        outputStream.write(toSendBytes);

        socket.close();
        serverSocket.close();
    }
}
