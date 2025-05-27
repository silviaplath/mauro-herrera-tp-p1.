package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;

public class Mago {
public Image imagen;
double x;
double y;
int radio;
 public Mago(double x, double y ,double radio) {
	this.x = x;
	this.y = y;
	this.radio = 20;
	this.imagen = Herramientas.cargarImagen("imagenes/oie_transparent (1).png");

}


 public void dibujar(Entorno entorno) {
		Color miColor = new Color(255, 0, 255);
		entorno.dibujarCirculo(x, y, 1.4* radio, miColor);
		 entorno.dibujarImagen(imagen, x, y, 0, 0.035);
	}
public void moverArriba (Entorno entorno) {
	y = y-3;
	  if (y < radio) {
          y = radio;
      }
  }

public void moverAbajo (Entorno entorno) {
	y = y+3;
	  if (y > entorno.alto() - radio) {
          y = entorno.alto() - radio;
      }
}
public void moverDerecha (Entorno entorno) {
	x = x+3;
	if (x > entorno.ancho() - radio) {
        x = entorno.ancho() - radio;
    }
}
public void moverIzquierda(Entorno entorno) {
	x = x-3;
	 if (x < radio) {
         x = radio;
     }
}
}
