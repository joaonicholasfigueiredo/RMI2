package persistencia;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProcessoA {

	public ProcessoA() throws Exception {
//		executaSemRMI();
		executaComRMI();
	}
	
	private void executaComRMI() throws Exception {
		Registry rmiRegistry = LocateRegistry.getRegistry("127.0.0.1",
				1234);
		System.out.println("Fazendo chamada.");
		IBuscador iuc = (IBuscador) 
				rmiRegistry.lookup("crt");
		
		iuc.update("nome", "Pedro", "Joao");
	}

	private void executaSemRMI() throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1", 5678);
		s.getOutputStream().write(("Exec UsuarioController update nome "
				+ "joao pedro").getBytes());
	}

	public static void main(String[] args) throws Exception {
		new ProcessoA();
	}
}
