package PacoteTeste;

import java.util.Scanner;

import PacoteDados.Produto;
import PacoteDados.ProdutoAlimenticio;
import PacoteRepositorio.ControleProduto;


public class InterfacePrincipal {
    
    
	Scanner input = new Scanner(System.in);
    private final ControleProduto controleProduto;
    

    public InterfacePrincipal(){

        controleProduto = new ControleProduto();
        
    }
    
    Produto produtoInserido = null;

    public int menu() {
        int opcao;
	    boolean loopMenu = true;
        
        while(loopMenu){
            System.out.print("\nControle de Estoque - Menu Principal:\n");
            System.out.print("\n");
            System.out.print("1 - Cadastrar Produto");
            System.out.print("\n");
            System.out.print("2 - Consultar todos os Produtos");
            System.out.print("\n");
            System.out.print("3 - Excluir Produto");
            System.out.print("\n");
            System.out.print("4 - Alterar quantidade vendida");
            System.out.print("\n");
            System.out.print("5 - Alterar preço do produto");
            System.out.print("\n");
            System.out.print("6 - Alterar descrição");
            System.out.print("\n");
            System.out.print("7 - Editar Estoque");
            System.out.print("\n");
            System.out.print("8 - Cadastrar compra de produto");
            System.out.print("\n");
            System.out.print("0 - Sair\n");
            System.out.print("\n");

            System.out.print("Digite a opção: \n");
            
			opcao = input.nextInt();

            System.out.print("\n");

            switch(opcao) {
                case 0:
                    loopMenu = false;
                    break;
                case 1:
                	System.out.print("Cadastro de Produto (Produto Alimentício/Produto não Alimentício):");
                    cadastrarProduto();
                    break;
		        case 2:
                    consultarProduto();
                    break;
                case 3:
                	excluirProduto();
                    break;
                case 4:
                	editarVenda();
                    break;
                case 5:
                	editarPreco();
                	 break;
                case 6:
                	editarDescricao();
                	 break;
                	
                case 7:
                	editarEstoque();
                	 break;
                case 8:
                	compraProduto();
                	 break;
               
                default:
                    System.out.println("\nOpcao incorreta!");
                    System.out.println("\n");
                    break;
            }
        }
        return 0;
    }
    public void cadastrarProduto() {
        int tipoProduto;
        String nomeProduto = "";
        String codigoProduto = "";
        String descricao = "";
        double precoCusto = -1;
        double precoVenda = -1;
        int quantidadeCompra = -1;
        int quantidadeVenda = -1;
        int quantidadeEstoque ;

        Produto produto = null;
        
        System.out.print("\n");
        System.out.print("Codigo do produto: \n");
        while(codigoProduto.isEmpty()) {
        	
        	codigoProduto = input.nextLine();
        }
        if(controleProduto.conferirCodigo(codigoProduto)) {
        	
        	System.out.println("\nO produto já foi cadastrado, você não pode cadastrar o mesmo produto duas vezes ");
			System.out.println("\nDigite um código não cadastrado");
			cadastrarProduto();
        }
        	
        System.out.print("\nNome do produto: ");
        while(nomeProduto.isEmpty()) {
        	nomeProduto = input.nextLine();
        }
        
        System.out.print("\nDescricao: ");
        while(descricao.isEmpty()) {
        	descricao = input.nextLine();
        }
        
        System.out.print("\nPreco custo(Informe apenas números): ");
        
        while( precoCusto<0) {
        	precoCusto = input.nextDouble();
        	if(precoCusto<0) {
        		System.out.println("\nValor invalido! Digite um valor válido.");
        	}
        }
        
        
        System.out.println("\nPreco venda (Informe apenas número): ");
        while( precoVenda<0) {
        	precoVenda = input.nextDouble();
        	if(precoVenda<0) {
        		System.out.println("\nValor invalido! Digite um valor válido.");
        	}
        }
                
        System.out.println("\nQuantidade compra: ");
        while( quantidadeCompra<0) {
        	quantidadeCompra = input.nextInt();
        	if(quantidadeCompra<0) {
        		System.out.println("\nValor invalido! Digite um valor válido.");
        	}
        }
        
        System.out.println("\nQuantidade vendida: ");
        while( quantidadeVenda <0) {
        	quantidadeVenda = input.nextInt();
        	if(quantidadeVenda<0 ) {
        		System.out.println("\nValor invalido! Digite um valor válido.");
        	}
        	if(quantidadeVenda>quantidadeCompra) {
        		System.out.println("\nValor invalido! A quantidade vendida não pode ser maior que a quantidade comprada. \nDigite um valor válido.");
        	quantidadeVenda=-1;
        	}
        }
        
        quantidadeEstoque = quantidadeCompra - quantidadeVenda; //inicialmente igual a 0
        

        System.out.print("Digite o tipo de Produto que você deseja cadastrar: \n(1 - Produto não alimentício ou 2 - Produto alimentício: ");
        tipoProduto = input.nextInt();
        input.nextLine(); // Limpar a quebra de linha pendente após nextInt()
        
        switch (tipoProduto) {
            case 1:
            	
                produto = new Produto(nomeProduto, codigoProduto, descricao, precoCusto, precoVenda, quantidadeVenda, quantidadeCompra, quantidadeEstoque, tipoProduto);
                
                controleProduto.cadastrarProduto(produto);

                System.out.print("\nProduto - Produto cadastrada com sucesso!\n");

                break;
            case 2:
                System.out.print("\nData de validade: ");
                String dataDeValidade = input.next();
                produto = new ProdutoAlimenticio(nomeProduto, codigoProduto, descricao, precoCusto, precoVenda, quantidadeVenda, quantidadeCompra, quantidadeEstoque, tipoProduto, dataDeValidade);
                
                controleProduto.cadastrarProduto(produto);
                
                System.out.print("\nProduto - Produto cadastrada com sucesso!\n");
                break;
            default:
                System.out.print("\nOpcao incorreta!\n");
                System.out.print("\n");
                System.out.print("Cancelando o cadastro...\n");
                System.out.print("\n");
                menu();
                break;
        }
    }
    
