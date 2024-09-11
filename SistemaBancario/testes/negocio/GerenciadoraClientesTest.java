package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class GerenciadoraClientesTest {

	private GerenciadoraClientes gerenciarClientes;
	private int idClient1 = 1;
	private int idClient2 = 2;
	
	@Before
	public void setUp() {
		
	/*montagem de cenario*/
		// criando clientes
		Cliente cliente1=new Cliente(idClient1,"jão",35,"joao@gmail.com",1,true);
		Cliente cliente2=new Cliente(idClient2,"maria",37,"maria@gmail.com",1,true);
		//inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesdoBanco = new ArrayList<>();
		
		gerenciarClientes = new GerenciadoraClientes(clientesdoBanco);
		
	}
	@After
	public void tearDown() {
		gerenciarClientes.limpa();
	}
	@Test
	public void testPesquisaCliente() {
		/* Execução */
		Cliente cliente =gerenciarClientes.pesquisaCliente(idClient1);
		/* Verificações */
		assertThat(cliente.getId(), is(idClient1));
		
	}
	@Test
	public void testRemoveCliente() {
		/* Execução */
		boolean clienteRemovido = gerenciarClientes.removeCliente(idClient1);
		/* Verificações */
		assertThat(clienteRemovido,is(true));
		assertThat(gerenciarClientes.getClientesDoBanco().size(),is(1));
		assertNull(gerenciarClientes.pesquisaCliente(idClient1));
	}
}
