/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Emerson
 */
public class ConexaoBanco {
    
    private Connection conn = null;
    Statement stm;
    private String user;
    private String password;
    private String url;
    private String jdbcDriver;
    private ParamsBanco params;
    
    public ConexaoBanco() throws FileNotFoundException, IOException {
        params= new ParamsBanco();
        this.user = params.getUser();
        this.password = params.getPassword();
        this.url = params.getUrl();
        this.jdbcDriver = params.getJdbcDriver();
    }
    public Statement getConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName(jdbcDriver);
        conn = (Connection) DriverManager.getConnection(url, user, password);
        stm = (Statement) conn.createStatement();
        
        return stm;
    }
    public void closeConnection() throws SQLException{
        stm.close();
        conn.close();
    }
    
}
