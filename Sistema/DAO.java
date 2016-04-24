import java.sql.*;
import java.util.ArrayList;

public class DAO {

	private Connection con;
	private Patio patio;
	private ArrayList<Carga> cargas;

	public DAO(){
		String url="jdbc:mysql://localhost:3306/porto";
		String root="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, root, root);
			if(con!=null)
				System.out.println("Banco de Dados Conectado");
			else
				throw new SQLException("Erro na conexão com o banco de dados");

			IniciaPatio();
			RecuperaCarga();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

  	public void close() {
		try{
			con.close();
		}catch(SQLException e){}
  	}

	private void RecuperaCarga(){
		cargas=new ArrayList<Carga>();
		try{
			Statement st=con.createStatement();
			Carga temp;
			ResultSet rs=st.executeQuery("SELECT * FROM carga");

			while(rs.next()){
				int id=rs.getInt("id"), pos=rs.getInt("Posicao");
				String d_chega=rs.getString("DataChegada");
				boolean l_chega=rs.getBoolean("LocalChegada");
				String previsto=rs.getString("TempoPrevisto"), d_saida=rs.getString("DataSaida");
				boolean l_saida=rs.getBoolean("LocalSaida");
				String dono=rs.getString("Dono"), remetente=rs.getString("Remetente"), destinatario=rs.getString("Destinatario");
				temp=new Carga(d_chega, l_chega, previsto, dono, remetente, destinatario);
				temp.setID(id);
				temp.setPosicao(pos);
				if(pos==1000)	temp.Saida(d_saida, l_saida);
				cargas.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void IniciaPatio(){
		patio=new Patio(1001);
		try{
			Statement st=con.createStatement();
			int id;
			ResultSet rs=st.executeQuery("SELECT posicao FROM patio WHERE ocupado=true");
			while(rs.next()){
				id=rs.getInt("posicao");
				patio.ColocaCarga(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Resposta CadastraEntrada(Carga c) {
		Resposta resposta=new Resposta();
		try{
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			int i=0;
			while(patio.Ocupado(i))	i++;
			if(i==1000){
				resposta.setTipo(Resposta.PatioCheio);
				return resposta;
			}
			String op2="UPDATE patio SET ocupado=true WHERE patio.posicao="+i;
			patio.ColocaCarga(i);
			if(cargas.isEmpty())	c.setID(0);
			else	c.setID(cargas.size());
			c.setPosicao(i);
			cargas.add(c);
			String op1="INSERT INTO carga VALUES("+c.getID()+", "+c.getPosicao()+", '"+c.getDataChegada()+"', "+
				c.getLocalChegada()+", '"+c.getTempoPrevisto()+"', null, null, '"+c.getDono()+"', '"+c.getRemetente()+
				"', '"+c.getDestinatario()+"')";

			st1.execute(op1);
			st2.execute(op2);
			resposta.setTipo(Resposta.CadastramentoCarga);
			resposta.setCarga(c);
		}catch(SQLException e){
			resposta.setTipo(Resposta.ErroCadastramentoCarga);
			System.out.println("Erro no Cadastro");
			e.printStackTrace();
		}
		return resposta;
  	}

  	public Resposta CadastraSaida(int ID, String DataSaida, boolean LocalSaida) {
		Resposta resposta=new Resposta();
		try{
			if(cargas.size()<ID||cargas.get(ID).getPosicao()==1000){
				resposta.setTipo(Resposta.ErroID);
				return resposta;
			}
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			String op1="UPDATE carga SET Posicao=1000, DataSaida="+DataSaida+", LocalSaida="+LocalSaida+" WHERE carga.id="+ID;
			String op2="UPDATE patio SET ocupado=false WHERE patio.posicao="+cargas.get(ID).getPosicao();
			st1.execute(op1);
			st2.execute(op2);
			patio.Libera(cargas.get(ID).getPosicao());
			cargas.get(ID).Saida(DataSaida, LocalSaida);
			resposta.setTipo(Resposta.SaidaCarga);
		}catch(SQLException e){
			resposta.setTipo(Resposta.ErroSaidaCarga);
			e.printStackTrace();
		}
		return resposta;
  	}

}
