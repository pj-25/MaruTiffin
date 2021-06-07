package networkConnection.messageHandler;

import java.io.IOException;

@FunctionalInterface
public interface MessageConsumer {
    void consume(String ...msg) throws IOException;
}
