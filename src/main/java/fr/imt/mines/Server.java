package fr.imt.mines;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args){
        try {
            // registry creation
            LocateRegistry.createRegistry(1099);

            // component instanciation and implicit activation
            ConnectionImpl ConnectionComponent = new ConnectionImpl();

            System.out.println(ConnectionComponent.getRef().remoteToString());

            //publication of component reference in the registry
            Naming.rebind("Connection", ConnectionComponent);

            System.out.println("[System] : Server's ready");

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
