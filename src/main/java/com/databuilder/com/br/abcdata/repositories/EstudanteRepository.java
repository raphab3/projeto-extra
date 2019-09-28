package com.databuilder.com.br.abcdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.abcdata.entity.Estudante;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

	@Transactional(readOnly=true)
	@Query(value = "SELECT * FROM v_busca_estudante_escola WHERE unidadeeducacional_id = :escolas and servidores = :serv", nativeQuery = true)
	List<Estudante> findAlunoEscola(@Param("serv") Integer servidor, @Param("escolas") String escolas);

}
