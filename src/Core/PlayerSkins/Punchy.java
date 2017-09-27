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
public class Punchy extends Player{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []stay={
        "/ResourcesPlayer/stay39.png",
        "/ResourcesPlayer/stay40.png",
        "/ResourcesPlayer/stay41.png",
        "/ResourcesPlayer/stay42.png",
        "/ResourcesPlayer/stay43.png",
        "/ResourcesPlayer/stay44.png",
        "/ResourcesPlayer/stay43.png",
        "/ResourcesPlayer/stay42.png"
    };
    String []down={
        "/ResourcesPlayer/down21.png",
        "/ResourcesPlayer/down22.png",
        "/ResourcesPlayer/down23.png",
        "/ResourcesPlayer/down24.png"
    };
    String []up={
        "/ResourcesPlayer/up21.png",
        "/ResourcesPlayer/up22.png",
        "/ResourcesPlayer/up23.png",
        "/ResourcesPlayer/up24.png"
    };
    String []left={
        "/ResourcesPlayer/left21.png",
        "/ResourcesPlayer/left22.png",
        "/ResourcesPlayer/left23.png",
        "/ResourcesPlayer/left24.png"
    };
    String []right={
        "/ResourcesPlayer/right21.png",
        "/ResourcesPlayer/right22.png",
        "/ResourcesPlayer/right23.png",
        "/ResourcesPlayer/right24.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Punchy(int line, int column, Board board, String direction) {
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
