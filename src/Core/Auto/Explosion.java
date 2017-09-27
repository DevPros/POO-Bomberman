/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Auto;

import Core.Board.Board;
import Core.Fixed.Empty;
import java.util.Random;

/**
 *
 * @author Diogo
 */

public class Explosion extends AutoActionable implements Runnable{
    
    //Atributo aleatório(random) necessário para mais tarde decidir as probabilidades de aquele espaço ter bónus
    Random rnd;
    //Atributo booliano (boolean) nacessário para a verificação se naquela zzona da explosão existia um Tijolo, se sim então terá probabilidade de sair Bónus
    boolean isBrick;
    /*Atributo Thread necessário para reescrever o método run() já implementado da classe 
    AutoActionable (da qual esta herda) para criar o efeito de explosão mais animado */
    Thread threadThis;
    
    //Atributo do tipo String com as referências das fontes das imagens que serão evocadas para o efeito da explosão
    String []explosion={
        "/Resources/explosion1.png",
        "/Resources/explosion2.png",
        "/Resources/explosion3.png",
        "/Resources/explosion4.png",
        "/Resources/explosion5.png"
    };
    //********************************************************************************************************************
    
    //construtor do objeto Explosão(Explosion) recebendo as posições que ocupa e o Tabuleiro(Board) a que pertence, e o booliano já referido
    public Explosion(int line, int column, Board board, Boolean isBrick) {
        super(line, column, "/Resources/explosion1.png", board, 500);
        this.isBrick=isBrick;
        start();
    }
    //**************************************************************************************************************************
        
    //Métodos herdados da classe Caixa (Box)
    //Os objetos da class AutoAcionável(AutoActionable) Não podem ser destruidos
    @Override
    public boolean isDestructible() {
        return false;
    }
    //Os objetos desta class Não podem ser transpostos
    @Override
    public boolean isSolid() {
        return false;
    }
     //**************************************************************************************************************************

    /* Método herdado da classe AutoAcionável (AutoActionable), nesta class vai atribuir uma probabilidade de 5% a cair bonus de vida,
    40% de cair bonus de Bomba e 55% de não cair nada */
    @Override
    public void timeIsOver(){
        if(isBrick==false) board.setMatrix(new Empty(line, column, board.strBackground()));
        else{
            rnd=new Random();
            int value = rnd.nextInt(20);
            if(value==0)board.setMatrix(new BonusBomb(line, column, board));
            else if(value>0 && value<8) board.setMatrix(new BonusBomb(line, column, board));
            else board.setMatrix(new Empty(line, column, board.strBackground()));
        }
    }
    //********************************************************************************************************************
    //constrói e inicia a execução da thread
    @Override
    public void start() {
        threadThis=new Thread(this);
        threadThis.start();
    }
    // reescrita do método run() que vai correr as imagens da explosão sucessivamente até á ultima com uma velocidade de 8 frames por segundo
    @Override
    public void run(){
        int counter = 0;
        while(counter!=explosion.length){
            for (int i = 0; i < explosion.length; i++) {
                this.setImageIcon(explosion[i]);
                try {Thread.sleep(1000/8);
                } catch (InterruptedException ex) {}
                counter++;
            }
        timeIsOver();
        }
    }
}
