package br.com.Bytebank.arquivos.Tributaveis;
public class SeguroDeVida implements Tributavel {

	private double ValorDoSeguro;
	
	public SeguroDeVida() {

		ValorDoSeguro = 300.00;
		
	}
	
	@Override
	public double ValorDoImposto() {
		
		return ValorDoSeguro;
	}



}
