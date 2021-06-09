package services;

import networkConnection.messageHandler.MessageConsumer;
import server.RequestConsumer;
import server.RequestHandler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServeRequest implements RequestConsumer {

    @Override
    public void consume(String... req) {
        System.out.println(req[0]);
    }

    @Override
    public void sendResponse(String s) {

    }

    @Override
    public DataOutputStream getDataOutputStream() {
        return null;
    }
}
