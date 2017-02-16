
package App;

import Domain.Jogo_Em_Acao;


public class TesteForca {
	public static void main(String[] args) {
		
		Jogo_Em_Acao jogo = new Jogo_Em_Acao();
	
		jogo.armazem.adicionar_palavra("Horizonte", "Perspectiva");
		jogo.armazem.adicionar_palavra("Azul", "Cor");
		jogo.armazem.adicionar_palavra("Athena", "Deusa Grega");
		jogo.armazem.adicionar_palavra("Afrodite", "Amor");
		jogo.armazem.adicionar_palavra("Prisma", "Forma geometrica");
		
		jogo.qtd_palavras(jogo.armazem.listaDePalavras.size());
		jogo.fluxo_in_game();
		
			}
		}
