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
public class Boss extends PlayerMoveable{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []down={
        "/ResourcesEnemy/eDown1.png",
        "/ResourcesEnemy/eDown2.png",
        "/ResourcesEnemy/eDown1.png",
        "/ResourcesEnemy/eDown3.png"
    };
    String []up={
        "/ResourcesEnemy/eUp1.png",
        "/ResourcesEnemy/eUp2.png",
        "/ResourcesEnemy/eUp1.png",
        "/ResourcesEnemy/eUp3.png"
    };
    String []left={
        "/ResourcesEnemy/eLeft1.png",
        "/ResourcesEnemy/eLeft2.png",
        "/ResourcesEnemy/eLeft1.png",
        "/ResourcesEnemy/eLeft3.png"
    };
    String []right={
        "/ResourcesEnemy/eRight1.png",
        "/ResourcesEnemy/eRight2.png",
        "/ResourcesEnemy/eRight1.png",
        "/ResourcesEnemy/eRight3.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Boss(int line, int column, Board board) {
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
