package br.com.Bytebank.arquivos.BackEnd.ContaEDescendentes;

import br.com.Bytebank.arquivos.BackEnd.Excecoes.SaldoInsuficiente;
import br.com.Bytebank.arquivos.Tributaveis.Tributavel;

/**
 * 
 * @author matheus
 *
 */

public  abstract class Conta {
	
	private int agencia;
	private Cliente titular;
	private int numero;
	protected double saldo;
	private Tributavel seguro;
	
	public Conta() {
		
		
		this.agencia = 400028922;

		this.saldo = 0;
		
	}			

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero (int novo) {
	
		if (novo > 0) { 
		
		this.numero = novo;
		
		} else if (novo <= 0) {
			
			System.out.println("ESSE NUMERO NAO EXISTE.N");
			
		}
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void sacar (double valor) throws SaldoInsuficiente{
		
		if (this.saldo < valor) {
			
			throw new SaldoInsuficiente("Saldo insuficiente");
									
		} 
		this.saldo = this.saldo - valor;	
	}

	public void depositar (double valor) {
		
		if (valor > 0) {
			
			this.saldo = this.saldo + valor;
			
		} else if (valor < 0) {
			
			System.out.println("NAO É POSSIVEL DEPOSITAR VALORES NEGATIVOS>");
			
		}
						
	}

	public void transferir (double valor, Conta destino) throws SaldoInsuficiente{
		
		this.sacar(valor);
		destino.depositar(valor);
		
	}

	public void setSeguro(Tributavel seguro) {
		
		if (this.saldo < seguro.ValorDoImposto()) {
			
			throw new SaldoInsuficiente("Saldo insuficiente");
									
		} 
		
		saldo-= seguro.ValorDoImposto();
		
	}

	public void setTitular(Cliente NovoNome) {
		this.titular = NovoNome;
	}

	public Cliente getTitular() {
		
		return this.titular;
		
	}
	
	public void VerInformacoes() {
		
		System.out.println("AGENCIA: " + this.agencia);
		System.out.println("NUMERO: " + this.numero);
		System.out.println("SALDO: " + this.saldo);
		
	}
		
}