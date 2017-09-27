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
public class Fairy extends Player{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []stay={
        "/ResourcesPlayer/stay17.png",
        "/ResourcesPlayer/stay18.png",
        "/ResourcesPlayer/stay19.png",
        "/ResourcesPlayer/stay20.png",
        "/ResourcesPlayer/stay21.png",
        "/ResourcesPlayer/stay22.png",
        "/ResourcesPlayer/stay23.png",
        "/ResourcesPlayer/stay22.png",
        "/ResourcesPlayer/stay23.png",
        "/ResourcesPlayer/stay24.png"
    };
    String []down={
        "/ResourcesPlayer/down9.png",
        "/ResourcesPlayer/down10.png",
        "/ResourcesPlayer/down11.png",
        "/ResourcesPlayer/down12.png"
    };
    String []up={
        "/ResourcesPlayer/up9.png",
        "/ResourcesPlayer/up10.png",
        "/ResourcesPlayer/up11.png",
        "/ResourcesPlayer/up12.png"
    };
    String []left={
        "/ResourcesPlayer/left9.png",
        "/ResourcesPlayer/left10.png",
        "/ResourcesPlayer/left11.png",
        "/ResourcesPlayer/left12.png"
    };
    String []right={
        "/ResourcesPlayer/right9.png",
        "/ResourcesPlayer/right10.png",
        "/ResourcesPlayer/right11.png",
        "/ResourcesPlayer/right12.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Fairy(int line, int column, Board board, String direction) {
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
