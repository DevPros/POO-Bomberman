/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Fixed;

import static Core.Fixed.Box.width;
import java.awt.Graphics;

/**
 *
 * @author Diogo
 */
public abstract class Castle extends Box{

    /* Construtor que recebe as coordenadas na matriz e a referencia á imagem, esta classe é abstracta porque nunca será invocada 
    no entanto é base de alguns objetos que compuram o tabuleiro, de modo a dar um espeto visivlmente mais atraente ao Consumidor */
    public Castle(int line, int column, String source) {
        super(line, column, source);
    }
    //*****************************************************************************************************
    
    //Métodos herdados da classe Caixa(Box)
    
    //O Castelo(Castle) Pode ser destruido
    @Override
    public boolean isDestructible() {
        return false;
    }
    //O Castelo(Castle) NÃO pode ser transposto
    @Override
    public boolean isSolid() {
        return true;
    }
    // Estes métodos ficam já definidos para todas as classes que herdarem do Castelo(Castle)
    //********************************************************************************************************
    
    /* Reescrita do método draw que já foi declarado na Caixa(Box) para tornar este objeto de maior dimensão, embora na matriz do tabuleiro(board)
        ocupe apena uma posição como outro objeto do tipo Caixa(Box), no aspeto da frame este estará ampliado, dando a falsa ideia de ser maior no decorrer do jogo*/
    @Override
    public void draw(Graphics g){
        g.drawImage(imageIcon.getImage(), (line-2)*width, (column-2)*width, 3*width, 3*width, imageIcon.getImageObserver());
    }
}
