package br.com.Bytebank.arquivos.FrontEnd;
import java.util.Scanner;

import br.com.Bytebank.arquivos.BackEnd.ContaEDescendentes.Cliente;
import br.com.Bytebank.arquivos.BackEnd.ContaEDescendentes.Conta;
import br.com.Bytebank.arquivos.BackEnd.ContaEDescendentes.ContaCorrente;
import br.com.Bytebank.arquivos.BackEnd.Excecoes.SaldoInsuficiente;
import br.com.Bytebank.arquivos.Tributaveis.SeguroDeVida;
import br.com.Bytebank.arquivos.Tributaveis.Tributavel;
public class CriarConta {

	public static void main(String[] args) {
		
		double valor;
		int acao;
		String resposta;	
		
		Cliente ronald = new Cliente();
		
			ronald.setNome("Ronald");
		
			ronald.setCpf(222222);
			
			ronald.setEndereco("Reino Unido");
		
			ronald.setProfissao("Jogador de xadrez");
			
		ContaCorrente ContaDoRonald = new ContaCorrente();
															
			ContaDoRonald.setNumero(40028922);
		
			ContaDoRonald.setTitular(ronald);		
						
			ContaCorrente segundaconta = new ContaCorrente();
							
			
		do {
			
			System.out.println("QUAL ACAO VOCE DESEJA EXECUTAR?");
			
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("[1] SACAR");
			System.out.println("[2] DEPOSITAR");
			System.out.println("[3] TRANSFERIR");
			System.out.println("[4] VISUALISAR INFORMACOES DA CONTA");
			System.out.println("[5] ALTERAR DADOS");
			System.out.println("[6] ADICIONAR SEGURO");
			
			acao = teclado.nextInt();
			
			 if (acao == 1) {
				 
				 System.out.println("QUAL VALOR DESEJA SACAR ?");
			 
				 valor = teclado.nextDouble();
				 
				 try {
				 
					 ContaDoRonald.sacar(valor);	
				 
				 }catch (SaldoInsuficiente e) {
				
					 System.out.println(e.getMessage());
				 
				 }

				 System.out.println("AGORA O SEU SALDO É DE " + ContaDoRonald.getSaldo());
						
			 } else if (acao == 2) { 
			 					 
		 		System.out.println("QUAL VALOR DESEJA DEPOSITAR ?");
			 		
		 		valor = teclado.nextDouble();
				 
		 		ContaDoRonald.depositar(valor);
				 
		 		System.out.println("AGORA O SEU SALDO É DE " + ContaDoRonald.getSaldo());
			 				 			
			 } else if (acao == 3) {
			 			
			 		System.out.println("QUAL VALOR DESEJA TRANSFERIR ?");
				 
				 	valor = teclado.nextDouble();
				 
			 		ContaDoRonald.transferir(valor, segundaconta);
			 		
			 		System.out.println("AGORA O SEU SALDO É DE " + ContaDoRonald.getSaldo() +
					" E O SALDO DO SEU COLEGA É DE" + segundaconta.getSaldo());	 
			 		
			} else if (acao == 4) {		 		
			 		
					ContaDoRonald.getTitular().VerInformacoes();
				
					ContaDoRonald.VerInformacoes();
			 		
			} else if (acao == 5) {
			 		
			 		int acaoo;
			 				 		
			 		System.out.println("[1] ALTERAR NUMERO DO TITULAR");
			 		System.out.println("[2] ALTERAR NOME DO TITULAR");
			 		
			 		acaoo = teclado.nextInt();
			 		
			 		switch (acaoo) {
			 		
			 		case 1:
			 			
			 			String NovoNome;
			 			
			 			System.out.println("DIGITE O NOVO NOME DO TITULAR:");
			 			
			 			NovoNome = teclado.next();
			 			
			 			break;
			 			
			 		case 2:
			 			
			 			int NovoNumero;
			 			
			 			System.out.println("DIGITE O NOVO NUMERO DE CELULAR DO TITULAR DA CONTA:");
			 			
			 			NovoNumero = teclado.nextInt();
			 			
			 			ContaDoRonald.setNumero(NovoNumero);
			 			
			 			break;
			 			
			 		}
			 		
			} else if (acao == 6) {
				
				Tributavel SeguroVida = new SeguroDeVida();
						
				 try {
					 
					 ContaDoRonald.setSeguro(SeguroVida);	
				 
				 }catch (SaldoInsuficiente e) {
				
					 System.out.println(e.getMessage());
				 
				 }

				 System.out.println("AGORA O SEU SALDO É DE " + ContaDoRonald.getSaldo());
				 
				
			}
		
			 System.out.println("DESEJA CONTINUAR A E EXECUSAO DO PROGRAMA [S/N]");
			 
			 resposta = teclado.next();
			 
		} while((resposta != "S") || (resposta != "s"));
		
	
	}

}