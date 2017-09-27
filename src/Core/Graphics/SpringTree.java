/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Graphics;

import Core.Fixed.Brick;

/**
 *
 * @author utilizador
 */
public class SpringTree extends Brick{
    
    //construtor que recebe as coordenas do objeto no tabuleiro  e a referência da imagem atribuida ao referido objeto
    public SpringTree(int line, int column) {
        super(line, column, "/Resources/springTree.png");
    }
}
