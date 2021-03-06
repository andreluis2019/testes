package br.com.viasoft.carrinhoCompra.notafiscal;

import java.util.List;

public interface NotaFiscalService {

    NotaFiscal save(NotaFiscal notaFiscal);

    void saveAll(List<NotaFiscal> notaFiscalList);

    NotaFiscal update(String chave, NotaFiscal notaFiscal);

    NotaFiscal findByChave(String chave);

    void atualizaChaveHomologacao(String chave);

}
