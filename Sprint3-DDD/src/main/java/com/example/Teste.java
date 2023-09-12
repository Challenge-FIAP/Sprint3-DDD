// package com.example;


//ATENÇÃO: Remova os comentários para testar!


// import java.sql.SQLException;
// import com.example.data.PrestadorDao;
// import com.example.data.SessaoDao;
// import com.example.model.Prestador;
// import com.example.model.Sessao;

// public class Teste {

//     public static void main(String[] args) {
//         try {
//             Sessao sessao = new Sessao("teste@email.com", "senha");

//             SessaoDao sessaoDao = new SessaoDao();
//             if (sessaoDao.autenticar(sessao)) {
//                 System.out.println("Usuário autenticado com sucesso.");
//             } else {
//                 System.out.println("Falha na autenticação.");
//             }

//             Prestador novoPrestador = new Prestador("teste2@email.com", "SENHA", "Execução de teste", "Teste");

//             PrestadorDao prestadorDao = new PrestadorDao();
//             prestadorDao.inserir(novoPrestador);
//             System.out.println("Prestador inserido com sucesso.");

//             System.out.println("Lista de Prestadores:");
//             for (Prestador prestador : prestadorDao.buscarTodos()) {
//                 System.out.println(prestador);
//             }

//             Prestador prestadorParaExcluir = prestadorDao.buscarTodos().get(0);
//             prestadorDao.apagar(prestadorParaExcluir);
//             System.out.println("Prestador excluído com sucesso.");

//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }
