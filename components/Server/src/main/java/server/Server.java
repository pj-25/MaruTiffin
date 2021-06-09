package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ServeClient {
    public final static int DEFAULT_SERVER_PORT = 5656;     //Default port number

    private ServerSocket serverSocket;

    private ServeClient serveClient;

    private ClientConnectionsHandler clientConnectionsHandler;
    private boolean isRunning = false;

    public Server(int serverPort, RequestConsumer requestConsumer) throws IOException {
        this(serverPort,socket-> {
            RequestHandler requestHandler = new RequestHandler(socket, requestConsumer);
            requestHandler.run();
        });
    }

    public Server(int serverPort) throws IOException{
        this(serverPort, (ServeClient) null);
    }

    public Server() throws IOException{
        this(DEFAULT_SERVER_PORT, (ServeClient) null);
    }

    public Server(RequestConsumer requestConsumer) throws IOException{
        this(DEFAULT_SERVER_PORT, requestConsumer);
    }

    public Server(int serverPort, ServeClient serveClient) throws IOException{
        serverSocket = new ServerSocket(serverPort);
        this.serveClient = serveClient;
        clientConnectionsHandler = new ClientConnectionsHandler();
    }

    public static int getDefaultServerPort() {
        return DEFAULT_SERVER_PORT;
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

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }


    public ServeClient getServeClient() {
        return serveClient;
    }

    public void setServeClient(ServeClient serveClient) {
        this.serveClient = serveClient;
    }

    public void start(){
        System.out.println("Server started on "+ getDefaultServerPort());
        isRunning = true;
        while(isRunning){
            try{
                Socket cSock = serverSocket.accept();
                serve(cSock);
            }
            catch (IOException e){
                System.err.println("Unable to accept client!");
            }
        }
        close();
    }

    public void close(){
        try{
            clientConnectionsHandler.closeAll();
            serverSocket.close();
            isRunning = false;
            System.out.println("Server closed successfully!");
        }catch (IOException ignore){
        }
    }


    @Override
    public void serve(Socket socket) {
        if(serveClient!=null){
            new Thread(()->{
                try {
                    serveClient.serve(socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }).start();
        }
    }

}
