package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarroDAO;
import DAO.ClienteDAO;
import MODELO.carros;

@WebServlet("/carroservlet")
public class carroservlet extends HttpServlet {

  protected void doGet(HttpServletRequest request,
             HttpServletResponse response) 
    throws ServletException, IOException {

     RequestDispatcher rq = request.getRequestDispatcher("carro.jsp");
     rq.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id_carro = Integer.parseInt(request.getParameter("id_carro"));
	    carros carro = CarroDAO.findById(id_carro);
	    
	    if (carro != null) {
	        String marca = request.getParameter("marca");
	        String modelo = request.getParameter("modelo");
	        int ano = Integer.parseInt(request.getParameter("ano"));
	        String cor = request.getParameter("cor");
	        boolean disponivel = Boolean.parseBoolean(request.getParameter("disponivel"));
	        double preco_diaria = Double.parseDouble(request.getParameter("preco_diaria"));
	        String placa = request.getParameter("placa");
	        
	        carro.setmarca(marca);
	        carro.setmodelo(modelo);
	        carro.setano(ano);
	        carro.setcor(cor);
	        carro.setdisponivel(disponivel);
	        carro.setpreco_diaria(preco_diaria);
	        carro.setplaca(placa);
	        
	        CarroDAO carroDAO = new CarroDAO();
	        carroDAO.atualizar(carro);
	    }
	    
	    doGet(request, response);
	}


}
	 
	 


