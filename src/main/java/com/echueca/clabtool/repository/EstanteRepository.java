package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.model.Estante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EstanteRepository extends JpaRepository<Estante, Long> {
    
    public Estante findByNombre(String nombre);
    
    public List<Estante> findByArmario(Armario armario);
}
