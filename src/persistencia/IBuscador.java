package persistencia;


import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBuscador extends Remote {

    public File buscar(String nomeDoDado) throws RemoteException;

    public void addProximo(IBuscador iuc);
}
