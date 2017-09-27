/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Shifting;

import Core.Board.Board;
import Core.Auto.BonusBomb;
import Core.Auto.BonusLife;
import Core.Fixed.Empty;

/**
 *
 * @author Diogo
 */
public abstract class Player extends Movement implements Runnable{
    
    //Atributos que representam o número de bombas(bombs), de vidas(lifes) e a pontuação(score) com que o jogador começa 
    int bombs=20, lives=3, score=0;
    //Atributo do tipo thread necessaŕio ao corrimento da animação
    Thread threadThis;
    //Declaração da String direção na qual se realizará a animação
    String direction;
    //*****************************************************************************************************************
    
    /* Construtor que recebe as coordenadas na matriz, a referência da imagem do objeto, a matriz da classe Tabuleiro(Board) 
    em que o jogador estará inserido e a direção desejada na sua animação */
    public Player(int line, int column, Board board, String direction) {
        super(line, column, "", board);
        this.direction=direction;
        start();
    }
    //*****************************************************************************************************************

    /*Get's e Set's necessários para alterar os valores de bombas(bombs), de vidas(lifes) e da pontuação(score) 
    e atribuir novas direções no decorrer do jogo */
    
    public int getBombs() {
        return bombs;
    }
    public void setBombs(int numBombs) {
        this.bombs += numBombs;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int life) {
        this.lives += life;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score += score;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    //**************************************************************************************************************************
    
    //Método abstrato que só os avatares do tipo Jogador(Player) realizam
    public abstract void stay();
    //*************************************************************************************************************************
    
    //Apanha o bonus de 2 bombas
    public void getBonusBomb(){
        if (board.getMatrix(line, column) instanceof BonusBomb){
            board.setMatrix(new Empty(line, column, board.strBackground()));
            setBombs(2);
        }
    }
    //apanha o bónus de 1 vida
    public void getBonusLife(){
        if (board.getMatrix(line, column) instanceof BonusLife){
            board.setMatrix(new Empty(line, column, board.strBackground()));
            setLives(1);
        }
    }
    //**************************************************************************************************************************

    //Inicialização da Thread para o corrimento contínuo da animação dos avatares dependendo da direção atribuida pela String direction
    
    public void start(){
        threadThis=new Thread(this);
        threadThis.start();
    }
    public void stop(){
        threadThis=null;
        threadThis=null;
    }
    @Override
    public void run() {
        while(threadThis!=null){
            switch(direction){
                case "stay": stay(); break;
                case "up": moveUp(); break;
                case "down": moveDown(); break;
                case "left": moveLeft(); break;
                case "right": moveRight(); break;
                default: stay(); break;
            }
        }
    }
    //**************************************************************************************************************************
}