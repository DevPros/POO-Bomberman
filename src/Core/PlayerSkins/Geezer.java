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
public class Geezer extends Player{

    //Conjuntos de Arrays de String's em que cada array simboliza uma direção e as suas Strings as referências fonte das imagens atribuidas ao efeito
    
    String []stay={
        "/ResourcesPlayer/stay25.png",
        "/ResourcesPlayer/stay26.png",
        "/ResourcesPlayer/stay27.png",
        "/ResourcesPlayer/stay28.png",
        "/ResourcesPlayer/stay29.png",
        "/ResourcesPlayer/stay30.png",
        "/ResourcesPlayer/stay29.png",
        "/ResourcesPlayer/stay30.png"
    };
    String []down={
        "/ResourcesPlayer/down13.png",
        "/ResourcesPlayer/down14.png",
        "/ResourcesPlayer/down15.png",
        "/ResourcesPlayer/down16.png"
    };
    String []up={
        "/ResourcesPlayer/up13.png",
        "/ResourcesPlayer/up14.png",
        "/ResourcesPlayer/up15.png",
        "/ResourcesPlayer/up16.png"
    };
    String []left={
        "/ResourcesPlayer/left13.png",
        "/ResourcesPlayer/left14.png",
        "/ResourcesPlayer/left15.png",
        "/ResourcesPlayer/left16.png"
    };
    String []right={
        "/ResourcesPlayer/right13.png",
        "/ResourcesPlayer/right14.png",
        "/ResourcesPlayer/right15.png",
        "/ResourcesPlayer/right16.png"
    };
    //*******************************************************************************************************************************
    
    //Construtor do Objeto que recebe as coordenadas da localização no tabuleiro e o tabuleiro em si
    public Geezer(int line, int column, Board board, String direction) {
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
