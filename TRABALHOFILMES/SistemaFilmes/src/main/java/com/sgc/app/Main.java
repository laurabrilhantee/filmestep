package main.java.com.sgc.app;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.com.sgc.modelos.Filme;

public class Main {

    private static ArrayList<Filme> filmes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> cadastrarFilme();
                case 2 -> listarFilmes();
                case 3 -> buscarFilme();
                case 0 -> executando = false;
                default -> System.out.println("Opção inválida!");
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE FILMES ===");
        System.out.println("1 - Cadastrar Filme");
        System.out.println("2 - Listar Filmes");
        System.out.println("3 - Buscar Filme por título");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFilme() {
        System.out.println("\n=== CADASTRAR FILME ===");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Diretor: ");
        String diretor = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        System.out.print("Duração (em horas): ");
        double duracao = scanner.nextDouble();
        scanner.nextLine();

        Filme filme = new Filme(titulo, diretor, ano, duracao);
        filmes.add(filme);

        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void listarFilmes() {
        System.out.println("\n=== LISTA DE FILMES ===");

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    private static void buscarFilme() {
        System.out.println("\n=== BUSCAR FILME ===");

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        System.out.print("Digite o título do filme: ");
        String tituloBusca = scanner.nextLine();

        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(tituloBusca)) {
                System.out.println("Filme encontrado:");
                System.out.println(filme);
                return;
            }
        }

        System.out.println("Filme não encontrado.");
    }
}