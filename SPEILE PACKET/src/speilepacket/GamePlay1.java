/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speilepacket;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JPanel;
/**
 *
 * @author win
 */
public class GamePlay1 extends JPanel implements ActionListener, KeyListener{
    private boolean play = false;
    private int score = 0;
    private int TotalBricks=21;
    private Timer timer;
    private int delay = 4;
    private int playerx=310;
     private int playery=570;
    private int ballposx=240;
    private int ballposy=350;
    private int ballxdir=1;
    private int ballydir=2;
    private int moves=0;
    private MapGenerator map;
    private int serial=1;
    private int min=1;
    private int max=12;
    private int ballspeed=1;
    public int r=1;
    public GamePlay1(){
        Random random=new Random();
       
        int randomrows = min + random.nextInt(max);
                
               

        map = new MapGenerator(randomrows,20-randomrows,r);
        TotalBricks=0;
         for(int i=0;i<map.map.length;i++){
                for(int j=0;j<map.map[0].length;j++){
                    if(map.map[i][j]>0)
                    {
                        TotalBricks+=map.map[i][j] ;
                    }
                }
         }
        
        

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
     //   if(score%20==0)
       //     delay--;
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g){
        //background color
        if((score/5)%2==0){

        g.setColor(Color.CYAN);
        g.fillRect(1,1,692,592);
        }
        else if((score/5)%2==1){
        g.setColor(Color.PINK);
        g.fillRect(1,1,692,592);
        }
        
    

        //label
        g.setColor(Color.RED);
        g.fillRect(1,592,700,100);

        //map

        map.draw((Graphics2D)g);
        //border

        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 8, 592);
        g.fillRect(0, 0, 692, 8);
        g.fillRect(684, 0, 8, 592);

        //padddle
       
            g.setColor(Color.BLUE);
            g.fillRoundRect(playerx,playery, 150, 25,25,25);
        
        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString("score:"+score, 30 , 650);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString(" moves:" + moves , 550 , 650);



        //the ball
    
            g.setColor(Color.RED);
            g.fillOval(ballposx,ballposy,20,20);

       
        //the message
        g.setColor(Color.WHITE);

                  g.setFont(new Font("serif", Font.BOLD,35));
                    g.drawString("SPIELE PAKET", 250 , 630);
                    g.setColor(Color.WHITE);

                  g.setFont(new Font("serif", Font.BOLD,35));
                    g.drawString("By THAKUR", 250 , 665);

        if(ballposy>590)
              {
                  play=false;
                  ballxdir=ballydir=0;

                  g.setColor(Color.RED);
                  g.setFont(new Font("serif", Font.BOLD,25));
                      g.drawString("GAME OVER, score:"+score , 250 , 350);

                      g.setColor(Color.RED);
                  g.setFont(new Font("serif", Font.BOLD,25));
                  serial=1;
                  ballspeed=1;
                      g.drawString("PRESS ENTER to continue...", 250 , 540);
                      
              }
        if(TotalBricks==0)
             {
                  play=false;
                  ballxdir=ballydir=0;

                  g.setColor(Color.RED);
                  g.setFont(new Font("serif", Font.BOLD,25));
                      g.drawString("YOU WON    \nscore:"+score , 250 , 250);

                      g.setColor(Color.RED);
                  g.setFont(new Font("serif", Font.BOLD,25));
                  serial++;
                  
                      
                      g.drawString("PRESS C For next stage...", 250 , 400);
                       
              }
        g.dispose();
    }


        public void actionPerformed(ActionEvent e) {
            timer.start();
            if(play){

                if((ballposx - playerx <160 && ballposx - playerx >145)&& ballxdir==-1 &&  ballposy >= playery-20  )
              {     ballxdir=-ballxdir;
                    ballydir=-ballydir;
                    moves++;

              }
              

                else if(((ballposx - playerx >-20 && ballposx - playerx <5)) && ballxdir==1 &&  ballposy >= playery-20   )
                        {     ballxdir=-ballxdir;
                    ballydir=-ballydir;
                    moves++;

              }
                else  if (ballposx - playerx <160 &&  ballposy >= playery-20 && ballposx - playerx >-20)
              {
                    ballydir=-ballydir;
                    moves++;

              }



               
               


                
              
              A: for(int i=0;i<map.map.length;i++){
                for(int j=0;j<map.map[0].length;j++){
                    if(map.map[i][j]>0)
                    {
                        int brickx=j*map.brickWidth + 80;
                        int bricky=i*map.brickHeight + 50;

                        int brickWidth=map.brickWidth;
                        int brickHeight=map.brickHeight;

                        Rectangle rect=new Rectangle(brickx,bricky,brickWidth,brickHeight);
                        Rectangle ballrect = new Rectangle(ballposx,ballposy,20,20);
                        Rectangle brickrect=rect;

                        if(ballrect.intersects(brickrect)){
                            map.setBrickValue(1, i, j);
                            TotalBricks--;
                            score+=5;
                           if(score%40==0 && score<60)
                                ballspeed++;
                            if(ballrect.y-brickrect.y<brickHeight-10 )
                            {
                                    ballxdir=-ballxdir;
                                    break A;
                            }

                            if (ballrect.y < brickrect.y+brickHeight || ballrect.y+20>brickrect.y)
                            {
                                 ballydir=-ballydir;
                            }
                            break A;
                        }

                    }
                }
              }
              
              ballposx += ballspeed*ballxdir;
              ballposy += ballspeed*ballydir;
              if(ballposx <= 8)
                  ballxdir=+1;
              if(ballposx >= 654)
                  ballxdir=-1;
              if(ballposy < 8)
                  ballydir=+1;

              repaint();
            }
        }

        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {
           
        }


        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                    if(playerx>=550)
                        playerx=550;
                    else
                        moveRight();
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                    if(playerx<8)
                        playerx=8;
                    else
                        moveLeft();

            }
           
            

            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                play=true;
                ballposx=240;
                ballposy=350;
                ballxdir=1;
                ballydir=-2;
                moves=0;
                score=0;
                
                 Random random=new Random();
                int randomrows = min + random.nextInt(max);
               if(r<=4)
                   r++;
               else 
                   r=1;
                
                 map=new MapGenerator(randomrows,20-randomrows,r);
                  TotalBricks=0;
                 for(int i=0;i<map.map.length;i++){
                        for(int j=0;j<map.map[0].length;j++){
                            if(map.map[i][j]>0)
                            {
                                 TotalBricks+=map.map[i][j];
                            }
                        }
                 }

                repaint();
            }
            if(e.getKeyCode() == KeyEvent.VK_C)
            {
                play=true;
                ballposx=240;
                ballposy=350;
                ballxdir=1;
                ballydir=-2;
                moves=0;
                score=0;

                 Random random=new Random();
                int randomrows = min + random.nextInt(max);

                   r=1;

                 map=new MapGenerator(randomrows,20-randomrows,r);
                  TotalBricks=0;
                 for(int i=0;i<map.map.length;i++){
                        for(int j=0;j<map.map[0].length;j++){
                            if(map.map[i][j]>0)
                            {
                                 TotalBricks+=map.map[i][j];
                            }
                        }
                 }

                repaint();
            }
            


        }
        public void moveRight()
        {
            play=true;
            playerx+=10*ballspeed;
        }
        public void moveLeft()
        {
            play=true;
            playerx-=10*ballspeed;
        }
         
        
}


    


