package br.com.viasoft.carrinhoCompra.notafiscal;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NotaFiscalItem {

    private String descricao;
    private BigDecimal valor;

}
