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
		 private int anchoBoton = 100;
		 private int altoBoton = 40;
	     private Image fondo;
		
	     	public Menu () {
	     		 this.fondo = Herramientas.cargarImagen("imagenes/WhatsApp Image 2025-05-27 at 23.31.53 (1).jpeg");
	     	}
		public void dibujar(Entorno entorno) {
			
			 entorno.dibujarImagen(this.fondo, 700, 300, 0);
			
			entorno.dibujarRectangulo(botonFuegoX, botonFuegoY, anchoBoton, altoBoton, 0, Color.RED);
			entorno.cambiarFont("Lucida Calligraphy", 18, Color.BLACK);
			entorno.escribirTexto("Fuego", botonFuegoX - 30, botonFuegoY + 5);

			entorno.dibujarRectangulo(botonAguaX, botonAguaY, anchoBoton, altoBoton, 0, Color.CYAN);
			entorno.cambiarFont("Lucida Calligraphy", 18, Color.BLACK);
			entorno.escribirTexto("Agua", botonAguaX - 25, botonAguaY + 5);
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
		}
		
