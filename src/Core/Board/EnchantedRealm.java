/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Board;

import Core.PlayerSkins.Boss;
import Core.PlayerSkins.Fairy;
import Core.PlayerSkins.Minion;
import Core.PlayerSkins.Ranger;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;

/**
 *
 * @author utilizador
 */
public class EnchantedRealm extends Board{
    
    //atributo constituido por um array de Strings que forma um esquema do Mapa do Nível1(Level1)
    static String [] board={
        "kkkkkkkkkkkkkkkkkkkkkk",
        "k  6 u464u64 6u 4 5 4k",
        "k4 4 -* 5 46    5 6 uk",
        "k6  4 6 65 4  6 4  4 k",
        "kcu5 5 c4    646 5  6k",
        "k333333333333333333  k",
        "k1111111115c*c-5 c*- k",
        "k-*c-c5 -1   c-55s vvk",
        "k5-cc*5*-111111 * 3v1k",
        "k*-s5-3s -*-sc1    v1k",
        "k5c-*   vvv c 8    v1k",
        "k355cv 5-**v  1111111k",
        "k 3 5c5-*-*-sv   s v1k",
        "k  3vs  s  s5cc 3  v1k",
        "k5c*-5vcc5--*3 -**-v1k",
        "kcc5*-*s v v55c vvvv1k",
        "k  s55*- v s-- v11111k",
        "k*-v  s---*c55v11vvvvk",
        "kc*-v55vs 3 vv11vb   k",
        "k-s-*33  v s c8      k",
        "k5cc*-55*c-5*v1vb   lk",
        "kkkkkkkkkkkkkkkkkkkkkk"
    };
    //definição das posições inicias do Jogador(Player) neste Cenário
    final int inicLine=1, inicColumn=1;
    //definção da imagem de fundo neste Cenário, no caso será Areia
    final String strBackground="/Resources/grassLight.png";
    //***************************************************************************************
    
    //construtor que declara o tamanho do Tabuleiro conforme o tamanho do array previamente declarado 
    public EnchantedRealm() {
        super(board.length);
    }
    
    //****************************************************************************************

    //Método que evoca o método de carregar o mapa através do atributo desta Classe
    @Override
    public void createLevelMap() {                 
        loadFromString(board);
    }
    //Método para criar e retornar O Jogador(Player) deste cenario que sera o 
    @Override
    public Player getPlayer(){
        return new Fairy(1, 1, this, "stay"); 
    }
    //Métodos para criar os Inimigos(PlayerMoveable) no cenário
    @Override
    public PlayerMoveable getPlayerMoveable1() {
        return new Minion(15, 3, this);
    }
    @Override
    public PlayerMoveable getPlayerMoveable2() {
        return new Minion(18, 10, this);
    }
    @Override
    public PlayerMoveable getBoss() {
        return new Boss(20, 20, this);
    }
    @Override
    public PlayerMoveable getGeneral() {
        return new Ranger(20, 20, this);
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
