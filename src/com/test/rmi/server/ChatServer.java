package com.test.rmi.server;

import com.test.rmi.client.ChatClientIF;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by nadunindunil on 11/5/17.
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerIF {
    public static final long serialVersionUID = 1L;
    private ArrayList<ChatClientIF> chatClients;
    protected ChatServer() throws RemoteException {
        chatClients = new ArrayList<>();
    }

    @Override
    public void registerChatClient(ChatClientIF chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
        System.out.println("new client added!");
    }

    @Override
    public synchronized void broadcastMessage(String message) throws RemoteException {
        int i = 0;
        System.out.println("broadcasting...........");
        while (i < chatClients.size()){
            chatClients.get(i++).retrieveMessage(message);
        }
    }
}
