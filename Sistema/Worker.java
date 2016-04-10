import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Worker implements Runnable{

	private Socket Cliente;
	private DAO bd;

	public Worker(Socket Cliente, DAO bd){
		this.Cliente=Cliente;
		this.bd=bd;
  	}

	public void run() {
		try{
			ObjectInputStream in=new ObjectInputStream(Cliente.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(Cliente.getOutputStream());
			Requisicao req=(Requisicao)in.readObject();
			Resposta rep=cases(req);
			out.writeObject(rep);
			
			out.close();
			in.close();
			Cliente.close();
		}catch(Exception e){
			e.printStackTrace();
		}
  	}

	private Resposta cases(Requisicao req){
		Resposta rep=new Resposta();
		switch(req.getTipo()){
			case Requisicao.CadastramentoCarga:
				try{
					System.out.println("Cadastramento de Carga requisitado por: "
								+Cliente.getInetAddress().getHostAddress());
					Carga c=bd.CadastraEntrada(rep.getCarga());
					rep.setTipo(Resposta.CadastramentoCarga);
					rep.setCarga(c);
				}catch(Exception e){
					rep.setTipo(Resposta.ErroCadastramentoCarga);
				}
				break;
			case Requisicao.SaidaCarga:
				try{
					System.out.println("Saída de Carga requisitado por: "
								+Cliente.getInetAddress().getHostAddress());
					Carga ca=req.getCarga();
					bd.CadastraSaida(ca.getID(), ca.getDataSaida(), ca.getLocalSaida());
					rep.setTipo(Resposta.SaidaCarga);
				}catch(Exception e){
					rep.setTipo(Resposta.ErroSaidaCarga);
				}
				break;
			default:
				System.out.println("Erro desconhecido");
				rep.setTipo(Resposta.ErroDesconhecido);
				break;
		}
		return rep;
	}

}
