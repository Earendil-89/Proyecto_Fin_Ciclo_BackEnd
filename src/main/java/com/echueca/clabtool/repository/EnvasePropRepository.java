package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.EnvaseProp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EnvasePropRepository extends JpaRepository<EnvaseProp, Long> {
    
    public EnvaseProp findByCodigo(String codigo);
}
