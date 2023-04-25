package com.pfcti.spring.dev.app.repository;

import com.pfcti.spring.dev.app.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    //Derived Methods
    List<Cliente> findClientesByPaisAndCuentas_EstadoIsTrue(String pais);

    //JPQL
    @Query(value = "select c from Cliente c where c.apellidos =:apellidos")
    List<Cliente> buscarPorApelidos(String apellidos);

    //Derived Methods
    List<Cliente> findClientesByApellidos(String apellidos);

    //Native Query --> Es la sintaxis de la Base de Datos SQL Estandar
    @Query(value = "select nombre, apellidos, cedula, telefono,id from TCLIENTE where apellidos =:apellidos", nativeQuery = true)
    List<Tuple> buscarPorApellidosQueryNativo(String apellidos);

    @Modifying
    @Query(value = "update Cliente c set c.nombre =:nombre where c.apellidos =:apellidos")
    void updateClienteByQuery(String nombre, String apellidos);

    List<Cliente> findByApellidosAndAndNombre(String apellidos, String nombre);

    List<Cliente> findClientesByCedula(String cedula);

    List<Cliente> findClientesByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombres, String apellidos);
}