    public void consultarProduto(){
    	if(!controleProduto.getListProduto().isEmpty()){
    		System.out.println(controleProduto.getAllProducts());
	    		
    	} else {
    		System.out.print("\nNão existe cadastrado no sistema!\n");
    	}
    }

    public void editarVenda(){

        
        int quantidadeVenda = -1;
        
        
            System.out.print("\nPara realizar a alteração, informe o código do produto: ");
            String codigo = input.next();

            System.out.print("\n");

            Produto produto = controleProduto.selecionarProduto(codigo);

            if(produto != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.println("\nQuantidade vendida: ");
                while( quantidadeVenda <0) {
                	quantidadeVenda = input.nextInt();
                	if(quantidadeVenda<0) {
                		System.out.println("\nValor invalido! Digite um valor válido.");
                	}
                	int quantidadeEstoque = produto.getQuantidadeEstoque();
                	if(quantidadeVenda>quantidadeEstoque) {
                		System.out.println("\nValor invalido! A quantidade vendida não pode ser maior que a quantidade em estoque. \nDigite um valor válido.");
                	quantidadeVenda=-1;
                	}
                }
                produto.setQuantidadeVenda(quantidadeVenda);
                
                System.out.print("\nQuantidade vendida do produto alterada com sucesso!\n");
            } else {
            	System.out.print("O produto que você deseja editar não existe no sitema");
            }
    }

