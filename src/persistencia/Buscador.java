package persistencia;


import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Buscador extends UnicastRemoteObject implements IBuscador {

    public Buscador() throws RemoteException {
        super();
    }

    @Override
    public File buscar(String nomeDoDado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
