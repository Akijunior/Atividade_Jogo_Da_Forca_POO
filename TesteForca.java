
package App;

import javax.swing.JOptionPane;
import Domain.Armazem_de_Nomes;
import Domain.Boneco;
import Domain.Jogo_Em_Acao;
import java.util.Random;


public class TesteForca {
	public static void main(String[] args) {
		
		Jogo_Em_Acao jogo = new Jogo_Em_Acao();
		Random palavra = new Random();
		Boneco Forca = new Boneco();
		Armazem_de_Nomes armazem = new Armazem_de_Nomes();
		armazem.adicionar_palavra("Horizonte", "Perspectiva");
		armazem.adicionar_palavra("Azul", "Cor");
		
		int qtd_palavras = palavra.nextInt(4);
		int i, cont = jogo.cont;
		
		
		while(qtd_palavras == 0){
			qtd_palavras = palavra.nextInt(4);
			}

		
		while(cont < qtd_palavras) {

			int posicaoDaPalavra = palavra.nextInt(jogo.bancoDePalavras.size());
			int tamanho = jogo.bancoDePalavras[posicaoDaPalavra].length();

			String[] msg = new String[tamanho];
			String msgF = "";

			JOptionPane.showMessageDialog(null,"Qtd de palavras restantes "

												+ "da rodada: " + (qtd_palavras - cont));


			JOptionPane.showMessageDialog(null,"Tamanho da palavra: " + tamanho + "\n");

			for (i = 0; i < tamanho; i++) {

				msg[i] = "_ ";
				msgF += msg[i];
				}

			msgF +=  "\n" + jogo.temas[posicaoDaPalavra] + "\n";

			String palavraEscolhida = jogo.bancoDePalavras[posicaoDaPalavra];


			int contErros = -1;
			int contAcerto = 1;
			int essaNFoi = 0;
			
			String letrasCertas = "";
			String letrasWrong = "";
			String letraDaVez = "";
			String letrasGerais = "";


				while(contAcerto != 0){	

					String letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");

					int contRodada = 0;	
					contAcerto = 0;
					int umParaVerdadeiro = 1;
				
					
					for (int j = 0; j < letrasGerais.length(); j++) {
						letraDaVez = String.valueOf(letrasGerais.charAt(j));
						
						if(letraDaVez.equals(letra)){
							umParaVerdadeiro = 0;
							break;
							}	
						}
					

					while (letra.length() > 1 || umParaVerdadeiro == 0){

						if(letra.length() > 1)
							JOptionPane.showMessageDialog(null, "Não é válido digitar mais"
									+ " de uma letra por tentativa. Tente novamente.");

						if(umParaVerdadeiro == 0){

							for (int j = 0; j < letrasGerais.length(); j++) {
								
								letraDaVez = String.valueOf(letrasGerais.charAt(j));

								if(letraDaVez.equals(letra)){
									JOptionPane.showMessageDialog(null, "A letra digitada já foi "
											+ "citada antes.");
									umParaVerdadeiro = 0;
									break;
									}
								
								umParaVerdadeiro ++;
								}
							}

						letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");
						}

					msgF = "";
					
					for(i = 0; i < tamanho; i++){

						letraDaVez = String.valueOf(palavraEscolhida.charAt(i));

						if(letra.equalsIgnoreCase(letraDaVez)){
							msg[i] = letraDaVez;
							jogo.pontuacao += 15;
							contRodada = 1;
							}
						}

						
					if(contRodada == 1){
						letrasCertas += letra + " ";
						letrasGerais += letra + " ";
						}

					else{
						letrasWrong += letra + " ";
						letrasGerais += letra + " ";
						contErros ++;

						Forca.forca += Forca.forca_em_andamento[contErros];

						if(contErros == 5 && contRodada == 0) {
							essaNFoi ++;
							break;
							}		
						}

					for (i = 0; i < tamanho; i++) 
						msgF += msg[i];

					for (i = 0; i < tamanho; i++){
						String letraF = String.valueOf(msgF.charAt(i));
						if(letraF.equals("_")){
							contAcerto ++;			
							}
						}

					msgF +=  "\n" + jogo.temas[posicaoDaPalavra] + "\n" + Forca.forca + "\n" + "Pontuacao: " +
					jogo.pontuacao + "\nLetras Certas { "
							+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	
					}

					
					if(essaNFoi == 1){
						msgF +=  "\n" + jogo.temas[posicaoDaPalavra] + "\n" + Forca.forca + "\n" + "Letras Certas { "
								+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	

						JOptionPane.showMessageDialog(null, msgF + 
								"\nVocê perdeu essa. Mais sorte na próxima.");
							}

					if(essaNFoi == 0){
						jogo.pontuacao += 100;
						JOptionPane.showMessageDialog(null, msgF + "\nParabéns, você venceu!");	
							}
					
					msgF = "";
					Forca.forca = "\n--"
						     + " |";
					cont ++;
				}
				
				JOptionPane.showMessageDialog(null, "Fim do Jogo!\n"
						+ "Pontuação total: " + jogo.pontuacao + "."
						+ "\nObrigado pela participação e até a próxima!");
		
			}
		}
