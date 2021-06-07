import java.net.Socket;

@FunctionalInterface
public interface ServeClient{
    void serve(Socket socket);
}
