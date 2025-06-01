package juego;
import entorno.Entorno;
import java.awt.Image;
import java.awt.Color;
import entorno.Herramientas;

public class Menu {
		 private int botonFuegoX = 700;
		 private int botonFuegoY = 200;
		 private int botonAguaX = 700;
		 private int botonAguaY = 300;
		 private int anchoBoton = 150;
		 private int altoBoton = 40;
	     private Image fondo;
		private Image corazon;
	     	public Menu () {
	     		 this.fondo = Herramientas.cargarImagen("imagenes/descarga (3) (1).png");
	     		this.corazon = Herramientas.cargarImagen("imagenes/Corazón de videojuego _ Vector Gratis (1).png");
	     	}
		public void dibujar(Entorno entorno) {
			
			 entorno.dibujarImagen(this.fondo, 700, 300, 0);
			
			entorno.dibujarRectangulo(botonFuegoX, botonFuegoY, anchoBoton, altoBoton, 0, Color.RED);
			entorno.cambiarFont("Cooper Black", 14, Color.BLACK);
			entorno.escribirTexto("Explosion de Fuego", botonFuegoX - 65, botonFuegoY + 5);

			entorno.dibujarRectangulo(botonAguaX, botonAguaY, anchoBoton, altoBoton, 0, Color.CYAN);
			entorno.cambiarFont("Cooper Black", 15, Color.BLACK);
			entorno.escribirTexto("Bomba de Magia", botonAguaX - 55, botonAguaY + 5);
			
	    }
		
		public boolean mouseEnBotonFuego(Entorno entorno) {
			double mouseX = entorno.mouseX();
			double mouseY = entorno.mouseY();
			return (mouseX >= this.botonFuegoX - this.anchoBoton / 2 && mouseX <= this.botonFuegoX + this.anchoBoton / 2)
					&& (mouseY >= this.botonFuegoY - this.altoBoton / 2 && mouseY <= this.botonFuegoY + this.altoBoton / 2);
		}
		
		public boolean mouseEnBotonAgua(Entorno entorno) {
			double mouseX = entorno.mouseX();
			double mouseY = entorno.mouseY();
			return (mouseX >= this.botonAguaX - this.anchoBoton / 2 && mouseX <= this.botonAguaX + this.anchoBoton / 2)
					&& (mouseY >= this.botonAguaY - this.altoBoton / 2 && mouseY <= this.botonAguaY + this.altoBoton / 2);
		}
		
		public boolean sePresionoBoton (int bot, Entorno entorno) {
			 boolean dentroBoton = false;
			 if (bot== 1) {
				 dentroBoton = mouseEnBotonFuego(entorno);
			 } else if (bot == 2) { 
			        dentroBoton = mouseEnBotonAgua(entorno);
			    }
			 if (dentroBoton && entorno.sePresionoBoton (entorno.BOTON_IZQUIERDO)) {
				 return true;
				 
			 }
			 return false;
			 }
		public void informacion (Entorno entorno ,int enemigosEliminados) {
			entorno.cambiarFont("Cooper Black", 15, Color.BLACK);
			entorno.escribirTexto("Enemigos eliminados: " + enemigosEliminados, 610, 390);
		}
		public void BarraEnergia (Entorno entorno , int Energia) {
			 entorno.dibujarRectangulo( 700.0,120.0, 100.0,20.0, 0, Color.GRAY);
			 
			 int anchoBarra = (int) Energia;
			 entorno.dibujarRectangulo(700.0- 50.0 + anchoBarra / 2.0, 120.0, anchoBarra,20.0 , 0, Color.GREEN);
		}
		public void dibujarvidas(Entorno entorno, int vidas) {
			for (int i = 0; i < vidas; i++) {
		        entorno.dibujarImagen(corazon, 700 -70 + i * 35, 450, 0, 0.06);
		}
		}
}
		
		
