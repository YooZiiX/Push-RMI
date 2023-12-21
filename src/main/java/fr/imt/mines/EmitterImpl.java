package fr.imt.mines;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class EmitterImpl extends UnicastRemoteObject implements Emitter {

    private String nickname;
    private HashMap<String, Receiver> sessions;

    protected EmitterImpl() throws RemoteException {
    }

    @Override
    public void sendMessage(String to, String message) throws RemoteException {
        if (sessions.get(to) != null ){
            System.out.println(nickname + " -> " + to + " : " + message);
            sessions.get(to).receive(nickname, message);
        }
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSessions(HashMap<String, Receiver> sessions) {
        this.sessions = sessions;
    }
}
