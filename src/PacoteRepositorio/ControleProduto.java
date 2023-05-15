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

    public void excluirProduto(Produto produto) {
        this.arrayListProduto.remove(produto);
    }
}