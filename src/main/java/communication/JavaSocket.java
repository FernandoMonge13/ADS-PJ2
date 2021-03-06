package communication;

import Challenges.Generator;
import Timer.Timer;
import TreeTracker.Tracker;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;

public class JavaSocket {

    /**
     * Realiza el protocolo de comunicación entre C# y Java y actualiza todos los datos lógicos del juego
     *
     * @return
     * @throws IOException
     */
    public static boolean Init () throws IOException {

        ServerSocket serverSocket = new ServerSocket(3925);
        Socket socket = serverSocket.accept();
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

        // String received message to Object
        Message message = Jason.stringToObject(received_string);

        //Appling changes...
        if (!message.checkeo) {
            message.tree_print = Tracker.obtenerInstancia().addNode(message.player, message.new_node, message.id);
            message.win = Tracker.obtenerInstancia().checkWin(message.player, message.id);
            if(message.win){
                //Generator.obtenerInstancia().generateChallenge();
                //Timer.reset = true;
                message.winner = message.player;
                Tracker.obtenerInstancia().clearAll();
                message.challenge = Generator.obtenerInstancia().getCurrentChallenge();
                message.winCondition = Generator.obtenerInstancia().getCurrentWinCondition();
                message.tree_print = "";
                message.win = false;
            }
//        } if (Timer.challenge){
//            Generator.obtenerInstancia().generateChallenge();
//            message.challenge = Generator.obtenerInstancia().getCurrentChallenge();
//            message.winCondition = Generator.obtenerInstancia().getCurrentWinCondition();
//            Timer.challenge = false;
//            message.win = true;
//            message.winner = Tracker.obtenerInstancia().checkForcedWin(message.id);
//            Tracker.obtenerInstancia().clearAll();
        }else {
            // tiempo de challenge
        }
        //System.out.println(message.tree_print);
        //Testing...

        //Object to String
        //message.setTree_print("tree");//tree var
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

        return message.exit;
    }
}
