/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Fixed;


public abstract class Brick extends Box{

    /* Construtor que recebe as coordenadas na matriz e a referencia á imagem, esta classe é abstracta porque nunca será invocada 
    no entanto é base de alguns objetos que compuram o tabuleiro, de modo a dar um espeto visivlmente mais atraente ao Consumidor */
    public Brick(int line, int column, String source) {
        super(line, column, source);
    }
    //*****************************************************************************************************
    
    //Métodos herdados da classe Caixa(Box)
    
    //O Tijolo(Brick) Pode ser destruido
    @Override
    public boolean isDestructible() {
        return true;
    }
    //O Tijolo(Brick) NÃO pode ser transposto
    @Override
    public boolean isSolid() {
        return true;
    }
    // Estes métodos ficam já definidos para todas as classes que herdarem do Tijolo(Brick)
    //********************************************************************************************************
}

