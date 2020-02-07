package camara;

import faceprint.ControlAcceso;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio.rojas
 */
public class Camara {
      public static void main(String args[]) {
          
       
                             
          
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //CamaraDiscover
               
                
                
               // new ControlAcceso().setVisible(true);
                ControlAcceso principalUi = new ControlAcceso();
           
                                 //listaUsuariosJinternalFrame listaUsuarios = new listaUsuariosJinternalFrame();
                 Controler control = new Controler(principalUi);
                 principalUi.setControlador(control);
                 principalUi.arranca();
                 /*
                  new CamaraDiscover();
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
                }
		System.out.println("Bye!");*/
            }
        });
    }
}
