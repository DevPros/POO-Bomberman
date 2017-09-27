/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Graphics;

import Core.Fixed.Empty;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author utilizador
 */
public class Bridge extends Empty{

    //construtor que recebe as coordenas do objeto no tabuleiro  e a referência da imagem atribuida ao referido objeto
    public Bridge(int line, int column) {
        super(line, column, "/Resources/bridge.png");
    }
    @Override
    public void draw(Graphics g){
        imageIcon = new ImageIcon(this.getClass().getResource("/Resources/water.png"));
        g.drawImage(imageIcon.getImage(), line * width, column * width, width, width, imageIcon.getImageObserver());
        imageIcon = new ImageIcon(this.getClass().getResource("/Resources/bridge.png"));
        g.drawImage(imageIcon.getImage(), line * width, column * width, width, width, imageIcon.getImageObserver());
    }
    
}
