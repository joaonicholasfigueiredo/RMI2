package persistencia;


import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPesquisa extends Remote {

    public File buscar(String nomeDoDado) throws RemoteException;

    public void addProximo(IPesquisa iuc);
}
