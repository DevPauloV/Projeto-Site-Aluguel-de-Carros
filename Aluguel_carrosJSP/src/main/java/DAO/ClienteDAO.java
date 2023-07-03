package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import MODELO.clientes;

import java.sql.DriverManager;
import java.sql.SQLException;





public class ClienteDAO {
	
	//Metodo de "INSERIR"
	public void inserir (clientes clientes) {
		try {
			new ConnectionFactory();
			Connection conexao = 
					ConnectionFactory.getConnection();
			
			String sql =  "INSERT INTO clientes (nome, email, senha, telefone) VALUES (?, ?, ?, ?)";
					
					
					
					
					
					
			
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			
			pstmt.setString(1, clientes.getnome());
			pstmt.setString(2, clientes.getemail());
			pstmt.setString(3, clientes.getsenha());
			pstmt.setString(4, clientes.gettelefone());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	//Metodo de "ATUALIZAÇÂO"
	public void atualizar (clientes clientes) {
		try {
			new ConnectionFactory();
			Connection conexao = 
					ConnectionFactory.getConnection();
			
			String sql = "UPDATE clientes SET " +
										"nome = ?, " +
										"email = ?, " +
										"senha = ?, " +
										"telefone = ? " +
									"WHERE id_cliente = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setString(1, clientes.getnome());
			pstmt.setString(2, clientes.getemail());			
			pstmt.setString(3, clientes.gettelefone());
			pstmt.setString(4, clientes.getsenha());
			pstmt.setInt(5, clientes.getid_cliente());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}
	}
	
	//Metodo de "EXCLUSÃO"
	public void excluir (int id_cliente) {
		try {
			new ConnectionFactory();
			Connection conexao = 
					ConnectionFactory.getConnection();
			
			String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);

			pstmt.setInt(1, id_cliente);
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			}
	}

	
	// PESQUISAR POR CODIGO
	
	  public clientes pesquisarPorCodigo(int id_cliente) {
	        clientes clienteRetorno = null;
	        try {
	            new ConnectionFactory();
				Connection conexao = ConnectionFactory.getConnection();

	            String sql = "SELECT " +
	                    "nome, " +
	                    "email, " +
	                    "senha, " +
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
	                clienteRetorno.setsenha(rs.getString(4));
	                clienteRetorno.settelefone(rs.getString(5));
	            }

	            pstmt.close();
	            conexao.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	        return clienteRetorno;
	    }
	
	
	
	// PESQUISAR GERAL

	  public List<clientes> pesquisarTodos() {
		  List<clientes> Clientes = new ArrayList<>();

		  try { 
		      new ConnectionFactory();
			Connection conexao = 
		              ConnectionFactory.getConnection(); 

		      String sql = "SELECT " + 
		                          "id_cliente, " +  
		                          "nome, " +  
		                          "email, " + 
		                          "senha, " +
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
		          Cliente.setsenha(rs.getString(4)); 
		          Cliente.settelefone(rs.getString(5)); 

		          Clientes.add(Cliente); 
		      } 
		      pstmt.close(); 
		      conexao.close(); 
		  } catch (Exception e) { 
		      System.out.println(e.getMessage()); 
		  } 
		  return Clientes; 
	  }
	  
	  
	  
	

	  
	  
	  
	  
	  
	  
	  
	  public class ConnectionFactory {
		    private static final String URL = "jdbc:mysql://localhost:3306/aluguel_carros";
		    private static final String USERNAME = "root";
		    private static final String PASSWORD = "root";

		    public static Connection getConnection() throws SQLException {
		        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    }
		}
	  
	  
	  public clientes entrar(String email, String senha) {
		    clientes clienteRetorno = null;
		    
		    try {
		        new ConnectionFactory();
				Connection conexao = ConnectionFactory.getConnection();
		        
		        String sql = "SELECT id_cliente, nome, telefone FROM clientes WHERE email = ? AND senha = ?";
		        
		        PreparedStatement pstmt = conexao.prepareStatement(sql);
		        
		        pstmt.setString(1, email);
		        pstmt.setString(2, senha);
		        
		        ResultSet rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
		            clienteRetorno = new clientes();
		            clienteRetorno.setid_cliente(rs.getInt("id_cliente"));
		            clienteRetorno.setnome(rs.getString("nome"));
		            clienteRetorno.settelefone(rs.getString("telefone"));
		        }
		        
		        rs.close();
		        pstmt.close();
		        conexao.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return clienteRetorno;
		}

		
}
