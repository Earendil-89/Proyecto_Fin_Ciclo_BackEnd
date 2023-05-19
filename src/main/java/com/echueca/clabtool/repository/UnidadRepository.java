package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Unidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    
    public List<Unidad> findByOrderById();
    
}
