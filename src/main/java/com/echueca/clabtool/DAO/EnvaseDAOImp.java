package com.echueca.clabtool.DAO;

import com.echueca.clabtool.DTO.EnvaseReturnDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseDAOImp implements IEnvaseDAO {

    private JdbcTemplate jdbcTemplate;
            
    public EnvaseDAOImp(DataSource dataSourceSoftpiel) throws IOException {


        Properties prop = new Properties();
        String propFileName = "softpiel.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(prop.getProperty("postgresql.url"));
        driverManagerDataSource.setUsername(prop.getProperty("postgresql.user"));
        driverManagerDataSource.setPassword(prop.getProperty("postgresql.password"));
        driverManagerDataSource.setDriverClassName(prop.getProperty("postgresql.driver"));

        this.jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }
            
    @Override
    public List<EnvaseReturnDTO> getEnvaseForUsuario(EnvaseSearchDTO envase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
