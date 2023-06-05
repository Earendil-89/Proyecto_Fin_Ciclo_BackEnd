package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de usos de envase
 * @author Eduardo Chueca Montaner
 */
public interface UsoEnvaseRepository extends JpaRepository<UsoEnvase, Long> {
    
    /**
     * Busca usos de envase activos (sin fecha de devolución)
     * @return Lista de usos de envase activos
     */
    public List<UsoEnvase> findByFechaDevolucionNotNull();
    
    /**
     * Busca usos de envase por usuario
     * @param usuario Usuario que realizó el uso de envase
     * @return Lista de usos de envase
     */
    public List<UsoEnvase> findByUsuario(Usuario usuario);
    
    /**
     * Busca usos de envase por usuario finalizados (con fecha de devolucion)
     * @param usuario Usuario que realizo el uso de envase
     * @return Lista de usos de envase
     */
    public List<UsoEnvase> findByUsuarioAndFechaDevolucionIsNull(Usuario usuario);
    
        /**
     * Busca usos de envase por envase finalizados (con fecha de devolucion)
     * @param envase Usuario que realizo el uso de envase
     * @return Lista de usos de envase
     */
    public List<UsoEnvase> findByEnvaseAndFechaDevolucionIsNull(Envase envase);
    /**
     * Busca usos de envase por envase activos (sin fecha de devolucion)
     * @param envase Envase utilizado
     * @return Lista de usos de envase
     */
    public List<UsoEnvase> findByEnvaseAndFechaDevolucionIsNotNull(Envase envase);
}
