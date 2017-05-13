package persistencia;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBuscador extends Remote {

    public boolean update(String col, String valorAntigo, String novoValor) throws RemoteException;

    public void delete(String id) throws RemoteException;
}
