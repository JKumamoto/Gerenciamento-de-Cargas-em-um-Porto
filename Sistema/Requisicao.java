public class Requisicao {

	public static final int ErroCadastramentoCarga=-1;
	public static final int ErroSaidaCarga=-2;
	public static final int ErroDesconhecido=0;
	public static final int CadastramentoCarga=1;
	public static final int SaidaCarga=2;
	private int tipo;
	private Carga carga;

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
}
