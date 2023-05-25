package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.model.EnvaseProp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EnvasePropRepository extends JpaRepository<EnvaseProp, Long> {
    
    public EnvaseProp findByCodigo(String codigo);
    
    public List<EnvaseProp> findByCodigoContainsIgnoreCase(String codigo);
    
    public List<EnvaseProp> findByNombreContainsIgnoreCase(String nombre);
    
    public List<EnvaseProp> findByCompuesto(Compuesto compuesto);
}
