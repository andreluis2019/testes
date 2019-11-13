package br.com.viasoft.carrinhoCompra;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra{

    private Double valorTotal;
    private Double valorFrete;
    private Double valorDesconto;
    private List<Item> itens;

    public CarrinhoCompra() {
        valorTotal = 0D;
        valorFrete = 0D;
        valorDesconto = 0D;
        itens = new ArrayList<>();
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
