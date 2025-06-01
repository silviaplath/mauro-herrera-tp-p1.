package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;

public class ExplosionFuego {
public double x,y;
public int duracion;
private Image gifExplosion;

public void dibujar(Entorno entorno) {
    entorno.dibujarImagen(gifExplosion, x, y, 0);
    duracion--;
}

public ExplosionFuego(double x, double y) {
    this.x = x;
    this.y = y;
    this.duracion = 30;
    this.gifExplosion = Herramientas.cargarImagen("imagenes/explosion fuego (1).gif");
}
}
