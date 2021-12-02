package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola(double width, double height) {
		super(width, height);	
	}

	public Bola(double width, double height, Color c) {
		super(width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}

	public void muevete(Arkanoid ark){
		//rebote con el suelo y rebote con el techo
		if (getY() > ark.getHeight() || getY() < 10){
			dy = dy * -1;
		}

		//rebote con la pared derecha y rebote con la pared izquierda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA - 30 || getX() < 10){
			dx = dx * -1;
		}

		//chequeo la esquina superior izquierda de la bola
		if (chequeaColision(getX(),	getY(), ark) ){
			if (chequeaColision(getX() + getWidth(), getY(), ark) ){
				if (chequeaColision(getX(),	getY()+getHeight(), ark) ){
					if (chequeaColision(getX()+getWidth(), getY()+getHeight(), ark) ){

					}
				}
			}
		}

		//mueve la bola en la dirección correcta
		this.move(dx,dy);
	}

	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;
		int a = 1; //Creamos un int con valor 1, para despues hacer un if en el cual a tiene que ser menor
		//que un numero con valor aleatorio entre 1 y 10, asi si sale 0 significa que ese bloque necesitará mas de un golpe para romperse

		auxiliar = ark.getElementAt(posx, posy);

		if (auxiliar == ark.miCursor){ //si entra aquí es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null es que no había nada ahi

		}else if (auxiliar instanceof Ladrillo3){ //si es un ladrillo
			if (auxiliar.getX() >= posx || auxiliar.getX() <= posx){
				dx *= -1;
			}
			if (auxiliar.getY() >= posy || auxiliar.getY() <= posy){
				dy *= -1;
			}
			if (a< Math.random()*11){ //Este if sirve para que haya algunos ladrillos que no se eliminen con 1 toque solo
				ark.remove(auxiliar);//borro el ladrillo
				ark.miMarcador.incrementaMarcador(1); 
			}
			noHaChocado = false;
		}

		return noHaChocado;
	}

}