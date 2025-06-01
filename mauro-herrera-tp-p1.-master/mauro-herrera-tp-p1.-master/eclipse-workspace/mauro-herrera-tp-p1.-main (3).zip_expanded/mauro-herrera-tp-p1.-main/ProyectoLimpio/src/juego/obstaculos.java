package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;


public class obstaculos {
double x;
double y;
double altoroca;
double anchoroca;
Image imagen;


public obstaculos (double x, double y) {
    this.x = x;
    this.y = y;
    this.altoroca=40;
    this.anchoroca=40;
    this.imagen = Herramientas.cargarImagen("imagenes/oie_transparent.png");
}
public void dibujar(Entorno entorno) {
	entorno.dibujarRectangulo(x, y, anchoroca, altoroca, 0.0, Color.LIGHT_GRAY);
	entorno.dibujarImagen(this.imagen, this.x, this.y, 0, 0.05);
    
}
public double bordeInf() {
	return this.y+altoroca/2;
}
public double bordeSup() {
	return this.y-altoroca/2;
	
}
public double bordeIzq() {
	return this.x-anchoroca/2;
	
}
public double bordeDer() {
	return this.x+anchoroca/2;
}

}
