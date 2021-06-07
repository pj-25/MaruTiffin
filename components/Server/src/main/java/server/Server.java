import networkConnection.SocketConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int SERVER_PORT = 5656;     //Default port number

    private ServerSocket serverSocket;
    private static ClientConnectionsHandler clientConnectionsHandler;
    private boolean isRunning = false;

    public Server(int serverPort) throws IOException {
        serverSocket = new ServerSocket(serverPort);
        clientConnectionsHandler = new ClientConnectionsHandler();
    }

    public Server() throws IOException{
        this(SERVER_PORT);
    }

    public static int getServerPort() {
        return SERVER_PORT;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ClientConnectionsHandler getClientConnectionsHandler() {
        return clientConnectionsHandler;
    }

    public void setClientConnectionsHandler(ClientConnectionsHandler ccHandler) {
        clientConnectionsHandler = ccHandler;
    }

    public void start(){
        System.out.println("Server started on "+getServerPort());
        isRunning = true;
        while(isRunning){
            try{
                Socket cSock = serverSocket.accept();
                createClientConnection(cSock);
            }
            catch (IOException e){
                System.err.println("Unable to accept client!");
            }
        }
        close();
    }

    private void createClientConnection(Socket cSock) throws IOException{
        SocketConnection socketConnection = new SocketConnection(cSock, (data)->{

        });
    }

    public void close(){
        try{
            serverSocket.close();
            isRunning = false;
            System.out.println("Server closed successfully!");
        }catch (IOException ignore){
        }
    }

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
