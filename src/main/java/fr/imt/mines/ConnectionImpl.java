package fr.imt.mines;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectionImpl extends UnicastRemoteObject implements Connection {

    private HashMap<String, Receiver> sessions = new HashMap<>();
    private ArrayList<String> userList = new ArrayList<>();

    protected ConnectionImpl() throws RemoteException {
    }

    @Override
    public Emitter connect(String nickname, Receiver rcv) throws RemoteException {
        EmitterImpl userEmitter = null;
        if (!userList.contains(nickname)) {
            userEmitter = new EmitterImpl();
            rcv.initClients(userList);
            userEmitter.setNickname(nickname);
            userEmitter.setSessions(sessions);
            addUser(nickname);
            userList.add(nickname);
            sessions.put(nickname, rcv);
            System.out.println("(+) " + nickname);
        } else {
            System.out.println("[System] : Error - Nickname \""+ nickname +"\" already use.");
        }
        return (Emitter) userEmitter;
    }

    private void addUser(String nickname) throws RemoteException {
        assert !userList.isEmpty() : "No Clients";
        for (String user : userList){
            sessions.get(user).addClient(nickname);
        }
    }

    @Override
    public void disconnect(String nickname) throws RemoteException {
        removeUser(nickname);
        System.out.println("(-) " + nickname);
    }

    private void removeUser(String nickname) throws RemoteException {
        assert !userList.isEmpty() : "No more Clients";
        sessions.remove(nickname);
        for (String user : userList){
            sessions.get(user).removeClient(nickname);
        }
    }
}
