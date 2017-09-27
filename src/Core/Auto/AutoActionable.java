/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Auto;

import Core.Board.Board;
import Core.Fixed.Box;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
//A classe AutoAcionavel (AutoActionable) será uma superClasse para o objeto Bomba(Bomb)
public abstract class AutoActionable extends Box implements Runnable{
    
    //Atributo board que servirá para ser possível um objeto criar outro objeto no tabuleiro 
    Board board;
    //tempo de espera até executar a tarefa
    int timeToSleep;
    //********************************************************************************************************************
            
    /*Construtor que recebe as coordenadas na matriz, a referência da imagem do objeto, a respetiva matriz da classe Tabuleiro(Board) 
    e o tempo de espera para o desenrrolar da animação de cada objeto que herda desta class */
    public AutoActionable(int line, int column, String source, Board board, int timeToSleep) {
        super(line, column, source);
        this.board=board;
        this.timeToSleep=timeToSleep;
        start();
    }
    //**************************************************************************************************************************
    //Método abstrato que será definido por todas as classes que herdam desta
    public abstract void timeIsOver();
    //**************************************************************************************************************************
    
    
    /* Método que constrói a thread e que inicia o seu funcionamento, 
    esta thread terá a função de dar alguma autonomia á gerencia dos eventos autoacionáveis durante a execução do jogo */
    public void start(){
        Thread threadThis=new Thread(this);
        threadThis.start();
    }
    
    // Método ao qual a thread está associada
    @Override
    public void run() {
        try {
            Thread.sleep(timeToSleep);
            timeIsOver();
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "InterruptedException", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
    }
    //**************************************************************************************************************************
}
