/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Shifting;

import Core.Board.Board;
import java.util.Random;

/**
 *
 * @author Diogo
 */
public abstract class PlayerMoveable extends Movement implements Runnable{
    
    //Atributo aleatório(random) necessário para a decisão da direção seguida poelo NPC durante o jogo
    Random rnd, rand;
    //Atributo board que servirá para verificar as direções em que o NPC pode circular
    Board board;
    //Atributo do tipo thread necessaŕio ao corrimento da animação
    Thread threadThis;
    //******************************************************************************************************
    
    //Construtor que recebe as coordenadas na matriz, a referência da imagem do objeto, a respetiva matriz da classe Tabuleiro(Board) 
    public PlayerMoveable(int line, int column, String source, Board board) {
        super(line, column, source, board);
        this.board=board;
        start();
    }
    //********************************************************************************************************************
    
    //Inicialização e corrimento da thread para o movimento e animação do NPC
    private void start() {
        threadThis=new Thread(this);
        threadThis.start();
    }
    public void stop(){
        threadThis=null;
    }
    
    /* Método run() que decidirá aleatóriamente um valor entre 0 e 4, para cada valor terá um inicio de condições diferente 
    para a direção a seguir e em cada movimento este realiza a respetiva animação */
    @Override
    public void run() {
        while(threadThis!=null){
            rnd=new Random();
            int value = rnd.nextInt(4);
            switch(value){
                case 0:
                    if(!board.getMatrix(line-1, column).isSolid()){ moveLeft(); line--;}
                    else if(!board.getMatrix(line+1, column).isSolid()){ moveRight(); line++;}
                        else if(!board.getMatrix(line, column-1).isSolid()){ moveUp(); column--;}
                            else{ moveDown(); column++;}
                    break;
                case 1:
                    if(!board.getMatrix(line+1, column).isSolid()){ moveRight(); line++;}
                    else if(!board.getMatrix(line-1, column).isSolid()){ moveLeft(); line--;}
                        else if(!board.getMatrix(line, column+1).isSolid()){ moveDown(); column++;}
                            else{ moveUp(); column--;}
                    break;
                case 2: 
                    if(!board.getMatrix(line, column-1).isSolid()){ moveUp(); column--;}
                    else if(!board.getMatrix(line, column+1).isSolid()){ moveDown(); column++;}
                        else if(!board.getMatrix(line-1, column).isSolid()){ moveLeft(); line--;}
                            else{ moveRight(); line++;}
                    break;
                case 3: 
                    if(!board.getMatrix(line, column+1).isSolid()){ moveDown();column++;}
                    else if(!board.getMatrix(line, column-1).isSolid()){ moveUp(); column--;}
                        else  if(!board.getMatrix(line+1, column).isSolid()){ moveRight();line++;}
                            else {moveLeft(); line--;}
                    break;
            }
        }
    }
    //********************************************************************************************************************************+
    
    //Caso o NPC seja atinjido por uma explosão será evocado este método que o enviará para um espaço vazio aleatório no tabuleiro
    public void setPosicion(){
        int l, c;
        do{
            rnd=new Random();
            l = rnd.nextInt(20);
            rnd=new Random();
            c = rnd.nextInt(20);
        }while(board.getMatrix(l, c).isSolid());
        this.line =l;
        this.column =c;
    }
    
}
