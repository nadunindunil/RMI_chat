package com.test.rmi.server;
import com.test.rmi.client.ChatClientIF;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by nadunindunil on 11/5/17.
 */
public interface ChatServerIF extends Remote {
    void registerChatClient(ChatClientIF chatClient) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
}
