/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Graphics;

import Core.Fixed.Brick;

/**
 *
 * @author Diogo
 */
public class FlowerTree extends Brick{

    //construtor que recebe as coordenas do objeto no tabuleiro  e a referência da imagem atribuida ao referido objeto
    public FlowerTree(int line, int column) {
        super(line, column, "/Resources/flowerTree.png");
    }
}
