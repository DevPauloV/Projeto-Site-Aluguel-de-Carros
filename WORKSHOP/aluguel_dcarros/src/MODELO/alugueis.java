package MODELO;

public class alugueis {
	private int id_aluguel;
	private clientes cliente;
	private carros carro;
	private String data_inicio;
	private String data_fim;
	private double valor_total;


	//---------------------------------------------------------------------------------------------------------------------
	
	public void setid_aluguel(int id_aluguel) {
		this.id_aluguel = id_aluguel;
	}
	public int getid_aluguel() {
		return this.id_aluguel;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setcliente(clientes cliente) {
		this.cliente = cliente;
	}
	public clientes getcliente() {
		return this.cliente;
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setdata_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getdata_inicio() {
		return this.data_inicio;
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setdata_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	public String getdata_fim() {
		return this.data_fim;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setcarro(carros carro) {
		this.carro = carro;
	}
	public carros getcarro() {
		return this.carro;
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public void setvalor_total(double valor_total) {
		this.valor_total = valor_total;
	}   
	public double getvalor_total() {
		return this.valor_total;
	}
	
}
