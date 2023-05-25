package com.echueca.clabtool.DAO;

import com.echueca.clabtool.DTO.EnvaseReturnDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import java.util.List;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEnvaseDAO {
    
    public List<EnvaseReturnDTO> getEnvaseForUsuario(EnvaseSearchDTO envase);
    
}
