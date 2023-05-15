package PacoteRepositorio;
import java.util.ArrayList;

import PacoteDados.ProdutoAlimenticio;

public class ControleProdutoAlimenticio {
    ArrayList<ProdutoAlimenticio> arrayListProdutoAlimenticio;

    public ControleProdutoAlimenticio() {
        arrayListProdutoAlimenticio = new ArrayList<>();
    }

    public ArrayList<ProdutoAlimenticio> getListProdutoAlimenticio() {
        return arrayListProdutoAlimenticio;
    }

    public void cadastrarProdutoAlimenticio(ProdutoAlimenticio produtoAlimenticio) {
        arrayListProdutoAlimenticio.add(produtoAlimenticio);
    }

    public ProdutoAlimenticio selecionarProdutoAlimenticio(String codigo) {

        if(!arrayListProdutoAlimenticio.isEmpty()) {
            for(int i = 0; i < arrayListProdutoAlimenticio.size(); i++) {
                if(arrayListProdutoAlimenticio.get(i).getCodigoProduto().equals(codigo)) {
                    return arrayListProdutoAlimenticio.get(i);
                }
            }
        }
        return null;
    }

    public void excluirProdutoAlimenticio(ProdutoAlimenticio produtoAlimenticio) {
        arrayListProdutoAlimenticio.remove(produtoAlimenticio);
    }
}