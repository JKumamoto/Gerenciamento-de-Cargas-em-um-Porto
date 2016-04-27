import java.io.Serializable;

public class Funcionario implements Serializable{

	private static final long serialVersionUID=1L;
	private long CPF;
	private int RG;
	private String Nome;
	private String Endereco;
	private int Telefone;
	private String DataNasc;
	private String Email;
	private boolean Administrador;
	private String Senha;

	public Funcionario(long CPF, int RG, String Nome, String Endereco, int Telefone, String DataNasc, String Email, boolean Administrador){
		this.CPF=CPF;
		this.RG=RG;
		this.Nome=Nome;
		this.Endereco=Endereco;
		this.Telefone=Telefone;
		this.DataNasc=DataNasc;
		this.Email=Email;
		this.Administrador=Administrador;
	}

	public Funcionario(long CPF, String Senha){
		this.CPF=CPF;
		this.Senha=Senha;
	}

	public long getCPF(){
		return CPF;
	}

	public int getRG(){
		return RG;
	}

	public String getNome(){
		return Nome;
	}
	
	public void setNome(String Nome){
		this.Nome=Nome;
	}

	public String getEndereco(){
		return Endereco;
	}

	public void setEndereco(String Endereco){
		this.Endereco=Endereco;
	}

	public int getTelefone(){
		return Telefone;
	}

	public void setTelefone(int Telefone){
		this.Telefone=Telefone;
	}

	public String getDataNasc(){
		return DataNasc;
	}

	public String getEmail(){
		return Email;
	}

	public boolean isAdministrador(){
		return Administrador;
	}

	public void setAdministrador(boolean Administrador){
		this.Administrador=Administrador;
	}
	
	public String getSenha(){
		return Senha;
	}

	public void setSenha(String Senha){
		this.Senha=Senha;
	}

}

