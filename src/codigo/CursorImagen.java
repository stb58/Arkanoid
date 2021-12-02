package codigo;

import java.awt.Image;

import acm.graphics.GImage;

public class CursorImagen extends GImage {



	public CursorImagen(String name, double x, double y) {
		super(name, x, y);
	}

	
	public void muevete(int anchoPantalla, int posX){
		if (posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
		}
	}
}
