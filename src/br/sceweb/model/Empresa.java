package br.sceweb.model;

public class Empresa {
	String cnpj;
	String nomeDaEmpresa;
	String nomeFantasia;
	String endereco;
	String telefone;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}

	public String setNomeDaEmpresa(String nomeDaEmpresa) {
		String msg = "";
		if (nomeDaEmpresa.equals("")) {
			msg = "Nome da empresa inválido!";
		} else
			this.nomeDaEmpresa = nomeDaEmpresa;
		return msg;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
