package app.client.logica;

import app.client.graphics.GameComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jugador extends JFrame{
    //Declaracion atributos del jugador
    private InteligenciaArtificial pc;
    private String nombre;
    private String tipo;
    private int numJugador;
    private int puntuacion;
    
    public Jugador(String control, int numJugador){
        if(control.equals("jugador")){
            nombre = JOptionPane.showInputDialog(rootPane, "Inserte nombre del jugador " + numJugador, "Registro", 3);
            tipo = "humano";
        }else if(control.equals("pc")){
            nombre = "pc";
            tipo = "bot";
            pc = new InteligenciaArtificial();
        }
        this.numJugador = numJugador;
        puntuacion = 0;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public int getNumJugador(){
        return numJugador;
    }
    
    public void sumarPuntuacion(){
        puntuacion+=1;
    }
    
    public void pedirTurno(Tablero tablero, GameComponent gameComponent){
        if(tipo.equals("bot")){
            pc.hacerJugada(tablero, gameComponent);
        }
    }
}
