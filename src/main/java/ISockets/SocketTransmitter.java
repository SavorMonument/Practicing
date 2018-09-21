package ISockets;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTransmitter {

    private Socket cSocket;
    private BufferedWriter out;
    private final int PORT;

    public SocketTransmitter(int portNr) {

        this.PORT = portNr;

        initialize();
    }

    public void initialize(){

        try {
            cSocket = new Socket(InetAddress.getLocalHost(), PORT);

            out = new BufferedWriter(new OutputStreamWriter(cSocket.getOutputStream()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeToSocket(String str){

        try {
            out.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SocketTransmitter sT = new SocketTransmitter(20666);

        while (true){
            sT.writeToSocket("zaze\n");
        }
    }
}