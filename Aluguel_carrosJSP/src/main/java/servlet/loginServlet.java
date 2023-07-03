package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import MODELO.clientes;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response, clientes logado, int estado) 
									throws ServletException, IOException {
		
		if(estado == 0 && logado == null) {
				// configurando encaminhamento
				RequestDispatcher rq =
						request.getRequestDispatcher("login.jsp");
				
				request.setAttribute("erro", "is-invalid");
				
				// realizando encaminhamento
				rq.forward(request, response);
		
		}else if(estado == 0 && logado != null){
			
				RequestDispatcher rq =
						request.getRequestDispatcher("index.jsp");
				
				HttpSession sessao = request.getSession(true);
				sessao.setAttribute("id", logado.getid_cliente());
				sessao.setAttribute("Clientelogado", logado);
				
				// realizando encaminhamento
				rq.forward(request, response);
			
		}else if(estado == 1 && logado == null) {
				
				RequestDispatcher rq =
						request.getRequestDispatcher("index.jsp");
				
				HttpSession sessao = request.getSession(false);
				sessao.invalidate(); 
				
				// realizando encaminhamento
				rq.forward(request, response);
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String loginParam = request.getParameter("login");
	    int estado;

	    if (loginParam != null && !loginParam.isEmpty()) {
	        estado = Integer.parseInt(loginParam);
	    } else {
	        estado = 0; // 
	    }
	    
	    if (estado == 0) {        
	        String email = request.getParameter("email");
	        String senha = request.getParameter("senha");
	        
	        ClienteDAO clienteDAO = new ClienteDAO();
	        clientes clienteRetorno = clienteDAO.entrar(email, senha);
	        
	        doGet(request, response, clienteRetorno, estado);
	    } else {
	        clientes clienteRetorno = null;
	        doGet(request, response, clienteRetorno, estado);
	    }
	}

}