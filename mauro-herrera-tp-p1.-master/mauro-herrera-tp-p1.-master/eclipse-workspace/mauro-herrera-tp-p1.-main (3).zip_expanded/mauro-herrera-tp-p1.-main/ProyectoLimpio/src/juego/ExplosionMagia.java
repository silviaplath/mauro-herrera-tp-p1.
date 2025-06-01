package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;

public class ExplosionMagia {
	public double x,y;
	public int duracion;
	private Image gifExplosionMagia;
	
	public void dibujar(Entorno entorno) {
	    entorno.dibujarImagen(gifExplosionMagia, x, y, 0);
	    duracion--;
	}
	public ExplosionMagia(double x, double y) {
	    this.x = x;
	    this.y = y;
	    this.duracion = 30;
	    this.gifExplosionMagia = Herramientas.cargarImagen("imagenes/ezgif-882e311c995332 (1).gif");
	}
	}

