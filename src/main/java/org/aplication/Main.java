package org.aplication;
import java.util.Scanner;

import servico.ApiService;

public class Main {

    public static void main(String[] args) {

        ApiService apiService = new ApiService();

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o cep a ser buscado");

        String cepBuscado;

        cepBuscado = scan.nextLine();

        System.out.println("Buscando Informacoes...");

        System.out.println(apiService.getEndereco(cepBuscado));







    }
}
