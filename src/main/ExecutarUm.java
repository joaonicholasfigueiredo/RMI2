package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import persistencia.IPesquisa;

public class ExecutarUm {

    public ExecutarUm() throws Exception {
        executaComRMI();
    }

    private void executaComRMI() throws Exception {
        Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",
                5577);
        System.out.println("Conectando");
        IPesquisa iuc = (IPesquisa) rmiRegistry.lookup("A1");

        iuc.buscar("data");
    }

    public static void main(String[] args) throws Exception {
        new ExecutarUm();
    }
}
