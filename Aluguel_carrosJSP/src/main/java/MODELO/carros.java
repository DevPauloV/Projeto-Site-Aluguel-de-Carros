package MODELO;

public class carros {
	private int id_carro;
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private boolean disponivel;
	private double preco_diaria;
	private String placa;

	//---------------------------------------------------------------------------------------------------------------------
	
	public void setid_carro(int id_carro) {
		this.id_carro = id_carro;
	}
	public int getid_carro() {
		return this.id_carro;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setmarca(String marca) {
		this.marca = marca;
	}
	public String getmarca() {
		return this.marca;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}
	public String getmodelo( ) {
		return this.modelo;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setano(int ano) {
		this.ano = ano;
	}
	public int getano() {
		return this.ano;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setcor(String cor) {
	    this.cor = cor;
	}
	public String getcor() {
		return this.cor;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setdisponivel(boolean string) {
		this.disponivel = string;
	}   
	public boolean getdisponivel() {
		return this.disponivel;
	}
	
	//--------------------------------------------------------------------------------------------------------------
	


	public void setpreco_diaria(double preco_diaria) {
	    this.preco_diaria = preco_diaria;
	}

	public double getpreco_diaria() {
	    return this.preco_diaria;
	}

	
	//---------------------------------------------------------------------------------------------------------------------
	 
	public void setplaca(String placa) {
	     this.placa = placa;
	}
	public String getplaca() {
		return this.placa;
	}
	
	
	
	}
	
	
	


