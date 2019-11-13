package br.com.viasoft.carrinhoCompra;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompraService {

    private CarrinhoCompra carrinhoCompra;

    public CarrinhoCompraService(CarrinhoCompra carrinhoCompra) {
        this.carrinhoCompra = carrinhoCompra;
    }

    public void adicionaItem(Item item) {
        carrinhoCompra.setValorTotal(carrinhoCompra.getValorTotal() + item.getValor());
        carrinhoCompra.getItens().add(item);
    }

    public void removeItem(Item item){
        carrinhoCompra.setValorTotal(carrinhoCompra.getValorTotal() - item.getValor());
        carrinhoCompra.getItens().remove(item);
    }

    public void adicionaFrete(Double valorFrete) {
        carrinhoCompra.setValorTotal(carrinhoCompra.getValorTotal() - carrinhoCompra.getValorFrete());
        carrinhoCompra.setValorFrete(valorFrete);
        carrinhoCompra.setValorTotal(carrinhoCompra.getValorTotal() + valorFrete);
    }

    public void aplicaDesconto(Double valorDesconto) {
        if(valorDesconto > carrinhoCompra.getValorTotal()){
            throw new RuntimeException("Valor do desconto maior que o permitido");
        }
        carrinhoCompra.setValorDesconto(valorDesconto);
        carrinhoCompra.setValorTotal(carrinhoCompra.getValorTotal() - valorDesconto);
    }

    public CarrinhoCompra getCarrinhoCompra(){
        return carrinhoCompra;
    }
}
