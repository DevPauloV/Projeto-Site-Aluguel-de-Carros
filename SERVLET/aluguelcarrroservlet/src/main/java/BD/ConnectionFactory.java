package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection()
						throws SQLException {
		
		String sgbd = "mysql";
		String ip = "localhost";
		String porta = "3306";
		String bd = "aluguel_carros";
	
		
		String stringJDBC = 
			"jdbc:"+sgbd+"://"+ip+":"+porta+"/"+bd;
		
		String usuarioBD = "root";
		String senhaBD = "root";
		
		Connection conexao =
				DriverManager.getConnection(
						stringJDBC,
						usuarioBD,
						senhaBD
						);
		
		return conexao;
	}
	
}
