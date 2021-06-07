package server;

import networkConnection.SocketConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements RequestHandler, ServeClient {
    public final static int SERVER_PORT = 5656;     //Default port number

    private ServerSocket serverSocket;
    private RequestHandler requestHandler;
    private ServeClient serveClient;

    private ClientConnectionsHandler clientConnectionsHandler;
    private boolean isRunning = false;

    public Server(int serverPort, RequestHandler requestHandler) throws IOException {
        this(serverPort, socket -> {
            SocketConnection socketConnection = new SocketConnection(socket, requestHandler);
            socketConnection.run();
        }, requestHandler);
    }

    public Server(int serverPort) throws IOException{
        this(serverPort, null);
    }


    public Server() throws IOException{
        this(SERVER_PORT, null);
    }

    public Server(int serverPort, ServeClient serveClient, RequestHandler requestHandler) throws IOException{
        serverSocket = new ServerSocket(serverPort);
        this.serveClient = serveClient;
        this.requestHandler = requestHandler;
        clientConnectionsHandler = new ClientConnectionsHandler();
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

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public RequestHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public ServeClient getServeClient() {
        return serveClient;
    }

    public void setServeClient(ServeClient serveClient) {
        this.serveClient = serveClient;
    }

    public void start(){
        System.out.println("Server started on "+getServerPort());
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

    @Override
    public void consume(String... data) {
        if(requestHandler != null){
            requestHandler.consume(data);
        }
    }
}
