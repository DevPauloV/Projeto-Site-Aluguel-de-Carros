package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BD.ConnectionFactory;
import MODELO.clientes;





public class ClienteDAO {
	
	//Metodo de "INSERIR"
	public void inserir (clientes clientes) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "INSERT INTO clientes(" +
										"id_cliente, " +
										"nome, " +
										"email, " +
										"telefone) " +
									"VALUES (?, ?, ?, ?)";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setInt(1, clientes.getid_cliente());
			pstmt.setString(2, clientes.getnome());
			pstmt.setString(3, clientes.getemail());
			pstmt.setString(4, clientes.gettelefone());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	//Metodo de "ATUALIZAÇÂO"
	public void atualizar (clientes clientes) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "UPDATE clientes SET " +
										"nome = ?, " +
										"email = ?, " +
										"telefone = ? " +
									"WHERE id_cliente = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setString(1, clientes.getnome());
			pstmt.setString(2, clientes.getemail());			
			pstmt.setString(3, clientes.gettelefone());
			pstmt.setInt(4, clientes.getid_cliente());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}
	}
	
	//Metodo de "EXCLUSÃO"
	public void excluir (int id_cliente) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);

			pstmt.setInt(1, id_cliente);
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}
	}

	
	// PESQUISAR POR CODIGO
	
	  public clientes pesquisarPorCodigo(int id_cliente) {
	        clientes clienteRetorno = null;
	        try {
	            Connection conexao = new ConnectionFactory().getConnection();

	            String sql = "SELECT " +
	                    "id_cliente, " +
	                    "nome, " +
	                    "email, " +
	                    "telefone " +
	                    "FROM clientes " +
	                    "WHERE id_cliente = ?";

	            PreparedStatement pstmt = conexao.prepareStatement(sql);
	            pstmt.setInt(1, id_cliente);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                clienteRetorno = new clientes();
	                clienteRetorno.setid_cliente(rs.getInt(1));
	                clienteRetorno.setnome(rs.getString(2));
	                clienteRetorno.setemail(rs.getString(3));
	                clienteRetorno.settelefone(rs.getString(4));
	            }

	            pstmt.close();
	            conexao.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	        return clienteRetorno;
	    }
	
	
	
	// PESQUISAR GERAL

	  public List<clientes> pesquisarTodos() {
		  List<clientes> Clientes = new ArrayList<>();

		  try { 
		      Connection conexao = 
		              new ConnectionFactory().getConnection(); 

		      String sql = "SELECT " + 
		                          "id_cliente, " +  
		                          "nome, " +  
		                          "email, " +  
		                          "telefone " +  
		                      "FROM clientes"; 
		                     
		      PreparedStatement pstmt = 
		              conexao.prepareStatement(sql); 

		      ResultSet rs = pstmt.executeQuery(); 
		                     
		      while (rs.next()) { 

		          clientes Cliente = new clientes(); 
		          Cliente.setid_cliente(rs.getInt(1)); 
		          Cliente.setnome(rs.getString(2)); 
		          Cliente.setemail(rs.getString(3)); 
		          Cliente.settelefone(rs.getString(3)); 

		          Clientes.add(Cliente); 
		      } 
		      pstmt.close(); 
		      conexao.close(); 
		  } catch (SQLException e) { 
		      System.out.println(e.getMessage()); 
		  } 
		  return Clientes; 
	  }
}
