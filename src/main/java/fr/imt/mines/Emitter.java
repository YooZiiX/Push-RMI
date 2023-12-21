package fr.imt.mines;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Emitter extends Remote {

    void sendMessage(String to, String message) throws RemoteException;

}
