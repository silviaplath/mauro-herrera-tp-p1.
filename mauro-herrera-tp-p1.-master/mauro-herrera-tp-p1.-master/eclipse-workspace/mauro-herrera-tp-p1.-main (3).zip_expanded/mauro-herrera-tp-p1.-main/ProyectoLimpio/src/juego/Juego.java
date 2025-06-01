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
	enemigos [] enemigo = new enemigos [15];
	int enemigosEnPantalla = 15;
	int siguienteEnemigo = 5;
	public Menu menu;
	ExplosionFuego fuego;
	ExplosionMagia magia;
	private int hechizoseleccionado = 0 ;
	private boolean mousePresionadoAnterior = false;
	private boolean mouseClickActual = false;
	int enemigosVivos = 0;
	private final int CostoF = 5;
	private final int CostoM = 20;
	int contadorRecarga = 0;
	Juego()
	{
		
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		Mago = new Mago(300, 300,  20);
		this.menu= new Menu();
		ObstaculosArray = new obstaculos[5];
		ObstaculosArray[0] = new obstaculos(200, 150);
		ObstaculosArray[1] = new obstaculos(500, 200);
		ObstaculosArray[2] = new obstaculos(300, 400);
		ObstaculosArray[3] = new obstaculos(100, 300);
		ObstaculosArray[4] = new obstaculos(400, 500);
		
		
		System.out.println(Arrays.toString(entorno.fontDisponibles));
		
		fondo = Herramientas.cargarImagen("imagenes/WhatsApp Image 2025-05-27 at 16.05.36 (1).jpeg");
		
		this.entorno.iniciar();
	}

	private boolean colision(double x1, double y1, double radio1, double x2, double y2, double radio2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double distancia = Math.sqrt(dx * dx + dy * dy);
        return distancia < radio1 + radio2;
    }
	
	public void tick()
	{
		entorno.dibujarRectangulo(400, 300, 700, 600, 0, new Color(255, 253, 245));
		entorno.dibujarImagen(fondo, 300, 400, 0);
	    Mago.dibujar(entorno);
	    double xAntes = Mago.x;
	    double yAntes = Mago.y;
	    
	    mouseClickActual = entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && !mousePresionadoAnterior;
	    mousePresionadoAnterior = entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO);
	    
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
		 boolean choco = false;
		    for (int i = 0; i < ObstaculosArray.length; i++) {
		        if (Mago.colisionRocas(ObstaculosArray[i])) {
		            choco = true;
		        }
		    }

		    if (Mago.colisionMenu()) {
		        choco = true;
		    }

		    if (choco) {
		        Mago.x = xAntes;
		        Mago.y = yAntes;	
		    }
		
		for (int i = 0; i < ObstaculosArray.length; i++) {
            ObstaculosArray[i].dibujar(entorno);
        }
		
		
		
		if (mouseClickActual && menu.mouseEnBotonFuego(entorno) ) {
		    hechizoseleccionado = 1;
		}
		
		if (mouseClickActual && menu.mouseEnBotonAgua(entorno) ) {
		    hechizoseleccionado = 2;
		}
		
		boolean mouseEnMenu = entorno.mouseX() > 600;
		
		if (mouseClickActual && !menu.mouseEnBotonFuego(entorno) && !menu.mouseEnBotonAgua(entorno)) {
		    if (hechizoseleccionado == 1 && Mago.Energia  >= CostoF) {
		        fuego = new ExplosionFuego(entorno.mouseX(), entorno.mouseY());
		        Mago.gastarEnergia(CostoF);
		        hechizoseleccionado = 0;
		    } else if (hechizoseleccionado == 2 && Mago.Energia >= CostoM ) {
		        magia = new ExplosionMagia(entorno.mouseX(), entorno.mouseY());
		        Mago.gastarEnergia(CostoM);
		        hechizoseleccionado = 0;
		    }
		}
		
		if (fuego != null && fuego.duracion > 0) {
		    fuego.dibujar(entorno);
		}
		
		if (magia != null && magia.duracion > 0) {
		    magia.dibujar(entorno);
		}
	
		for (int i = 0; i < enemigosEnPantalla; i++) {
		    if (enemigo[i] != null) {
		        enemigo[i].moverHacia(Mago);
		        enemigo[i].dibujar(entorno);
		        
		      
		        if (fuego != null && fuego.duracion > 0) {
		            if (colision(enemigo[i].x, enemigo[i].y, 20, fuego.x, fuego.y, 30)) {
		                enemigo[i] = null; 
		                enemigosVivos--;
		            }
		        }
		        
		        if (magia != null && magia.duracion > 0) {
		            if (colision(enemigo[i].x, enemigo[i].y, 20, magia.x, magia.y, 30)) {
		                enemigo[i] = null; 
		                enemigosVivos--;
		            }
		        }
		    }
		}
		
		for (int i = 0; i < enemigosEnPantalla; i++) {
			 if (enemigo[i] == null && siguienteEnemigo < 80) {
			  double x = 0, y = 0;
			    int lado = (int)(Math.random() * 4);

			    if (lado == 0) {          
			        x = -20;
			        y = Math.random() * 600;
			    } else if (lado == 1) {  
			        x = 820;
			        y = Math.random() * 600;
			    } else if (lado == 2) {  
			        x = Math.random() * 800;
			        y = -20;
			    } else {                  
			        x = Math.random() * 800;
			        y = 620;
			    }

			    enemigo[i] = new enemigos(x, y);
		
		    if (enemigo[i] == null && siguienteEnemigo < 80) {
		        enemigo[i] = new enemigos(Math.random() * 600 + 50, Math.random() * 500 + 50);
		        siguienteEnemigo++;
		        enemigosVivos++;
		    }
		}
			 contadorRecarga++;
			    if (contadorRecarga >= 200) {
			    	Mago.recargarEnergia(1);
			    	contadorRecarga = 0;
			    }
			   
		}
		
		entorno.dibujarRectangulo(700, 300, 200, 600, 0, new Color(220, 220, 220));
		menu.dibujar(entorno);
		menu.BarraEnergia(entorno, Mago.Energia);
}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
