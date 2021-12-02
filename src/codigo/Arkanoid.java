package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;

	Bola bola1 = new Bola(10, 10, Color.RED);
	CursorImagen miCursor = new CursorImagen("imagenes/cursor.png",0, 400);
	//Cursor miCursor = new Cursor(0, 400, 60, 10, Color.GREEN);

	GImage inicio = new GImage("imagenes/historia_arkanoid.png");
	GImage fondo = new GImage("imagenes/fondo.jpg");
	GImage bonus = new GImage("imagenes/Bonus.png");
	GRect fondoMarcador = new GRect(300, 600);
	Marcador miMarcador = new Marcador(20, 40);

	public void init(){
		add(inicio);
		waitForClick();
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		add(fondo);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
		setSize(ANCHO_PANTALLA + 300 ,500);
	}

	public void run(){
		creaPiramide();
		miMarcador.addMarcador(this);
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando
			pause(1);
			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
			//Hacemos el bonus indicando que cuando llegue a la puntuación 31, sume 10 puntos y muestre un mensaje
			if(miMarcador.puntuacion == 31){
				add(bonus);
				waitForClick();
				remove(bonus);
				miMarcador.incrementaMarcador(10);
			}
			if(miMarcador.puntuacion == 101){
				creaNivelDos();
			}
		}
	}

	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}



	private void creaPiramide(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo3 miLadrillo = new Ladrillo3("imagenes/ladrillo.png");
						
						
						
						//ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						//ALTO_LADRILLO*j + desplazamiento_inicial_Y,  //pos Y
						//ANCHO_LADRILLO, //ancho
						//ALTO_LADRILLO, // alto
						//Color.//BLUE);
				add(miLadrillo, ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, ALTO_LADRILLO*j + desplazamiento_inicial_Y);
			}
		}
	}
	private void creaNivelDos(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;

		for (int a=0; a<numeroLadrillos; a++){
			for (int b=a; b<numeroLadrillos; b++){
				Ladrillo3 miLadrillo = new Ladrillo3("imagenes/ladrillo.png");
						
						
						
						//ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						//ALTO_LADRILLO*j + desplazamiento_inicial_Y,  //pos Y
						//ANCHO_LADRILLO, //ancho
						//ALTO_LADRILLO, // alto
						//Color.//BLUE);
				add(miLadrillo, ANCHO_LADRILLO*b + desplazamiento_inicial_X, ALTO_LADRILLO*a + desplazamiento_inicial_Y);
			}
		}
	}
	
}