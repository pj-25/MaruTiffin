package server;

import networkConnection.SocketConnection;
import networkConnection.messageHandler.MessageConsumer;

import java.io.IOException;
import java.net.Socket;

public class userConnection extends SocketConnection {

    //private UserType userType;    //********

    public userConnection(Socket socket, MessageConsumer msgDecoder) throws IOException {
        super(socket, msgDecoder);
    }

    public userConnection(String connectionIP, int connectionPort, MessageConsumer msgDecoder) throws IOException {
        super(connectionIP, connectionPort, msgDecoder);
    }

    public userConnection(String connectionID, Socket socket, MessageConsumer msgDecoder) throws IOException {
        super(connectionID, socket, msgDecoder);
    }
}
