/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Auto;

import Core.Board.Board;
import Core.Fixed.Brick;
import Core.Shifting.Player;

/**
 *
 * @author Diogo
 */
public class Bomb extends AutoActionable{
    
    //Atributo do tipo Jogador(Player) para permitir a atribuição de pontuação(score) no momento da explosão
    Player player;
    
    /* Construtor que recebe as coordenadas na matriz, a fonte do ficheiro(source) associado á imagem, 
    o respetivo Tabuleiro(Board) em que será inserido e o Jogador(Player) que lançará a bomba */
    public Bomb(int line, int column, Board board, Player player) {
        super(line, column, "/Resources/bomb.png", board, 2000);
        this.player=player;
    }
    //************************************************************************************************************************************
    
    //Métodos herdados da classe Caixa (Box)
    
    //Os objetos da class AutoAcionável(AutoActionable) Não podem ser destruidos
    @Override
    public boolean isDestructible() {
        return false;
    }
    //Os objetos da class AutoAcionável(AutoActionable) Não podem ser transpostos
    @Override
    public boolean isSolid() {
        return true;
    }
     //**************************************************************************************************************************

    /*Método herdado da classe AutoAcionável (AutoActionable) que define a execução da classe depois do tempo de espera, 
    aqui vão ser verificadas as direções no mapa a partir da posição atual da bomba,  se for tijolo envia true no atributo booliano isBrick,
    para mais tarde efetuar as atribuições de bónus, se não vai verificar se é um espaço vazio (ou seja não destrútivel e não sólido), envia false no boolean isBrick,
    pois essa zona também é atinjida pela explosão embora as alterações futuras permanentes não sejam visíveis (não tem bónus e permanecerá um espaço vazio, Empty)*/
    @Override
    public void timeIsOver() {
        
        //Troca na posição em que foi largada a bomba(bomb) por uma Explosão(Explosion)
        board.setMatrix(new Explosion(line, column, board, false));
            
        // Verifica á esquerda
        if((board.getMatrix(line-1, column) instanceof Brick)){
            if((board.getMatrix(line-2, column) instanceof Brick)){
                player.setScore(10);
                board.setMatrix(new Explosion(line-1, column, board, true));
                board.setMatrix(new Explosion(line-2, column, board, true));
            } else{
                if(!board.getMatrix(line-2, column).isDestructible() && !board.getMatrix(line-2, column).isSolid()){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line-1, column, board, true));
                    board.setMatrix(new Explosion(line-2, column, board, false));
                }else{
                    board.setMatrix(new Explosion(line-1, column, board, true));
                }
            }
        }else{
            if((!board.getMatrix(line-1, column).isDestructible()&&!board.getMatrix(line-1, column).isSolid())){
                if((board.getMatrix(line-2, column) instanceof Brick)){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line-1, column, board, false));
                    board.setMatrix(new Explosion(line-2, column, board, true));
                } else{
                    if(!board.getMatrix(line-2, column).isDestructible() && !board.getMatrix(line-2, column).isSolid()){
                        board.setMatrix(new Explosion(line-1, column, board, false));
                        board.setMatrix(new Explosion(line-2, column, board, false));
                    }else{
                        board.setMatrix(new Explosion(line-1, column, board, false));
                    }
                }
            }
        }
        
        //Troca à Direita
        if((board.getMatrix(line+1, column) instanceof Brick)){
            if((board.getMatrix(line+2, column) instanceof Brick)){
                player.setScore(10);
                board.setMatrix(new Explosion(line+1, column, board, true));
                board.setMatrix(new Explosion(line+2, column, board, true));
            } else{
                if(!board.getMatrix(line+2, column).isDestructible() && !board.getMatrix(line+2, column).isSolid()){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line+1, column, board, true));
                    board.setMatrix(new Explosion(line+2, column, board, false));
                }else{
                    board.setMatrix(new Explosion(line+1, column, board, true));
                }
            }
        }else{
            if((!board.getMatrix(line+1, column).isDestructible()&&!board.getMatrix(line+1, column).isSolid())){
                if((board.getMatrix(line+2, column) instanceof Brick)){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line+1, column, board, false));
                    board.setMatrix(new Explosion(line+2, column, board, true));
                } else{
                    if(!board.getMatrix(line+2, column).isDestructible() && !board.getMatrix(line+2, column).isSolid()){
                        board.setMatrix(new Explosion(line+1, column, board, false));
                        board.setMatrix(new Explosion(line+2, column, board, false));
                    }else{
                        board.setMatrix(new Explosion(line+1, column, board, false));
                    }
                }
            }
        }
        
        // Troca em Cima
        if((board.getMatrix(line, column-1) instanceof Brick)){
            if((board.getMatrix(line, column-2) instanceof Brick)){
                player.setScore(10);
                board.setMatrix(new Explosion(line, column-1, board, true));
                board.setMatrix(new Explosion(line, column-2, board, true));
            } else{
                if(!board.getMatrix(line, column-2).isDestructible() && !board.getMatrix(line, column-2).isSolid()){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line, column-1, board, true));
                    board.setMatrix(new Explosion(line, column-2, board, false));
                }else{
                    board.setMatrix(new Explosion(line, column-1, board, true));
                }
            }
        }else{
            if((!board.getMatrix(line, column-1).isDestructible()&&!board.getMatrix(line, column-1).isSolid())){
                if((board.getMatrix(line, column-2) instanceof Brick)){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line, column-1, board, false));
                    board.setMatrix(new Explosion(line, column-2, board, true));
                } else{
                    if(!board.getMatrix(line, column-2).isDestructible() && !board.getMatrix(line, column-2).isSolid()){
                        board.setMatrix(new Explosion(line, column-1, board, false));
                        board.setMatrix(new Explosion(line, column-2, board, false));
                    }else{
                        board.setMatrix(new Explosion(line, column-1, board, false));
                    }
                }
            }
        }
        
        //Troca em Baixo
       if((board.getMatrix(line, column+1) instanceof Brick)){
            if((board.getMatrix(line, column+2) instanceof Brick)){
                player.setScore(10);
                board.setMatrix(new Explosion(line, column+1, board, true));
                board.setMatrix(new Explosion(line, column+2, board, true));
            } else{
                if(!board.getMatrix(line, column+2).isDestructible() && !board.getMatrix(line, column+2).isSolid()){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line, column+1, board, true));
                    board.setMatrix(new Explosion(line, column+2, board, false));
                }else{
                    board.setMatrix(new Explosion(line, column+1, board, true));
                }
            }
        }else{
            if((!board.getMatrix(line, column+1).isDestructible()&&!board.getMatrix(line, column+1).isSolid())){
                if((board.getMatrix(line, column+2) instanceof Brick)){
                    player.setScore(5);
                    board.setMatrix(new Explosion(line, column+1, board, false));
                    board.setMatrix(new Explosion(line, column+2, board, true));
                } else{
                    if(!board.getMatrix(line, column+2).isDestructible() && !board.getMatrix(line, column+2).isSolid()){
                        board.setMatrix(new Explosion(line, column+1, board, false));
                        board.setMatrix(new Explosion(line, column+2, board, false));
                    }else{
                        board.setMatrix(new Explosion(line, column+1, board, false));
                    }
                }
            }
        }
    }
}
