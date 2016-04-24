public class Patio {

	private boolean Posicoes[];
	private int size;

	public Patio(int qtde){
		size=qtde;
		Posicoes=new boolean[size];
		for(int i=0; i<qtde; i++)
			Posicoes[i]=false;
  	}

	public int getSize(){
		return size;
	}

	public void Libera(int Posicao) {
		Posicoes[Posicao]=false;
  	}

	public boolean Ocupado(int Posicao) {
		return Posicoes[Posicao];
  	}

	public void ColocaCarga(int Posicao) {
		Posicoes[Posicao]=true;
  	}

}
