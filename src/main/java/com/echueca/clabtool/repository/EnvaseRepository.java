package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para extraer envases
 * @author Eduardo Chueca Montaner
 */
public interface EnvaseRepository extends JpaRepository <Envase, Long> {
    
    /**
     * Busca envases por sus proiedades de envase
     * @param propiedades Propiedades de envase
     * @return Lista de envases
     */
    public List<Envase> findByPropiedades(EnvaseProp propiedades);
  
    /**
     * Busca envases por sus propiedades de envase y disponibilidad
     * @param propiedades Propiedades de envase
     * @param disponible Disponibilidad del envase
     * @return Lista de envases
     */
    public List<Envase> findByPropiedadesAndDisponible(EnvaseProp propiedades, Boolean disponible);
    
    /**
     * Busca envases por los pedidos de los que proceden
     * @param pedido Pedido de procedencia
     * @return Lista de envases
     */ 
    public List<Envase> findByPedido(Pedido pedido);
}
