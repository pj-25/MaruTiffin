import networkConnection.SocketConnection;

import java.io.IOException;
import java.util.Scanner;

public class TestRelayEchoClient {
    static public Scanner scanner = new Scanner(System.in);
    public static void main(String []s){
        String msg = "";
        try{
            SocketConnection socketConnection = new SocketConnection("127.0.0.1", 5656, System.out::println);
            socketConnection.run();
            while(socketConnection.isConnected() && !msg.equals("exit")){
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
