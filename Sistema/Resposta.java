import java.io.Serializable;

public class Resposta implements Serializable{

	private static final long serialVersionUID=1L;
	public static final int ErroAlteraFuncionario=-8;
	public static final int ErroCadastroFuncionario=-7;
	public static final int ErroCPF=-6;
	public static final int ErroLogin=-5;
	public static final int PatioCheio=-4;
	public static final int ErroID=-3;
	public static final int ErroSaidaCarga=-2;
	public static final int ErroCadastramentoCarga=-1;
	public static final int ErroDesconhecido=0;
	public static final int CadastramentoCarga=1;
	public static final int SaidaCarga=2;
	public static final int Login=3;
	public static final int CadastroFuncionario=4;
	public static final int AlteraFuncionario=4;
	public static final int Promove=6;
	private int tipo;
	private Carga carga;
	private Funcionario funcionario;

	public void setTipo(int tipo){
		this.tipo=tipo;
	}

	public int getTipo(){
		return tipo;
	}

	public void setCarga(Carga carga){
		this.carga=carga;
	}

	public Carga getCarga(){
		return carga;
	}

	public void setFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;
	}

	public Funcionario getFuncionario(){
		return funcionario;
	}
}
