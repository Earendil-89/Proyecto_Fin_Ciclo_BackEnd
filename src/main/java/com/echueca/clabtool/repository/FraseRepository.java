package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de frases
 * @author Eduardo Chueca Montaner
 */
public interface FraseRepository extends JpaRepository<Frase, Long> {
    
    /**
     * Busca una frase por su código
     * @param codigo Código de la frase
     * @return Frase en caso satisfactorio, nulo en caso contrario
     */
    public Frase findByCodigo(String codigo);
}
