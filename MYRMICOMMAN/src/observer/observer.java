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
public interface observer extends Remote{
    public void update(String message) throws Exception;
    
    
}
