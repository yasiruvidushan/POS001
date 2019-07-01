/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.impl.ServiceImpl;

/**
 *
 * @author yasiru vidushan
 */
public class Start {

    
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(5050);
            reg.rebind("IJSE", (Remote) new ServiceImpl());
            System.out.println("Server is started"); //if server is started the console will given this message
        } catch (RemoteException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
