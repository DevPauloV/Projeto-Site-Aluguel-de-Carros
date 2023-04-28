package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BD.ConnectionFactory;
import MODELO.alugueis;
import MODELO.carros;
import MODELO.clientes;



public class AluguelDAO {

	//Metodo de "INSERIR"
	public void inserir (alugueis aluguel) {
		try {
			Connection conexao = 
					new ConnectionFactory().getConnection();
			
			String sql = "INSERT INTO alugueis(" +
										"id_aluguel, " +
										"id_cliente, " +
										"id_carro, " +
										"data_inicio, " +
										"data_fim, " +
										"quant_dias, " +
										"valor_total) " +
									"VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = 
					conexao.prepareStatement(sql);
			
			pstmt.setInt(1, aluguel.getid_aluguel());
			pstmt.setInt(2, aluguel.getcliente().getid_cliente()); 
	        pstmt.setInt(3, aluguel.getcarro().getid_carro());
			pstmt.setString(4, aluguel.getdata_inicio());
			pstmt.setString(5, aluguel.getdata_fim());
			pstmt.setString(6, aluguel.getquant_dias());
			pstmt.setDouble(7, aluguel.getvalor_total());
			
			pstmt.execute();
			
			pstmt.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		e.printStackTrace();	
		}
	}
	
	
	//Metodo de "ATUALIZAÇÂO"
		public void atualizar (alugueis aluguel) {
			try {
				Connection conexao = 
						new ConnectionFactory().getConnection();
				
				String sql = "UPDATE alugueis SET " +
											"id_cliente = ?, " +
											"id_carro = ?, " +
											"data_inicio = ?, " +
											"data_fim = ?, " +
											"quant_dias = ?, " +
											"valor_total = ? " +
										"WHERE id_aluguel = ?";
				
				PreparedStatement pstmt = 
						conexao.prepareStatement(sql);
				
				
				pstmt.setInt(1, aluguel.getcliente().getid_cliente()); 
		        pstmt.setInt(2, aluguel.getcarro().getid_carro());
				pstmt.setString(3, aluguel.getdata_inicio());
				pstmt.setString(4, aluguel.getdata_fim());
				pstmt.setString(5, aluguel.getquant_dias());
				pstmt.setDouble(6, aluguel.getvalor_total());
				pstmt.setInt(7, aluguel.getid_aluguel());
				
				pstmt.execute();
				
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();		
			}
		}
		
		
		public void excluir (int id_aluguel) {
			try {
				Connection conexao = 
						new ConnectionFactory().getConnection();
				
				String sql = "DELETE FROM alugueis WHERE id_aluguel = ?";
				
				PreparedStatement pstmt = 
						conexao.prepareStatement(sql);

				pstmt.setInt(1, id_aluguel);
				
				pstmt.execute();
				
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();		
			}
		}
		
		// PESQUISAR POR CODIGO
		
		  public alugueis pesquisarPorCodigo(int id_aluguel) {
		        alugueis aluguelRetorno = null;
		        try {
		            Connection conexao = new ConnectionFactory().getConnection();

		            String sql = "SELECT " +
							"id_cliente, " +
							"id_carro, " +
							"data_inicio, " +
							"data_fim, " +
							"quant_dias, " +
							"valor_total " +
		                    "FROM alugueis " +
		                    "WHERE id_aluguel = ?";

		            PreparedStatement pstmt = conexao.prepareStatement(sql);
		            pstmt.setInt(1, id_aluguel);

		            ResultSet rs = pstmt.executeQuery();

		            if (rs.next()) {
		            	
		                ClienteDAO clienteDAO = new ClienteDAO();
		                clientes clientes = clienteDAO.pesquisarPorCodigo(rs.getInt(1));
		                
		                CarroDAO carroDAO = new CarroDAO();
		                carros carros = carroDAO.pesquisarPorCodigo(rs.getInt(2));
		                
		                aluguelRetorno = new alugueis();
		                aluguelRetorno.setid_aluguel(id_aluguel);
		                aluguelRetorno.setcliente(clientes);
		                aluguelRetorno.setcarro(carros);
		                aluguelRetorno.setdata_inicio(rs.getString(3));
		                aluguelRetorno.setdata_fim(rs.getString(4));
		                aluguelRetorno.setquant_dias(rs.getString(5));
		                aluguelRetorno.setvalor_total(rs.getDouble(6));
		            }

		            pstmt.close();
		            conexao.close();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            e.printStackTrace();	
		        }
		        return aluguelRetorno;
		    }
		
		// PESQUISAR GERAL

		  public List<alugueis> pesquisarTodos() {
			  List<alugueis> Alugueis = new ArrayList<>();

			  try { 
			      Connection conexao = 
			              new ConnectionFactory().getConnection(); 

			      String sql = "SELECT " + 
			                "id_aluguel, " +
			    			"id_cliente, " +
							"id_carro, " +
							"data_inicio, " +
							"data_fim, " +
							"quant_dias, " +
							"valor_total " + 
			                      "FROM alugueis"; 
			                     
			      PreparedStatement pstmt = 
			              conexao.prepareStatement(sql); 

			      ResultSet rs = pstmt.executeQuery(); 
			                     
			      while (rs.next()) { 
			    	  
			    	  ClienteDAO clienteDAO = new ClienteDAO();
		                clientes clientes = clienteDAO.pesquisarPorCodigo(rs.getInt(2));
		                
		                CarroDAO carroDAO = new CarroDAO();
		                carros carros = carroDAO.pesquisarPorCodigo(rs.getInt(3));
		                

			          alugueis alugueis = new alugueis(); 
			          alugueis.setid_aluguel(rs.getInt(1)); 
			          alugueis.setcliente(clientes); 
			          alugueis.setcarro(carros); 
			          alugueis.setdata_inicio(rs.getString(4)); 
			          alugueis.setdata_fim(rs.getString(5));
			          alugueis.setquant_dias(rs.getString(6));
			          alugueis.setvalor_total(rs.getDouble(7));

			          Alugueis.add(alugueis); 
			      } 
			      pstmt.close(); 
			      conexao.close(); 
			  } catch (SQLException e) { 
			      System.out.println(e.getMessage());
			      e.printStackTrace();	
			  } 
			  return Alugueis; 
		  }
		
		
		
}
