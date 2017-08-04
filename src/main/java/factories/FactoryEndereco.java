package factories;

import com.ufcg.si1.model.Endereco;

public class FactoryEndereco {
	
	public static Endereco getEndereco(String rua, String uf, String cidade) {
        
		Endereco endereco = new Endereco(rua, uf, cidade);
		
		return endereco;
    }
}
