/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Fixed;


public abstract class Block extends Box {

    //Construtor que recebe as coordenadas na matriz e a referencia da imagem do objeto
    public Block(int line, int column, String source) {
        super(line, column, source);
    }
    //*********************************************************************************************************
    
    //Métodos herdados da classe Caixa(Box)
    
    //O Bloco(Block) Não pode ser destruido
    @Override
    public boolean isDestructible() {
        return false;
    }
    //O Bloco(Block) NÃO pode ser transposto
    @Override
    public boolean isSolid() {
        return true;
    }
    // Estes métodos ficam já definidos para todas as classes que herdarem do Bloco(Block)
    //********************************************************************************************************
}
