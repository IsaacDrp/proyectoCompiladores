package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public abstract class ComponentesJuego {
	protected int x;
	protected int y;
	protected String imagen;
	protected int velocidad;
	
	
	public ComponentesJuego(int x, int y, String imagen, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.imagen = imagen;
		this.velocidad = velocidad;
	}
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public abstract void pintar(GraphicsContext graficos);
	public abstract void teclado(KeyEvent evento,boolean presiona);
	public abstract void raton(KeyEvent evento);
	public abstract void logicaCalculos();
}
