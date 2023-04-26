package com.pfcti.spring.dev.app.repository;

import com.pfcti.spring.dev.app.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_Id(int clienteId);
    List<Cuenta> findCuentaByEstadoIsTrue();
    List<Cuenta> findByCliente_IdAndEstadoIsTrue(int clienteId);


}
