/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Jogo;
import com.mysql.jdbc.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Emerson
 */
public class OperacoesBanco {
    
    ConexaoBanco con;
    ControllerJogos conJ;
    
    public Jogo getUltimoJogo() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        con = new ConexaoBanco();
        Statement stm = con.getConnection();
        String query = ("SELECT * FROM jogos WHERE numero = (SELECT MAX(numero) FROM jogos)");
        ResultSet rs = stm.executeQuery(query);
        rs.next();
        Jogo jogo = new Jogo();
        jogo.setNum(rs.getInt("numero"));
        jogo.setPlacar(rs.getInt("placar"));
        jogo.setRecordeMin(rs.getInt("minimo"));
        jogo.setRecordeMax(rs.getInt("maximo"));
        jogo.setQuebraMin(rs.getInt("rec_min"));
        jogo.setQuebraMax(rs.getInt("rec_max"));
        con.closeConnection();
        return jogo;
    }
    
    public ArrayList<Jogo> getTodosJogos() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        con  = new ConexaoBanco();
        Statement stm = con.getConnection(); 
        String query  = ("SELECT * FROM jogos");
        ResultSet rs = stm.executeQuery(query);
        Jogo jogo;
        ArrayList<Jogo> jogos = new ArrayList();
        while(rs.next()){
            jogo = new Jogo();
            jogo.setNum(rs.getInt("numero"));
            jogo.setPlacar(rs.getInt("placar"));
            jogo.setRecordeMin(rs.getInt("minimo"));
            jogo.setRecordeMax(rs.getInt("maximo"));
            jogo.setQuebraMin(rs.getInt("rec_min"));
            jogo.setQuebraMax(rs.getInt("rec_max"));
            jogos.add(jogo);
            
        }
        con.closeConnection();
        return jogos;
    }
    public void inserir(int num, int placar) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        con = new ConexaoBanco();
        conJ = new ControllerJogos();
        Jogo ultimoJogo = getUltimoJogo();
        Jogo jogo = conJ.encontraRecorde(ultimoJogo.getNum(),num, placar, ultimoJogo.getRecordeMin(), ultimoJogo.getRecordeMax(),ultimoJogo.getQuebraMin() , ultimoJogo.getQuebraMax());
        Statement stm = con.getConnection();
        String query = ("INSERT INTO jogos VALUES ("+jogo.getNum()+","+jogo.getPlacar()+","+jogo.getRecordeMin()+","+jogo.getRecordeMax()+","+jogo.getQuebraMin()+","+jogo.getQuebraMax()+")");
        stm.executeUpdate(query);
        con.closeConnection();
    }
}
