public class Carga {

	private int ID;
	private int DataChegada;
	private int LocalChegada;
	private int TempoPrevisto;
	private int DataSaida;
	private int LocalSaida;
	private String Dono;
	private int Posicao;
	private String Remetente;
	private String Destinatario;

	public Carga(int DataChegada, int LocalChegada, int TempoPrevisto, String Dono, String Remetente, String Destinatario){
		this.DataChegada=DataChegada;
		this.LocalChegada=LocalChegada;
		this.TempoPrevisto=TempoPrevisto;
		this.Dono=Dono;
		this.Remetente=Remetente;
		this.Destinatario=Destinatario;
	}

	public void Saida(int ID, int DataSaida, int LocalSaida) {
  	}

}
