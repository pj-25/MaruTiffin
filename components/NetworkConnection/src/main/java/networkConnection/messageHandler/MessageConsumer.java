package networkConnection.messageHandler;

import java.util.function.Consumer;

@FunctionalInterface
public interface MessageConsumer extends Consumer<String> {
}
