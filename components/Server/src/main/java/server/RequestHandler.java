package server;

import networkConnection.SocketConnection;

import java.io.IOException;
import java.net.Socket;


class RequestHandler extends SocketConnection implements RequestConsumer{

    private String response;
    private boolean hasResponse = false;

    public RequestHandler(Socket socket, RequestConsumer requestConsumer) throws IOException {
        super(socket, requestConsumer);
    }

    @Override
    public void accept(String msg) {
        getMessageDecoder().andThen(s -> {
            if(hasResponse){
                write(getResponse());
                hasResponse = false;
            }
        }).accept(msg);
    }

    public String getResponse() {
        return response;
    }

    @Override
    final public void setResponse(String response) {
        hasResponse = true;
        this.response = response;
    }
}
