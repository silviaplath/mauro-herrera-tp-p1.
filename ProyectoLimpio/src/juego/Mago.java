package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;

public class Mago {
double x;
double y;
int radio;
 public Mago(double x, double y ,double radio) {
	this.x = x;
	this.y = y;
	this.radio = 20;
	
}


 public void dibujar(Entorno entorno) {
		Color miColor = new Color(255, 0, 255);
		entorno.dibujarCirculo(x, y, 2 * radio, miColor);
	}
public void moverArriba () {
	y = y-3;
}
public void moverAbajo () {
	y = y+3;
}
public void moverDerecha () {
	x = x+3;
}
public void moverIzquierda() {
	x = x-3;
}
}
