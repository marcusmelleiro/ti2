package carro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/", "ti2", "senha");
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection();
             Scanner scanner = new Scanner(System.in)) {
            
            DAO dao = new DAO(connection);
            boolean sair = false;

            while (!sair) {
                System.out.println("Menu:");
                System.out.println("1. Listar");
                System.out.println("2. Inserir");
                System.out.println("3. Atualizar");
                System.out.println("4. Excluir");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        List<Carro> lista = dao.listar();
                        for (Carro carro : lista) {
                            System.out.println(carro);
                        }
                        break;

                    case 2:
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Ano: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine(); 
                        dao.inserir(new Carro(0, modelo, ano));
                        break;

                    case 3:
                        System.out.print("ID do carro a ser atualizado: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Novo modelo: ");
                        modelo = scanner.nextLine();
                        System.out.print("Novo ano: ");
                        ano = scanner.nextInt();
                        scanner.nextLine(); 
                        dao.atualizar(new Carro(id, modelo, ano));
                        break;

                    case 4:
                        System.out.print("ID do carro a ser excluído: ");
                        id = scanner.nextInt();
                        dao.excluir(id);
                        break;

                    case 5:
                        sair = true;
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
