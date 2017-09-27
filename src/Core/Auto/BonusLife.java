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
public class BonusLife extends Bonus{

    // construtor da class Bonus que recebe da class AutoActionable os atributos por definir da posição deste objeto no tabuleiro, a String da referência da imagem 
    public BonusLife(int line, int column, Board board) {
        super(line, column, "/Resources/lifeBonus.png" , board);
    }
}
