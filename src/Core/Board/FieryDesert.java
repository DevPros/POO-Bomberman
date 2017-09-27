/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Board;

import Core.PlayerSkins.Boss;
import Core.PlayerSkins.Hero;
import Core.PlayerSkins.Minion;
import Core.PlayerSkins.Ranger;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;

/**
 *
 * @author utilizador
 */
public class FieryDesert extends Board{
    
    //atributo constituido por um array de Strings que forma um esquema do Mapa do Nível1(Level1)
    static String [] board={
        "kkkkkkkkkkkkkkkkkkkkkk",
        "k            1       k",
        "k x eeeeee   1     + k",
        "k+  e1111e  n1  x    k",
        "k    8  111111       k",
        "k  331e           +  k",
        "k 3ee1eee    +       k",
        "k3eee1111e       x   k",
        "keeee11111e          k",
        "kee11111111e     +   k",
        "ke111111111e         k",
        "kee11111111ee  x     k",
        "keee11111111e        k",
        "keeee11111e1e        k",
        "k eeeee11ee1e    x   k",
        "k   eeeeeee11e      vk",
        "k     eeeeee1e     vvk",
        "k  x        8    1111k",
        "k          e1e   1 vvk",
        "k  +   x   e1e e 8  vk",
        "k         ee111111   k",
        "kkkkkkkkkkkkkkkkkkkkkk"
    };
    //definição das posições inicias do Jogador(Player) neste Cenário
    final int inicLine=20, inicColumn=20;
    //definção da imagem de fundo neste Cenário, no caso será Areia
    final String strBackground="/Resources/sand.png";
    //***************************************************************************************
    
    //construtor que declara o tamanho do Tabuleiro conforme o tamanho do array previamente declarado 
    public FieryDesert() {
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
        return new Hero(20, 20, this, "stay"); 
    }
    //Métodos para criar os Inimigos(PlayerMoveable) no cenário
    @Override
    public PlayerMoveable getPlayerMoveable1() {
        return new Minion(18, 5, this);
    }
    @Override
    public PlayerMoveable getPlayerMoveable2() {
        return new Minion(19, 12, this);
    }
    @Override
    public PlayerMoveable getBoss() {
        return new Boss(12, 2, this);
    }
    @Override
    public PlayerMoveable getGeneral() {
        return new Ranger(12, 2, this);
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
