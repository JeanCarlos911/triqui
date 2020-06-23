package app.client.graphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;

import app.services.ObjGraficosService;
import app.services.RecursosService;

public class MainTemplate extends JFrame{
    
    //Declaracion de objetos graficos
    private JPanel pTotal;
    private JButton bt_unJugador, bt_dosJugadores, bt_salir;
    
    //Declaracion de objetos decoradores
    private Icon fondoMain;
    private JLabel titulo, autor, fondo;
    
    //Declaracion de servicios
    private ObjGraficosService cGraficos;
    private RecursosService cRecursos;
    private MainComponent mainComponent;
    
    public MainTemplate(MainComponent mainComponent){
        this.mainComponent = mainComponent;
        
        cRecursos = RecursosService.getService();
        cGraficos = ObjGraficosService.getService();
        
        crearPaneles();
        crearJButtons();
        crearTextos();
        crearDecoracion();
        
        cGraficos.crearVentana(this, 800, 600, "Triqui");
    }
    
    private void crearPaneles(){
        
        //panel que contiene todo
        pTotal = cGraficos.panel(0, 0, 800, 600, cRecursos.getColorVerdePastel());
        this.add(pTotal);
    }
    
    private void crearTextos(){
        
        //Titulo Triqui en ventana Main
        titulo = cGraficos.texto("Triqui", 280, 64, 300, 80, Color.black, cRecursos.getFuenteTituloJuego());
        pTotal.add(titulo);
        
        //Autor en ventana Main
        autor = cGraficos.texto("developed by Jean Carlos Santoya Cabrera", 5, 540, 300, 14, Color.black,
            cRecursos.getFuenteVersion());
        pTotal.add(autor);
    }
    
    private void crearDecoracion(){
        
        //Imagen fondo Main
        fondoMain = cGraficos.icono("/resources/backgroundMain.png", 960, 720);
        fondo = cGraficos.labelIcono(fondoMain, 0, 0);
        pTotal.add(fondo);
    }
    
    private void crearJButtons(){
        
        //Boton de un jugador
        bt_unJugador = cGraficos.construirJButton("1 Jugador", 240, 200, 290, 60,cRecursos.getCursorMano(), null,
                cRecursos.getFuenteOpcion(), cRecursos.getColorVerdePastel(), Color.black, cRecursos.getBorderNegro(), "c", true);
        bt_unJugador.addActionListener(mainComponent);
        pTotal.add(bt_unJugador);
        
        //Boton de dos jugadores
        bt_dosJugadores = cGraficos.construirJButton("2 Jugadores", 240, 270, 290, 60,cRecursos.getCursorMano(), null,
                cRecursos.getFuenteOpcion(), cRecursos.getColorVerdePastel(), Color.black, cRecursos.getBorderNegro(), "c", true);
        bt_dosJugadores.addActionListener(mainComponent);
        pTotal.add(bt_dosJugadores);
        
        //Boton salir
        bt_salir = cGraficos.construirJButton("Salir", 240, 400, 290, 60, cRecursos.getCursorMano(), null,
                cRecursos.getFuenteOpcion(), cRecursos.getColorVerdePastel(), Color.black, cRecursos.getBorderNegro(), "c", true);
        bt_salir.addActionListener(mainComponent);
        pTotal.add(bt_salir);
    }

    public JButton getBSalir(){
        return this.bt_salir;
    }

    public JButton getBUnJugador(){
        return this.bt_unJugador;
    }
    
    public JButton getBDosJugadores(){
        return this.bt_dosJugadores;
    }
    
    public void closeWindow(){
        setVisible(false);
    }

    public void setVisibilidad(boolean b) {
        setVisible(b);
    }
}
