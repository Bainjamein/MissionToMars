package MissionToMars.Modele;

public class Plateau{

    int         y, x;
    Robot[][]   plateau;
    
    /** Construteur de la class Plateau */
    public Plateau(int y, int x){

        this.y       = y;
        this.x       = x;
        this.plateau = new Robot[this.y][this.x];
    }

    /** Ascesseur getY */
    public int getY(){  return this.y;  }

    /** Ascesseur getX */
    public int getX(){  return this.x;  }

    /** Ascesseur plateau */
    public Robot[][] getPlateau(){  return this.plateau;    }

    /** Methode pour ajouter un robot sur le plateau */
    public void ajouterRobot(Robot robot){  this.plateau[(this.y-1) - robot.getPosY()][robot.getPosX()] = robot;    }

    /** Methode pour mettre a jour le plateau apres un deplacement */
    public void misAJourPlateau(int oldY, int oldX, int newY, int newX){

        Robot tmp = this.plateau[(this.y-1) - newY][newX]; 
        this.plateau[(this.y-1) - newY][newX] = this.plateau[(this.y-1) - oldY][oldX];
        this.plateau[(this.y-1) - oldY][oldX] = tmp;
    }

    /** Retourne le plateau en chaine de charactere */
    public String toString(){

        String str = "";

        for (Robot[] robots: this.plateau) {    
            for (Robot r: robots) {
                str += r + "\t";
            }
            str += "\n";
        }
        return str;
    }
}