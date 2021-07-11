package br.com.Bytebank.arquivos.BackEnd.ContaEDescendentes;
public class Cliente {

	private String nome;
	private int cpf;
	private String profissao;
	private String endereco;
		

	
	public void setNome(String NovoNome) {
		
		this.nome = NovoNome;
		
	}
	
	public void setCpf(int NovoCpf) {
		
		this.cpf = NovoCpf;
		
	}
	
	public void setProfissao (String NovaProfissao) {
		
		this.profissao = NovaProfissao;
		
	}
	
	public void setEndereco (String NovoEndereco) {
		
		this.endereco = NovoEndereco;
		
	}
	
	public void VerInformacoes() {
		
		System.out.println("NOME: " + this.nome);
		System.out.println("CPF: : " + this.cpf);
		System.out.println("ENDERECO: " + this.endereco);
		System.out.println("PROFISSAO: " + this.profissao);
		
	}
	
}
