import server.RequestManager;

public class PingRequestManagerImpl extends RequestManager {
    @Override
    public void accept(String msg){
        System.out.println("Received Request: "+msg);
        write(msg);
    }
}