    public void excluirProduto(){
    	String codigo;

        System.out.print("Para realizar a exclusão, informe o codigo do produto: ");
        codigo = input.next();

        System.out.print("\n");

        Produto produto = controleProduto.selecionarProduto(codigo);

        if(produto != null){
            controleProduto.excluirProduto(produto);
            System.out.println("Produto excluida com sucesso!");
        }else {
        	System.out.print("\nO produto não existe\n");
        	System.out.print("\n");
        	System.out.print("Cancelando exclusão...\n");
        	System.out.print("\n");
        }
    }
    public void editarEstoque() {
    	int quantidadeEstoque = -1;
    	
    	String codigo;

        System.out.print("Informe o codigo do produto que deseja alterar o estoque: ");
   		codigo = input.next();

   		System.out.print("\n");

   		Produto produto = controleProduto.selecionarProduto(codigo);

   		if(produto != null){
   			int quantidadeCompra = produto.getQuantidadeCompra();
        	System.out.println("Quantidade de Estoque ");
        	do{
        		quantidadeEstoque = input.nextInt();
        	}while(quantidadeEstoque<0);
        	
        	if (quantidadeEstoque<quantidadeCompra) {
        		produto.setQuantidadeEstoque(quantidadeEstoque);
        		System.out.println("Estoque do produto alterado com sucesso ");
        	}else {
        		System.out.println("Cadastro inválido, \nvocê não pode ter em estoque mais produtos do que você comprou. \nSe você comprou mais produtos, cadastre uma compra. ");
        	}
                    	
        }else {
        	System.out.print("O produto que você deseja editar não existe no sitema");
        }
    }
    
    public void editarPreco() {
    	double precoVenda = -1;
    	
        System.out.print("\nPara realizar a alteração, informe o código do produto: ");
        String codigo = input.next();

        System.out.print("\n");

        Produto produto = controleProduto.selecionarProduto(codigo);

        if(produto != null){
      		System.out.print("Realize a alteração:");
      		System.out.print("\n");

            System.out.println("\nPreco venda (Informe apenas número): ");
      		while( precoVenda<0) {
      			precoVenda = input.nextDouble();
      			if(precoVenda<0) {
      			System.out.println("\nValor invalido! Digite um valor válido.");
      			}
            }
                           
            produto.setPrecoVenda(precoVenda);

            System.out.print("\nQuantidade vendida do produto alterada com sucesso!\n");
            } else {
            	System.out.print("O produto que você deseja editar não existe no sitema");
            }
    }
    public void editarDescricao(){

        String descricao = "";
        
        System.out.print("\nPara realizar a alteração, informe o código do produto: ");
        String codigo = input.next();

        System.out.print("\n");

        Produto produto = controleProduto.selecionarProduto(codigo);

        if(produto != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                			
                System.out.print("\nDescricao: ");
                while(descricao.isEmpty()) {
                	descricao = input.nextLine();
                }
               
                produto.setDescricao(descricao);
                
                
                
                
                System.out.print("\nQuantidade vendida do produto alterada com sucesso!\n");
            } else {
            	System.out.print("O produto que você deseja editar não existe no sitema");
            }
        
    }
    public void compraProduto(){

        int quantidadeCompra = -1;
        int quantidadeEstoque;
        
     
        System.out.print("\n Informe o código do produto: ");
        String codigo = input.next();

        System.out.print("\n");

        Produto produto = controleProduto.selecionarProduto(codigo);

        if(produto != null){
        	System.out.println("\nQuantidade compra: ");
	        while( quantidadeCompra<0) {
	        	quantidadeCompra = input.nextInt();
	          	if(quantidadeCompra<0) {
	          		System.out.println("\nValor invalido! Digite um valor válido.");
	          	}
	        }
          	quantidadeEstoque = produto.getQuantidadeEstoque();
          	quantidadeEstoque += quantidadeCompra;
            produto.setQuantidadeCompra(quantidadeCompra);
            produto.setQuantidadeEstoque(quantidadeEstoque);
            
            System.out.print("\nQuantidade comprada do produto cadastrada com sucesso!\n");
        } else {
        	System.out.print("O produto que você deseja editar não existe no sitema");
        }
        
    }
}

