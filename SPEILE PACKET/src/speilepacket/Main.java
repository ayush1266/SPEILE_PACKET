/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package speilepacket;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        JFrame obj=new JFrame();

        GamePlay gameplay = new GamePlay();
         obj.setBounds(10,10,905,700);
       // obj.setBackground(Color.RED);
        obj.setTitle("SPILE PACKET");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
        // TODO code application logic here
    }

}
