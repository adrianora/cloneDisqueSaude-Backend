package com.ufcg.si1.pojo;

/**
 * Evitando utilizar os padroes de projeto Strategy e State devido ao grande
 * numero de classes que ambos demandam, optamos por utilizar um modelo em enum
 * onde o efeito polimorfico sera alterado a partir do tipo de enum.
 * 
 * Sobrecarregamos o metodo calcula() que retorna qual sera a situacao da
 * prefeitura em funcao do quoeficiente das queixas abertas e fechadas passada
 * como argumento.
 * 
 * Obs: A declaracao do metodo calcula() no escopo da classe eh necessario para
 * permitir o acesso polimorfico em instancias externas.
 */
public enum PrefeituraStatus {

	NORMAL {
		final double quocienteRuim = 0.2;
		final double quocienteRegular = 0.1;

		public QueixaSituacao calcula(double relacaoQueixasAbertas) {
			return calculaRelacaoQueixas(relacaoQueixasAbertas, quocienteRuim, quocienteRegular);
		}
	},

	EXTRA {
		final double quocienteRuim = 0.05;
		final double quocienteRegular = 0.1;

		public QueixaSituacao calcula(double relacaoQueixasAbertas) {
			return calculaRelacaoQueixas(relacaoQueixasAbertas, quocienteRuim, quocienteRegular);
		}
	},

	CAOS {
		final double quocienteRuim = 0.5;
		final double quocienteRegular = 0.2;

		public QueixaSituacao calcula(double relacaoQueixasAbertas) {
			return calculaRelacaoQueixas(relacaoQueixasAbertas, quocienteRuim, quocienteRegular);
		}
	};

	public QueixaSituacao calcula(double relacaoQueixasAbertas) {
		return this.calcula(relacaoQueixasAbertas);
	}

	private static QueixaSituacao calculaRelacaoQueixas(double queixas, double quocienteRuim, double quocienteRegular) {
		QueixaSituacao status = QueixaSituacao.BOM;
		if (queixas > quocienteRuim)
			status = QueixaSituacao.RUIM;
		else if (queixas > quocienteRegular)
			status = QueixaSituacao.REGULAR;
		return status;
	}

}
