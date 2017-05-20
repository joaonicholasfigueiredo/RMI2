package persistencia;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Pesquisa extends UnicastRemoteObject implements IPesquisa {
    
    List<IPesquisa> lista = new ArrayList<>();
    final String PATH = "C:\\Users\\Aluno\\Desktop\\Conteudo_Everton\\Atividade_RMI";

    public Pesquisa() throws RemoteException {
        super();
    }

    @Override
    public File buscar(String nomeDoDado)  throws RemoteException{
        File arquivo = buscar2(nomeDoDado);
        if (arquivo == null) {
            for (IPesquisa b : lista) {
                arquivo = b.buscar(nomeDoDado);
                if (arquivo != null) 
                    return arquivo;
            }
        }
        return arquivo;
    }

    private File buscar2(String nomeDoDado) {
        try {
            File folder = new File(PATH);
            File files[] = folder.listFiles();
            for (File f: files) {
                FileReader fr = new FileReader(f.getAbsolutePath());
                BufferedReader br = new BufferedReader(fr);
                String linha = "";
                while ((linha = br.readLine()) != null) {
                    String[] dados;
                    dados = linha.split(";");
                    for (int j = 0; j < dados.length; j++) {
                        if (dados[j].equalsIgnoreCase(nomeDoDado))
                            return new File(f.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProximo(IPesquisa iuc) {
        this.lista.add(iuc);
    }
}
