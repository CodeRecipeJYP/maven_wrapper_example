package com.yangyinetwork;


import com.yangyinetwork.server.SocketManager;

public class Main {
    public static void main( String[] args ) {
        SocketManager socketManager = new SocketManager(8080);
        socketManager.open();
    }
}
