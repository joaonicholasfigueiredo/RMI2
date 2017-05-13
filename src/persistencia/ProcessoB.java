package persistencia;

import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ProcessoB {

	public ProcessoB() throws Exception {
//		semRmi();
		comRMI();
	}

	private void comRMI() throws Exception {
		Registry reg = LocateRegistry.createRegistry(1234);
		IBuscador controller = new Buscador();
		
		reg.rebind("crt", controller);
		System.out.println("Objeto cadastrado.");
	}

	private void semRmi() throws Exception {
		ServerSocket ss = new ServerSocket(5678);

		Socket accept = ss.accept();

		Scanner scan = new Scanner(accept.getInputStream());
		String comando = scan.nextLine();
		String[] partes = comando.split(" ");
		// Exec UsuarioController update nome joao pedro
		if(partes[0].equals("Exec")) {
			if(partes[1].equals("UsuarioController")) {
				Buscador uc = new Buscador();
				if(partes[2].equals("update")) {
					uc.update(partes[3], partes[4], partes[5]);
				}
				if(partes[2].equals("delete")) {
					uc.delete(partes[3]);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		new ProcessoB();
	}
}
