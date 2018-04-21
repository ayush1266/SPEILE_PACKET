/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speilepacket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author win
 */
public class GamePlay extends JPanel implements ActionListener, KeyListener {



    private int i;
    private int c;
    Random random=new Random();

    public void actionPerformed(ActionEvent e) {
         JFrame obj2=new JFrame();
             GamePlay2 gameplay2 = new GamePlay2();
             obj2.setBounds(10,10,905,700);
            obj2.setBackground(Color.RED);
            obj2.setTitle("SNAKE XENXIA");
            obj2.setResizable(false);

            obj2.setVisible(true);
            obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             obj2.add(gameplay2);
             this.setVisible(false);
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            JFrame obj2=new JFrame();
            GamePlay2 gameplay2 = new GamePlay2();
            obj2.setBounds(10,10,905,700);
            obj2.setBackground(Color.RED);
            obj2.setTitle("SNAKE XENXIA");
            obj2.setResizable(false);

            obj2.setVisible(true);
            obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj2.add(gameplay2);
             this.setVisible(false);
        }
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public void paint(Graphics g){

         g.setColor(Color.WHITE);
        g.drawRect(4, 4, 891, 577);


       for(i=4;i<=255;i++)
       {
           
            Color mycolor = new Color(i, 255-i, i);
             g.setColor(mycolor);
             g.fillRect(4, i*3, 891,3 );


       }

     }
     

}
