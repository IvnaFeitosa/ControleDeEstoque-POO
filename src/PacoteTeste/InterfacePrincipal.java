package PacoteTeste;
import java.util.ArrayList;
import java.util.Scanner;

import PacoteDados.Produto;
import PacoteDados.ProdutoAlimenticio;
import PacoteRepositorio.ControleProduto;
import PacoteRepositorio.ControleProdutoAlimenticio;

public class InterfacePrincipal {
    
    
	Scanner input = new Scanner(System.in);
    private final ControleProduto controleProduto;
    private final ControleProdutoAlimenticio controleProdutoAlimenticio;

    public InterfacePrincipal(){

        controleProduto = new ControleProduto();
        controleProdutoAlimenticio = new ControleProdutoAlimenticio();
    }

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
            System.out.print("3 - Editar Produto");
            System.out.print("\n");
            System.out.print("4 - Excluir Produto");
            System.out.print("\n");
            System.out.print("5 - Cadastrar Estoque");
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
                    cadastrarProduto();
                    break;
		        case 2:
                    listarProduto();
                    break;
                case 3:
                	System.out.print("Digite o tipo de Produto que você deseja listar - (1 - Produto não perecivel ou 2 - Produto perecivel: ");
                    int tipoProduto = input.nextInt();
                    switch(tipoProduto){
                        case 1:
                            editarProduto();
                            break;
                        case 2:
                            editarProdutoAlimenticio();
                            break;
                        default:
                            System.out.println("tipo invalido, por favor insira um valor valido");
                            break;
                    }
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                	cadastrarEstoque();
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

        String nomeProduto;
        String codigoProduto;
        String descricao;
        double precoCusto;
        double precoVenda;
        int quantidadecompra;
        int quantidadeVenda;
        int quantidadeEstoque;

        System.out.print("Cadastro de Produto (Produto Perecivel/Produto não perecivel):");
        System.out.print("\n");

        System.out.print("\nCodigo do produto: ");
        codigoProduto = input.next();
        System.out.print("Nome do produto: ");
        nomeProduto = input.next();
        System.out.print("descricao: ");
        descricao = input.next();
        System.out.print("preco custo: ");
        precoCusto = input.nextDouble();
        System.out.println("preco venda: ");
        precoVenda = input.nextDouble();
        System.out.println("quantidade compra: ");
        quantidadecompra = input.nextInt();
        System.out.println("quantidade venda: ");
        quantidadeVenda = input.nextInt();
        quantidadeEstoque = 0; //inicialmente igual a 0
        

        System.out.print("Digite o tipo de Produto - (1 - Produto não perecivel ou 2 - Produto perecivel): ");
        tipoProduto = input.nextInt();
        input.nextLine(); // Limpar a quebra de linha pendente após nextInt()
        
