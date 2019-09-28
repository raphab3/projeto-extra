package com.databuilder.com.br.abcdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.databuilder.com.br.abcdata.entity.UnidadeEducacional;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com Data:
 *         14/09/2018
 */

@Repository
public interface UnidadeEducacionalRepository extends JpaRepository<UnidadeEducacional, Integer> {

}
