/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Auto;

import Core.Board.Board;
import Core.Fixed.Empty;

/**
 *
 * @author Diogo
 */

public class Bonus extends AutoActionable{

    /* construtor da class Bonus que recebe da class AutoActionable os atributos por definir da posição deste objeto no tabuleiro, 
    a String da referência da imagem e o tempo de espera até acionar o método timeIsOver() */
    public Bonus(int line, int column, String source, Board board) {
        super(line, column, source, board, 7000);
    }
    //********************************************************************************************************************
    /* Método abstrato da class AutoActionable que vai trocar os espaços da explosãos por espaços vazios,
    caso o bónus não seja apanhado a temp pelo Jogador(Player) */
    @Override
    public void timeIsOver() {
        board.setMatrix(new Empty(line, column, board.strBackground()));
    }
    //********************************************************************************************************************
    @Override
    public boolean isDestructible() {
        return false;
    }
    @Override
    public boolean isSolid() {
        return false;
    }
    
}
