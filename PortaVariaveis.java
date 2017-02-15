
package Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

public class PortaVariaveis {
	
	Random palavra = new Random();
	Boneco Forca = new Boneco();
	public Armazem_de_Nomes armazem = new Armazem_de_Nomes();

	List<String> bancoDePalavras = armazem.listaDePalavras;
	List<String> temas = armazem.dicas;
	
	int contErros = -1;
	int contAcerto = 1;
	int essaNFoi = 0;
	int contRodada = 0;	
	int tamanho;
	int umParaVerdadeiro = 1;
	int posicaoDaPalavra;
	int qtd_palavras = 0;
	int i, pontuacao = 0;
	
	String letra;
	String letraF;
	String letrasCertas;
	String letrasWrong;
	String letraDaVez;
	
	Set<String> letrasGerais = new HashSet<>();
	Set<String> Numeros = new HashSet<>();
	Set<String> PalavrasUsadas = new HashSet<>();
	
	String[] letrasErradas = {};
	String[] letrasCorretas = {};
	String msgF;
	String[] msg;
	String palavraDoBanco;
	String palavraEscolhida;
	
	public int qtd_palavras(int alcance){
		
		while(qtd_palavras == 0){
			this.qtd_palavras = palavra.nextInt(alcance);
			}
		return this.qtd_palavras;
		}
	
	public boolean contemLetra(String letra){
		
		for(int i = 0; i < 10; i++){
			String num = String.valueOf(i);
			Numeros.add(num);
				}
		
			if(letra.length() > 1 || letrasGerais.contains(letra) || Numeros.contains(letra)){
				if(letra.length() > 1)
					JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
						+ " de uma letra por tentativa. Tente novamente.");
		
				if(letrasGerais.contains(letra)){
					JOptionPane.showMessageDialog(null, "A letra digitada já foi "
						+ "citada antes.");
					}
					
				if(Numeros.contains(letra)){
					JOptionPane.showMessageDialog(null, "O caracter digitado "
						+ "foi um número.");
					}
				return false;
				}
			return true;
		}
	
	public void avaliadorDeResultado(int numero){
		
		if(numero == 1){
			JOptionPane.showMessageDialog(null, msgF + 
					"\nVocê perdeu essa. Mais sorte na próxima.");
				}

		else if(numero == 0){
			pontuacao += 100;
			JOptionPane.showMessageDialog(null, msgF + 
					"\nParabéns, você venceu!");	
				}
		
		msgF = "";
		Forca.forca = "\n--"
			     + " |";
			}
		}

