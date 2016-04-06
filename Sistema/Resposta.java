public class Resposta {
	public final int CadatramentoCarga=1;
	public final int SaidaCarga=2;
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
