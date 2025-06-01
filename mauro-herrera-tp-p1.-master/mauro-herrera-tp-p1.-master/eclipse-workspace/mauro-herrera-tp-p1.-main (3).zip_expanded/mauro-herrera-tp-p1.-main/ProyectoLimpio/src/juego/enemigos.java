package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;
public class enemigos {
	 double x, y;
	    Image imagen;
	  double velocidad;
	  double angulo;
	  double desfaseAngulo;
	  
public enemigos (double x , double y) {
	this.x= x;
	this.y = y;
	this.imagen= Herramientas.cargarImagen("imagenes/oie_26212844LHRSFIWB.gif");
	this.angulo= 0 ;
	this.velocidad= 0.5 ;
	this.desfaseAngulo = Math.random() * 0.6 - 0.3;		
}
public void moverHacia(Mago mago) {
    cambiarAngulo(mago.x, mago.y);
    this.x += Math.cos(this.angulo) * velocidad;
    this.y += Math.sin(this.angulo) * velocidad;
    
}

public void cambiarAngulo(double x2, double y2){
	this.angulo = Math.atan2(y2 - this.y, x2 - this.x) + desfaseAngulo;
}
public void dibujar(Entorno entorno) {
    entorno.dibujarImagen(this.imagen, this.x, this.y, 0, 0.05);
}
}
