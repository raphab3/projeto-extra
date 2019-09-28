package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituacaoEntrega {

	PENDENTE(1, "Pendente"),
	ENTREGUE(2, "Entregue"),
	NAOAPLICAVEL(3, "Não Aplicável");
	
	private int codigo;
	private String descricao;
	
	public static SituacaoEntrega toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (SituacaoEntrega x : SituacaoEntrega.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
