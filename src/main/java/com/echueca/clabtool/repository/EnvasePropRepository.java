package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.model.EnvaseProp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para extraer propiedades de envases
 * @author Eduardo Chueca Montaner
 */
public interface EnvasePropRepository extends JpaRepository<EnvaseProp, Long> {
    
    /**
     * Busca una propiedad de envases por su código (coincidencia exacta)
     * @param codigo Código de la propiedad de envases
     * @return EnvaseProp si la búsqueda fue satisfactoria, nulo en caso contrario
     */
    public EnvaseProp findByCodigo(String codigo);
    
    /**
     * Busca propiedades de envases por código (coincidencia parcial)
     * @param codigo Código a buscar
     * @return Lista de EnvaseProp
     */
    public List<EnvaseProp> findByCodigoContainsIgnoreCase(String codigo);
    
    /**
     * Busca propiedades de envases por el nombre de la propiedad
     * @param nombre Nombre de la propiedad
     * @return Lista de EnvaseProp
     */
    public List<EnvaseProp> findByNombreContainsIgnoreCase(String nombre);
    
    /**
     * Busca propiedades de envase por el compuesto químico que contienen
     * @param compuesto Compuesto químico
     * @return Lista de EnvaseProp
     */
    public List<EnvaseProp> findByCompuesto(Compuesto compuesto);
}
