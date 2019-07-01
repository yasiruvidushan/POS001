/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.Remote;

/**
 *
 * @author yasiru vidushan
 */
public interface subject extends Remote{
    public void register(observer ob) throws Exception;
    public void unregister(observer ob) throws Exception;
    public void notifyAllObserver(observer ob) throws Exception;
    
}
