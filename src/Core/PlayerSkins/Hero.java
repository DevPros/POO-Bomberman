/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.PlayerSkins;

import Core.Board.Board;
import Core.Shifting.Player;

/**
 *
 * @author utilizador
 */
public class Hero extends Player{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []stay={
        "/ResourcesPlayer/stay47.png",
        "/ResourcesPlayer/stay48.png",
        "/ResourcesPlayer/stay49.png",
        "/ResourcesPlayer/stay50.png",
        "/ResourcesPlayer/stay51.png",
        "/ResourcesPlayer/stay52.png",
        "/ResourcesPlayer/stay51.png",
        "/ResourcesPlayer/stay52.png"
    };
    String []down={
        "/ResourcesPlayer/down25.png",
        "/ResourcesPlayer/down26.png",
        "/ResourcesPlayer/down27.png",
        "/ResourcesPlayer/down28.png"
    };
    String []up={
        "/ResourcesPlayer/up25.png",
        "/ResourcesPlayer/up26.png",
        "/ResourcesPlayer/up27.png",
        "/ResourcesPlayer/up28.png"
    };
    String []left={
        "/ResourcesPlayer/left25.png",
        "/ResourcesPlayer/left26.png",
        "/ResourcesPlayer/left27.png",
        "/ResourcesPlayer/left28.png"
    };
    String []right={
        "/ResourcesPlayer/right25.png",
        "/ResourcesPlayer/right26.png",
        "/ResourcesPlayer/right27.png",
        "/ResourcesPlayer/right28.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Hero(int line, int column, Board board, String direction) {
        super(line, column, board, direction);
    }
    //*******************************************************************************************************************************
    
    //Métodos herdados da class Player para atribuir a sucessão de imagens correspondentes á direção do mesmo
    
    @Override
    public void stay(){
        move(stay);
    }
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
