 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.Auto.Explosion;
import Core.Board.Board;
import Core.Board.EnchantedRealm;
import Core.Board.FieryDesert;
import Core.Board.FrozenKingdom;
import Core.Board.IsolatedIsland;
import Core.Fixed.Castle;
import java.awt.Graphics;
import javax.swing.JPanel;
import Core.Shifting.Player;
import Core.Shifting.PlayerMoveable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
;

/**
 *
 * @author Diogo
 */

//Esta classe é o Jogo propriamente dito que evoca os objetos e os respetivos métodos que farão correr o jogo
public class Game extends JPanel 
    implements Runnable, Serializable{
    
    //número de frames que o Jogo(Game) vai actualizar por segundo
    final int FPS=24;
    //thread necessária á atualização contínua da frame
    Thread threadThis;
    
    //Atributos do tipo Tabuleiro(Board), Jogador(Player) e Inimigos(PlayerMoveable) que constituiram a Base do jogo
    Board board;
    Player player;
    PlayerMoveable playerMoveable1, playerMoveable2, general, boss;

    //*********************************************************************************************************
    
    /* construtor que dará início ao jogo, construindo um mapa respetivo ao Cenário os jogadores presentes no tabuleiro(board) sejam eles 
    jogador(player) ou os NPC's' (general, boss, playerMoveable) */
    public Game(){
        board=new IsolatedIsland();
        player= board.getPlayer();
        playerMoveable1=board.getPlayerMoveable1();
        playerMoveable2=board.getPlayerMoveable2();
        general=board.getGeneral();
        start();
        playSound("/SoundResources/task.WAV");
        requestFocus();
    }
    //Construtor necessário para a escolha do cenário desejado
    public Game(Board board){
        this.board=board;
        player= board.getPlayer();
        playerMoveable1=board.getPlayerMoveable1();
        playerMoveable2=board.getPlayerMoveable2();
        general=board.getGeneral();
        start();
        playSound("/SoundResources/task.WAV");
        requestFocus();
    }
    
    //*********************************************************************************************************
    
    //declaração do método paintComponent herdado da classe JPanel para desenhar os objetos do tabuleio, previmente inseridos, e os diferentes tipos de Player
    @Override
    protected void paintComponent(Graphics g) {
        board.draw(g, this.getWidth());
        player.draw(g);
        playerMoveable1.draw(g);
        playerMoveable2.draw(g);
        general.draw(g);
        if(boss!=null)boss.draw(g);
    }
    //*********************************************************************************************************
    
    /* Evento que recebe o código da tecla pressionada (keyCode) e evoca os métodos correspondentes á sua tecla, 
    os métodos são o movimento em si, a definição da direção para a sucessão de png's que dão o efeito de movimento ao jogador, 
    e a verifição de ocorrencia de bonus na posição do jogador */   
    void processKey(int keyCode){
        switch(keyCode){
            case KeyEvent.VK_UP:
                player.setDirection("up");
                player.up();
                player.getBonusBomb();
                player.getBonusLife();
                break;
            case KeyEvent.VK_DOWN:
                player.setDirection("down");
                player.down();
                player.getBonusBomb();
                player.getBonusLife();
                break;
            case KeyEvent.VK_RIGHT:
                player.setDirection("right");
                player.right();
                player.getBonusBomb();
                player.getBonusLife();
                break;
            case KeyEvent.VK_LEFT:
                player.setDirection("left");
                player.left();
                player.getBonusBomb();
                player.getBonusLife();
                break;
            /* o evento associado ao Espaço(SPACE) é a verificação do número delas que o jogador que ainda possui e 
            a tribuição de bombas na posição em que se encontra o jogador*/
            case KeyEvent.VK_SPACE:
                if(player.getBombs()>0){
                    player.explodesBomb(player);
                    player.setBombs(-1);
                }else{
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Você não tem mais Bombas", "BOMBAS", JOptionPane.INFORMATION_MESSAGE); }
                break;
        }
    }
    //************************************************************************************************************
    
    //Evento que é evocado sempre que uma tecla é largada, permitindo ao Jogador voltar á animação base
    void processKeyRealized(int keyCode) {
        player.setDirection("stay");
    }
    //************************************************************************************************************
        
    //Inicialização da Thread que fará as actualizações e verificaçãos necessárias ao corrimento do jogo, este processo só termina quando a thread for igualada a 'null'
    
    public void start(){
        threadThis = new Thread(this);
        threadThis.start();
    }
    
    public void stop(){
        threadThis = null;
    }

    @Override
    public void run(){
         while( threadThis != null){
            //actualiza o tabuleiro
            repaint();
                
            /*Verifica se na posição do jogador(player) existe uma explosão, OU se a posição do inimigo é igual á posição do jogador 
            se uma das condições ocorrer envia uma mensagem a relatar o sucedido e o player volta á posição inicial*/
            if((board.getMatrix(player.getLine(), player.getColumn()) instanceof Explosion)||
               (board.getMatrix(player.getLine(), player.getColumn())== board.getMatrix(playerMoveable1.getLine(), playerMoveable1.getColumn()))||
               (board.getMatrix(player.getLine(), player.getColumn())== board.getMatrix(playerMoveable2.getLine(), playerMoveable2.getColumn()))||
               (board.getMatrix(player.getLine(), player.getColumn())== board.getMatrix(general.getLine(), general.getColumn()))){
                player.setScore(-5);
                player.setLives(-1);
                if(player.getLives()<1){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Você não tem mais vidas", "FIM DO JOGO", JOptionPane.INFORMATION_MESSAGE);
                    stop();
                }else{
                    player.setPosicion(board.inicLine(), board.inicColumn());
                }
            }
            
            //Quando o Jogador estiver ao pé do Castelo aparecerá um Boss para ele Derrotar
            if(board.getMatrix(player.getLine()+1, player.getColumn()) instanceof Castle) animationBoss();
            
            /*  Caso já tenha sido criado o Boss, verifica se a posição do Boss é igual é do Jogador, se for o jogador perde uma vida e volta á posição inicial,
            caso já não tenha mais vidas, termina o jogo e é enviada uma mensagem a relatar o sucedido, verifica também se o Boss é atinjido por uma explosão,
            se for o jogo termina e o Jogador Vence*/
            if(boss!=null){
                if(board.getMatrix(player.getLine(), player.getColumn())== board.getMatrix(boss.getLine(), boss.getColumn())){
                    player.setScore(-5);
                    player.setLives(-1);
                    if(player.getLives()<1){
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Você não te mais vidas", "FIM DO JOGO", JOptionPane.INFORMATION_MESSAGE);
                        stop();
                    }else{
                        player.setPosicion(board.inicLine(), board.inicColumn());
                    }
                }
                if(board.getMatrix(boss.getLine(), boss.getColumn()) instanceof Explosion){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Você Ganhou", "FIM DO JOGO", JOptionPane.INFORMATION_MESSAGE);
                    stop();
                }
            }
            
            //Verifica se na posição do inimigo(playerMoveable) existe uma explosão se sim ele aparecerá numa nova posição (Empty) aleatória 
            if(board.getMatrix(playerMoveable1.getLine(), playerMoveable1.getColumn()) instanceof Explosion){
                playerMoveable1.setPosicion();
                player.setBombs(1);
            }
            if(board.getMatrix(playerMoveable2.getLine(), playerMoveable2.getColumn()) instanceof Explosion){
                player.setBombs(1);
                playerMoveable2.setPosicion();
            }
            if(board.getMatrix(general.getLine(), general.getColumn()) instanceof Explosion){
                player.setBombs(1);
                general.setPosicion();
            }
            
            
//            //verifica se já foram destruidos os blocos, se sim então termina o jogo
//            int victory=board.verifyVictory();
//            if(victory==0){
//                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Você Ganhou", "FIM DO JOGO", JOptionPane.INFORMATION_MESSAGE);
//                stop();
//            }
            
            
            try {
                //Actualiza o JPanel em cada 200 milisegundos
                Thread.sleep(1000/FPS);
            }catch (InterruptedException ex) {
                System.out.println("InterruptedException: Thread.sleep(1000/FPS) - Class.Game");
            }
        }
    }
    
    //Cria no tabuleiro um Inimigo do tipo Boss, e inicia um conjunto de sons/diálogo
    public void animationBoss(){
        boss=board.getBoss();
        playSound("/SoundResources/shallnotpass.WAV");
        playSound("/SoundResources/work.WAV");
    }
    
    //Método para devolver um Objeto lido num determinado ficheiro
    public Object readObject(String fileName){
        try {
            File f = new File(fileName);
            FileInputStream fs = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fs);
            Object obj = in.readObject();
            in.close();
            return obj;
        } catch (Exception ex) {
            System.out.println("Exception: readObject - Class.Game");
            return null;
        } 
    }
    
    //Método para escrever/guardar um determinado Objeto num determinado Ficheiro 
    public void  writeObject(Object obj, String fileName){
        try {
            File f = new File(fileName);
             if( !f.exists() ){
                f.createNewFile();
            }
            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(fs);
            out.writeObject(obj);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("Exception: writeObject - Class.Game");
        }
    }
    
    //método para reproduzir um som num determinado ficheiro
    public void playSound(String fileName){
        File sound = new File(fileName);
        try{
            Clip clip= AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        }catch (Exception ex){
            System.out.println("Exception: playSound - Class.Game");
        }
    }
}