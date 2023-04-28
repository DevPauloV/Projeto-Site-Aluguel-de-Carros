package PRINCIPAL;

import MODELO.carros;
import MODELO.clientes;
import MODELO.alugueis;

import java.util.List;

import DAO.AluguelDAO;
import DAO.CarroDAO;
import DAO.ClienteDAO;


public class Principal {
	public static void main(String[] args) {
		
		clientes cliente1 = new clientes();
		cliente1.setid_cliente(1);
		cliente1.setnome("Victor");
		cliente1.setemail("Paulocanalle@gmail.com");
		cliente1.settelefone("18 997036177");
		
		clientes cliente2 = new clientes();
		cliente2.setid_cliente(2);
		cliente2.setnome("Paulo");
		cliente2.setemail("Vitorcanalle@gmai.com");
		cliente2.settelefone("18 996310965");
		
		carros carro1 = new carros();
		carro1.setid_carro(1);
		carro1.setmarca("Ford");
		carro1.setmodelo("HB20");
		carro1.setano(2000);
		carro1.setcor("Branco");
		carro1.setdisponivel("sim");
		carro1.setpreco_diaria(150.90);
		carro1.setplaca("JQL-3HJG");
		
		carros carro2 = new carros();
		carro2.setid_carro(2);
		carro2.setmarca("Chevrolet");
		carro2.setmodelo("Picape");
		carro2.setano(2002);
		carro2.setcor("Preto");
		carro2.setdisponivel("não");
		carro2.setpreco_diaria(200.90);
		carro2.setplaca("FQL-2002");
		
/////////////////////////////////////////////////////////////////////////////////////////////		
		
		alugueis aluguel1 = new alugueis();
		aluguel1.setid_aluguel(1);
		aluguel1.setcliente(cliente1);
		aluguel1.setcarro(carro1);
		aluguel1.setdata_inicio("20/04/2023");
		aluguel1.setdata_fim("21/04/2023");
		aluguel1.setquant_dias("5");
		aluguel1.setvalor_total(499.90);
		
		alugueis aluguel2 = new alugueis();
		aluguel2.setid_aluguel(2);
		aluguel2.setcliente(cliente2);
		aluguel2.setcarro(carro2);
		aluguel2.setdata_inicio("22/04/2023");
		aluguel2.setdata_fim("23/04/2023");
		aluguel2.setquant_dias("2");
		aluguel2.setvalor_total(799.90);
		
	
		System.out.println(aluguel1);
		System.out.println(aluguel2);
		
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		//clienteDAO.excluir(cliente1.getid_cliente());
		clienteDAO.inserir(cliente1);
		clienteDAO.atualizar(cliente1);
		clientes cliente = clienteDAO.pesquisarPorCodigo(cliente1.getid_cliente());
		List<clientes> clientes = clienteDAO.pesquisarTodos();
		
		
		CarroDAO carrosDAO = new CarroDAO();
		carrosDAO.inserir(carro1);
		carrosDAO.atualizar(carro1);
		//carrosDAO.excluir(carro1.getid_carro());
	    carros Carro = carrosDAO.pesquisarPorCodigo(carro1.getid_carro());
		List<carros> Carros = carrosDAO.pesquisarTodos();
		
	    AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.inserir(aluguel1);
		aluguelDAO.atualizar(aluguel1);
		//aluguelDAO.excluir(aluguel1.getid_aluguel());
		alugueis ALUGUEIS = aluguelDAO.pesquisarPorCodigo(aluguel1.getid_aluguel());
	    List<alugueis> Alugueis = aluguelDAO.pesquisarTodos();
		
	
	}
}