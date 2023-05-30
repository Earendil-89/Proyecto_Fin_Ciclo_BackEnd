package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Armario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para extraer armarios
 * @author Eduardo Chueca Montaner
 */
public interface ArmarioRepository extends JpaRepository<Armario, Long> {
    
    /**
     * Busca armarios por su nombre
     * @param nombre Nombre del armario
     * @return Armario si la busqueda fue satisfactoria, nulo en caso contrario
     */
    public Armario findByNombre(String nombre);
}
