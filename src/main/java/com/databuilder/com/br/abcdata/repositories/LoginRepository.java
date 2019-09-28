package com.databuilder.com.br.abcdata.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.abcdata.entity.Login;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         23/10/2018
 */

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Transactional(readOnly=true)
	public Optional<Login> findByEmail(String email);
	
}
