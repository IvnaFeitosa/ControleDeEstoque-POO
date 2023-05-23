package PacoteRepositorio;
import java.util.ArrayList;
import PacoteDados.Produto;


public class ControleProduto {
        ArrayList<Produto> arrayListProduto;

    public ControleProduto() {
        arrayListProduto = new ArrayList<Produto>();
    }

    
	public ArrayList<Produto> getListProduto() {
        return arrayListProduto;
    }

    public void cadastrarProduto(Produto produto) {
        this.arrayListProduto.add(produto);
    }

    public Produto selecionarProduto(String codigo) {
        if(!arrayListProduto.isEmpty()) {
            for(int i = 0; i < arrayListProduto.size(); i++) {
                if(arrayListProduto.get(i).getCodigoProduto().equals(codigo)) {
                    return arrayListProduto.get(i);
                }
            }
        }
        return null; //nao achou
    }
    public boolean conferirCodigo(String codigo) {
        if(!arrayListProduto.isEmpty()) {
            for(int i = 0; i < arrayListProduto.size(); i++) {
                if(arrayListProduto.get(i).getCodigoProduto().equals(codigo)) {
                    return true;
                }
            }
        }
        return false; //nao existe
    }

    public void excluirProduto(Produto produto) {
        this.arrayListProduto.remove(produto);
    }
    
    public String getAllProducts() {
    	String result = "";
    		
    	for(Produto p: arrayListProduto) {
    		result += p.toString();
    	}
    	
    	return result;
    }
    
    
    
}