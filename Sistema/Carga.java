public class Carga {

	private int ID;
	private String DataChegada;
	private boolean LocalChegada;
	private String TempoPrevisto;
	private String DataSaida;
	private boolean LocalSaida;
	private String Dono;
	private int Posicao;
	private String Remetente;
	private String Destinatario;

	public Carga(String DataChegada, boolean LocalChegada, String TempoPrevisto, String Dono, String Remetente, String Destinatario){
		this.DataChegada=DataChegada;
		this.LocalChegada=LocalChegada;
		this.TempoPrevisto=TempoPrevisto;
		this.Dono=Dono;
		this.Remetente=Remetente;
		this.Destinatario=Destinatario;
	}

	public Carga(int ID, String DataSaida, boolean LocalSaida){
		this.ID=ID;
		this.DataSaida=DataSaida;
		this.LocalSaida=LocalSaida;
	}

	public int getID(){
		return ID;
	}

	public void setID(int ID){
		this.ID=ID;
	}

	public String getDataChegada(){
		return DataChegada;
	}

	public boolean getLocalChegada(){
		return LocalChegada;
	}

	public String getTempoPrevisto(){
		return TempoPrevisto;
	}

	public String getDataSaida(){
		return DataChegada;
	}

	public boolean getLocalSaida(){
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

	public int getPosicao(){
		return Posicao;
	}

	public void setPosicao(int Posicao){
		this.Posicao=Posicao;
	}

	public void Saida(String DataSaida, boolean LocalSaida) {
		this.DataSaida=DataSaida;
		this.LocalSaida=LocalSaida;
		setPosicao(1000);
  	}

}
