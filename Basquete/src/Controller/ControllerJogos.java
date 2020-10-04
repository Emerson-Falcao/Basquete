/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Jogo;

//esta classe realiza as comparações necessárias para se criar um novo objeto Jogo
public class ControllerJogos {
    
    //este metodo verifica se o placar do jogo a ser cadastrado é maior que o recorde máximo, ou menor que o recorde minimo, e atualiza os recordes para serem cadastrados no banco
    public Jogo encontraRecorde(int numJogoAnt,int num, int placar, int minimo, int maximo, int quebraMin, int quebraMax){
        if(numJogoAnt==0){//caso o jogo anterior seja o 0, cadastrado para comparação, os recordes são automaticamente cadastrados com os valores do jogo atual
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
