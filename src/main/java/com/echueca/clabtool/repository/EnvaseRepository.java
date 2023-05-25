package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.EnvaseProp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EnvaseRepository extends JpaRepository <Envase, Long> {
    
    public List<Envase> findByPropiedades(EnvaseProp propiedades);
}
