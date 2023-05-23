package PacoteTeste;

import java.util.Scanner;

import PacoteDados.Funcionario;

public class App {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
    	
    	String nome= "";
		
		System.out.println("Iniciando programa\n");
		
		Funcionario funci1 = new Funcionario("Bruna", "Gerente");
		Funcionario funci2 = new Funcionario("Carlos", "Asistente");
		Funcionario funci3 = new Funcionario("Anna", "Surpevisora");
    	System.out.println("Por favor nos informe seu nome: ");
    	while(nome.isEmpty()) {
    		nome = input.nextLine();
    	}
    	if (nome.equals(funci1.getNomeFuncionario()) || nome.equals(funci2.getNomeFuncionario()) || nome.equals(funci3.getNomeFuncionario())) {
    		
    		interfacePrincipal.menu();
    		
    		
    	}else {
    		System.out.println("\nDesculpe, apenas funcionários podem acessar o sistema.\n");
    	}
		
        
    }
    
}
