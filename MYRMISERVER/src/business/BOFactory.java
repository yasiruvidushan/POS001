/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author yasiru vidushan
 */
public class BOFactory {
    public static BOFactory bOFactory;
    
    private BOFactory(){
        
    }
    public static BOFactory getInstance(){
        if(bOFactory == null){
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public enum BOFactoryTypes {
        CUSTOMER;
    }
    public SuperBO getBO(BOFactoryTypes types){
        switch(types){
            case CUSTOMER:
                return new CustomerBoImpl();
                default:
                    return null;
                    
        }
    }
    
}
