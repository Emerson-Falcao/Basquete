/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Jogo;

/**
 *
 * @author Emerson
 */
public class ControllerJogos {
 
    public Jogo encontraRecorde(int numJogoAnt,int num, int placar, int minimo, int maximo, int quebraMin, int quebraMax){
        if(numJogoAnt==0){
            maximo = placar;
            minimo = placar;
        }else{
            if(placar>maximo){
                maximo = placar;
                quebraMax++;
            }
            if(placar<minimo){
                minimo = placar;
                quebraMin++;
            }  
        }
        
        return new Jogo(num,placar,minimo,maximo,quebraMin,quebraMax);
    }
    
}
