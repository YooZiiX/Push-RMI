package fr.imt.mines;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Connection extends Remote {

    Emitter connect(String nickname, Receiver rcv) throws RemoteException;
    void disconnect(String nickname) throws RemoteException;

}
