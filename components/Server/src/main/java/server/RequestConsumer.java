package server;

import networkConnection.messageHandler.MessageConsumer;

public interface RequestConsumer extends MessageConsumer {
    void setResponse(String msg);
}
