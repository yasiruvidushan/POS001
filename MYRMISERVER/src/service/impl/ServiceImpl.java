/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.observer;
import service.Service;

/**
 *
 * @author yasiru vidushan
 */
public class ServiceImpl extends UnicastRemoteObject implements Service{
    
    private static ArrayList<observer> allObservers = new ArrayList<>();

    public ServiceImpl() throws Exception{
    }
    

    @Override
    public String check(String message) throws Exception {
        System.out.println(message);
        notifyAllObserver(message);
        return message;
    }

    @Override
    public void register(observer ob) throws Exception {
        allObservers.add(ob);
    }

    @Override
    public void unregister(observer ob) throws Exception {
        allObservers.remove(ob);
        
    }

    @Override
    public void notifyAllObserver(String message) throws Exception {
         for (observer observer : allObservers) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                observer.update(message);
                            } catch (Exception ex) {
                                Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
            ).start();
        }
        
    }
    
}
