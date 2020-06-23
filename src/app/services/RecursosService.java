package app.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class RecursosService {
    private Color cyan, cyanOscuro, verdeClaro, verde, verdePastel, morado, moradoClaro;
    private Font fuenteTitulo, fuenteVersion, fuenteOpcion, fuenteTituloJuego, fuenteSubtitulo;
    private Cursor cMano;
    private Border borderGris, borderNegro;
    private int size;
    
    static private RecursosService servicio;
    
    private RecursosService(){
    //Paletas de colores----------------------------------------------------------
        //paleta estándar
        cyan = new Color(72, 206, 247);
        cyanOscuro = new Color(70, 147, 171);
        
        //paleta verde pastel complementario
        verdeClaro = new Color(193, 255, 171);
        verde = new Color(122, 179, 102);
        verdePastel = new Color(212, 255, 196);
        morado = new Color(179, 84, 167);
        moradoClaro = new Color(255, 171, 245);
        
    //Fuentes---------------------------------------------------------------------
        //fuentes estándar
        fuenteTitulo = new Font("Gill Sans MT Condensed", Font.PLAIN, 64);
        fuenteSubtitulo = new Font("Gill Sans MT Condensed", Font.PLAIN, 32);
        fuenteTituloJuego = new Font("Imprint MT Shadow", Font.PLAIN, 72);
        fuenteVersion = new Font("Arial", Font.PLAIN, 14);
        fuenteOpcion = new Font("Arial Narrow", Font.PLAIN, 18);
        
    //Cursores
        //cursores estándar
        cMano = new Cursor(Cursor.HAND_CURSOR);
        
    //Borders
        //bordes estándar
        borderNegro = BorderFactory.createLineBorder(Color.black, 2, true);
        borderGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
    }
    
    public Color getColorCyan(){
        return cyan;
    }
    
    public Color getColorCyanOscuro(){
        return cyanOscuro;
    }
    
    public Color getColorVerdeClaro(){
        return verdeClaro;
    }
    
    public Color getColorVerde(){
        return verde;
    }
    
    public Color getColorVerdePastel(){
        return verdePastel;
    }
    
    public Color getColorMorado(){
        return morado;
    }
    
    public Color getColorMoradoClaro(){
        return moradoClaro;
    }
    
    public Font getFuenteTitulo(){
        return fuenteTitulo;
    }
    
    public Font getFuenteSubtitulo(){
        return fuenteSubtitulo;
    }
    
    public Font getFuenteTituloJuego(){
        return fuenteTituloJuego;
    }
    
    public Font getFuenteVersion(){
        return fuenteVersion;
    }
    
    public Font getFuenteOpcion(){
        return fuenteOpcion;
    }
    
    public Cursor getCursorMano(){
        return cMano;
    }
    
    public Border getBorderGris(){
        return borderGris;
    }
    
    public Border getBorderNegro(){
        return borderNegro;
    }
    
    public static RecursosService getService(){
        if(servicio == null){
            servicio = new RecursosService();
        }
        return servicio;
    }
}
