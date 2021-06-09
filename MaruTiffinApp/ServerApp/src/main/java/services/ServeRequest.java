package services;

import server.RequestManager;


public class ServeRequest extends RequestManager {

    @Override
    public void accept(String req) {
        System.out.println("Request Received: " + req);
        write(req);
    }
}