        switch (tipoProduto) {
            case 1:
            	Produto produto;
                produto = new Produto();
                produto.setNomeProduto(nomeProduto);
                produto.setCodigoProduto(codigoProduto);
                produto.setDescricao(descricao);
                produto.setPrecoCusto(precoCusto);
                produto.setPrecoVenda(precoVenda);
                produto.setQuantidadeVenda(quantidadeVenda);
                produto.setQuantidadecompra(quantidadecompra);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                controleProduto.cadastrarProduto(produto);

                
                System.out.print("\nProduto - Produto não perecivel cadastrada com sucesso!\n");

                break;
            case 2:
                System.out.print("Data de validade: ");
                String dataDeValidade = input.next();
                ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio(nomeProduto, codigoProduto, descricao, precoCusto, precoVenda, quantidadecompra, quantidadeVenda, quantidadeEstoque, dataDeValidade);
                produtoAlimenticio.setValidade(dataDeValidade);
                controleProdutoAlimenticio.cadastrarProdutoAlimenticio(produtoAlimenticio);
                System.out.print("\n Produto - Produto Perecivel cadastrada com sucesso!\n");
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
    
    public void listarProduto(){
        int tipoProduto;
        
        System.out.print("Digite o tipo de Produto que você deseja listar - (1 - Produto não perecivel ou 2 - Produto perecivel: ");
        tipoProduto = input.nextInt();

        switch (tipoProduto) {
            case 1:
                if(!controleProduto.getListProduto().isEmpty()){
                    System.out.print("Lista de Produtos - Produto não perecivel:");
                    System.out.print("\n");

                    for(int i = 0; i < controleProduto.getListProduto().size(); i++){
                        System.out.println("ID: " + (i+1));
                        System.out.println("Nome: " + controleProduto.getListProduto().get(i).getNomeProduto());
                        System.out.println("Codigo: " + controleProduto.getListProduto().get(i).getCodigoProduto());
                        System.out.println("Descricao: " + controleProduto.getListProduto().get(i).getDescricao());
                        System.out.println("Preco custo: " + controleProduto.getListProduto().get(i).getPrecoCusto());
                        System.out.println("Preco venda: " + controleProduto.getListProduto().get(i).getPrecoVenda());
                        System.out.println("Quantidade estoque: " + controleProduto.getListProduto().get(i).getQuantidadeEstoque());
                        System.out.println("Quantidade venda: " + controleProduto.getListProduto().get(i).getQuantidadeVenda());
                        System.out.println("Quantidade compra: " + controleProduto.getListProduto().get(i).getQuantidadecompra());
                    }
                } else {
                    System.out.print("\nNão existe nenhum Produto - Produto não Perecivel cadastrado!\n");
                }
                break;
            case 2:
            	ArrayList<ProdutoAlimenticio> listaProdutosAlimenicio = controleProdutoAlimenticio.getListProdutoAlimenticio();
                if(!listaProdutosAlimenicio.isEmpty()){
                    System.out.print("Lista de Produto - Produtos:");
                    System.out.print("\n");

                    for(int i = 0; i < listaProdutosAlimenicio.size(); i++){
                    	ProdutoAlimenticio produtoAlimenticio = listaProdutosAlimenicio.get(i);
                        System.out.println("ID: " + (i+1));
                        System.out.println("Nome: " + produtoAlimenticio.getNomeProduto());
                        System.out.println("Codigo: " + produtoAlimenticio.getCodigoProduto());
                        System.out.println("Descricao: " + produtoAlimenticio.getDescricao());
                        System.out.println("Preco custo: " + produtoAlimenticio.getPrecoCusto());
                        System.out.println("Preco venda: " + produtoAlimenticio.getPrecoVenda());
                        System.out.println("Quantidade estoque: " + produtoAlimenticio.getQuantidadeEstoque());
                        System.out.println("Quantidade venda: " + produtoAlimenticio.getQuantidadeVenda());
                        System.out.println("Quantidade compra: " + produtoAlimenticio.getQuantidadecompra());
                        System.out.println("Data de validade: " + produtoAlimenticio.getDataValidade());
                    }
                } else {
                    System.out.print("\nNão existe nenhum produto alimenticio cadastradp!\n");
                }
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

    public void editarProduto(){

        String nomeProduto;
        String descricao;
        double precoCusto;
        double precoVenda;
        int quantidadecompra;
        int quantidadeVenda;
        int quantidadeEstoque;
        try{
            System.out.print("Para realizar a alteração, informe o codigo do produto: ");
            String codigo = input.next();

            System.out.print("\n");

            Produto produto = controleProduto.selecionarProduto(codigo);

            if(produto != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("Nome do produto: ");
                nomeProduto = input.next();
                System.out.print("descricao: ");
                descricao = input.next();
                System.out.print("preco custo: ");
                precoCusto = input.nextDouble();
                System.out.println("preco venda: ");
                precoVenda = input.nextDouble();
                System.out.println("quantidade compra: ");
                quantidadecompra = input.nextInt();
                System.out.println("quantidade venda: ");
                quantidadeVenda = input.nextInt();
                System.out.println("quantidade estoque: ");
                quantidadeEstoque = input.nextInt();

                produto.setNomeProduto(nomeProduto);
                produto.setDescricao(descricao);
                produto.setPrecoCusto(precoCusto);
                produto.setPrecoVenda(precoVenda);
                produto.setQuantidadeEstoque(quantidadeEstoque);
                produto.setQuantidadeVenda(quantidadeVenda);
                produto.setQuantidadecompra(quantidadecompra);
                System.out.print("\nProduto alterado com sucesso!\n");
            } 
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void editarProdutoAlimenticio(){

        String nomeProduto;
        String descricao;
        double precoCusto;
        double precoVenda;
        int quantidadecompra;
        int quantidadeVenda;
        int quantidadeEstoque;
        String dataDeValidade;
        try{
            System.out.print("Para realizar a alteração, informe o codigo do produto: ");
            String codigo = input.next();

            System.out.print("\n");

            ProdutoAlimenticio produtoAlimenticio = controleProdutoAlimenticio.selecionarProdutoAlimenticio(codigo);

            if(produtoAlimenticio != null){
                System.out.print("Realize a alteração:");
                System.out.print("\n");

                System.out.print("Nome do produto: ");
                nomeProduto = input.next();
                System.out.print("descricao: ");
                descricao = input.next();
                System.out.println("Data de validade: ");
                dataDeValidade = input.next();
                System.out.print("preco custo: ");
                precoCusto = input.nextDouble();
                System.out.println("preco venda: ");
                precoVenda = input.nextDouble();
                System.out.println("quantidade compra: ");
                quantidadecompra = input.nextInt();
                System.out.println("quantidade venda: ");
                quantidadeVenda = input.nextInt();
                System.out.println("quantidade estoque: ");
                quantidadeEstoque = input.nextInt();

                produtoAlimenticio.setNomeProduto(nomeProduto);
                produtoAlimenticio.setDescricao(descricao);
                produtoAlimenticio.setValidade(dataDeValidade);
                produtoAlimenticio.setPrecoCusto(precoCusto);
                produtoAlimenticio.setPrecoVenda(precoVenda);
                produtoAlimenticio.setQuantidadeEstoque(quantidadeEstoque);
                produtoAlimenticio.setQuantidadeVenda(quantidadeVenda);
                produtoAlimenticio.setQuantidadecompra(quantidadecompra);
                System.out.print("\nProduto alterado com sucesso!\n");
            } 
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void excluirProduto(){
        int tipoProduto;

        String codigo;

        System.out.print("Digite o tipo de Produto que você deseja excluir - (1 - Produto não pereivel ou 2 - Produto perecivel): ");
        tipoProduto = input.nextInt();

        switch (tipoProduto) {
            case 1:
                try{
                    System.out.print("Para realizar a exclusão, informe o codigo do produto não perecivel: ");
                    codigo = input.next();

                    System.out.print("\n");

                    Produto produto = controleProduto.selecionarProduto(codigo);

                    if(produto != null){
                        controleProduto.excluirProduto(produto);
                        System.out.println("Produto não perecivel excluida com sucesso!");
                    }
                } catch(Exception e){
                System.out.println(e.getMessage());
                }
                break;
            case 2:
                try{
                    System.out.print("Para realizar a exclusão, informe o codigo o produto perecivel: ");
                    codigo = input.next();

                    System.out.print("\n");

                    ProdutoAlimenticio produtoAlimenticio = controleProdutoAlimenticio.selecionarProdutoAlimenticio(codigo);

                    if(produtoAlimenticio != null){
                        controleProdutoAlimenticio.excluirProdutoAlimenticio(produtoAlimenticio);
                        System.out.println("Produto perecivel excluido com sucesso.");
                    }
                } catch(Exception e){
                System.out.println(e.getMessage());
                }
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
    public void cadastrarEstoque() {
    	int quantidadeEstoque = -1;
    	int tipoProduto;

        String codigo;

        System.out.print("Digite o tipo de Produto que você deseja cadastrar estoque - (1 - Produto não alimenticio ou 2 - Produto alimenticio): ");
        tipoProduto = input.nextInt();

        switch (tipoProduto) {
            case 1:
                try{
                    System.out.print("Informe o codigo do produto não alimenticio que deseja inserir o estoque: ");
                    codigo = input.next();

                    System.out.print("\n");

                    Produto produto = controleProduto.selecionarProduto(codigo);

                    if(produto != null){
                    	System.out.println("Quantidade de Estoque ");
                    	do{
                    		quantidadeEstoque = input.nextInt();
                    	}while(quantidadeEstoque == -1);

                    	produto.setQuantidadeEstoque(quantidadeEstoque);
                    	
                    	System.out.println("Estoque do produto cadastrada com sucesso ");
                    }
                } catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Não há nenhum produto com esse código");
                }
                break;
            case 2:
                try{
                    System.out.print("Informe o codigo do produto alimenticio que deseja inserir o estoque: ");
                    codigo = input.next();

                    System.out.print("\n");

                    ProdutoAlimenticio produtoAlimenticio = controleProdutoAlimenticio.selecionarProdutoAlimenticio(codigo);

                    if(produtoAlimenticio != null){

                    	System.out.println("Quantidade de Estoque ");
                    	do{
                    		quantidadeEstoque = input.nextInt();
                    	}while(quantidadeEstoque == -1);
                    	
                    	produtoAlimenticio.setQuantidadeEstoque(quantidadeEstoque);
                    	System.out.println("Estoque do produto cadastrada com sucesso ");
                    }
                } catch(Exception e){
	                System.out.println(e.getMessage());
	                System.out.println("Não há nenhum produto com esse código");
                }
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
}