import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server_Interface extends Remote{
	public Resposta EntradaCarga(Requisicao req) throws RemoteException;
	public Resposta SaidaCarga(Requisicao req) throws RemoteException;
}
