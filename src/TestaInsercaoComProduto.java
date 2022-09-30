import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.ConnectionFactory;
import br.com.alura.dao.ProdutoDAO;
import br.com.alura.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda", "Comoda vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.salvar(comoda);
			//Lista = persistenciaProduto.listar();
		}

		System.out.println(comoda);
	}

}
