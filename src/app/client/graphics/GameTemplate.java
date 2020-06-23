package app.client.graphics;

import app.client.logica.Jugador;
import app.client.logica.Tablero;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameTemplate extends JFrame{
    //Declaracion de objetos graficos y decoradores
    private JPanel p_total, fPanel1, fPanel2, fPanel1a, fPanel2a, p_turno;
    private JLabel jugador1, jugador2, punt1, punt2, fondo, lTurno;
    private Icon fondoGame;
    private JButton menu;
    private String forma;
    
    //Declaracion de servicios y tablero
    private ObjGraficosService g;
    private RecursosService r;
    private GameComponent gameComponent;
    private Tablero tablero;
    
    //Declaracion jugadores en juego
    private Jugador j1, j2;
    
    public GameTemplate(GameComponent gameComponent, Jugador j1, Jugador j2){
        this.gameComponent = gameComponent;
        
        this.j1=j1;
        this.j2=j2;
        
        r = RecursosService.getService();
        g = ObjGraficosService.getService();
        
        //Tutorial de los controles del juego
        JOptionPane.showMessageDialog(rootPane, "Bienvenido(s),\nRecuerda que para seleccionar "+
                "\nla  casilla  debes  presionar  un \nclick con el mouse", "Tutorial", 3);
        
        crearPaneles();
        this.tablero = new Tablero(gameComponent, this, p_total);
        crearJButtons();
        crearTextos();
        crearDecoracion();
        
        g.crearVentana(this, 800, 600, "Un jugador");
    }
    
    public void closeWindow(){
        setVisible(false);
    }

    public JButton getBMenu() {
        return menu;
    }
    
    public JFrame getFrame(){
        return this;
    }
    
    public JPanel getPanel(){
        return p_total;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    public GameTemplate getTemplate(){
        return this;
    }
    
    public void actualizarPuntuacion(){
        //actualizar puntuacion
        fPanel1a.remove(punt1);
        punt1 = g.texto(Integer.toString(j1.getPuntuacion()), 8, 2, 100, 35, Color.black, r.getFuenteOpcion());
        fPanel1a.add(punt1);
        fPanel1a.repaint();
        
        fPanel2a.remove(punt2);
        punt2 = g.texto(Integer.toString(j2.getPuntuacion()), 8, 2, 100, 35, Color.black, r.getFuenteOpcion());
        fPanel2a.add(punt2);
        fPanel2a.repaint();
        
        p_total.repaint();
        this.repaint();
    }
    
    public void actualizarTurno(){
        if(gameComponent.getTurno()==1){
            forma="X";
        }else{
            forma="O";
        }
        
        //Label turno de quien
        p_turno.remove(lTurno);
        lTurno = g.texto(forma, 18, 5, 40, 40, Color.black, r.getFuenteSubtitulo());
        p_turno.add(lTurno);
        p_turno.repaint();
        
        p_total.repaint();
        this.repaint();
    }
    
    private void crearPaneles(){
        //Panel contenedor de todo
        p_total = g.panel(0, 0, 800, 600, Color.lightGray);
        add(p_total);
        
        //panel turno de quien
        p_turno = g.panel(350, 32, 50, 50, Color.white);
        p_turno.setBorder(r.getBorderNegro());
        p_total.add(p_turno);
        
        //fondo de los label text nombres 1 y 2
        fPanel1 = g.panel(27, 95, 160, 80, Color.white);
        fPanel1.setBorder(r.getBorderNegro());
        p_total.add(fPanel1);
        
        fPanel2 = g.panel(595, 95, 160, 80, Color.white);
        fPanel2.setBorder(r.getBorderNegro());
        p_total.add(fPanel2);
        
        //fondo de los label text puntajes 1 y 2
        fPanel1a = g.panel(27, 175, 160, 40, Color.white);
        fPanel1a.setBorder(r.getBorderNegro());
        p_total.add(fPanel1a);
        
        fPanel2a = g.panel(595, 175, 160, 40, Color.white);
        fPanel2a.setBorder(r.getBorderNegro());
        p_total.add(fPanel2a);        
    }
    
    private void crearJButtons(){
        //Boton para ingresar al menu
        menu = g.construirJButton("Menu", 300, 470, 200, 70,r.getCursorMano(), null, r.getFuenteOpcion(), r.getColorVerdePastel(),
                Color.black, r.getBorderNegro(), "c", true);
        menu.addActionListener(gameComponent);
        p_total.add(menu);
    }
    
    private void crearTextos(){
        //Label turno de quien
        lTurno = g.texto("X", 18, 5, 40, 40, Color.black, r.getFuenteSubtitulo());
        p_turno.add(lTurno);
        
        //jugador 1 y su puntuacion
        jugador1 = g.texto(j1.getNombre(), 4, 4, 150, 70, Color.black, r.getFuenteSubtitulo());
        fPanel1.add(jugador1);
        
        punt1 = g.texto(Integer.toString(j1.getPuntuacion()), 8, 2, 100, 35, Color.black, r.getFuenteOpcion());
        fPanel1a.add(punt1);
        
        //jugador 2 y su puntuacion
        jugador2 = g.texto(j2.getNombre(), 4, 4, 150, 70, Color.black, r.getFuenteSubtitulo());
        fPanel2.add(jugador2);
        
        punt2 = g.texto(Integer.toString(j2.getPuntuacion()), 8, 2, 100, 35, Color.black, r.getFuenteOpcion());
        fPanel2a.add(punt2);
    }
    
    private void crearDecoracion(){
        //Imagen fondo Game
        fondoGame = g.icono("/resources/backgroundGame.jpg", 960, 720);
        fondo = g.labelIcono(fondoGame, 0, 0);
        p_total.add(fondo);
    }
    
}
