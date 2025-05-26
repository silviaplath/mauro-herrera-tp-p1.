package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
public class enemigos {
	 double x, y;
	    int radio;
public enemigos (double x , double y) {
	this.x= x;
	this.y = y;
	this.radio= 20;
}
public void dibujar(Entorno entorno) {
    entorno.dibujarCirculo(x, y, 2 * radio, Color.RED);
}
}
