/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;



/**
 *
 * @author Slyvain
 */
public class Memory {
    

     /**
    * @param args the command line arguments
    * tdg
    */
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new MainFrame().setVisible(true);
         }
      });
   }
    
    
}
