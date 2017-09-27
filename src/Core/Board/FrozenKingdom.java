/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Board;

import Core.PlayerSkins.Boss;
import Core.PlayerSkins.Geezer;
import Core.PlayerSkins.Minion;
import Core.PlayerSkins.Ranger;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;
import GUI.Game;

/**
 *
 * @author utilizador
 */
public class FrozenKingdom extends Board{
    
    //atributo constituido por um array de Strings que forma um esquema do Mapa do Cenário da Ilha Isolada (IsolatedIsland)
    static String [] board={
        "kkkkkkkkkkkkkkkkkkkkkk",
        "k   11111111111111111k",
        "k   1111111111111   1k",
        "k da1111111111111   1k",
        "k   8              m1k",
        "kd a11111111111111111k",
        "k   8          da  d k",
        "k1111wwwwwwwwwwww d  k",
        "kdd 8   d dad    da  k",
        "kddd11111111111111111k",
        "kddd1 a da da 1 d  d k",
        "kdd 8   dadd d1d  2 dk",
        "k1111ad d ad d1d 22  k",
        "k1111 a ddda  8 222d k",
        "k1111   d  d  12222 dk",
        "k11111111111111 222d k",
        "kd dd dd w ddd1d 22d k",
        "k  dwda w d wd1 ad2 dk",
        "k d dw d w dw 8 d dd k",
        "k   wdadadwd w1111111k",
        "k  wdd d a ad 111  11k",
        "kkkkkkkkkkkkkkkkkkkkkk"
    };
    //definição das posições inicias do Jogador(Player) neste Cenário
    final int inicLine=2, inicColumn=20;
    //definção da imagem de fundo neste Cenário, no caso será Areia
    final String strBackground="/Resources/snow.png";
    //***************************************************************************************
    
    //construtor que declara o tamanho do Tabuleiro conforme o tamanho do array previamente declarado 
    public FrozenKingdom() {
        super(board.length);
    }


    //****************************************************************************************

    //Métodos herdados da classe Tabuleiro(Board)
    
    //Método que evoca o método de carregar o mapa através do atributo desta Classe
    @Override
    public void createLevelMap() {                 
        loadFromString(board);
    }
    //Método para criar e retornar O Jogador(Player) deste cenario que sera o 
    @Override
    public Player getPlayer(){
        return new Geezer(1, 20, this, "stay"); 
    }
    //Métodos para criar os Inimigos(PlayerMoveable) no cenário
    @Override
    public PlayerMoveable getPlayerMoveable1() {
        return new Minion(6, 11, this);
    }
    @Override
    public PlayerMoveable getPlayerMoveable2() {
        return new Minion(6, 6, this);
    }
    @Override
    public PlayerMoveable getBoss() {
        return new Boss(18, 3, this);
    }
    @Override
    public PlayerMoveable getGeneral() {
        return new Ranger(18, 3, this);
    }
    //Métodos que devolve as posições iniciais do jogador neste cenário
    @Override
    public int inicLine(){
        return inicLine;
    }
    @Override
    public int inicColumn(){
        return inicColumn;
    }
    //Método que devolve a string de direção do ficheiro da imagem
    @Override
    public String strBackground() {
        return strBackground;
    }
}
