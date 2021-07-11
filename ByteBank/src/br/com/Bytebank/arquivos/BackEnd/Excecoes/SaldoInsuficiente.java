package br.com.Bytebank.arquivos.BackEnd.Excecoes;
public class SaldoInsuficiente extends RuntimeException{

	public SaldoInsuficiente(String msg) {
		
		super(msg);
		
	}
	
}
