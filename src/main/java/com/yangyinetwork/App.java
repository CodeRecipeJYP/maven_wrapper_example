package com.yangyinetwork;


public class App {
    public static void main( String[] args ) {
        SocketManager socketManager = new SocketManager(8080);
        socketManager.open();
    }
}
