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
		String usuarioBD = "root";
		String senhaBD = "root";
		
		String stringJDBC =
			"jdbc:"+sgbd+"://"+ip+":"+porta+"/"+bd;
		
		Connection conexao =
				DriverManager.getConnection(
						stringJDBC,
						usuarioBD,
						senhaBD
						);
		
		return conexao;
	}
	
}
