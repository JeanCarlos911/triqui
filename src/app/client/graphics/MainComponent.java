package app.client.graphics;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;

public class MainComponent extends JFrame implements ActionListener{
    private MainTemplate mainTemplate;
    
    public MainComponent(){
        
        //Crear ventana
        this.mainTemplate = new MainTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainTemplate.getBSalir()) {
            System.exit(0);
        }
        if (e.getSource() == mainTemplate.getBUnJugador()) {
            mainTemplate.closeWindow();
            App.unJugador();
        }
        if (e.getSource() == mainTemplate.getBDosJugadores()) {
            mainTemplate.closeWindow();
            App.dosJugadores();
        }
    }

    public void setVisibilidad(boolean b) {
        mainTemplate.setVisibilidad(true);
    }
}
