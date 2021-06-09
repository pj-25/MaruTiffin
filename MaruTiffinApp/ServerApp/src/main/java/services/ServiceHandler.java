package services;

import networkConnection.messageHandler.MessageConsumer;
import server.RequestHandler;

import java.io.IOException;
import java.net.Socket;

public class ServiceHandler extends RequestHandler {

    public ServiceHandler(Socket socket, RequestHandler msgDecoder) throws IOException {
        super(socket, msgDecoder);
    }
}
