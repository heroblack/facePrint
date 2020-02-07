package camara;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import faceprint.ControlAcceso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author fabio.rojas
 */
public final class Controler {
    ControlAcceso uiPrincipal;
    
    /*CAMARA INI*/
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    
    
    public Controler(ControlAcceso uiPrincipal) {
          this.uiPrincipal = uiPrincipal;
          startCamara();
          //HD720();
          //startCamara();
    }
    
    
    public void CamareToPanel(int ancho, int alto) {
        panel = new WebcamPanel(webcam, false);
        panel.setPreferredSize(webcam.getViewSize());
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, ancho, alto);
        uiPrincipal.getPanelCamara().add(panel);
        if (initialized.compareAndSet(false, true)) {
            executor.execute(new Runnable() {
 
                @Override
                public void run() {
                    panel.start();
                }
            });
        }
    }
    
    public void HD720() {
        
        Dimension[] nonStandardResolutions = new Dimension[] {
			WebcamResolution.PAL.getSize(),
			WebcamResolution.HD.getSize(),
			new Dimension(2000, 1000),
			new Dimension(1000, 500),
		};
        
                webcam = Webcam.getDefault();
                if (webcam != null) {
		   webcam.setCustomViewSizes(nonStandardResolutions);
		   webcam.setViewSize(WebcamResolution.HD.getSize());
		   webcam.open();
                   BufferedImage image = webcam.getImage();
                   System.out.println(image.getWidth() + "x" + image.getHeight());
                   CamareToPanel(400, 300);
		} else {
			System.out.println("No webcam detected");
		}
		
        
    }
    public void startCamara() {
        webcam = Webcam.getDefault();
        if (webcam != null) {
          webcam.setViewSize(new Dimension(640, 480));
          //webcam.setViewSize(webcam.getViewSizes()[0]);
          CamareToPanel(400, 300);
        } 
        else {
	  System.out.println("No webcam detected");
	 }
      
    }
    
}
