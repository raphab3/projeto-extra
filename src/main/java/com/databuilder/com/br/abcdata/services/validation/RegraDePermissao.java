package com.databuilder.com.br.abcdata.services.validation;

import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.PermissaoDeAcesso;
import com.databuilder.com.br.abcdata.security.UserSS;
import com.databuilder.com.br.abcdata.services.UserService;
import com.databuilder.com.br.abcdata.services.exceptions.AuthorizationException;

public class RegraDePermissao {

	public static void acessaRegrasPorId(Integer id) {

		UserSS user = UserService.authenticated();

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.ADMIN.getCodigo())) {

			if (user == null || !user.hasHole(PermissaoDeAcesso.ADMIN) && !id.equals(user.getId())) {
				throw new AuthorizationException("Acesso negado");
			}

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.GESTOR_GERAL.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.GERENTE_NUCLEO.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.DIRETOR_UN_EDUCACIONAL.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.COORDENADOR_UN_EDUCACIONAL.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.SECRETARIA_UN_EDUCACIONAL.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.PROFESSOR.getCodigo())) {

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.ESTUDANTE.getCodigo())) {

			if (user.getNivelDeAcesso().equals(NivelDeAcesso.ESTUDANTE.getCodigo()) && !id.equals(user.getId())) {

				throw new AuthorizationException("Acesso negado!!");

			}
		}
	}

	public int acessaRegrasGeral(int liberacao)

	{

		UserSS user = UserService.authenticated();

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.ADMIN.getCodigo())) {

			return liberacao = 1;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.GESTOR_GERAL.getCodigo())) {

			return liberacao = 2;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.GERENTE_NUCLEO.getCodigo())) {

			return liberacao = 3;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.DIRETOR_UN_EDUCACIONAL.getCodigo())) {

			System.out.println(user.getNivelDeAcesso());

			return liberacao = 4;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.COORDENADOR_UN_EDUCACIONAL.getCodigo())) {

			return liberacao = 5;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.SECRETARIA_UN_EDUCACIONAL.getCodigo())) {

			return liberacao = 6;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.PROFESSOR.getCodigo())) {

			return liberacao = 7;

		} else

		if (user.getNivelDeAcesso().equals(NivelDeAcesso.ESTUDANTE.getCodigo())) {

			if (user.getNivelDeAcesso().equals(NivelDeAcesso.ESTUDANTE.getCodigo())) {
				throw new AuthorizationException("Acesso negado !!");
			}
			return liberacao = 8;
		}
		return liberacao = 0;
	}

}
