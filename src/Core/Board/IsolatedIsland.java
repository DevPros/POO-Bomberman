/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Board;

import Core.PlayerSkins.Boss;
import Core.PlayerSkins.Minion;
import Core.PlayerSkins.Punchy;
import Core.PlayerSkins.Ranger;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;

/**
 *
 * @author Diogo
 */
public class IsolatedIsland extends Board{
    
    //atributo constituido por um array de Strings que forma um esquema do Mapa do Cenário da Ilha Isolada (IsolatedIsland)
    static String [] board={
        "kkkkkkkkkkkkkkkkkkkkkk",
        "k11111111111111111111k",
        "k11   1            11k",
        "k1    1111eevvvvv   1k",
        "k1   eeee11eeeeeev  1k",
        "k1  eeeeee1111eeeev 1k",
        "k1  eeevvvvvv1  eev 1k",
        "k1  eeeve11111  eev 1k",
        "k1  eeeve1vvve  eev 1k",
        "k1  eeeve1  ve  eev 1k",
        "k1  eeeve   ve  eev 1k",
        "k1  eeeve  pve  eev 1k",
        "k1  eeevevvvve  eev 1k",
        "k1  eeev        eev 1k",
        "k1  eeevvvvvvvvvvvv 1k",
        "k1  eeeeeeeeeeeeeee 1k",
        "k1  eeeeeeeeeeeeeee 1k",
        "k1   eeeeeeeeeeeeee 1k",
        "k1    eeeeeeeeeeee  1k",
        "k11    eeeeeeeeee  11k",
        "k11111111111111111111k",
        "kkkkkkkkkkkkkkkkkkkkkk"
    };
    //definição das posições inicias do Jogador(Player) neste Cenário
    final int inicLine=3, inicColumn=2;
    //definção da imagem de fundo neste Cenário, no caso será Areia
    final String strBackground="/Resources/grass.png";
    //***************************************************************************************
    
    //construtor que declara o tamanho do Tabuleiro conforme o tamanho do array previamente declarado 
    public IsolatedIsland() {
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
        return new Punchy(2, 3, this, "stay"); 
    }
    //Métodos para criar os Inimigos(PlayerMoveable) no cenário
    @Override
    public PlayerMoveable getPlayerMoveable1() {
        return new Minion(20, 3, this);
    }
    @Override
    public PlayerMoveable getPlayerMoveable2() {
        return new Minion(4, 20, this);
    }
    @Override
    public PlayerMoveable getBoss() {
        return new Boss(10, 10, this);
    }
    @Override
    public PlayerMoveable getGeneral() {
        return new Ranger(14, 11, this);
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