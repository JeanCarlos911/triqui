package app.client.logica;

import app.client.graphics.GameComponent;
import app.client.graphics.GameTemplate;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero{
    private JPanel vL1, vL2, hL1, hL2, base;//verticalLine and horizontalLine
    private ObjGraficosService g;
    private GameComponent gameComponent;
    private GameTemplate gameTemplate;
    private RecursosService r;
    private Ficha[][] ficha;
    
    public Tablero(GameComponent gameComponent, JFrame frame, JPanel panel){
        this.gameComponent = gameComponent;
        
        g = ObjGraficosService.getService();
        r = RecursosService.getService();
        
        dibujarTablero(frame, panel);
        crearFichas(gameComponent);
    }
    
    public JButton getButton(int i, int j){
        JButton boton = ficha[i][j].getButton();
        return boton;
    }
    
    public void setFicha(int i, int j, int turno){
        if(turno == 1){
            ficha[i][j].setForma("X");
        }else if(turno == 2){
            ficha[i][j].setForma("O");
        }
        ficha[i][j].actualizar(0);
    }
    
    public Ficha[][] getFichas(){
        return ficha;
    }
    
    public JPanel getBase(){
        return this.base;
    }
    
    public int verificarTablero(){
        int linea = linea();
        boolean lleno = lleno();
        if(linea!=0){
            reiniciarTablero();
            return linea;
        }else if(lleno==true){
            reiniciarTablero();
            return 0;
        }else{
            return 0;
        }
    }
    
    private int linea(){
        for(int i=0; i<3; i++){
            if(ficha[i][0].getForma().equals(ficha[i][1].getForma()) && ficha[i][1].getForma().equals(ficha[i][2].getForma())){
                if(ficha[i][0].getForma().equals("X")){
                    return 1;
                }else if(ficha[i][0].getForma().equals("O")){
                    return 2;
                }
            }
        }
        for(int j=0; j<3; j++){
            if(ficha[0][j].getForma().equals(ficha[1][j].getForma()) && ficha[1][j].getForma().equals(ficha[2][j].getForma())){
                if(ficha[0][j].getForma().equals("X")){
                    return 1;
                }else if(ficha[0][j].getForma().equals("O")){
                    return 2;
                }
            }
        }
        if(ficha[0][0].getForma().equals(ficha[1][1].getForma()) && ficha[1][1].getForma().equals(ficha[2][2].getForma())){
            if(ficha[0][0].getForma().equals("X")){
                return 1;
            }else if(ficha[0][0].getForma().equals("O")){
                return 2;
            }
        }
        if(ficha[0][2].getForma().equals(ficha[1][1].getForma()) && ficha[1][1].getForma().equals(ficha[2][0].getForma())){
            if(ficha[0][2].getForma().equals("X")){
                return 1;
            }else if(ficha[0][2].getForma().equals("O")){
                return 2;
            }
        }
        return 0;
    }
    
    private boolean lleno(){
        boolean lleno=true;
        for(int i=0; i<3; i++){
            if(lleno==false){
                break;
            }
            for(int j=0; j<3; j++){
                if(lleno==false){
                    break;
                }
                if(ficha[i][j].getForma().equals(" ")){
                    lleno=false;
                    break;
                }
            }
        }
        return lleno;
    }
    
    private void reiniciarTablero(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                ficha[i][j].actualizar(-1);
            }
        }
    }
    
    private void dibujarTablero(JFrame frame, JPanel panel){
        crearPaneles(frame, panel);
        panel.repaint();
    }
    
    private void crearPaneles(JFrame frame, JPanel panel){

        //Base del tablero
        this.base = g.panel(235, 105, 310, 310, Color.white);
        this.base.setBorder(r.getBorderNegro());
        panel.add(base);
        
        //Dibujar lineas del tablero
        vL1 = g.panel(100, 4, 4, 300, Color.black);
        base.add(vL1);

        vL2 = g.panel(204, 4, 4, 300, Color.black);
        base.add(vL2);

        hL1 = g.panel(4, 100, 300, 4, Color.black);
        base.add(hL1);

        hL2 = g.panel(4, 204, 300, 4, Color.black);
        base.add(hL2);
        
    }
    
    private void crearFichas(GameComponent gameComponent){
        ficha = new Ficha[3][3];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                ficha[i][j] = new Ficha(i, j, gameComponent, base);
            }
        }
    }

}
