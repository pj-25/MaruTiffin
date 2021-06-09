package server;

import networkConnection.SocketConnection;
import networkConnection.messageHandler.MessageConsumer;

import java.io.IOException;
import java.net.Socket;


public class ServiceProvider extends SocketConnection implements RequestConsumer {

    private RequestConsumer requestConsumer;
    private String response;
    private boolean sendResponse = false;

    public ServiceProvider(Socket socket, MessageConsumer msgDecoder, RequestConsumer requestConsumer) throws IOException {
        super(socket, msgDecoder);
        this.requestConsumer = requestConsumer;
    }

    public ServiceProvider(String connectionIP, int connectionPort, MessageConsumer msgDecoder, RequestConsumer requestConsumer) throws IOException {
        super(connectionIP, connectionPort, msgDecoder);
        this.requestConsumer = requestConsumer;
    }

    public ServiceProvider(String connectionID, Socket socket, MessageConsumer msgDecoder, RequestConsumer requestConsumer) throws IOException {
        super(connectionID, socket, msgDecoder);
        this.requestConsumer = requestConsumer;
    }

    @Override
    public void consume(String... req) {
        requestConsumer.consume();
        if(sendResponse){
            write(response);
            sendResponse = false;
        }
    }

    public void setResponse(String response) {
        sendResponse = true;
        this.response = response;
    }
}
