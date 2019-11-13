package br.com.viasoft.carrinhoCompra.notafiscal;

import lombok.Data;

import java.util.List;

@Data
public class NotaFiscal {

    private String chave;
    private List<NotaFiscalItem> notaFiscalItemList;

}
