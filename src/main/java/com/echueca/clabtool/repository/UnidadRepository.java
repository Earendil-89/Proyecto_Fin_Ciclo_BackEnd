package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Unidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de estantes
 * @author Eduardo Chueca Montaner
 */
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    
    /**
     * Devuelve las unidades ordenadas por su ID
     * @return Lista ordenada de unidades
     */
    public List<Unidad> findByOrderById();
    
}
