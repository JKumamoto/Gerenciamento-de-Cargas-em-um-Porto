import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class Server extends UnicastRemoteObject implements Server_Interface{

	private static final long serialVersionUID=1L;
	private DAO bd;
	
	public Server() throws RemoteException{
		super();
		bd=new DAO();
	}

	public Resposta EntradaCarga(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		try{
			rep=bd.CadastraEntrada(req.getCarga());
		}catch(SQLException e){
			rep.setTipo(Resposta.ErroCadastramentoCarga);
		}
		return rep;
	}

	public Resposta SaidaCarga(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		Carga c=req.getCarga();
		try{
			rep=bd.CadastraSaida(c.getID(), c.getDataSaida(), c.getLocalSaida());
		}catch(SQLException e){
			rep.setTipo(Resposta.ErroSaidaCarga);
			e.printStackTrace();
		}
		return rep;
	}

	public Resposta Login(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		Funcionario f=req.getFuncionario();
		try{
			rep=bd.Login(f.getCPF(), f.getSenha());
		}catch(SQLException e){
			rep.setTipo(Resposta.ErroDesconhecido);
		}
		return rep;
	}
	
	public Resposta CadastraFuncionario(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		try{
			rep=bd.CadastraFuncionario(req.getFuncionario());
		}catch(SQLException e){
			rep.setTipo(Resposta.ErroCadastroFuncionario);
		}
		return rep;
	}

	public Resposta AlteraFuncionario(Requisicao req) throws RemoteException{
		Resposta rep=new Resposta();
		Funcionario f=req.getFuncionario();
		try{
			rep=bd.AlteraFuncionario(f, f.isAdministrador());
		}catch(SQLException e){
			rep.setTipo(Resposta.ErroAlteraFuncionario);
		}
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
