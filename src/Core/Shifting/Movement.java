/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Shifting;

import Core.Board.Board;
import Core.Auto.Bomb;
import Core.Fixed.Box;
import java.io.Serializable;

/**
 *
 * @author Diogo
 */

/* A classe Movimento (Movement) será uma superClasse para o objeto Jogador (Player) e dos NPC's (PlayerMoveable)
daí herdam os atributos e métodos da classe Caixa (Box) */
public abstract class Movement extends Box implements Serializable{
    
    //atributo do tipo tabuleiro(board) que será necessário para moveimentar os avatares
    Board board;
    //atributo thread necessária para a animação dos avatares
    Thread thread;
    //atributo que define o numero de frames por segundo realizadas para a sucessão de imagens dos avatares
    int FPS=10;
    
    //Construtor que recebe as coordenadas na matriz a referencia da sua imagem e a respetiva matriz da classe Tabuleiro(Board)
    public Movement(int line, int column, String source, Board board) {
        super(line, column, source);
        this.board=board;
    }
    //*************************************************************************************************************************
    
    //Funções para os Movimentos do jogador, em que verifica se pode mover-se em determinada posição da matriz e executa a ação
    
    //Movimento para Cima
    public void up(){
        if(!board.getMatrix(line, column-1).isSolid()){
            column--;
        }
    }
    //Movimento para Baixo
    public void down(){
        if(!board.getMatrix(line, column+1).isSolid()){
            column++;
        }
    }
    //Movimento para a Esquerda
    public void left(){
        if(!board.getMatrix(line-1, column).isSolid()){
            line--;
        }
    }
    //Movimento paraa Direita
    public void right(){
        if(!board.getMatrix(line+1, column).isSolid()){
            line++;
        }
    }
    //Coloca uma Bomba na posição do Jogador
    public void explodesBomb(Player player){
        board.setMatrix(new Bomb(line, column, board, player));
    } 
    //****************************************************************************************************************************
    
    //Métodos herdados da classe Caixa (Box) que estarão já declarados para a classe Jogador(Player) e para os NPC's (PlayerMoveable)
    
    //O jogador Pode ser destruido
    @Override
    public boolean isDestructible() {
        return true;
    }
    //O Jogador pode ser transposto   
    @Override
    public boolean isSolid() {
        return false;
    }
    //**************************************************************************************************************************
    
    //Métodos abstratos que serão definidos pelos diversos avatares para realizarem a animação do movimento
    
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
    
    //**************************************************************************************************************************
    
    /* Método que será usado por todos os joadores para a animação em que recebe uma String referente á direção desejada 
    e a vai correr até ao fim com um tempo pausado já definido pelo atributo FPS entre cada elemento da String*/
    public void move(String [] action){
        for (int i = 0; i < action.length; i++) {
            this.setImageIcon(action[i]);
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException ex) {
                System.out.println("InterruptedExcepcion: Movement");
            }
        }
    }
}
