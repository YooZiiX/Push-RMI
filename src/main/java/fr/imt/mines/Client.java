package fr.imt.mines;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Connection myConnectionComponent;
        try {
            myConnectionComponent = (Connection) Naming.lookup("rmi://localhost:1099/Connection");
            ReceiverImpl userReceiver = new ReceiverImpl();
            Emitter userEmitter = null;
            Scanner s = new Scanner(System.in);
            while (userEmitter == null) {
                System.out.println("Entrez votre nom et appuyez sur Entrée:");
                String username = s.nextLine().trim();
                userEmitter = myConnectionComponent.connect(username, userReceiver);
            }
            while (true) {
                System.out.println("To :");
                String dest = s.nextLine().trim();
                System.out.println("Message :");
                String message = s.nextLine().trim();
                userEmitter.sendMessage(dest, message);
            }
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
