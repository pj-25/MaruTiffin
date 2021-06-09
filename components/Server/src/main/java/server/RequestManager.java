package server;

import networkConnection.SocketConnection;


abstract public class RequestManager extends SocketConnection implements RequestConsumer{

    private String response;
    private boolean hasResponse = false;

    private ClientConnectionsHandler clientConnectionsHandler = new ClientConnectionsHandler();

    @Override
    abstract public void accept(String req);

    @Override
    public void run(){
        run(this);
    }

    public String getResponse() {
        return response;
    }

    @Override
    final public void setResponse(String response) {
        hasResponse = true;
        this.response = response;
    }

    public void sendResponse(){
        write(response);
        hasResponse = false;
    }

    public ClientConnectionsHandler getClientConnectionsHandler() {
        return clientConnectionsHandler;
    }

    public void setClientConnectionsHandler(ClientConnectionsHandler ccHandler) {
        clientConnectionsHandler = ccHandler;
    }
}
