package com.genciv.materialconsumido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genciv.servico.Servico;

@Repository
public interface MaterialConsumidoRepository extends JpaRepository<MaterialConsumido, Long> {
	List<MaterialConsumido> findByServico(Servico servico);

}
