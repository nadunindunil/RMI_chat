package com.test.rmi.client;

import com.test.rmi.server.ChatServerIF;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by nadunindunil on 11/5/17.
 */
public class ChatClientDriver {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String chatServerURL = "rmi://localhost/RMIChatServer";
        ChatServerIF chatServer = (ChatServerIF) Naming.lookup(chatServerURL);
        new Thread(new ChatClient(args[0],chatServer)).start();
    }
}
