package br.com.viasoft.carrinhoCompra;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarrinhoCompraServiceTest {

    CarrinhoCompraService carrinhoCompraService = new CarrinhoCompraService(new CarrinhoCompra());
    Item item = new Item();
    Item item2 = new Item();

    @Test
    public void adicionaItem() {
        item.setValor(15D);
        carrinhoCompraService.adicionaItem(item);

        assertEquals(Double.valueOf(15D), carrinhoCompraService.getCarrinhoCompra().getValorTotal());
        System.out.println(carrinhoCompraService.getCarrinhoCompra().getValorTotal());

        assertEquals(1, carrinhoCompraService.getCarrinhoCompra().getItens().size());
        System.out.println(carrinhoCompraService.getCarrinhoCompra().getItens().size());

    }

    @Test
    public void removeItem(){
        item.setValor(15D);
        carrinhoCompraService.getCarrinhoCompra().setValorTotal(15D);
        carrinhoCompraService.getCarrinhoCompra().getItens().add(item);
        carrinhoCompraService.removeItem(item);

        assertEquals(Double.valueOf(0D), carrinhoCompraService.getCarrinhoCompra().getValorTotal());
        System.out.println(carrinhoCompraService.getCarrinhoCompra().getValorTotal());

        assertEquals(0, carrinhoCompraService.getCarrinhoCompra().getItens().size());
        System.out.println(carrinhoCompraService.getCarrinhoCompra().getItens().size());
    }

    @Test
    public void validaAdicaoValorFrete() {
        carrinhoCompraService.adicionaFrete(5D);
        assertEquals(Double.valueOf(5D), carrinhoCompraService.getCarrinhoCompra().getValorFrete());

        item.setValor(10D);
        carrinhoCompraService.adicionaItem(item);

        assertEquals(Double.valueOf(15D), carrinhoCompraService.getCarrinhoCompra().getValorTotal());
    }

    @Test
    public void validaDesconto() {
        item.setValor(10D);
        carrinhoCompraService.adicionaItem(item);
        carrinhoCompraService.aplicaDesconto(2D);
        assertEquals(Double.valueOf(8D), carrinhoCompraService.getCarrinhoCompra().getValorTotal());
    }

    @Test(expected = RuntimeException.class)
    public void validaDescontoMaiorQueOPermitido() {
        carrinhoCompraService.aplicaDesconto(2D);
    }

    @Test
    public void todosOsTestes() {
        carrinhoCompraService.getCarrinhoCompra().setValorTotal(0D);
        item.setValor(10D);
        item2.setValor(5D);

        carrinhoCompraService.adicionaItem(item);
        carrinhoCompraService.adicionaItem(item2);

        carrinhoCompraService.removeItem(item2);

        carrinhoCompraService.adicionaFrete(5D);
        carrinhoCompraService.adicionaFrete(2D);

        carrinhoCompraService.aplicaDesconto(2D);
    }

}