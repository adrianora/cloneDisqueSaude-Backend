package com.ufcg.si1.model;

/**
 * Evitando utilizar os padroes de projeto Strategy e State devido ao grande
 * numero de classes que ambos demandam, optamos por utilizar um modelo em enum
 * onde o efeito polimorfico sera alterado a partir do tipo de enum.
 * 
 * Sobrecarregamos o metodo calcula() que retorna qual sera a situacao da
 * prefeitura em funcao do quoeficiente das queixas abertas e fechadas passada
 * como argumento.
 * 
 * A declaracao do metodo calcula() no escopo da classe eh necessario para
 * permitir o acesso polimorfico em instancias externas.
 */
public enum PrefeituraStatus {

	NORMAL {
		final double quocienteRuim = 0.2;
		final double quocienteRegular = 0.1;

		public RelacaoQueixasStatus calcula(double relacaoQueixasAbertas) {
			RelacaoQueixasStatus status = RelacaoQueixasStatus.BOM;
			if (relacaoQueixasAbertas > quocienteRuim)
				status = RelacaoQueixasStatus.RUIM;
			else if (relacaoQueixasAbertas > quocienteRegular)
				status = RelacaoQueixasStatus.REGULAR;
			return status;
		}
	},

	EXTRA {
		final double quocienteRuim = 0.05;
		final double quocienteRegular = 0.1;

		public RelacaoQueixasStatus calcula(double relacaoQueixasAbertas) {
			RelacaoQueixasStatus status = RelacaoQueixasStatus.BOM;
			if (relacaoQueixasAbertas > quocienteRuim)
				status = RelacaoQueixasStatus.RUIM;
			else if (relacaoQueixasAbertas > quocienteRegular)
				status = RelacaoQueixasStatus.REGULAR;
			return status;
		}
	},

	CAOS {
		final double quocienteRuim = 0.5;
		final double quocienteRegular = 0.2;

		public RelacaoQueixasStatus calcula(double relacaoQueixasAbertas) {
			RelacaoQueixasStatus status = RelacaoQueixasStatus.BOM;
			if (relacaoQueixasAbertas > quocienteRuim)
				status = RelacaoQueixasStatus.RUIM;
			else if (relacaoQueixasAbertas > quocienteRegular)
				status = RelacaoQueixasStatus.REGULAR;
			return status;
		}
	};

	public RelacaoQueixasStatus calcula(double relacaoQueixasAbertas) {
		return this.calcula(relacaoQueixasAbertas);
	}

}
