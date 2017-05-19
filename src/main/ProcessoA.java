package main;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import persistencia.IBuscador;

public class ProcessoA {

    public ProcessoA() throws Exception {
        executaComRMI();
    }

    private void executaComRMI() throws Exception {
        Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",
                1234);
        System.out.println("Fazendo chamada.");
        IBuscador iuc = (IBuscador) rmiRegistry.lookup("A1");

        iuc.buscar("dia");
    }

    public static void main(String[] args) throws Exception {
        new ProcessoA();
    }
}
