package main;

import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import persistencia.Buscador;
import persistencia.IBuscador;

public class ProcessoB {

    public ProcessoB() throws Exception {
        comRMI();
        Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",
                1234);
        System.out.println("Fazendo chamada.");
        IBuscador iuc = (IBuscador) rmiRegistry.lookup("A2");
    }

    private void comRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(1234);
        IBuscador controller = new Buscador();

        reg.rebind("A1", controller);
        System.out.println("Objeto cadastrado.");
    }

    public static void main(String[] args) throws Exception {
        new ProcessoB();
    }
}
