import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String args[]){
		try{
			DAO bd=new DAO();
			ServerSocket server=new ServerSocket(9500);
			System.out.println("Listening..");
			while(true){
				Socket socket=server.accept();
				new Thread(new Worker(socket, bd)).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
   
}
