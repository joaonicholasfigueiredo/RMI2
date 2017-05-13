package persistencia;


import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Buscador extends UnicastRemoteObject implements IBuscador {
    
    List<Buscador> lista;
    final String PATH = "C:\\Users\\marco\\Documents";

    public Buscador() throws RemoteException {
        super();
        
    }

    @Override
    public File buscar(String nomeDoDado) {
        File arquivo = encontrar();
        if(arquivo == null)
            for (Buscador b: lista) {
                arquivo = b.buscar(nomeDoDado);
                if (arquivo != null) return arquivo;
            }
        return arquivo;
    }
}
