package implementacao2;

public class GarcomDiretor {
	
	private PizzaBuilder builder;
	
	public GarcomDiretor defineBuilder(PizzaBuilder builder) {
		this.builder = builder;
		return this;
	}
	
	public Pizza montarPizza(){
		return builder
			   .defineCobertura()
			   .defineMassa()
			   .defineMolho()
			   .defineTamPizza("grande")
			   .defineTipoPizza()
			   .build();
	}
	
}
