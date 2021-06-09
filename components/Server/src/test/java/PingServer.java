
import server.Server;

import java.io.IOException;

public class PingServer {
    public static void main(String []s){
        try{
            Server pingServer = new Server(Server.DEFAULT_SERVER_PORT, PingRequestManagerImpl.class);
            pingServer.start();
        }catch (IOException e){
            System.out.println("Unable to start server :(");
        }
    }
}
