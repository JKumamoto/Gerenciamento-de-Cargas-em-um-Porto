import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DAO {

	private Connection con;
	private Patio patio;
	private ArrayList<Carga> cargas;
	private HashMap<Long, Funcionario> funcionarios;

	public DAO(){
		String url="jdbc:mysql://localhost/porto";
		String root="root";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, root, root);
			if(con!=null)
				System.out.println("Banco de Dados Conectado");
			else
				throw new SQLException();
			IniciaPatio();
			RecuperaCarga();
			RecuperaFuncionario();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

  	public void close() {
		try{
			con.close();
		}catch(SQLException e){}
  	}

	private void RecuperaFuncionario() throws SQLException{
		funcionarios=new HashMap<Long, Funcionario>();
		Statement st=con.createStatement();
		Funcionario temp;
		ResultSet rs=st.executeQuery("SELECT * FROM funcionario");

		while(rs.next()){
			temp=new Funcionario(rs.getLong("CPF"), rs.getInt("RG"), rs.getString("nome"), rs.getString("endereco"),
							rs.getInt("fone"), rs.getString("data_nasc"), rs.getString("email"),
							rs.getBoolean("administrador")); 
			temp.setSenha(rs.getString("senha"));
			funcionarios.put(temp.getCPF(), temp);
		}
	}

	private void RecuperaCarga() throws SQLException{
		cargas=new ArrayList<Carga>();
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
	}

	private void IniciaPatio() throws SQLException{
		patio=new Patio(1001);
		Statement st=con.createStatement();
		int id;
		ResultSet rs=st.executeQuery("SELECT posicao FROM patio WHERE ocupado=true");
		while(rs.next()){
			id=rs.getInt("posicao");
			patio.ColocaCarga(id);
		}
	}

	public Resposta CadastraEntrada(Carga c) throws SQLException{
		Resposta resposta=new Resposta();
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
		c.setID(cargas.size());
		c.setPosicao(i);
		cargas.add(c);
		String op1="INSERT INTO carga VALUES("+c.getID()+", "+c.getPosicao()+", '"+c.getDataChegada()+"', "+
			c.getLocalChegada()+", '"+c.getTempoPrevisto()+"', NULL, NULL, '"+c.getDono()+"', '"+c.getRemetente()+
			"', '"+c.getDestinatario()+"')";

		st1.execute(op1);
		st2.execute(op2);
		resposta.setTipo(Resposta.CadastramentoCarga);
		resposta.setCarga(c);
		return resposta;
  	}

  	public Resposta CadastraSaida(int ID, String DataSaida, boolean LocalSaida) throws SQLException{
		Resposta resposta=new Resposta();
		if(cargas.size()<ID||cargas.get(ID).getPosicao()==1000){
			resposta.setTipo(Resposta.ErroID);
			return resposta;
		}
		CallableStatement cs=con.prepareCall("{call sp_saida_carga(?, ?, ?, ?)}");
		cs.setInt(1, ID);
		cs.setString(2, DataSaida);
		cs.setBoolean(3, LocalSaida);
		cs.setInt(4, cargas.get(ID).getPosicao());
		cs.execute();
		patio.Libera(cargas.get(ID).getPosicao());
		cargas.get(ID).Saida(DataSaida, LocalSaida);
		resposta.setTipo(Resposta.SaidaCarga);
		return resposta;
  	}

	public Resposta Login(long cpf, String senha) throws SQLException{
		Resposta resposta=new Resposta();
		if(funcionarios.containsKey(cpf))
			if(funcionarios.get(cpf).getSenha().equals(senha)){
				resposta.setTipo(Resposta.Login);
				resposta.setFuncionario(funcionarios.get(cpf));
			}else
				resposta.setTipo(Resposta.ErroLogin);
		else
			resposta.setTipo(Resposta.ErroCPF);
		return resposta;
	}

	public Resposta CadastraFuncionario(Funcionario f) throws SQLException{
		Resposta resposta=new Resposta();
		if(funcionarios.containsKey(f.getCPF()))
			resposta.setTipo(Resposta.ErroLogin);
		else{
			Statement st=con.createStatement();
			String op="INSERT INTO funcionario VALUES("+f.getCPF()+", "+f.getRG()+", '"+
				f.getNome()+"', '"+f.getEndereco()+"', "+f.getTelefone()+", '"+
				f.getDataNasc()+"', '"+f.getEmail()+"', "+f.isAdministrador()+", '0000')";
			st.execute(op);
			funcionarios.put(f.getCPF(), f);
			resposta.setTipo(Resposta.CadastroFuncionario);
		}
		return resposta;
	}

	public Resposta AlteraFuncionario(Funcionario f, boolean promove) throws SQLException{
		Resposta resposta=new Resposta();
		if(funcionarios.containsKey(f.getCPF())){
			Statement st=con.createStatement();
			if(!f.getNome().equals(""))
				funcionarios.get(f.getCPF()).setNome(f.getNome());
			if(!f.getEndereco().equals(""))
				funcionarios.get(f.getCPF()).setEndereco(f.getEndereco());
			if(f.getTelefone()!=0)
				funcionarios.get(f.getCPF()).setTelefone(f.getTelefone());
			if(!f.getSenha().equals(""))
				funcionarios.get(f.getCPF()).setSenha(f.getSenha());
			funcionarios.get(f.getCPF()).setAdministrador(promove);
			Funcionario fa=funcionarios.get(f.getCPF());
			String op="UPDATE funcionario SET nome='"+fa.getNome()+"', endereco='"+fa.getEndereco()+
				"', fone="+fa.getTelefone()+", senha='"+fa.getSenha()+"' WHERE cpf="+fa.getCPF();
			st.execute(op);
			resposta.setTipo(Resposta.AlteraFuncionario);
		}else
			resposta.setTipo(Resposta.ErroCPF);
		return resposta;
	}

	public Resposta DelFuncionario(long cpf) throws SQLException{
		Resposta resposta=new Resposta();
		if(funcionarios.containsKey(cpf)){
			Statement st=con.createStatement();
			String op="DELETE FROM funcionario WHERE funcionario.cpf="+cpf;
			st.execute(op);
			funcionarios.remove(cpf);
			resposta.setTipo(Resposta.DelFuncionario);
		}else
			resposta.setTipo(Resposta.ErroCPF);
		return resposta;
	}

	public Resposta UpCarga(Carga c) throws SQLException{
		Resposta resposta=new Resposta();
		if(cargas.size()>c.getID()){
			Statement st=con.createStatement();
			if(!c.getDono().equals(""))
				cargas.get(c.getID()).setDono(c.getDono());
			if(!c.getRemetente().equals(""))
				cargas.get(c.getID()).setRemetente(c.getRemetente());
			if(!c.getDestinatario().equals(""))
				cargas.get(c.getID()).setDestinatario(c.getDestinatario());
			Carga ca=cargas.get(c.getID());
			String op="UPDATE carga SET TempoPrevisto='"+ca.getTempoPrevisto()+"', Dono='"+ca.getDono()+
				"', Remetente='"+ca.getRemetente()+"', Destinatario='"+ca.getDestinatario()+"' WHERE id="+ca.getID();
			st.execute(op);
			resposta.setTipo(Resposta.AlteraCarga);
		}else
			resposta.setTipo(Resposta.ErroID);
		return resposta;
	}

}
