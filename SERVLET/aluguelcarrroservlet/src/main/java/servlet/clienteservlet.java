package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import DAO.ClienteDAO;
import MODELO.clientes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/aluguelcarroservlet")
public class clienteservlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request,
			 HttpServletResponse response)
	    throws ServletException, IOException { 
		 
		 response.setCharacterEncoding("UTF-8");
		 
		 PrintWriter saida = response.getWriter();
		 saida.append("<html>");
		 saida.append("<head>");
		 saida.append("<meta charset='UTF-8' />");
			saida.append("<title>Cadastro de Cliente</title>");
			saida.append("</head>");
			saida.append("<body>");
			saida.append("<h1>Cadastro de Cliente</h1>");
			
			saida.append("<form action='aluguelcarroservlet' method='post'>");
			
			saida.append("<label>codigo</label>");
			saida.append("<input type='number' name='id_cliente'/>");
			
			saida.append("<br/>");
			
			saida.append("<label>nome</label>");
			saida.append("<input type='text' name='nome'/>");
			
			saida.append("<br/>");
			
			
			saida.append("<label>email</label>");
			saida.append("<input type='text' name='email'/>");

			saida.append("<br/>");
			
			saida.append("<label>telefone</label>");
			saida.append("<input type='number' name='telefone'/>");
			
			saida.append("<br/>");
			
			saida.append("<input type='submit' value='Salvar'/>");
			saida.append("</form>");
			
			saida.append("<hr/>");
			
			saida.append("<h2>Listagem de Clientes</h2>");
			
			saida.append("<table border='1'>");
			saida.append("<thead>");
				saida.append("<tr>");
					saida.append("<td>Codigo</td>");
					saida.append("<td>Nome</td>");
					saida.append("<td>Email</td>");
					saida.append("<td>Telefone</td>");
				saida.append("</tr>");
			saida.append("</thead>");
			saida.append("<tbody>");
			
			ClienteDAO clienteDAO = new ClienteDAO();
			List<clientes> clientes = clienteDAO.pesquisarTodos();
			
			for(clientes cliente : clientes) {
				saida.append("<tr>");
					saida.append("<td>" + cliente.getid_cliente() + "</td>");
					saida.append("<td>" + cliente.getnome() + "</td>");
					saida.append("<td>" + cliente.getemail() + "</td>");
					saida.append("<td>" + cliente.gettelefone() + "</td>");
				saida.append("</tr>");
			}
			
			saida.append("</tbody>");
			saida.append("</table>");
			
		saida.append("</body>");
	saida.append("</html>");
	 		
	 }
	 protected void doPost(HttpServletRequest request,
	         HttpServletResponse response)
             throws ServletException,
              IOException {
  
  String id_clienteStr = request.getParameter("id_cliente");
 
  if (id_clienteStr == null || id_clienteStr.trim().isEmpty()) {
 
    throw new ServletException("Invalid id_cliente");	    
  }
  int id_cliente = Integer.parseInt(id_clienteStr);
  
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

