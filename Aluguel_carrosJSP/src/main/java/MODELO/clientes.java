package MODELO;

public class clientes {
	private int id_cliente;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	
	
	public void setsenha( String senha) {
		this.senha = senha;
	}
	public String getsenha() {
		return this.senha;
	}
	// --------------------------------------------------------------------------------------------------------------------
	
	public void setid_cliente(int id_cliente) {
		this.id_cliente = id_cliente;	
	}
	public int getid_cliente() {
		return this.id_cliente;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void setnome( String nome) {
		this.nome = nome;
	}
	public String getnome() {
		return this.nome;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void setemail(String email) {
		this.email = email;
	}
	public String getemail() {
		return this.email;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void settelefone(String telefone) {
		this.telefone = telefone;
	}
	public String gettelefone() {
		return this.telefone;
	}
	

	
	
}
