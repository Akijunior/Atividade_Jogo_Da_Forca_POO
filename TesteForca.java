
package Teste;

import javax.swing.JOptionPane;

import Armazem.Armazem_de_Nomes;
import Armazem.Boneco;
import java.util.Random;

public class TesteForca {
	
	public static void main(String[] args) {
		
		int cont = 0, contador = 0, contPalavra = 0;
		String espaco = " ";
		String palavra_atual = "";
		Boneco forca = new Boneco();
		String boneco_Forca = forca.forca;
		String forca_Andamento = forca.forca_em_andamento;
		
		Armazem_de_Nomes adn = new Armazem_de_Nomes();

		String[] listaDePalavras = adn.listaDePalavras;
		
		Random aleatorio = new Random();
		int posicaoDaPalavra = aleatorio.nextInt(listaDePalavras.length);
		int tamanho = listaDePalavras[posicaoDaPalavra].length();
		String palavra =  listaDePalavras[posicaoDaPalavra];
		String dica = adn.dicas[posicaoDaPalavra];
		for(int o = 0; o < palavra.length(); o++){
			palavra_atual += "_ ";
		}
		System.out.println("\n");
		
		while(contador < 7){
				
			
			String a = JOptionPane.showInputDialog(palavra_atual + "\n" + dica + "\n" + 
													boneco_Forca + "\n\n");
			
			for (int i = 0; i < palavra.length(); i++) {
				
				String letra = String.valueOf(palavra.charAt(i));
				
				if (letra.equalsIgnoreCase(a)){
					
					for (int l = contPalavra; l < palavra.length(); l++) {
						
						String letraNaPalavra = String.valueOf(palavra.charAt(l));
						
						if(letraNaPalavra.equalsIgnoreCase(a)){
							palavra_atual = "";
							palavra_atual += a;
							
							contPalavra ++;
							}
						
						else{
							palavra_atual += "_ ";
							}
						}
					break;
					}
					
				
				else{
					
					boneco_Forca += forca_Andamento.charAt(cont);
					String add_letra = String.valueOf(forca_Andamento.charAt(cont));
					cont ++;
			
					while(add_letra.equals(espaco) || add_letra.equals("\n")){
						boneco_Forca += forca_Andamento.charAt(cont);
						add_letra = String.valueOf(forca_Andamento.charAt(cont));
						cont ++;
							}
					break;
						}
					}
			
			contador ++;
			}
		}
	}
