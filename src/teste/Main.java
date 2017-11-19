package teste;

import java.io.FileNotFoundException;
import java.io.IOException;

import implementacao.FabricaDinamica;
import implementacao.Teste;

public class Main {

	public static void main(String[] args) {
		try {
			FabricaDinamica f = new FabricaDinamica("configuracoes.properties");
			f.criaImplementacao(Teste.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
