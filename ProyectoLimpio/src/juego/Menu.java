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
	

		public void dibujar(Entorno entorno) {
			entorno.cambiarFont("Arial", 18, Color.black);
			entorno.dibujarRectangulo(botonFuegoX, botonFuegoY, anchoBoton, altoBoton, 0, Color.RED);
			entorno.escribirTexto("Fuego", botonFuegoX - 30, botonFuegoY + 5);

			entorno.dibujarRectangulo(botonAguaX, botonAguaY, anchoBoton, altoBoton, 0, Color.CYAN);
			entorno.escribirTexto("Agua", botonAguaX - 25, botonAguaY + 5);
	    }
}