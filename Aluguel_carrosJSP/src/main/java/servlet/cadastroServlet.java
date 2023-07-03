package servlet;

import DAO.ClienteDAO;
import MODELO.clientes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cadastroServlet")
public class cadastroServlet extends HttpServlet {
  
	
	protected void doGet(HttpServletRequest request, 
								HttpServletResponse response, int erro)
										throws ServletException, IOException {
		if(erro == 1) {
				
			RequestDispatcher rq =
					request.getRequestDispatcher("cadastro.jsp");	
			
				request.setAttribute("erro", "is-invalid");
				// realizando encaminhamento
				rq.forward(request, response);
		}else {
			
			RequestDispatcher rq =
					request.getRequestDispatcher("login.jsp");	
			
				// realizando encaminhamento
				rq.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, 
								HttpServletResponse response) 
										throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
	
		int erro =0;
		
		
		
			
			clientes cliente = new clientes();
			
			cliente.setnome(nome);
			cliente.setemail(email);
			cliente.setsenha(senha);
			cliente.settelefone(telefone);
			
			
				
				ClienteDAO clienteDAO = new ClienteDAO();		
				clienteDAO.inserir(cliente);
			
			
			
			
			doGet(request, response, erro);
			
		}
		
		
	}

