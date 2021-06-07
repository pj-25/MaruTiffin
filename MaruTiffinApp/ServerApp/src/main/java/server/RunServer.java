package server;

import java.io.IOException;

public class RunServer {
    public static void main(String []s){
        if(s.length > 1){
            System.err.println("Invalid number of arguments!");
            return;
        }
        try{

            Server serverApp;
            if(s.length == 1){
                serverApp = new Server(Integer.parseInt(s[0]));
            }else {
                serverApp = new Server();
            }
            serverApp.start();

        }catch (IOException e){
            System.err.println("Unable to start Server :(");
        }catch (NumberFormatException nfe){
            System.err.println("Invalid server port number!");
        }
    }

}
