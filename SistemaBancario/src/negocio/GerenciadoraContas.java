package negocio;
import java.util.List;

public class GerenciadoraContas {

    private List<ContaCorrente> contasDoBanco;

    public GerenciadoraContas(List<ContaCorrente> contasDoBanco) {
        this.contasDoBanco = contasDoBanco;
    }

    // Método que limpa a lista de contas
    public void limpaContas() {
        contasDoBanco.clear();  // Limpa todas as contas do banco
    }

    // Método para transferir valor entre contas
    public boolean transfereValor(int idContaOrigem, double valor, int idContaDestino) {
        ContaCorrente contaOrigem = pesquisaCliente(idContaOrigem);
        ContaCorrente contaDestino = pesquisaCliente(idContaDestino);

        if (contaOrigem != null && contaDestino != null && contaOrigem.getSaldo() >= valor) {
            contaOrigem.sacarSaldo(valor);
            contaDestino.depositarSaldo(valor);
            return true;
        }

        return false;
    }

    // Método para pesquisar cliente
    public ContaCorrente pesquisaCliente(int idConta) {
        for (ContaCorrente conta : contasDoBanco) {
            if (conta.getId() == idConta) {
                return conta;
            }
        }
        return null;
    }

    // Método para remover cliente
    public boolean removeCliente(int idConta) {
        ContaCorrente conta = pesquisaCliente(idConta);
        if (conta != null) {
            contasDoBanco.remove(conta);
            return true;
        }
        return false;
    }

    public List<ContaCorrente> getContasDoBanco() {
        return contasDoBanco;
    }
}

