package app.client.logica;

import app.client.graphics.GameComponent;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ficha {
    private int i, j;
    private String forma;
    private JButton boton;
    private JPanel base;
    
    private ObjGraficosService g;
    private RecursosService r;
    private GameComponent gameComponent;
    
    public Ficha(int i, int j, GameComponent gameComponent, JPanel base){
        g = ObjGraficosService.getService();
        r = RecursosService.getService();
        
        this.gameComponent = gameComponent;
        this.base = base;
        this.i = i;
        this.j = j;
        
        reestablecer();
    }
    
    public void reestablecer(){
        forma = formaInicial();
        this.boton = botonInicial();
        base.add(this.boton);
    }
    
    public void actualizar(int i){
        if(i==0 && this.forma != " "){
            base.remove(this.boton);
            this.boton = botonFinal();
            base.add(this.boton);
            base.repaint();
        }else if(i==-1){
            base.remove(this.boton);
            forma = formaInicial();
            this.boton = botonInicial();
            base.add(this.boton);
        }
    }
    
    public void setForma(String form){
        this.forma = form;
    }
    
    public String getForma(){
        return forma;
    }
    
    public JButton getButton(){
        return this.boton;
    }
    
    private JButton botonInicial(){
        JButton botonInicial = g.construirJButton(" ", i*99+4+i*4, j*99+4+j*4, 95, 95,r.getCursorMano(),
                null, null, Color.white, null, null, "c", true);
        botonInicial.addActionListener(this.gameComponent);
        return botonInicial;
    }
    
    private JButton botonFinal(){
        JButton botonFinal = g.construirJButton(this.forma, i*99+4+i*4, j*99+4+j*4, 95, 95, null,
                null, r.getFuenteTitulo(), Color.white, Color.black, null, "c", true);
        return botonFinal;
    }
    
    private String formaInicial(){
        String formaInicial = " ";
        return formaInicial;
    }
}
