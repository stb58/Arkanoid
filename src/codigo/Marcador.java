package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto = new GLabel("");
	int puntuacion = 0;

	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel("Marcador ");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("iomanoid", Font.BOLD, 30));
	}

	//suma el nº de puntos que se indica en la variable puntos a la puntuacion actual
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos;
		texto.setLabel("Marcador = " + puntuacion);
	}

	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 260, 40);
	}
}