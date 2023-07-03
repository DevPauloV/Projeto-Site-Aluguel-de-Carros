package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import BD.ConnectionFactory;
import MODELO.carros;


public class CarroDAO {
	
	//Metodo de "INSERIR"
	public void inserir (carros carros) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "INSERT INTO carros(" +
										"id_carro, " +
										"marca, " +
										"modelo, " +
										"ano, " +
										"cor, " +
										"disponivel, " +
										"preco_diaria, " +
										"placa) " +
									"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setInt(1, carros.getid_carro());
			pstmt.setString(2, carros.getmarca());
			pstmt.setString(3, carros.getmodelo());
			pstmt.setInt(4, carros.getano());
			pstmt.setString(5, carros.getcor());
			pstmt.setBoolean(6, carros.getdisponivel());
			pstmt.setDouble(7, carros.getpreco_diaria());
			pstmt.setString(8, carros.getplaca());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo de "ATUALIZAÇÂO"
	public void atualizar (carros carros) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "UPDATE carros SET " +
										"marca = ?, " +
										"modelo = ?, " +
										"ano = ?, " +
										"cor = ?, " +
										"disponivel = ?, " +
										"preco_diaria = ?, " +
										"placa = ? " +
									"WHERE id_carro = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setString(1, carros.getmarca());
			pstmt.setString(2, carros.getmodelo());
			pstmt.setInt(3, carros.getano());
			pstmt.setString(4, carros.getcor());
			pstmt.setBoolean(5, carros.getdisponivel());
			pstmt.setDouble(6, carros.getpreco_diaria());
			pstmt.setString(7, carros.getplaca());
			pstmt.setInt(8, carros.getid_carro());
			
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo de "EXCLUSÃO"
	public void excluir (int id_carro) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "DELETE FROM carros WHERE id_carro = ?";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);

			pstmt.setInt(1, id_carro);
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();	
		}
	}

	
	// PESQUISAR POR CODIGO
	
	  public carros pesquisarPorCodigo(int id_carro) {
	        carros carroRetorno = null;
	        try {
	            Connection conexao = new ConnectionFactory().getConnection();

	            String sql = "SELECT " +
	                    "id_carro, " +
	                    "marca, " +
	                    "modelo, " +
	                    "ano, " +
	                    "cor, " +
	                    "disponivel, " +
	                    "preco_diaria, " +
	                    "placa " +
	                    "FROM carros " +
	                    "WHERE id_carro = ?";

	            PreparedStatement pstmt = conexao.prepareStatement(sql);
	            pstmt.setInt(1, id_carro);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                carroRetorno = new carros();
	                carroRetorno.setid_carro(rs.getInt(1));
	                carroRetorno.setmarca(rs.getString(2));
	                carroRetorno.setmodelo(rs.getString(3));
	                carroRetorno.setano(rs.getInt(4));
	                carroRetorno.setcor(rs.getString(5));
	                carroRetorno.setdisponivel(rs.getBoolean(6));
	            	carroRetorno.setpreco_diaria(rs.getDouble(7));
	    			carroRetorno.setplaca(rs.getString(8));
	    			
	            }

	            pstmt.close();
	            
	            conexao.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        	e.printStackTrace();
	        }
	        return carroRetorno;
	    }
	
	
	
	// PESQUISAR GERAL

	  public List<carros> pesquisarTodos() {
		  List<carros> Carros = new ArrayList<>();

		  try { 
		      Connection conexao = 
		              new ConnectionFactory().getConnection(); 

		      String sql = "SELECT " + 
		    		  "id_carro, " +
	                    "marca, " +
	                    "modelo, " +
	                    "ano, " +
	                    "cor, " +
	                    "disponivel, " +
	                    "preco_diaria, " +
	                    "placa " +
	                    "FROM Carros";
		                     
		      PreparedStatement pstmt = 
		              conexao.prepareStatement(sql); 

		      ResultSet rs = pstmt.executeQuery(); 
		                     
		      while (rs.next()) { 

		          carros carros = new carros(); 
		          carros.setid_carro(rs.getInt(1)); 
		          carros.setmarca(rs.getString(2)); 
		          carros.setmodelo(rs.getString(3)); 
		          carros.setano(rs.getInt(4)); 
		          carros.setcor(rs.getString(5)); 
		          carros.setdisponivel(rs.getBoolean(6)); 
		          carros.setpreco_diaria(rs.getDouble(7));
	    		  carros.setplaca(rs.getString(8));
	    			

		          Carros.add(carros); 
		      } 
		      pstmt.close(); 
		      conexao.close(); 
		  } catch (Exception e) { 
		      System.out.println(e.getMessage()); 
		  	e.printStackTrace();
		  } 
		  return Carros; 
	  }

	  public static carros findById(int id_carro) {
		    ResultSet rs = null;  
		    Statement stmt = null;  
		    Connection conn = null;
		    carros carro = null; 
		    
		    try {
		        // Conectar ao banco de dados
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aluguel_carros", "root", "root"); 

		        // Criar um statement
		        stmt = conn.createStatement();

		        // SQL para buscar o carro pelo ID
		        String sql = "SELECT * FROM carros WHERE id_carro = " + id_carro;  

		        // Executar o query
		        rs = stmt.executeQuery(sql);

		        // Verificar se o resultado está vazio
		        if (rs.next()) {
		            carro = new carros();
		            carro.setid_carro(rs.getInt("id_carro"));
		            carro.setmarca(rs.getString("marca"));
		            carro.setmodelo(rs.getString("modelo")); 
		            carro.setano(rs.getInt("ano")); 
		            carro.setcor(rs.getString("cor")); 
		            carro.setdisponivel(rs.getBoolean("disponivel")); 
		            carro.setpreco_diaria(rs.getDouble("preco_diaria"));
		            carro.setplaca(rs.getString("placa")); 
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); 
		    } finally {  
		        try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            if (conn != null) conn.close(); 
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }   
		    }
		    
		    return carro; // Retornar a variável carro após o bloco try
		}

	  
}