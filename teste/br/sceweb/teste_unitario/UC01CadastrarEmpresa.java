package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

/** Este caso de teste ......
 * @author Luiz Ferreira
 */

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
	 * Estabelece as pré-condições antes da execucao de cada teste
	 * @throws Exception
	 */
	@After
	public void excluiEmpresa() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
	/**
	 * ID - CT01UC01CadastrarEmpresa_com_sucesso
	 * Objetivo - verificar o comportamento do sistema na inclusao de um cnpj valido
	 * Pré-condição - O cnpj 89424232000180 nao estar cadastrado
	 */
	@Test
	public void CT01UC01CadastrarEmpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	/**
	 * ID - CT02UC01CadastrarEmpresa_cnpj_invalido
	 * Objetivo - verificar o comportamento do sistema na inclusao de um cnpj invalido
	 * Pré-condição - Usar um CNPJ invalido, por exemplo 2345678
	 */
	@Test
	public void CT02UC01CadastrarEmpresa_cnpj_invalido() {
		assertEquals("CNPJ invalido.", empresa.setCnpj("2345678"));
	}
	/**
	 * ID - CT03UC01CadastrarEmpresa_cnpj_ja_cadastrado
	 * Objetivo - verificar o comportamento do sistema na inclusao de um cnpj ja cadastrado
	 * Pré-condição - O CNPJ 89424232000180 já estar cadastrado
	 */
	@Test
	public void CT03UC01CadastrarEmpresa_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}
	/**
	 * ID - CT04UC01CadastrarEmpresa_valida_nome
	 * Objetivo - verificar a validação dos dados para none da empresa inválido
	 */
	@Test
	public void CT04UC01CadastrarEmpresa_valida_nome() {
		try {
			empresa.setNomeDaEmpresa("");
		} catch (IllegalArgumentException e) {
			assertEquals("Nome da empresa inválido!", e.getMessage());
		}
	}

}
