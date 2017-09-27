/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Fixed;


public class Empty extends Box{

    //Construtor que recebe as coordenadas na matriz e a referência da imagem a este objeto
    public Empty(int line, int column, String source) {
        super(line, column, source);
    }
    //********************************************************************************************************
    
    //Métodos herdados da classe Caixa(Box)
    
    //O espaço vazio (Empty) Não pode ser destruido
    @Override
    public boolean isDestructible() {
        return false;
    }
    //O espaço vazio (Empty) Pode ser transposto
    @Override
    public boolean isSolid() {
        return false;
    }
    //********************************************************************************************************
}
