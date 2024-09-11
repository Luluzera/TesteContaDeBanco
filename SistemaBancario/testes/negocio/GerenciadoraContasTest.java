package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class GerenciadoraContasTest {

    private GerenciadoraContas gerContas;
    private ContaCorrente conta01;
    private ContaCorrente conta02;

    @Before
    public void setUp() {
        // Montagem de cenário comum a todos os testes
        int idConta1 = 1;
        int idConta2 = 2;
        conta01 = new ContaCorrente(idConta1, 200, true);
        conta02 = new ContaCorrente(idConta2, 0, true);

        List<ContaCorrente> contasDoBanco = new ArrayList<>();
        contasDoBanco.add(conta01);
        contasDoBanco.add(conta02);

        gerContas = new GerenciadoraContas(contasDoBanco);
    }

    @After
    public void tearDown() {
        // Limpar o estado das contas após cada teste
        gerContas.limpaContas();
    }

    // Validação de transferência entre contas.
    @Test
    public void testTransfereValor() {
        // Execução
        boolean sucesso = gerContas.transfereValor(1, 100, 2);

        // Verificações
        assertTrue(sucesso);
        assertThat(conta02.getSaldo(), is(100.0));
        assertThat(conta01.getSaldo(), is(100.0));
    }

    // Teste da funcionalidade de pesquisa de cliente
    @Test
    public void testPesquisaCliente() {
        // Execução
        ContaCorrente clientePesquisado = gerContas.pesquisaCliente(1);

        // Verificações
        assertNotNull(clientePesquisado);
        assertThat(clientePesquisado.getId(), is(1));
    }

    // Teste da funcionalidade de remoção de cliente
    @Test
    public void testRemoveCliente() {
        // Execução
        boolean clienteRemovido = gerContas.removeCliente(2);

        // Verificações
        assertTrue(clienteRemovido);
        assertThat(gerContas.getContasDoBanco().size(), is(1));
        assertNull(gerContas.pesquisaCliente(2));
    }
}
