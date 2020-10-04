/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Emerson
 */
public class Jogo {
    
    private int num;
    private int placar;
    private int recordeMin;
    private int recordeMax;
    private int quebraMin;
    private int quebraMax;

    public Jogo(int num, int placar, int recordeMin, int recordeMax, int quebraMin, int quebraMax) {
        this.num = num;
        this.placar = placar;
        this.recordeMin = recordeMin;
        this.recordeMax = recordeMax;
        this.quebraMin = quebraMin;
        this.quebraMax = quebraMax;
    }
    public Jogo(){
        
    }
    //este método é utilizado para os testes do JUnit
    @Override
    public boolean equals(Object auxJogo){
        Jogo testJogo = (Jogo) auxJogo;
        if(this.getNum()==testJogo.getNum() && this.getPlacar()==testJogo.getPlacar() && this.getRecordeMin() == testJogo.getRecordeMin()
                && this.getRecordeMax() == testJogo.getRecordeMax() && this.getQuebraMin() == testJogo.getQuebraMin() && this.getQuebraMax() == testJogo.getQuebraMax()){
            return true;
        }
        return false;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPlacar() {
        return placar;
    }

    public void setPlacar(int placar) {
        this.placar = placar;
    }

    public int getQuebraMax() {
        return quebraMax;
    }

    public void setQuebraMax(int quebraMax) {
        this.quebraMax = quebraMax;
    }

    public int getQuebraMin() {
        return quebraMin;
    }

    public void setQuebraMin(int quebraMin) {
        this.quebraMin = quebraMin;
    }

    public int getRecordeMax() {
        return recordeMax;
    }

    public void setRecordeMax(int recordeMax) {
        this.recordeMax = recordeMax;
    }

    public int getRecordeMin() {
        return recordeMin;
    }

    public void setRecordeMin(int recordeMin) {
        this.recordeMin = recordeMin;
    }
    
    
}
