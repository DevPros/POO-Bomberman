/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Fixed;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Diogo
 */
public abstract class Box implements Serializable{

    //Atributos presentes em todos os Objetos contidos no tabuleiro
    protected int line, column; // posição da caixa na matriz, sendo line a coordenada X e column a coordenada Y
    protected static int width; // tamanho da caixa sendo quadrada
    protected ImageIcon imageIcon; // icon do objeto
    //****************************************************************************************************

    /* Construtor para as caixas, que recebe valores para os atributos da posição linha(line) e column(column) que terá no tabuleiro 
    e a refrencia da imagem atribuida ao objeto em questão */
    public Box(int line, int column, String source) {
        this.line = line;
        this.column = column;
        this.imageIcon = new ImageIcon(this.getClass().getResource(source));
    }
    //*****************************************************************************************************

    //Set's e Get's que serão uteís ao longo do programa para obter as posições dos Objetos ou atribuir o tamanho e as imagens dos mesmos

    public static int getWidth() {
        return width;
    }
    
    public static void setWidth(int width) {
        Box.width = width;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public void setImageIcon(String source) {
        this.imageIcon = new ImageIcon(this.getClass().getResource(source));
    }

    public void setPosicion(int line, int column) {
        this.line = line;
        this.column = column;
    }
    //******************************************************************************************************

    //Métodos abstratos que serão declarados em todas as classes extendidas da classe Caixa(Box)
    
    //método que verifica se o objeto pode ser destruido
    public abstract boolean isDestructible();

    //método que verifica se o objeto NÂO pode ser transposto
    public abstract boolean isSolid();
    //******************************************************************************************************

    // Método para desenhar a imagem do objeto referente á fonte (source)
    public void draw(Graphics g) {
        g.drawImage(imageIcon.getImage(), line * width, column * width, width, width, imageIcon.getImageObserver());
    }
    //********************************************************************************************************
}
