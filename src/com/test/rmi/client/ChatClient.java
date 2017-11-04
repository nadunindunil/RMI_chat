package com.test.rmi.client;

import com.test.rmi.server.ChatServerIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Created by nadunindunil on 11/5/17.
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientIF, Runnable {
    private ChatServerIF chatServer;
    private String name = null;
    protected ChatClient(String name, ChatServerIF chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerChatClient(this);
        System.out.println(name + " is registered!");

    }

    @Override
    public void retrieveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void run() {
        System.out.println("client thread started.........");
        Scanner scan = new Scanner(System.in);
        String message;
        while(true){
            message = scan.nextLine();
            try {
                chatServer.broadcastMessage(name + " : " + message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
