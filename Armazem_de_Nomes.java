package Domain;

import java.util.ArrayList;
import java.util.List;

public class Armazem_de_Nomes {

	public List<String> listaDePalavras = new ArrayList<>();
	public List<String> dicas = new ArrayList<>();

	public void adicionar_palavra(String palavra, String dica){

		listaDePalavras.add(palavra);
		dicas.add(dica);
		}
	}
