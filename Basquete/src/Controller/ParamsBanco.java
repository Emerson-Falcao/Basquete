/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Emerson
 */
public class ParamsBanco {
    private String user;
    private String password;
    private String url;
    private String jdbcDriver;

    public ParamsBanco() throws FileNotFoundException, IOException{
        getParams();
    }
    public void getParams() throws FileNotFoundException, IOException{
        FileReader config = new FileReader("config.cfg");
        BufferedReader readConfig = new BufferedReader(config);
        user = readConfig.readLine();
        password = readConfig.readLine();
        url = "jdbc:mysql://"+readConfig.readLine()+"/basquete";
        jdbcDriver = readConfig.readLine();
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
