package persistencia;


import java.io.File;
import java.rmi.Remote;

public interface IBuscador extends Remote {

    public File buscar(String nomeDoDado);
}
