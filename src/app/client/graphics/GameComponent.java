package app.client.graphics;

import app.App;
import app.client.logica.Jugador;
import app.client.logica.Tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameComponent implements ActionListener{
    private GameTemplate gameTemplate;
    private Tablero tablero;
    private Jugador j1, j2;
    private static int juego=1;
    private int turno;
    
    public GameComponent(int numeroJugadores){
        //Crear Jugadores
        establecerJugadores(numeroJugadores);
        
        //Crear ventana con tutorial y tablero con fichas
        this.gameTemplate = new GameTemplate(this, j1, j2);
        this.tablero = gameTemplate.getTablero();
        
        //Iniciar Juego
        iniciarJuego(j1, j2);
    }
    
    public void setTurno(int turno){
        this.turno=turno;
    }
    
    public void siguienteTurno(){
        int punto = this.tablero.verificarTablero();
        if(punto==1){
            punto=0;
            j1.sumarPuntuacion();
            gameTemplate.actualizarPuntuacion();
        }else if(punto==2){
            punto=0;
            j2.sumarPuntuacion();
            gameTemplate.actualizarPuntuacion();
        }
        gameTemplate.actualizarTurno();
        if(turno==1){
            j1.pedirTurno(this.tablero, this);
        }else{
            j2.pedirTurno(this.tablero, this);
            if(j2.getTipo().equals("bot")){
                setTurno(1);
                siguienteTurno();
            }
        }
    }
    
    public int getTurno(){
        return turno;
    }
    
    private void terminarJuego(){
        turno=3;
    }
    
    private void establecerJugadores(int numJugadores){
        if(numJugadores == 1){
            j1 = new Jugador("jugador", 1);
            j2 = new Jugador("pc", 2);
        }else if(numJugadores == 2){
            j1 = new Jugador("jugador", 1);
            j2 = new Jugador("jugador", 2);
        }
    }
    
    private void iniciarJuego(Jugador j1, Jugador j2){
        turno = 1;
        if(juego==1){
            if(turno%2!=0){
                j1.pedirTurno(this.tablero, this);
            }else{
                j2.pedirTurno(this.tablero, this);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == gameTemplate.getBMenu()) {
            gameTemplate.closeWindow();
            this.terminarJuego();
            App.ventanaMenu();
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if (e.getSource() == tablero.getButton(i, j)){
                    tablero.setFicha(i, j, turno);
                    
                    if(turno == 1){
                        turno = 2;
                    }else{
                        turno = 1;
                    }
                    siguienteTurno();
                }
            }
        }
    }
}