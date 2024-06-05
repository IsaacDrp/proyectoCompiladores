package fes.aragon.interprete;

import fes.aragon.extras.MusicaCiclica;
import fes.aragon.modelo.Fondo;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Inicio extends Application {
    private GraphicsContext graficos;
    private Group root;
    private Scene escena;
    private Canvas hoja;
    private Thread hiloFondo;
    private Fondo fondo;
    private Stage ventana;

    @Override
    public void start(Stage ventana) {
        this.ventana = ventana;
        componentesIniciar();
        pintar();
        eventosTeclado();
        this.ventana.setScene(escena);
        this.ventana.setTitle("Interprete");
        this.ventana.show();
        ciclo();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void stop() throws Exception {
        hiloFondo.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void componentesIniciar() {
        root = new Group();
        escena = new Scene(root, 600, 600);
        hoja = new Canvas(600, 600);
        root.getChildren().add(hoja);
        graficos = hoja.getGraphicsContext2D();
        MusicaCiclica entrada = new MusicaCiclica("musica_entrada");
        hiloFondo = new Thread(entrada);
        //hiloFondo.start();
        fondo = new Fondo(55, 55, "/fes/aragon/imagenes/derecha.png", 2, ventana);

    }

    public void ciclo() {
        long tiempoInicio = System.nanoTime();
        AnimationTimer tiempo = new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicio) / 1000000000.0;
                calculosLogica();
                pintar();


            }
        };
        tiempo.start();
    }

    private void pintar() {
        this.fondo.pintar(graficos);
    }

    private void calculosLogica() {
        this.fondo.logicaCalculos();

    }

    private void eventosTeclado() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                // TODO Auto-generated method stub
                fondo.teclado(arg0, true);
            }
        });

    }
}