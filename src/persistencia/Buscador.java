package persistencia;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

public class Buscador extends UnicastRemoteObject implements IBuscador {
    
    List<Buscador> lista;
    final String PATH = "C:\\Users\\marco\\Documents";

    public Buscador() throws RemoteException {
        super();
        
    }

    @Override
    public File buscar(String nomeDoDado) {
        File arquivo = encontrar(nomeDoDado);
        if (arquivo == null) {
            for (Buscador b : lista) {
                arquivo = b.buscar(nomeDoDado);
                if (arquivo != null) 
                    return arquivo;
            }
        }
        return arquivo;
    }

    private File encontrar(String nomeDoDado) {
        try {
            FileReader fr = new FileReader(PATH);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String[] dados;
                dados = linha.split(";");
                for (int i = 0; i < dados.length; i++) {
                    
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
