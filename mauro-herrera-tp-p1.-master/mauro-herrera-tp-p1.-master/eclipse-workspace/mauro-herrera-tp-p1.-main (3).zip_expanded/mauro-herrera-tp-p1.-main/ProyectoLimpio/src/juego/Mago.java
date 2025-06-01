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
public int Energia;

 public Mago(double x, double y ,double radio) {
	this.x = x;
	this.y = y;
	this.radio = 20;
	this.imagen = Herramientas.cargarImagen("imagenes/oie_transparent (1).png");
	this.Energia= 100;

}
 public double getX() { return x; }
 public double getY() { return y; }
 

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
public boolean colisionMenu() {
    double menuX = 700;
    double menuY = 300;
    double menuAncho = 200;
    double menuAlto = 600;
    
    double bordeIzq = menuX - menuAncho / 2;   
    double bordeDer = menuX + menuAncho / 2;   
    double bordeSup = menuY - menuAlto / 2;    
    double bordeInf = menuY + menuAlto / 2;    
    
    boolean choqueX = (x + radio) > bordeIzq && (x - radio) < bordeDer;
    boolean choqueY = (y + radio) > bordeSup && (y - radio) < bordeInf;

    return choqueX && choqueY;
}
public boolean colisionRocas(obstaculos roca) {
	
	return x-radio < roca.bordeDer() &&
			x+radio > roca.bordeIzq() &&
			y-radio < roca.bordeInf() &&
			y+radio > roca.bordeSup();
}
public ExplosionFuego lanzarExplosion() {
    return new ExplosionFuego(this.x, this.y);
}
public ExplosionMagia lanzarExplosion2() {
    return new ExplosionMagia(this.x, this.y);
}

public void gastarEnergia(int cantidad) {
    if (Energia >= cantidad) {
        Energia -= cantidad;
    }
}
}


