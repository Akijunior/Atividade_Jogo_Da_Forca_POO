package Domain;

import javax.swing.JOptionPane;

public class Jogo_Em_Acao extends PortaVariaveis{
	
	public void fluxo_in_game(){
		
		while(qtd_palavras != 0) {
			
			posicaoDaPalavra = palavra.nextInt(bancoDePalavras.size());
			palavraDoBanco = bancoDePalavras.get(posicaoDaPalavra);
			tamanho = palavraDoBanco.length();

			msg = new String[tamanho];
			msgF = "";

			JOptionPane.showMessageDialog(null,"Qtd de palavras restantes "
												+ "da rodada: " + (qtd_palavras));

			JOptionPane.showMessageDialog(null,"Tamanho da palavra: " + tamanho + "\n");

			for (i = 0; i < tamanho; i++) {

				msg[i] = "_ ";
				msgF += msg[i];
				}

			msgF +=  "\n" + temas.get(posicaoDaPalavra) + "\n";

			palavraEscolhida = bancoDePalavras.get(posicaoDaPalavra);

			contErros = -1;
			contAcerto = 1;
			essaNFoi = 0;
			
			letrasCertas = "";
			letrasWrong = "";
			letraDaVez = "";
			letrasGerais.clear();


				while(contAcerto != 0){	

					letra = JOptionPane.showInputDialog(msgF + "Diga uma letra: ");

					contRodada = 0;	
					contAcerto = 0;
					boolean avaliadorDeLetra = contemLetra(letra);
					
					while(!avaliadorDeLetra){
						
						letra = JOptionPane.showInputDialog(msgF + "Digite uma nova letra: ");
						contemLetra(letra);
						avaliadorDeLetra = contemLetra(letra);
					}
				

					msgF = "";
					
					for(i = 0; i < tamanho; i++){

						letraDaVez = String.valueOf(palavraEscolhida.charAt(i));

						if(letra.equalsIgnoreCase(letraDaVez)){
							msg[i] = letraDaVez;
							pontuacao += 15;
							contRodada = 1;
							}
						}

						
					if(contRodada == 1){
						letrasCertas += letra + " ";
						letrasGerais.add(letra);
						}

					else{
						letrasWrong += letra + " ";
						letrasGerais.add(letra);
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
						letraF = String.valueOf(msgF.charAt(i));
						if(letraF.equals("_")){
							contAcerto ++;			
							}
						}
					
					msgF +=  "\n" + temas.get(posicaoDaPalavra) + "\n" + Forca.forca + "\n" + "Pontuacao: " +
							pontuacao + "\nLetras Certas { "
									+ letrasCertas + "}\nLetras Erradas { " + letrasWrong + "}\n";	
					}
					
					avaliadorDeResultado(essaNFoi);
					
					qtd_palavras --;	
					}
					JOptionPane.showMessageDialog(null, "Fim do jogo!\nPontuação final: " + pontuacao 
							+ "\nAté a próxima!");
					
				}
			}
		
		
	
		
		
		
