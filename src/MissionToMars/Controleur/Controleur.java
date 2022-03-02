package MissionToMars.Controleur;

import MissionToMars.Vue.*;
import MissionToMars.Modele.*;

public class Controleur{

    Fenetre fenetre;
    Plateau plateau;
    Robot   robot;
    
    /** Construteur de la class Controleur */
    public Controleur(){

        this.plateau    = new Plateau(5, 10);
        this.robot      = new Robot(0, 0, 'N', this);
        this.plateau.ajouterRobot(robot);
        this.fenetre    = new Fenetre(this);
    }

    /** Ascesseur fenetre */
    public Fenetre getFenetre(){    return this.fenetre;    }

    /** Ascesseur plateau */
    public Plateau getPlateau(){    return this.plateau;    }

    /** Ascesseur robot */
    public Robot getRobot(){        return this.robot;      }

    /** Methode qui envoie une String de deplacement pour le robot sur le plateau et mettre a jour la fenetre */
    public void deplacer(String str){
        
        this.robot.deplacer(str);
        this.fenetre.misAJour();
    }

    public static void main(String args[]){ new Controleur();   }   
}
