import networkConnection.SocketConnection;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    static public Scanner scanner = new Scanner(System.in);
    public static void main(String []s){
        String msg = "";
        try{
            Socket serverConnection = new Socket("127.0.0.1", 5656);
            SocketConnection socketConnection = new SocketConnection(serverConnection,data -> {
                System.out.println(data[0]);
            } );
            socketConnection.run();
            while(!msg.equals("exit")){
                System.out.print(">> ");
                msg = scanner.nextLine();
                socketConnection.write(msg);
            }

            System.out.println("----------- Bye :) -----------");
        }catch (IOException ioE){
            System.out.println("Server's offline or check your network connection :(");
        }
    }

}
