/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.PlayerSkins;

import Core.Board.Board;
import Core.Shifting.PlayerMoveable;

/**
 *
 * @author utilizador
 */
public class Minion extends PlayerMoveable{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []down={
        "/ResourcesEnemy/eDown6.png",
        "/ResourcesEnemy/eDown5.png",
        "/ResourcesEnemy/eDown6.png",
        "/ResourcesEnemy/eDown4.png"
    };
    String []up={
        "/ResourcesEnemy/eUp4.png",
        "/ResourcesEnemy/eUp5.png",
        "/ResourcesEnemy/eUp4.png",
        "/ResourcesEnemy/eUp6.png"
    };
    String []left={
        "/ResourcesEnemy/eLeft4.png",
        "/ResourcesEnemy/eLeft5.png",
        "/ResourcesEnemy/eLeft4.png",
        "/ResourcesEnemy/eLeft6.png"
    };
    String []right={
        "/ResourcesEnemy/eRight5.png",
        "/ResourcesEnemy/eRight4.png",
        "/ResourcesEnemy/eRight5.png",
        "/ResourcesEnemy/eRight6.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Minion(int line, int column, Board board) {
        super(line, column, "",board);
    }
    //*****************************************************************************************************************************
    
    //Métodos herdados da class PlayerMoveable para atribuir a sucessão de imagens correspondentes á direção do mesmo
    
    @Override
    public void moveUp(){
        move(up);
    }
    @Override
    public void moveDown(){
        move(down);
    }
    @Override
    public void moveLeft(){
        move(left);
    }
    @Override
    public void moveRight(){
        move(right);
    }
}
