/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speilepacket;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author win
 */
public class GamePlay2 extends JPanel implements ActionListener, KeyListener{
    private ImageIcon titleimage;

      private int[] snakexlength = new int[750];
        private int[] snakeylength = new int[750];
        private boolean left=false;
        private boolean right=false;
        private boolean up=false;
        private boolean down=false;
        private Timer timer;
        private int lengthofsnake = 3;
        private int delay=100;
        private int moves=0;
        private int score=0;
        private int time=0;
        private int c1=255;
        private int c2=255;
        private int c3=150;
        private int colorchange=10;
        private int stage=0;
        private int[] enemyxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
        350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};

         private int[] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,
        350,375,400,425,450,475,500,525,550,575,600,625};

        private Random random = new Random();
        private int xpos = random.nextInt(34);
         private int ypos = random.nextInt(23);
         private int leftboundpos=75;
         private int bounddir=20;
         private int leftboundpos2=550;
         private int bound2dir=-20;

    public GamePlay2(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
        
    }

    @Override
    public void paint(Graphics g){

        if(moves==0)
        {
                snakexlength[2]=50;
                snakexlength[1]=75;
                snakexlength[0]=100;


                snakeylength[2]=100;
                snakeylength[1]=100;
                snakeylength[0]=100;
        }

        //titleborder

        g.setColor(Color.BLACK);
        g.fillRect(24, 10, 851, 55);
       
        //draw gameplay background
          g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        //fill gameplay
        if(score>20)
        {
                if(c1<0)
                    c1=255;
                if(c2>255);
                c2=0;
                if(c3<0)
                c3=random.nextInt(255);
                Color mycolor = new Color(c1, c2, c3);
                c1-=colorchange;
                c2-=-colorchange;
                c3=-10;
                g.setColor(mycolor);
        }
        else
                g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        //TITLE
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString("SPILE PACKET by THAKUR  - - score: " + score , 350 , 45);


         g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString("PRES Esc TO PAUSE " , 350 ,670 );
        //snake
            //snake face
             

                 for(int i=0;i<lengthofsnake;i++)
                 {
                        if(i==0)
                        {
                            g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);
                        }
                        else{
                          g.setColor(Color.BLUE);

                            g.fillOval(snakexlength[i],snakeylength[i],25,25);
                         }
                 }
        //intersection
          if((enemyxpos[xpos]==snakexlength[0]) && (enemyypos[ypos]==snakeylength[0]))
                    {
                            lengthofsnake++;
                           xpos = random.nextInt(34);
                            ypos = random.nextInt(23);
                            score+=5;
                            delay-=5;
                    }
        
        //enemy
          
          
          if(score<10)
          {
                if(xpos==0 && score==5)
                    xpos++;
                if(ypos==0 && score==5)
                    ypos++;
                if(xpos==33 && score==5)
                    xpos--;
                if(ypos==22 && score==5)
                    ypos--;
              g.setColor(Color.ORANGE);
                 g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
           for(int i=1;i<lengthofsnake;i++){
               if(snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i])
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                      left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;

                      
                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);
                        
               }
           }
          }
          
          if(score>=10 && score<20)
          {
                if(xpos==0)
                    xpos++;
                if(ypos==0 || (score==15  && (xpos >=13 && xpos <=23 && ypos ==11)))
                    ypos++;
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                 g.fillRect(25, 625, 850, 25);
              for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i])
                       || (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625))
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);

               }
           }
          }

          if(score>=20  && score<30)
          {
                if(xpos==0 )
                    xpos++;
                if(ypos==0 || ypos ==11)
                    ypos+=2;
                if(score==25 &&(  ypos ==8 || ypos ==13))
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                 g.fillRect(25, 625, 850, 25);
                  g.fillRect(350, 350, 250, 25);
              for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) || 
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==350))
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);

               }
           }
          }
         if(score>=30 && score<40)
          {
                if(xpos==0 )
                    xpos++;
                if(ypos==0 ||  ypos ==8 || ypos ==13)
                    ypos+=2;
                if(score==35 && (ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18))
                    ypos+=2;
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                 g.fillRect(25, 625, 850, 25);
                  g.fillRect(350, 275, 250, 25);
                   g.fillRect(350, 400, 250, 25);
              for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) ||
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==400)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==275))
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);

               }
           }
          }
        if(score>=40 && score<50)
          {
                if(xpos==0 )
                    xpos++;
                if(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18)
                    ypos+=2;
              if(score==45 &&(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29))
                {
                    ypos+=2;

                    xpos+=2;
                }
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                 g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                 g.fillRect(25, 75, 850,25);
                 g.fillRect(25, 75, 25, 575);
                 g.fillRect(850, 75, 25, 575);
                 g.fillRect(25, 625, 850, 25);
                 g.fillRect(350, 275, 250, 25);
                 g.fillRect(350, 400, 250, 25);
                 g.fillRect(350, 150, 250, 25);
                 g.fillRect(350, 525, 250, 25);
              for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) ||
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==400)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==275)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==150)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==525))
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);

               }
           }
          }
         if(score>=50 && score<60)
          {
                if(xpos==0 )
                    xpos++;
                if(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29)
                {
                    ypos+=2;

                    xpos+=2;
                }
                if(score==55 &&(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29))
                {
                    ypos+=2;

                    xpos+=2;
                }
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                 g.fillRect(25, 625, 850, 25);
                  g.fillRect(350, 275, 250, 25);
                   g.fillRect(350, 400, 250, 25);
                   g.fillRect(350, 150, 250, 25);
                   g.fillRect(350, 525, 250, 25);
                   g.fillRect(150, 150, 25, 400);
                   g.fillRect(750, 150, 25, 400);

              for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) ||
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==400)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==275)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==150)
                        || (snakexlength[0]>=350 && snakexlength[0]<600 && snakeylength[0]==525)
                         || (snakexlength[0]==150 && snakeylength[0]>=150 && snakeylength[0]<550)
                          || (snakexlength[0]==750 && snakeylength[0]>=150 && snakeylength[0]<550))
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);

               }
           }
         }
        if(score>=60 && score<70)
          {
                if(xpos==0)
                    xpos++;
                if(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29)
                {
                    ypos+=2;

                    xpos+=2;
                }
               if(score==65 &&(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29))
                {
                    ypos+=2;

                    xpos+=2;
                }
           if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                g.fillRect(25, 625, 850, 25);
                g.fillRect(leftboundpos, 275, 250, 25);
                g.fillRect(leftboundpos, 400, 250, 25);
                g.fillRect(leftboundpos, 150, 250, 25);
                g.fillRect(leftboundpos, 525, 250, 25);

                if(leftboundpos>550)
                    bounddir=-20;
                 if(leftboundpos<75)
                    bounddir=20;

                leftboundpos+=bounddir;

                for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) ||
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==400)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==275)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==150)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==525)
                  )
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);


               }
           }
         }
         if(score>=70)
          {
                if(xpos==0)
                    xpos++;
                if(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29)
                {
                    ypos+=2;

                    xpos+=2;
                }
                if(score==55 &&(ypos==0 ||  ypos ==8 || ypos ==13 ||  ypos ==3 || ypos ==18 || xpos==5 || xpos==29))
                {
                    ypos+=2;

                    xpos+=2;
                }
                if(xpos==33)
                    xpos--;
                if(ypos==22)
                    ypos--;
                leftboundpos=75;
                leftboundpos2=550;
                 g.setColor(Color.ORANGE);
                g.fillOval(enemyxpos[xpos],enemyypos[ypos],25,25);
                 g.setColor(Color.RED);
                g.fillRect(25, 75, 850,25);
                g.fillRect(25, 75, 25, 575);
                g.fillRect(850, 75, 25, 575);
                g.fillRect(25, 625, 850, 25);
                 g.fillRect(leftboundpos2, 150, 250, 25);
                g.fillRect(leftboundpos, 275, 250, 25);
                g.fillRect(leftboundpos2, 400, 250, 25);
                g.fillRect(leftboundpos, 525, 250, 25);

                if(leftboundpos>550)
                    bounddir=-20;
                 if(leftboundpos<75)
                    bounddir=20;
                if(leftboundpos2>550)
                    bound2dir=-20;
                 if(leftboundpos2<75)
                    bound2dir=20;
                leftboundpos+=bounddir;
                leftboundpos2+=bound2dir;
                for(int i=1;i<lengthofsnake;i++){
               if((snakexlength[0]==snakexlength[i] &&snakeylength[0]==snakeylength[i]) ||
                       (snakexlength[0]==25 || snakexlength[0]==850 || snakeylength[0]==75 || snakeylength[0]==625)
                        || (snakexlength[0]>=leftboundpos2 && snakexlength[0]<leftboundpos2+250 && snakeylength[0]==400)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==275)
                        || (snakexlength[0]>=leftboundpos2 && snakexlength[0]<leftboundpos2+250 && snakeylength[0]==150)
                        || (snakexlength[0]>=leftboundpos && snakexlength[0]<leftboundpos+250 && snakeylength[0]==525)
                  )
               {
                    g.setColor(Color.WHITE);
                   g.setFont(new Font("serif", Font.BOLD,25));
                       g.drawString("GAME OVER, PRESS ENETER TO RESTART", 150 , 345);
                       left=false;
                        right=false;
                        up=false;
                        down=false;
                        lengthofsnake=3;
                        score=0;
                        moves=0;
                        snakexlength[2]=50;
                        snakexlength[1]=75;
                        snakexlength[0]=100;
                        stage=0;

                        snakeylength[2]=100;
                        snakeylength[1]=100;
                        snakeylength[0]=100;


                       g.setColor(Color.RED);
                        g.fillOval(snakexlength[0],snakeylength[0],25,25);


               }
           }
         }
          g.dispose();
    }   

    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(right){
            for(int i=lengthofsnake-1;i>=0;i--){
                snakeylength[i+1]=snakeylength[i];

            }
             for(int i=lengthofsnake-1;i>=0;i--){
                if(i==0)
                 snakexlength[i]=snakexlength[i]+25;
                else
                snakexlength[i]=snakexlength[i-1];
                if(snakexlength[i]>850)
                    snakexlength[i]=25;
             }
            repaint();
        }
        if(left){
            for(int i=lengthofsnake-1;i>=0;i--){
                snakeylength[i+1]=snakeylength[i];

            }
             for(int i=lengthofsnake-1;i>=0;i--){
                if(i==0)
                 snakexlength[i]=snakexlength[i]-25;
                else
                snakexlength[i]=snakexlength[i-1];
                if(snakexlength[i]<25)
                    snakexlength[i]=850;
             }
            repaint();
        }
        if(up){
            for(int i=lengthofsnake-1;i>=0;i--){
                snakexlength[i+1]=snakexlength[i];

            }
             for(int i=lengthofsnake-1;i>=0;i--){
                if(i==0)
                 snakeylength[i]=snakeylength[i]-25;
                else
                snakeylength[i]=snakeylength[i-1];
                if(snakeylength[i]<75)
                    snakeylength[i]=625;
             }
            repaint();
        }
        if(down){
            for(int i=lengthofsnake-1;i>=0;i--){
                snakexlength[i+1]=snakexlength[i];

            }
             for(int i=lengthofsnake-1;i>=0;i--){
                if(i==0)
                 snakeylength[i]=snakeylength[i]+25;
                else
                snakeylength[i]=snakeylength[i-1];
                if(snakeylength[i]>625)
                    snakeylength[i]=75;
             }
            repaint();
       }
         
       
       
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(!left)
            {
                right=true;
                moves++;

            }
            else
            {
                right=false;
                left=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(!right)
            {
                left=true;
                moves++;

            }
            else
            {
                left=false;
                right=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(!down)
            {
                up=true;
                moves++;

            }
            else
            {
                up =false;
                down=true;
            }
            right=false;
            left=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(!up)
            {
                down=true;
                moves++;

            }
            else
            {
                right =false;
                left=true;
            }
            right=false;
            left=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
                left=false;
                right=false;
                up=false;
                down=false;
                

        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
                left=false;
                right=false;
                up=false;
                down=false;
                lengthofsnake=3;
                score=0;
                moves=0;
                snakexlength[2]=50;
                snakexlength[1]=75;
                snakexlength[0]=100;
                stage=0;

                snakeylength[2]=100;
                snakeylength[1]=100;
                snakeylength[0]=100;

        }
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
