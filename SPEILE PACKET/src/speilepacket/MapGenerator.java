/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speilepacket;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author win
 */
public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;
    public int powerx;
    public int powery;
    public int rowglobal;
    public int colglobal;
    public MapGenerator(int row, int col ,int r)
    {
            map = new int[row][col];
            rowglobal=row;
            colglobal=col;
            for(int i=0;i<rowglobal;i++)
                for(int j=0;j<colglobal;j++)
                    map[i][j]=0;
            if(r<=2)
            for(int i=0;i<map.length;i++)
                for(int j=0;j<map[0].length;j+=r)
                    map[i][j]=2;
             
            else if(r==3)
            {

              
               for(int i=0;i<rowglobal;i++)
                   for(int j=0;j<i;j++)
                   {
                       map[i][j]=2;
                   }
                   for(int i=rowglobal-1;i>=0;i--)
                   for(int j=colglobal-1;j>=colglobal-i;j--)
                   {
                       map[i][j]=2;
                   }
            }
            else if(r==4)
            {


               for(int i=0;i<colglobal;i++)
                       map[0][i]=2;
                   for(int i=0;i<rowglobal-1;i++)
                   {
                        map[i][0]=map[i][colglobal-1]=2;
                   }
                 for(int i=0;i<colglobal;i++)
                       map[rowglobal-1][i]=2;
            }

            map[row/2][col/2]=3;


            brickWidth = 540/col;
            brickHeight = 150/row;
    }
            public void draw(Graphics2D g){
                 for(int i=0;i<rowglobal;i++){
                for(int j=0;j<colglobal;j++){
                    if(map[i][j]==2)
                    {
                        g.setColor(Color.GREEN);
                        g.fill3DRect(j*(brickWidth) + 80, i*brickHeight + 50 ,brickWidth-5, brickHeight-5,true);
                    }
                     if(map[i][j]==1)
                    {
                        g.setColor(Color.WHITE);
                        g.fill3DRect(j*(brickWidth) + 80, i*brickHeight + 50 ,brickWidth-5, brickHeight-5,true);
                    }
                    if(map[i][j]==3)
                    {
                        g.setColor(Color.RED);
                        g.fill3DRect(j*brickWidth + 80, i*brickHeight + 50 ,brickWidth-5, brickHeight-5,true);
                    }
                    
                }

            }
                 
            }

            public void setBrickValue(int value,int row,int col)
            {
                map[row][col]=map[row][col]-value;
            }

}