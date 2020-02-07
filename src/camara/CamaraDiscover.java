/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camara;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;

/**
 *
 * @author fabio.rojas
 */
    public class CamaraDiscover implements WebcamDiscoveryListener {

    public CamaraDiscover() {
		for (Webcam webcam : Webcam.getWebcams()) {
			System.out.println("Webcam detected: " + webcam.getName());
		}
		Webcam.addDiscoveryListener(this);
		System.out.println("\n\nPlease connect additional webcams, or disconnect already connected ones. Listening for events...");
	}

	@Override
	public void webcamFound(WebcamDiscoveryEvent event) {
		System.out.format("Webcam connected: %s \n", event.getWebcam().getName());
	}

	@Override
	public void webcamGone(WebcamDiscoveryEvent event) {
		System.out.format("Webcam disconnected: %s \n", event.getWebcam().getName());
	}
}
