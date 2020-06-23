/*
    @author Jean Carlos Santoya Cabrera
    Este programa tiene el propósito de emular el juego tres en linea con interfaz gráfica 
    Última edición 05/jun/2020
 */
package app;

import app.client.graphics.MainComponent;
import app.client.graphics.GameComponent;

public class App {
    
    public static void main(String args[]){
        App main = new App();
    }
    
    public App(){
        MainComponent ventanaMain = new MainComponent();
    }
    
    public static void unJugador(){
        GameComponent ventana = new GameComponent(1);
    }
    
    public static void dosJugadores(){
        GameComponent ventana = new GameComponent(2);
    }
    
    public static void ventanaMenu(){
       MainComponent ventanaMain = new MainComponent();
    }
}
