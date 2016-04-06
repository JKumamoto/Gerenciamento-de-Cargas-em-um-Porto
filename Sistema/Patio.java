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

	public boolean Libera(int Posicao) {
		if(!Posicoes[Posicao])	return false;
		Posicoes[Posicao]=false;
		return true;
  	}

	public boolean Ocupado(int Posicao) {
		return Posicoes[Posicao];
  	}

	public boolean ColocaCarga(int Posicao) {
		if(Posicoes[Posicao])	return false;
		Posicoes[Posicao]=true;
		return true;
  	}

}
