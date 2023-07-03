package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarroDAO;
import DAO.AluguelDAO;
import DAO.ClienteDAO;


import MODELO.alugueis;
import MODELO.carros;
import MODELO.clientes;



@WebServlet("/aluguelservlet")
public class aluguelservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        RequestDispatcher rq = request.getRequestDispatcher("carro.jsp");
        rq.forward(request, response);
    }

   

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
	
	    // Recupere os valores do formulário
	    int idAluguel = Integer.parseInt(request.getParameter("id_aluguel"));
	    int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
	    int idCarro = Integer.parseInt(request.getParameter("carro"));
	    String dataInicio = request.getParameter("data_inicio");
	    String dataFim = request.getParameter("data_fim");
	    String quantDias = request.getParameter("quant_dias");
	    

	    
	    
        CarroDAO carroDAO = new CarroDAO();
		carros Carros = carroDAO.pesquisarPorCodigo(idCarro);
		
          ClienteDAO clienteDAO = new ClienteDAO();
		clientes Cliente = clienteDAO.pesquisarPorCodigo(idCliente);
		
	    AluguelDAO aluguelDAO = new AluguelDAO();
		aluguelDAO.pesquisarTodos();
	  
		
		alugueis aluguel = new alugueis();
		aluguel.setid_aluguel(idAluguel);
		aluguel.setcliente(Cliente);
	    aluguel.setcarro(Carros);
	    aluguel.setdata_inicio(dataInicio);
	    aluguel.setdata_fim(dataFim);
	    aluguel.setquant_dias(quantDias);
	    
		
		
		
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("carro.jsp");
	    dispatcher.forward(request, response);
	    
	    doGet(request, response);


}
}