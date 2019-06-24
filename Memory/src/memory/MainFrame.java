/*//GEN-LINE:variables
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Runtime.getRuntime;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javafx.animation.Animation;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author syl-b
 */
public class MainFrame extends javax.swing.JFrame {

    //Hash map of number
    HashMap<String, String> map = new HashMap<String, String>();

    //Get the hashmap first clicked card's key
    String firstCardkey = "";
    ActionEvent firstTouchedButton;
    ActionEvent secondTouchedButton;

    /**
     * load pictures in hashmap
     *
     * @author Théo
     */
    public void loadPictures(int numberOfCard) {
        Random rand = new Random();
        boolean flag;
        int n;

        for (int i = 0; i < numberOfCard; i++) {
            for (int j = 0; j < 2; j++) {
                do {
                    flag = true;

                    // Obtain a number between [0 - numberOfCard-1 ].
                    n = rand.nextInt(numberOfCard * 2);
                    boolean m = map.containsKey(String.valueOf(n));
                    if (map.containsKey(String.valueOf(n))) {
                        flag = false;
                    }
                } while (flag != true);

                String text = "Numéro " + i;
                map.put(String.valueOf(n), text);
            }
        }//End for
    }//end loadPictures

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        int lastCard = 0;
        int rows = 4;
        int cols = 1;
        int cardNumber = 10;
        int vgap = 0;
        
        timer = new Timer(1000, new TimerListener());

        this.setLayout(new BorderLayout());
        loadPictures(cardNumber);
        GridLayout GridMemory = new GridLayout(rows, cols);

        pnlGrid = new JPanel();
        pnlConf = new JPanel();

        this.add(pnlConf, BorderLayout.SOUTH);
        this.add(pnlGrid, BorderLayout.CENTER);
        this.setBounds(100, 100, 800, 600);
        pnlGrid.setLayout(GridMemory);

        //this.setContentPane(pnlMemory);
        pnlConf.setLayout(new FlowLayout(FlowLayout.LEFT));
        Random rand = new Random();

        BtnListener listener = new BtnListener();
        JButton currentBtn;
        for (int i = 0; i < cardNumber * 2; i++) {
            currentBtn = new JButton("");
            currentBtn.addActionListener(listener);
            currentBtn.setName(String.valueOf(i));
            pnlGrid.add(currentBtn);

        }
        pnlConf.add(new JButton("Mélanger"));

    }

    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            ((JButton) secondTouchedButton.getSource()).setText("");
            ((JButton) firstTouchedButton.getSource()).setText("");
            ((JButton) firstTouchedButton.getSource()).setEnabled(true);
            ((JButton) secondTouchedButton.getSource()).setEnabled(true);
            firstCardkey = "";
            secondTouchedButton = null;
            firstTouchedButton = null;
        }
        
        
        
    }

    class BtnListener implements ActionListener {

        @Override
        @SuppressWarnings("empty-statement")
        public void actionPerformed(ActionEvent e) {
        if(secondTouchedButton == null){
            timer.stop();
            
            //Display pressed button's name in output console
            System.out.println(((JButton) e.getSource()).getName());

            // if the pressed button is the first one then:
            if (firstCardkey == "") {

                //keap the button's name (int in var String)
                firstCardkey = ((JButton) e.getSource()).getName();

                //Change visible button's text
                ((JButton) e.getSource()).setText(map.get(((JButton) e.getSource()).getName()));

                //Set this button disabled
                ((JButton) e.getSource()).setEnabled(false);

                //Save the object in firstTouchedButton
                firstTouchedButton = e;
                
            } //Else if the pressed button is the second one then:
            else {

                //If the first and second button's are same
                if (map.get(firstCardkey).equals(map.get(((JButton) e.getSource()).getName()))) {

                    //Set second button visible and disabled it
                    ((JButton) e.getSource()).setText(map.get(((JButton) e.getSource()).getName()));
                    ((JButton) e.getSource()).setEnabled(false);
                    firstCardkey = "";
                    firstTouchedButton = null;
                    secondTouchedButton = null;
                } //Else if the first and second buttons aren't same
                else {

                    if(firstTouchedButton != null){
                    secondTouchedButton = e;
                    }
                    ((JButton) e.getSource()).setText(map.get(((JButton) e.getSource()).getName()));
                    ((JButton) e.getSource()).setEnabled(false);
                    timer.start();
  
                }//End else
            }//End if
        }
        }//End actionPerformed
    }//End btnListener

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panel1 = new java.awt.Panel();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Panel panel1;
    // End of variables declaration                   
    private JPanel pnlGrid;
    private JPanel pnlConf;
    private Timer timer;
}
