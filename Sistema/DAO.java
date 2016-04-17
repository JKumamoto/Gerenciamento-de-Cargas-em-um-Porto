import java.sql.*;
import java.util.ArrayList;

public class DAO {

	private Connection con;
	private Patio patio;
	private ArrayList<Carga> cargas;

	public DAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=root&password=root");
			patio=new Patio(1000);
			cargas=new ArrayList<>();
		}catch(Exception e){}
	}

  	public void close() {
		try{
			con.close();
		}catch(SQLException e){}
  	}

	public Carga CadastraEntrada(Carga c) {
		try{
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			int i=0;
			while(!patio.Ocupado(i))
				i++;
			String op2="UPDATE patio SET ocupado=true";

			if(patio.ColocaCarga(i)){
				c.setID(cargas.size());
				c.setPosicao(i);
				cargas.add(c);

				String op1="INSERT INTO carga VALUES("+c.getID()+", "
					+c.getPosicao()+", '"+c.getDataChegada()+"', "+
					c.getLocalChegada()+", '"+c.getTempoPrevisto()+
					"', null, null, '"+c.getDono()+"', '"+c.getRemetente()+
					"', '"+c.getDestinatario()+"')";

				st1.execute(op1);
				st2.execute(op2);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
  	}

  	public boolean CadastraSaida(int ID, String DataSaida, boolean LocalSaida) {
		try{
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();

			String op1="UPDATE carga SET Posicao=1000, DataSaida="
				+DataSaida+", LocalSaida="+LocalSaida+" WHERE carga.id="+ID;
			String op2="UPDATE patio SET ocupado=false";

			st1.execute(op1);
			st2.execute(op2);

			if(patio.Libera(cargas.get(ID).getID())){
				cargas.get(ID).Saida(DataSaida, LocalSaida);
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
  	}

}
