/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Auto;

import Core.Board.Board;

/**
 *
 * @author Diogo
 */
public class BonusBomb extends Bonus{
    
    // construtor da class Bonus que recebe da class Bonus os atributos por definir da posição deste objeto no tabuleiro e a String da referência da imagem 
    public BonusBomb(int line, int column, Board board) {
        super(line, column, "/Resources/bombBonus.png", board);
    }
}
