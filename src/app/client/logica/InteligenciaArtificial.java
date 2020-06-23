package app.client.logica;

import app.client.graphics.GameComponent;
import java.util.Random;

public class InteligenciaArtificial {
    private Tablero tablero;
    private Ficha[][] ficha;
    private GameComponent gameComponent;
    
    public int hacerJugada(Tablero tablero, GameComponent gameComponent){
        this.tablero = tablero;
        this.ficha = tablero.getFichas();
        this.gameComponent = gameComponent;
        
        int o; int x;
        
        
//ESTRATEGIA PRIMERA LINEA--------------------------------------------------------------------
    //Linea ofensiva
        //lineas horizontales
        for(int i=0; i<3; i++){
            o=0;
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
            if(o==2){
                for(int j=0; j<3; j++){
                    if(ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //lineas verticales
        for(int j=0; j<3; j++){
            o=0;
            for(int i=0; i<3; i++){
                if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
            if(o==2){
                for(int i=0; i<3; i++){
                    if(ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //linea diagonal principal
        o=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j && ficha[i][j].getForma().equals("O")){
                    o+=1;
                    break;
                }
            }
        }
        if(o==2){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==j && ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //linea diagonal secundaria
        o=0;
        int fila=0;
        for(int j=2; j>-1; j--){
            if(ficha[fila][j].getForma().equals("O")){
                o+=1;
                break;
            }
            fila++;
        }
        if(o==2){
            for(int j=2; j>-1; j--){
                if(ficha[fila][j].getForma().equals(" ")){
                    tablero.setFicha(fila, j, 2);
                    return 0;
                }
                fila++;
            }
        }
    //línea defensiva
        //lineas horizontales
        for(int i=0; i<3; i++){
            x=0;
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                }
            }
            if(x==2){
                for(int j=0; j<3; j++){
                    if(ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //lineas verticales
        for(int j=0; j<3; j++){
            x=0;
            for(int i=0; i<3; i++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                }
            }
            if(x==2){
                for(int i=0; i<3; i++){
                    if(ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //linea diagonal principal
        x=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j && ficha[i][j].getForma().equals("X")){
                    x+=1;
                    break;
                }
            }
        }
        if(x==2){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==j && ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //linea diagonal secundaria
        x=0;
        fila=0;
        for(int j=2; j>=0; j--){
            if(ficha[fila][j].getForma().equals("X")){
                x+=1;
            }
            fila++;
        }
        if(x==2){
            fila=0;
            for(int j=2; j>=0; j--){
                if(ficha[fila][j].getForma().equals(" ")){
                    tablero.setFicha(fila, j, 2);
                    return 0;
                }
                fila++;
            }
        }
        
//ESTRATEGIA OFENSIVA--------------------------------------------------------------------
    //Estrategia 1 (empezar en esquina)
        boolean aplica=true;
        for(int i=0; i<3; i++){
            if(aplica==false){
                break;
            }
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals(" ")!=true){
                    aplica=false;
                    break;
                }
            }
        }
        if(aplica==true){
            tablero.setFicha(cEsquinaRandom(), cEsquinaRandom(), 2);
            return 0;
        }
        
        //Estrategia 1.1(si el oponente juega en centro)
        aplica=true;
        o=0; x=0;
        if(ficha[1][1].equals("X")){
            for(int i=0; i<3; i++){
                if(aplica==false){
                    break;
                }
                for(int j=0; j<3; j++){
                    if(aplica==false){
                        break;
                    }
                    if(ficha[i][j].getForma().equals("O")){
                        o+=1;
                        if(o>1){
                            aplica=false;
                        }
                    }else if(ficha[i][j].getForma().equals("X")){
                        x+=1;
                        if(x>1){
                            aplica=false;
                        }
                    }
                }
            }
            if(aplica==true){
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(ficha[i][j].getForma().equals("O")){
                            if(i==0){
                                i=2;
                            }else{
                                i=0;
                            }
                            if(j==0){
                                j=2;
                            }else{
                                j=0;
                            }
                            tablero.setFicha(i, j, 2);
                            return 0;
                        }
                    }
                }
            }
        }
        
        //Estrategia 1.1.1(si juega a esquina)
        aplica=true;
        x=0; o=0;
        for(int i=0; i<3; i++){
            if(aplica==false){
                break;
            }
            for(int j=0; j<3; j++){
                if(aplica==false){
                    break;
                }
                if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                    if(i==1 || j==1){
                        aplica=false;
                    }
                }else if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                    if((i==1 || j==1) && i!=j){
                        aplica=false;
                    }
                }
            }
        }
        if(o!=2 || x!=2){
            aplica=false;
        }
        if(aplica==true){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(ficha[i][j].getForma().equals("X")){
                        if(i==0){
                            i=2;
                        }else{
                            i=0;
                        }
                        if(j==0){
                            j=2;
                        }else{
                            j=0;
                        }
                        tablero.setFicha(i, j, 2);
                        System.out.println("return");
                        return 0;
                    }
                }
            }
        }
        
//ESTRATEGIA DEFENSIVA-----------------------------------------------------------------
    //1(centro libre)
        x=0; o=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
        }
        if(x==1 && ficha[1][1].getForma().equals(" ") && o==0){
            tablero.setFicha(1, 1, 2);
            return 0;
        }
        //1.1 (movimiento en L)
        x=0; o=0; boolean esquina=false; boolean arista = false; int[] posicionArista = new int[2];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                    if((i==0 || i==2) && (j==0 || j==2)){
                        if(esquina==false){
                            esquina=true;
                        }else if (esquina==true){
                            esquina=false;
                        }
                    }
                    if((i==1 || j==1) && (i!=j)){
                        if(arista==false){
                            arista=true;
                            posicionArista[0] = i;
                            posicionArista[1] = j;
                        }else if (arista==true){
                            arista=false;
                        }
                    }
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
        }
        if(x==2 && ficha[1][1].getForma().equals("O") && o==1 && arista==true && esquina==true){
            if(posicionArista[0]==1){
                for(int i = 0; i<3; i++){
                    if(ficha[i][posicionArista[1]].getForma().equals(" ")){
                        tablero.setFicha(i, posicionArista[1], 2);
                        return 0;
                    }
                }
            }else if(posicionArista[1]==1){
                for(int j = 0; j<3; j++){
                    if(ficha[posicionArista[0]][j].getForma().equals(" ")){
                        tablero.setFicha(posicionArista[0], j, 2);
                        return 0;
                    }
                }
            }
        }
        //1.2(doble esquina)
        x=0; o=0; esquina=true; aplica=true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                    if(i==1 || j==1){
                        if(esquina==true){
                            esquina=false;
                        }
                    }
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                    if(i!=1 || j!=1){
                        aplica=false;
                    }
                }
            }
        }
        if(aplica==true && esquina==true && x==2 && o==1){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(ficha[i][j].getForma().equals(" ") && (i==1 || j==1) && i!=j){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
        //1.3 (doble aristas diagonales)
        x=0; o=0; aplica=true; int[] diagonal=new int[4];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    if(i!=j && (i==1 || j==1)){
                        x+=1;
                        if(x==1){
                            diagonal[0]=i;
                            diagonal[1]=j;
                        }else if(x==2){
                            diagonal[2]=i;
                            diagonal[3]=j;
                        }
                    }else{
                        aplica=false;
                    }
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
        }
        if(aplica==true && x==2 && o==1){
            if(diagonal[0]!=diagonal[2] && diagonal[1]!=diagonal[3]){
                if(ficha[diagonal[0]][diagonal[3]].getForma().equals(" ")){
                    tablero.setFicha(diagonal[0], diagonal[3], 2);
                    return 0;
                }else if(ficha[diagonal[2]][diagonal[1]].getForma().equals(" ")){
                    tablero.setFicha(diagonal[2], diagonal[1], 2);
                    return 0;
                }
            }
        }
    //2(le da al centro)
        aplica=true; x=0; o=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                    if(i!=1 || j!=1){
                        aplica=false;
                    }
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                    if(o>0){
                        aplica=false;
                    }
                }
            }
        }
        if(aplica==true && x==1){
            tablero.setFicha(cEsquinaRandom(), cEsquinaRandom(), 2);
            return 0;
        }
        //2.1 (si le da a esquina defender en esquina)
        aplica=true; x=0; o=0; boolean centro=false; esquina=false; aplica=true;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals("X")){
                    x+=1;
                    if(i!=1 && j!=1){
                        if(esquina==false){
                            esquina=true;
                        }else{
                            esquina=false;
                        }
                    }else if(i==1 && j==1){
                        centro=true;
                    }else{
                        aplica=false;
                    }
                }else if(ficha[i][j].getForma().equals("O")){
                    o+=1;
                }
            }
        }
        if(aplica==true && centro==true && esquina==true&& x==2 && o==1){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if((i!=1 || j!=1) && i!=j && ficha[i][j].getForma().equals(" ")){
                        tablero.setFicha(i, j, 2);
                        return 0;
                    }
                }
            }
        }
//ESTRATEGIA DE ULTIMO RECURSO--------------------------------------------------------------------
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ficha[i][j].getForma().equals(" ")){
                    tablero.setFicha(i, j, 2);
                    return 0;
                }
            }
        }
        return 0;
    }
    
    private int cEsquinaRandom(){
        Random r = new Random();
        int random = r.nextInt(1) + 1;
        random*=2;
        return random;
    }
}
