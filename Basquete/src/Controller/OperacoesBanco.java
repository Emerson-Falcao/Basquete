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

//esta classe utiliza a classe de ConexaoBanco para realizar as querys de consulta e inserção no banco
public class OperacoesBanco {
    
    ConexaoBanco con;
    ControllerJogos conJ;
    
    //este método cria um objeto Jogo e o povoa com os resultados 
    public Jogo getUltimoJogo() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        con = new ConexaoBanco();
        Statement stm = con.getConnection();
        String query = ("SELECT * FROM jogos WHERE numero = (SELECT MAX(numero) FROM jogos)");// esta query seleciona o resultado da coluna numero que possui o maior valor, e busca o jogo que possui esse numero
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
    //este método cria uma lista de jogos, com todos os jogos do banco
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
    //este método insere um novo jogo no banco
    public void inserir(int num, int placar) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        con = new ConexaoBanco();
        conJ = new ControllerJogos();
        //aqui é criado um novo objeto Jogo com os valores do ultimo jogo cadastrado, para efeito de comparaçao
        Jogo ultimoJogo = getUltimoJogo();
        //aqui é criado o jogo que será salvo no banco, o método encontraRecorde compara os valores do jogo anterior com o do atual e atualiza os recordes se necessário
        Jogo jogo = conJ.encontraRecorde(ultimoJogo.getNum(),num, placar, ultimoJogo.getRecordeMin(), ultimoJogo.getRecordeMax(),ultimoJogo.getQuebraMin() , ultimoJogo.getQuebraMax());
        Statement stm = con.getConnection();
        String query = ("INSERT INTO jogos VALUES ("+jogo.getNum()+","+jogo.getPlacar()+","+jogo.getRecordeMin()+","+jogo.getRecordeMax()+","+jogo.getQuebraMin()+","+jogo.getQuebraMax()+")");
        stm.executeUpdate(query);
        con.closeConnection();
    }
}
