
package Domain;

import java.util.List;

public class Jogo_Em_Acao {

	public Armazem_de_Nomes armazem = new Armazem_de_Nomes();
	public List<String> bancoDePalavras = armazem.listaDePalavras;
	public List<String> temas = armazem.dicas;
	public int cont = 0, i, pontuacao = 0;
	
	public String[] letrasErradas = {};
	public String[] letrasCorretas = {};

	

	
}
