package com.databuilder.com.br.abcdata.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databuilder.com.br.abcdata.entity.Servidor;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Integer> {

/*	@Transactional(readOnly=true)
	Page<Servidor> findByProprietario(Login proprietario, Pageable pageRequest);

	Optional<Servidor> findByIdAndProprietario(Integer id, Login proprietario);
	*/
}
