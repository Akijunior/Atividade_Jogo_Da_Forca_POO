
package Armazem;

import javax.swing.JOptionPane;
import java.util.Random;
public class Armazem_de_Nomes {
	
	public String[] listaDePalavras = {"Pera", "Alface", "Banana"};
	public String[] dicas = {"� uma fruta", "� um legume", "� uma fruta amarela"};
	int cont = listaDePalavras.length + 1;
	
	public void adicionar_palavra(String palavra, String dica){
		
		listaDePalavras[cont] = palavra;
		dicas[cont] = dica;
		cont ++;
	}
	
		}
