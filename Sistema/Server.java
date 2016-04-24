import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server extends UnicastRemoteObject implements Server_Interface{

	private static final long serialVersionUID=1L;
	private DAO bd;
	
	public Server() throws RemoteException{
		super();
		bd=new DAO();
	}

	public Resposta EntradaCarga(Requisicao req) throws RemoteException{
		Resposta rep=bd.CadastraEntrada(req.getCarga());
		System.out.println("Cadastramento de Carga requisitado\nResposta="+rep.getTipo());
		return rep;
	}

	public Resposta SaidaCarga(Requisicao req) throws RemoteException{
		Carga c=req.getCarga();
		Resposta rep=bd.CadastraSaida(c.getID(), c.getDataSaida(), c.getLocalSaida());
		System.out.println("Saída de Carga requisitado\nResposta="+req.getTipo());
		return rep;
	}

	public static void main(String args[]){
		try{
			Server_Interface Servidor=new Server();
			Naming.rebind("rmi://localhost/Servidor", Servidor);
			System.out.println("Rodando...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
