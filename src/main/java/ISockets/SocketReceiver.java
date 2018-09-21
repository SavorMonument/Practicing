package ISockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReceiver {

    private ServerSocket sSocket;
    private Socket cSocket;
    private BufferedReader in;
    private final int PORT;

    public SocketReceiver(int portNr) {

        this.PORT = portNr;

        initialize();
    }

    public void initialize(){

        try {
            sSocket = new ServerSocket(PORT);
            cSocket = sSocket.accept();

            in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String listen(){

        String output = "";

        try {
            output = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void main(String[] args) {

        SocketReceiver sR = new SocketReceiver(20666);

        while (true){

            System.out.println(sR.listen());
        }
    }
}
