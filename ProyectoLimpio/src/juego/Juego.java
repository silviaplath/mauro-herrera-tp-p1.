package juego;
import entorno.Entorno;
import java.awt.Color;
import entorno.InterfaceJuego;
import java.util.Arrays;
import entorno.Herramientas;
import java.awt.Image;

public class Juego extends InterfaceJuego
{
	private Image fondo;
	private Entorno entorno;
	private obstaculos [] ObstaculosArray;
	Mago Mago ;
	enemigos [] enemigo = new enemigos [5];
	public Menu menu;
	
	
	Juego()
	{
		
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		Mago = new Mago(50, 50,  20);
		this.menu= new Menu();
		ObstaculosArray = new obstaculos[5];
		ObstaculosArray[0] = new obstaculos(200, 150);
		ObstaculosArray[1] = new obstaculos(500, 200);
		ObstaculosArray[2] = new obstaculos(300, 400);
		ObstaculosArray[3] = new obstaculos(100, 300);
		ObstaculosArray[4] = new obstaculos(400, 500);
		
		enemigo[0] = new enemigos(100, 100);
		enemigo[1] = new enemigos(700, 100);
		enemigo[2] = new enemigos(100, 500);
		enemigo[3] = new enemigos(300, 800);
		enemigo[4] = new enemigos(400, 300);
		
		System.out.println(Arrays.toString(entorno.fontDisponibles));
		
		fondo = Herramientas.cargarImagen("imagenes/WhatsApp Image 2025-05-27 at 16.05.36 (1).jpeg");

		this.entorno.iniciar();
	}

	
	
	public void tick()
	{
		entorno.dibujarRectangulo(400, 300, 800, 600, 0, new Color(255, 253, 245));
		entorno.dibujarImagen(fondo, 300, 400, 0);
	    Mago.dibujar(entorno);
	    
		if (entorno.estaPresionada('W')) {
			Mago.moverArriba(entorno);
		}
		if (entorno.estaPresionada('s')) {
			Mago.moverAbajo(entorno);
		}
		if (entorno.estaPresionada('a')) {
			Mago.moverIzquierda(entorno);
		}
		if (entorno.estaPresionada('d')) {
			Mago.moverDerecha(entorno);
		}
		for (int i = 0; i < ObstaculosArray.length; i++) {
            ObstaculosArray[i].dibujar(entorno);
        }
		
		for (int i = 0; i < enemigo.length; i++) {
		    enemigo[i].moverHacia(Mago);
		    enemigo[i].dibujar(entorno);
		}
		
		entorno.dibujarRectangulo(700, 300, 200, 600, 0, new Color(220, 220, 220));
		menu.dibujar(entorno);
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
