package app.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ObjGraficosService{
    private JPanel panel;
    private JLabel label;
    private Font fuente;
    private ImageIcon iIcono;
    private JButton button;
    private Border borde;
    
    static private ObjGraficosService servicio;
    
    private ObjGraficosService(){
    }
    
    public JPanel panel(int x, int y, int ancho, int largo, Color color){
        panel = new JPanel();
        panel.setBounds(x, y, ancho, largo);
        panel.setLayout(null);
        panel.setBackground(color);
        return panel;
    }
    
    public JLabel labelIcono(Icon icono, int x, int y){
        label = new JLabel();
        label.setSize(icono.getIconWidth(), icono.getIconHeight());
        label.setLocation(x, y);
        label.setIcon(icono);
        return label;
    }
    
    /**
     * Este metodo retorna un label con texto
     *
     * @param cadena cadena a mostrar en panel
     * @param x posicion x del texto 
     * @param y posicion y del texto
     * @param ancho ancho del label del texto
     * @param alto alto del label del texto
     * @param colorFuente color del texto
     * @param fuente fuente del texto
     **/
    public JLabel texto(String cadena, int x, int y, int ancho, int alto, Color colorFuente,Font fuente){        
        label= new JLabel(cadena);
        label.setSize(ancho, alto);
        label.setLocation(x, y);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        return label;
    }
    
    /**
     * Este metodo retorna un icono
     *
     * @param ruta ruta del icono
     * @param width ancho de la imagen
     * @param height alto de la imagen
     **/
    public Icon icono(String ruta, int width, int height){
        iIcono = new ImageIcon(getClass().getResource(ruta));
        Icon icono = new ImageIcon(iIcono.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));;
        return icono;
    }
    
    //Darle propiedades y hacer visible a una ventana-----------------------------
    public void crearVentana(JFrame frame, int ancho, int alto, String titulo){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        frame.setSize(ancho, alto);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public JButton construirJButton(
        String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente, 
        Color colorFondo, Color colorFuente,Border borde, String direccion, boolean esSolido
    ){
        button= new JButton(texto);
        button.setSize(ancho, alto);
        button.setLocation(x, y);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(imagen);
        button.setBorder(borde);
        button.setContentAreaFilled(esSolido);
        switch(direccion){
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return button;
    }
    
    
    public static ObjGraficosService getService(){
        if(servicio==null){
            servicio = new ObjGraficosService();
        }
        return servicio;
    }
}
