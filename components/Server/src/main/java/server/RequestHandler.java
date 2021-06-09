package server;

@FunctionalInterface
public interface RequestHandler {
    void handle(String req);
}
