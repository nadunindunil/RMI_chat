package com.test.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by nadunindunil on 11/5/17.
 */
public class ChatServerDriver {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Naming.rebind("RMIChatServer",new ChatServer());
        System.out.println("chat server starting.....");
    }
}
