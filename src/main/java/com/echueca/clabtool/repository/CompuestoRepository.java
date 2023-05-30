package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para extraer compuestos
 * @author Eduardo Chueca Montaner
 */
public interface CompuestoRepository extends JpaRepository<Compuesto, Long> {
    
    /**
     * Busca compuestos por su código CAS
     * @param cas Código CAS del compuesto
     * @return Compuesto si la busqueda fue satisfactoria, nulo en caso contrario
     */
    public Compuesto findByCas(String cas);
    
    /**
     * Realiza una consulta de compuesto por su nombre
     * @param nombre Nombre del compuesto a buscar
     * @return Lista con compuestos coincidentes
     */
    public List<Compuesto> findByNombreContainsIgnoreCase(String nombre);
}
