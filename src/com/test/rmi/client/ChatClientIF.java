package com.test.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by nadunindunil on 11/5/17.
 */
public interface ChatClientIF extends Remote {
    void retrieveMessage(String message) throws RemoteException;

}
