package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();
		empresaDAO = new EmpresaDAO();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * estabelece as pre-condicoes antes da execucao de cada teste
	 * 
	 * @throws Exception
	 */
	@After
	public void excluiEmpresa() throws Exception {
		empresaDAO.exclui("89424232000180");
	}

	/**
	 * verifica o comportamento do sistema na inclusao de um cnpj valido
	 */
	@Test
	public void CT01UC01CadastrarEmpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}

	/*
	 * verifica a validação dos dados para none da empresa inválido
	 */
	@Test
	public void CT02UC01CadastrarEmpresa_valida_nome() {
		try {
			empresa.setNomeDaEmpresa("");
		} catch (IllegalArgumentException e) {
			assertEquals("Nome da empresa inválido!", e.getMessage());
		}
	}

}
