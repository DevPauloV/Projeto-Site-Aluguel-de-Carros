package PRINCIPAL;

import MODELO.carros;
import MODELO.clientes;
import MODELO.alugueis;

import java.util.List;

import DAO.CarroDAO;
import DAO.ClienteDAO;


public class Principal {
	public static void main(String[] args) {
		
		clientes cliente1 = new clientes();
		cliente1.setid_cliente(1);
		cliente1.setnome("nome");
		cliente1.setemail("email");
		cliente1.settelefone("11 1111-1111");
		
		clientes cliente2 = new clientes();
		cliente2.setid_cliente(2);
		cliente2.setnome("nome");
		cliente2.setemail("email");
		cliente2.settelefone("22 2222-2222");
		
		carros carro1 = new carros();
		carro1.setid_carro(1);
		carro1.setmarca("marca");
		carro1.setmodelo("modelo");
		carro1.setano("ano");
		carro1.setcor("cor");
		carro1.setdisponivel("sim/não");
		
		carros carro2 = new carros();
		carro2.setid_carro(2);
		carro2.setmarca("marca");
		carro2.setmodelo("modelo");
		carro2.setano("ano");
		carro2.setcor("cor");
		carro2.setdisponivel("sim/não");
		
/////////////////////////////////////////////////////////////////////////////////////////////		
		
		alugueis aluguel1 = new alugueis();
		aluguel1.setid_aluguel(1);
		aluguel1.setid_clientes(1);
		aluguel1.setid_carro(1);
		aluguel1.setdata_inicio("data inicio");
		aluguel1.setdata_fim("data fim");
		aluguel1.setvalor_total("valor total");
		
		alugueis aluguel2 = new alugueis();
		aluguel2.setid_aluguel(2);
		aluguel2.setid_clientes(2);
		aluguel2.setid_carro(2);
		aluguel2.setdata_inicio("data inicio");
		aluguel2.setdata_fim("data fim");
		aluguel2.setvalor_total("valor total");
		
	
		System.out.println(aluguel1);
		System.out.println(aluguel2);
		
		
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(cliente1.getid_cliente());
		clienteDAO.inserir(cliente1);
		clienteDAO.atualizar(cliente1);
		clientes cliente = clienteDAO.pesquisarPorCodigo(cliente1.getid_cliente());
		List<clientes> Clientes = clienteDAO.pesquisarTodos();
		
		CarroDAO carroDAO = new CarroDAO();
		carroDAO.inserir(carro2);
		carroDAO.atualizar(carro2);
		carroDAO.excluir(carro2.getid_carro());
		carros Carros = carroDAO.pesquisarPorCodigo(carro2.getid_carro);
		List<carros> Carros = carroDAO.pesquisarTodos();
		
		
	}
}