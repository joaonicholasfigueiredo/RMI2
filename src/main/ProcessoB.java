package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import persistencia.Buscador;
import persistencia.IBuscador;

public class ProcessoB {

    public ProcessoB() throws Exception {
        comRMI();        
    }

    private void comRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(1234);
        IBuscador buscador = new Buscador();
        IBuscador iuc = (IBuscador) reg.lookup("A1");

        buscador.addProximo(iuc);
        
        reg.rebind("A1", buscador);
        System.out.println("Objeto cadastrado.");
    }

    public static void main(String[] args) throws Exception {
        new ProcessoB();
    }
}
