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
public class Ranger extends PlayerMoveable{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []down={
        "/ResourcesEnemy/eDown7.png",
        "/ResourcesEnemy/eDown8.png",
        "/ResourcesEnemy/eDown7.png",
        "/ResourcesEnemy/eDown9.png"
    };
    String []up={
        "/ResourcesEnemy/eUp7.png",
        "/ResourcesEnemy/eUp8.png",
        "/ResourcesEnemy/eUp7.png",
        "/ResourcesEnemy/eUp9.png"
    };
    String []left={
        "/ResourcesEnemy/eLeft7.png",
        "/ResourcesEnemy/eLeft8.png",
        "/ResourcesEnemy/eLeft7.png",
        "/ResourcesEnemy/eLeft9.png"
    };
    String []right={
        "/ResourcesEnemy/eRight7.png",
        "/ResourcesEnemy/eRight8.png",
        "/ResourcesEnemy/eRight7.png",
        "/ResourcesEnemy/eRight9.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Ranger(int line, int column, Board board) {
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
