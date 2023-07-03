package servlet;

import java.io.IOException;


import DAO.ClienteDAO;
import MODELO.clientes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/clienteservlet")
public class clienteservlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request,
			 HttpServletResponse response)
	    throws ServletException, IOException { 
		 
		 RequestDispatcher rq =
					request.getRequestDispatcher("cliente.jsp");
			rq.forward(request, response);
		 
	 		
	 }
	 protected void doPost(HttpServletRequest request,
	         HttpServletResponse response)
             throws ServletException,
              IOException {
  
  
  int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
  String nome = request.getParameter("nome");
  String email = request.getParameter("email");
  String telefone = request.getParameter("telefone");
  
    clientes cliente = new clientes();
	cliente.setid_cliente(id_cliente);
	cliente.setnome(nome);
	cliente.setemail(email);
	cliente.settelefone(telefone);
	
	ClienteDAO clienteDAO = new ClienteDAO();
	clienteDAO.inserir(cliente);
	
	doGet(request, response);
  
}
	 
}

