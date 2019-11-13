package br.com.viasoft.carrinhoCompra.notafiscal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NotaFiscalServiceImplTest {

    @Mock
    private NotaFiscalRepository repository;
    @Mock
    private EmailService emailService;
    @Mock
    private EstoqueService estoqueService;
    @InjectMocks
    private NotaFiscalServiceImpl serviceImpl;

    @Test
    public void verificaSeChamaMetodoSave() {
        NotaFiscal notaFiscal = new NotaFiscal();
        serviceImpl.save(notaFiscal);

        Mockito.verify(repository).save(notaFiscal);
        Mockito.verify(emailService).enviaEmail(notaFiscal);
    }

    @Test
    public void verificaSeAListaFoiAdicionada() {
        List<NotaFiscal> notaFiscalList = new ArrayList<>();
        serviceImpl.saveAll(notaFiscalList);

        Mockito.verify(repository).saveAll(notaFiscalList);
    }

    @Test
    public void verificaSeAtualizaNota() {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setChave("123456");
        serviceImpl.update(notaFiscal.getChave(), notaFiscal);

        Mockito.verify(repository).update(notaFiscal.getChave(), notaFiscal);
    }

    @Test
    public void verificaSeBuscaPorChave() {
        String chave = "654321";
        serviceImpl.findByChave(chave);

        Mockito.verify(repository).findByChave(chave);
    }

    @Test
    public void atualizaChaveHomologacao() {
        var notaFiscal = new NotaFiscal();
        notaFiscal.setChave("123");

        Mockito.when(repository.findByChave("123")).thenReturn(notaFiscal);

        serviceImpl.atualizaChaveHomologacao("123");

        assertEquals("123HOMOLOGACAO", notaFiscal.getChave());
        Mockito.verify(repository).update("123", notaFiscal);
    }

    @Test
    public void verificaBaixaEstoque() {
        var notaFiscal = new NotaFiscal();
        notaFiscal.setNotaFiscalItemList(new ArrayList<>());
        var item1 = new NotaFiscalItem();
        var item2 = new NotaFiscalItem();
        var item3 = new NotaFiscalItem();

        notaFiscal.getNotaFiscalItemList().add(item1);
        notaFiscal.getNotaFiscalItemList().add(item2);
        notaFiscal.getNotaFiscalItemList().add(item3);

        serviceImpl.save(notaFiscal);
        Mockito.verify(estoqueService, Mockito.times(3)).baixarEstoque(Mockito.any());
    }

    @Test
    public void verificaBaixaEstoqueVariasNotas() {
        var notaFiscal = new NotaFiscal();
        notaFiscal.setNotaFiscalItemList(new ArrayList<>());
        var item1 = new NotaFiscalItem();
        var item2 = new NotaFiscalItem();
        var item3 = new NotaFiscalItem();

        var notaFiscal2 = new NotaFiscal();
        notaFiscal2.setNotaFiscalItemList(new ArrayList<>());

        notaFiscal.getNotaFiscalItemList().add(item1);
        notaFiscal.getNotaFiscalItemList().add(item2);
        notaFiscal.getNotaFiscalItemList().add(item3);

        notaFiscal2.getNotaFiscalItemList().add(item1);
        notaFiscal2.getNotaFiscalItemList().add(item2);

        List<NotaFiscal> notaFiscalList = new ArrayList<>();
        notaFiscalList.add(notaFiscal);
        notaFiscalList.add(notaFiscal2);

        serviceImpl.saveAll(notaFiscalList);
        Mockito.verify(estoqueService, Mockito.times(5)).baixarEstoque(Mockito.any());
    }
}