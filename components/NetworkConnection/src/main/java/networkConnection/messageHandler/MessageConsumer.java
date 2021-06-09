package networkConnection.messageHandler;

@FunctionalInterface
public interface MessageConsumer {
    void consume(String ...msg);
}
