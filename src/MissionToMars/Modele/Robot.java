package MissionToMars.Modele;

import MissionToMars.Controleur.*;

public class Robot{

    private int     posX, posY; 
    private char    compassPoint;

    private Plateau plateau;    

    /** Construteur de la class Robot */
    public Robot(int posY, int posX, char compassPoint, Controleur ctrl){ 

        this.posX           = posY;
        this.posY           = posX;
        this.compassPoint   = compassPoint;
        this.plateau        = ctrl.getPlateau();
    }

    /** Ascesseur posX */
    public int getPosX(){           return this.posX;   }

    /** Ascesseur posY */
    public int getPosY(){           return this.posY;   }

    /** Ascesseur compassPoint */
    public char getCompassPoint(){  return this.compassPoint;   }

    /** Ascesseur plateau */
    public Plateau getPlateau(){    return this.plateau;    }

    /** Setter posX */
    public void setPosX(int posX){  this.posX = posX;   }

    /** Setter posY */
    public void setPosY(int posY){  this.posY = posY;   }

    /** Setter compassPoint */
    public void setCompassPoint(char compassPoint){ this.compassPoint = compassPoint;   }

    /** Setter plateau */
    public void setPlateau(Plateau plateau){        this.plateau = plateau; }

    /** Methode pour verifier si le deplacement est possible, si c'est le cas elle deplace le robot  */
    public void verifDeplacement(int newY, int newX){
        
        if(newY <= this.plateau.getY()-1 && newY >= 0 && newX <= this.plateau.getX()-1 && newX >= 0 ){

            this.plateau.misAJourPlateau(this.getPosY(), this.getPosX(), newY, newX);
            this.setPosY(newY);
            this.setPosX(newX);
        }
    }

    /** Methode pour deplacer/orienter le robot sur le plateau */
    public void deplacer(String str){
        
        char[] tabCompass = {'W', 'N', 'E', 'S', 'W', 'N' };
        boolean bool = true; 

        for(int cpt = 0; cpt < str.length(); cpt++){

            if(str.charAt(cpt) == 'L')
                for(int cpt2 = 1; cpt2 < tabCompass.length; cpt2++)
                    if(this.compassPoint == tabCompass[cpt2] && bool == true){
                        this.setCompassPoint(tabCompass[cpt2-1]);
                        bool = false;
                    }
                bool = true;
            
            if(str.charAt(cpt) == 'R')
                for(int cpt2 = 1; cpt2 < tabCompass.length; cpt2++)
                    if(this.compassPoint == tabCompass[cpt2] && bool == true){
                        this.setCompassPoint(tabCompass[cpt2+1]);
                        bool = false;
                    }
                bool = true;
            
            if(str.charAt(cpt) == 'F' && this.getCompassPoint() == 'N' || str.charAt(cpt) == 'B' && this.getCompassPoint() == 'S' )
                    this.verifDeplacement(posY+1, this.posX);
            if(str.charAt(cpt) == 'B' && this.getCompassPoint() == 'N' || str.charAt(cpt) == 'F' && this.getCompassPoint() == 'S' )
                    this.verifDeplacement(posY-1, this.posX);
            if(str.charAt(cpt) == 'F' && this.getCompassPoint() == 'W' || str.charAt(cpt) == 'B' && this.getCompassPoint() == 'E' )
                    this.verifDeplacement(this.posY ,posX-1);
            if(str.charAt(cpt) == 'B' && this.getCompassPoint() == 'W' || str.charAt(cpt) == 'F' && this.getCompassPoint() == 'E' )
                    this.verifDeplacement(this.posY ,posX+1);            
        }
    }
    
    /** Retourne une chaine de charactere ex : "4 4 N" */
    public String toString(){   return this.posX + " " + this.posY + " " + this.compassPoint;   }
}
