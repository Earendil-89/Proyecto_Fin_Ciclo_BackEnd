package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface CompuestoRepository extends JpaRepository<Compuesto, Long> {
    
    public Compuesto findByCas(String cas);
    
    public List<Compuesto> findByNombreContainsIgnoreCase(String nombre);
}
