package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de etiquetas
 * @author Eduardo Chueca Montaner
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    
    /**
     * Busca etiquetas por su código
     * @param codigo
     * @return Etiqueta en caso satisfactorio, nulo en caso contrario
     */
    public Etiqueta findByCodigo(String codigo);
}