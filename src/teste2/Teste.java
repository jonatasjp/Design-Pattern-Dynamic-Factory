package teste2;

import java.io.FileNotFoundException;
import java.io.IOException;

import implementacao2.FabricaDinamica;
import implementacao2.GarcomDiretor;
import implementacao2.PizzaBuilder;

public class Teste {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FabricaDinamica f = new FabricaDinamica("configuracoes.properties");
		PizzaBuilder pizzaBuilder = f.criaImplementacao(PizzaBuilder.class);
		
		new GarcomDiretor()
				.defineBuilder(pizzaBuilder)
				.montarPizza()
				.exibePizza();
		
	}

}
