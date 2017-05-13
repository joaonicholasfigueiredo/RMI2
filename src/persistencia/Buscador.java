package persistencia;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Buscador extends UnicastRemoteObject implements IBuscador {

    public Buscador() throws RemoteException {
        super();
    }

    public boolean update(String col, String valorAntigo, String novoValor) throws RemoteException {

        System.out.println("Atualizacao concluida");
        return true;
    }

    public void delete(String string) throws RemoteException {
        // TODO Auto-generated method stub

    }

}
