package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.model.Estante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de estantes
 * @author Eduardo Chueca Montaner
 */
public interface EstanteRepository extends JpaRepository<Estante, Long> {
    
    /**
     * Busca un estante por su nombre
     * @param nombre Nombre del estante
     * @return Estante en caso satisfactorio, nulo en caso contrario
     */
    public Estante findByNombre(String nombre);
    
    /**
     * Busca estantes por el armario al que pertenecen
     * @param armario Armario
     * @return Lista de estantes
     */
    public List<Estante> findByArmario(Armario armario);
}
