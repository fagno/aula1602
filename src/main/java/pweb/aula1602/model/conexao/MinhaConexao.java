package pweb.aula1602.model.conexao;

import java.sql.Connection;

public class MinhaConexao {




    public static Connection conexao(){
        ConexaoJDBC conexao = new Conexaohdb();
        return conexao.criarConexao();
    }

}
