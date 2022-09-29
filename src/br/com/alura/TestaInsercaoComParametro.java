package br.com.alura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);

		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO(nome, descricao) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS);

		adicionarVariavel("SmartTV", "80 polegadas", stm);
		adicionarVariavel("Led", "Led 5038", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

//		if (nome.equals("Led")) {
//			throw new RuntimeException("Nao foi possivel add produto");
//		}

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		rst.close();
	}
}
