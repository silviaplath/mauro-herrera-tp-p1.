package juego;
import entorno.Entorno;
import java.awt.Color;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private obstaculos [] ObstaculosArray;
	Mago Mago ;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		Mago = new Mago(50, 50,  20);
		
		ObstaculosArray = new obstaculos[5];
		ObstaculosArray[0] = new obstaculos(200, 150);
		ObstaculosArray[1] = new obstaculos(600, 200);
		ObstaculosArray[2] = new obstaculos(300, 400);
		ObstaculosArray[3] = new obstaculos(500, 350);
		ObstaculosArray[4] = new obstaculos(400, 500);
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		entorno.dibujarRectangulo(400, 300, 800, 600, 0, new Color(255, 253, 245));
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
		
		// Procesamiento de un instante de tiempo
		// ...
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
