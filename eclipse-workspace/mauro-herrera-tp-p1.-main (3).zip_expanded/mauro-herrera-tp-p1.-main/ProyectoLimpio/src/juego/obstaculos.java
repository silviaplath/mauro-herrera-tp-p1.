package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;


public class obstaculos {
double x;
double y;
Image imagen;


public obstaculos (double x, double y) {
    this.x = x;
    this.y = y;
    this.imagen = Herramientas.cargarImagen("imagenes/oie_transparent.png");
}
public void dibujar(Entorno entorno) {
    entorno.dibujarImagen(this.imagen, this.x, this.y, 0, 0.05);
    
}

}
