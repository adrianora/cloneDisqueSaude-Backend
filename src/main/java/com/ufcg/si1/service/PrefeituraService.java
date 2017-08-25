package com.ufcg.si1.service;

import com.ufcg.si1.pojo.PrefeituraStatus;
import com.ufcg.si1.pojo.QueixaSituacao;

/**
 * Utiliza do padrao Singleton para garantir a existencia de uma unica
 * prefeitura no banco de dados.
 */
public interface PrefeituraService {
	
	/**
	 * Retorna a situacao geral das queixas dependendo da situacao da prefeitura, Se
	 * normal: mais de 20% abertas eh ruim, mais de 10 eh regular Se extra: mais de
	 * 10% abertas eh ruim, mais de 5% eh regular O situacao retornada pode ser 0
	 * (ruim), 1 (regular) e 2 (bom).
	 */
	QueixaSituacao getSituacaoGeralQueixas(double relacaoQueixasAbertas);

	/**
	 * Interage sobre o singleton para garantir a existencia da prefeitura no
	 * repositorio, evitando acessar atributos nulos e nao duplicando codigo
	 */
	PrefeituraStatus getStatus();
	
	/**
	 * Garante a existencia do singleton da prefeitura no repositorio e em seguida
	 * atualiza o status e atualiza o objeto no banco de dados.
	 */
	void setPrefeituraStatus(PrefeituraStatus status);

}
