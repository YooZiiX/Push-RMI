package fr.imt.mines;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceiverImpl extends UnicastRemoteObject implements Receiver {

    ArrayList<String> userList = new ArrayList<>();

    protected ReceiverImpl() throws RemoteException {
    }

    @Override
    public void receive(String from, String message) throws RemoteException {
        System.out.println(from + " : " + message);
    }

    @Override
    public void initClients(ArrayList<String> clients) throws RemoteException {
        this.userList = clients;
        System.out.println(userList);
    }

    @Override
    public void addClient(String client) throws RemoteException {
        if (!userList.contains(client)) {
            this.userList.add(client);
            System.out.println("(+) " + client);
        }
    }

    @Override
    public void removeClient(String client) throws RemoteException {
        if (userList.contains(client)){
            this.userList.remove(client);
            System.out.println("(-) " + client);
        }
    }
}
