import java.sql.*;
import java.util.ArrayList;

public class DAO {

	private Connection con;

	public DAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=root&password=root");
		}catch(Exception e){}
	}

  	public void close() {
		try{
			con.close();
		}catch(SQLException e){}
  	}

	public Carga CadastraEntrada(Carga c) {
		return c;
  	}

  	public void CadastraSaida(int ID, int DataSaida, int LocalSaida) {

  	}

}
