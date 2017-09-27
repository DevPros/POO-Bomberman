/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Board;

import Core.Fixed.Box;
import Core.Fixed.Empty;
import Core.Graphics.BerryTree;
import Core.Graphics.SpringTree;
import Core.Graphics.Bridge;
import Core.Graphics.Cactus;
import Core.Graphics.Crystal;
import Core.Graphics.FlowerTree;
import Core.Graphics.Fortress;
import Core.Graphics.FrozenTree;
import Core.Graphics.House;
import Core.Graphics.IceCastle;
import Core.Graphics.IceRock;
import Core.Graphics.MossRock;
import Core.Graphics.PalmTree;
import Core.Graphics.Pyramid;
import Core.Graphics.SandCastle;
import Core.Graphics.Wall;
import Core.Graphics.Water;
import Core.Graphics.FairyHouse;
import Core.Graphics.FairyHouse1;
import Core.Graphics.GoldenTree;
import Core.Graphics.Igloo;
import Core.Graphics.Rock;
import Core.Graphics.SnowPine;
import Core.Graphics.TreeHouse;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Diogo
 */
public abstract class Board implements Serializable{
    //este atributo é uma matriz(matrix) bidimensional que será composta de objetos do tipo Caixa(Box)
    Box[][] matrix;
    // imagem de fundo dominante em cada Cenário
    ImageIcon imgEmpty;
    
    //Construtor que recebe a dimensão da matriz(matrix) e cria o mapa dessa matriz
    public Board (int dim){
        //construtor da matriz de objetos do tipo Caixo(Box)
        matrix= new Box[dim][dim];
        //método que cria lê o Array de  String's que definem o mapa
        createLevelMap();
    }
    //*************************************************************************************
    //Métodos abstratos que todas classes Cenário serão forçadas a criar
    
    //Método para devolver a iagem de fundo de cada objeto, para evitar espaços em branco no decorrer do jogo
    public abstract String strBackground();
    //Métodos para devolver as posições iniciais do Jogador onde ele retornará sempre que perder uma vida 
    public abstract int inicLine();
    public abstract int inicColumn();
    //método para criar um Jogador(Player) no Tabuleiro(Board)
    public abstract Player getPlayer();
    //métodos para criar inimigos (NPC's) no Tabuleiro(Board) 
    public abstract PlayerMoveable getGeneral();
    public abstract PlayerMoveable getBoss();
    public abstract PlayerMoveable getPlayerMoveable1();
    public abstract PlayerMoveable getPlayerMoveable2();
    //método para criar um mapa para o respetivo Nível(Level)
    public abstract void createLevelMap();
    //*************************************************************************************
    
    //Métodos para Criar um Tabuleiro
    
    /*método que vai ler o array de caracteres correspondentes ao Cenario que que evoca 
    este método a atibuir os objetos correspondentes na matriz do Tabulero(Board)*/
    public void loadFromString (String[] txt){
        matrix=new Box[txt.length][txt.length];
        
        for(int i=0; i<txt.length; i++){
            for(int j=0; j< txt.length; j++){
                switch(txt[i].charAt(j)){
                    case 'a': matrix[j][i]=new SnowPine(j,i); break;
                    case 'c': matrix[j][i]=new FlowerTree(j, i); break;
                    case 'd': matrix[j][i]=new FrozenTree(j, i); break;
                    case 'e': matrix[j][i]=new PalmTree(j, i); break;
                    case 'l': matrix[j][i]=new Fortress(j, i); break;
                    case 'm': matrix[j][i]=new IceCastle(j, i); break;
                    case 'n': matrix[j][i]=new SandCastle(j, i); break;
                    case 'p': matrix[j][i]=new TreeHouse(j, i); break;
                    case 's': matrix[j][i]=new Crystal(j, i); break;
                    case 'u': matrix[j][i]=new House(j, i); break;
                    case 'w': matrix[j][i]=new IceRock(j, i); break;
                    case 'v': matrix[j][i]=new MossRock(j, i); break;
                    case 'x': matrix[j][i]=new Pyramid(j, i); break;
                    case 'k': matrix[j][i]=new Wall(j, i); break;
                    case '1': matrix[j][i]=new Water(j, i); break;
                    case '2': matrix[j][i]=new Igloo(j, i); break;
                    case '3': matrix[j][i]=new Rock(j, i); break;
                    case '4': matrix[j][i]=new FairyHouse(j, i); break;
                    case '5': matrix[j][i]=new SpringTree(j, i); break;
                    case '6': matrix[j][i]=new FairyHouse1(j, i); break;
                    case '8': matrix[j][i]=new Bridge(j,i); break;
                    case '-': matrix[j][i]=new GoldenTree(j, i); break;
                    case '*': matrix[j][i]=new BerryTree(j, i); break;
                    case '+': matrix[j][i]=new Cactus(j, i); break;
                    case ' ': matrix[j][i]=new Empty(j, i, strBackground()); break;
                    default: matrix[j][i]=new Empty(j, i, strBackground()); break;
                }
            }
        }
    }
    // depois de atribuidos os objetos nas suas posições da matriz este método vai desenhar os objetos
    public void draw(Graphics g, int width){
        /* O tamanho de cada objecto Caixa(Box) vai ser redimensionado proporcionalemente ao tamanho do tamanho, 
        consoate o numero de caixas que tiver cada coluna */
        Box.setWidth(width/matrix.length);
        
        /* Vai correr todos os elementos da matriz(matrix) e desenhá-los no tabuleiro, 
        em cada elemento é desenhado um fundo consoante o espaço Vazio(Empty) dominante do respetivo cenário */ 
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                // definição da imagem de fundo do tabuleiro
                imgEmpty= new ImageIcon(this.getClass().getResource(strBackground()));
                //desenho da imagem de fundo antes do desenho do próprio objeto
                g.drawImage(imgEmpty.getImage(), i*(Box.getWidth()), j*(Box.getWidth()), (Box.getWidth()), (Box.getWidth()), imgEmpty.getImageObserver());
                matrix[i][j].draw(g);
            }
        }
    }
    //*************************************************************************************************
    
    /*Vai verificar todas as posições do array se já não existir nenhum tijolo(Brick) retorna 0 
    para terminar o jogo no método run() do Jogo(Game)*/
    
//    public int verifyVictory(){
//        int counter=0;
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j< matrix.length; j++){
//                if(matrix[i][j] instanceof Brick){
//                    counter+=1;
//                }
//            }
//        }
//        return counter;
//    }
    //***************************************************************************************************
    
    //método que retorna o tamanho do Tabuleiro(Board)
    public int getWidth(){
        return matrix.length;
    }
    //método que retorna o objeto do tipo Caixa(Box) na posição XY da matriz(matrix)
    public Box getMatrix(int line, int column){
        return matrix[line][column];
    } 
    //método que recebe um objeto do tipo Caixa(Box) e o coloca numa determinada posição da matriz(matrix)
    public void setMatrix(Box box) {
        matrix[box.getLine()][box.getColumn()] = box;
    }
    //**************************************************************************************************
}