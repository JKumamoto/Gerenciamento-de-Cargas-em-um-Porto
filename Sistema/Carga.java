public class Carga {

	public static final int Navio=1;
	public static final int Caminhao=2;

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

	public int getID(){
		return ID;
	}

	public void setID(int ID){
		this.ID=ID;
	}

	public int getDataChegada(){
		return DataChegada;
	}

	public int getLocalChegada(){
		return LocalChegada;
	}

	public int getTempoPrevisto(){
		return TempoPrevisto;
	}

	public int getDataSaida(){
		return DataChegada;
	}

	public int getLocalSaida(){
		return LocalChegada;
	}
	
	public String getDono(){
		return Dono;
	}

	public String getRemetente(){
		return Remetente;
	}

	public String getDestinatario(){
		return Destinatario;
	}

	public void Saida(int DataSaida, int LocalSaida) {
		this.DataSaida=DataSaida;
		this.LocalSaida=LocalSaida;
  	}

}
