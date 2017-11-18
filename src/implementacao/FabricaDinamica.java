package implementacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import teste.Teste;

public class FabricaDinamica {

	private Properties props;

	public FabricaDinamica(String arquivo) throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(getClass().getClassLoader().getResourceAsStream(arquivo));
	}

	public <E> E criaImplementacao(Class<E> interfacee) {
		String nomeClasse = props.getProperty(interfacee.getName());
		
		if (nomeClasse == null) {
			throw new IllegalArgumentException("Interface n�o configurada");
		}
		
		try {
			Class clazz = Class.forName(nomeClasse);
			if (interfacee.isAssignableFrom(clazz)) {
				return (E) clazz.newInstance();
			} else {
				throw new IllegalArgumentException("Classe configurada n�o implementa a interface");
			}
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Classe configurada n�o existe", e);
		} catch (Exception e) {
			throw new IllegalArgumentException("N�o foi poss�vel criar a implementa��o", e);
		}
	}
	
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
