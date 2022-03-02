package MissionToMars.Vue;

import MissionToMars.Controleur.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
	
	private JPanel 		panelPrincipal;
	private JPanel 		panelHaut;
	private JPanel 		panelMilieu;
	private JPanel 		panelBas;

	private JLabel 		labelHaut;

	private JPanel[][] 	ensPanels;
	
	private JTextField 	textField;
	private JButton 	button;

	private Controleur 	ctrl;
	
	/** Constructeur de la class fenetre  */
	public Fenetre(Controleur ctrl){

		this.ctrl = ctrl;
		this.setTitle("MissionToMars");
		this.setSize(1000,500);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

		this.setPanelPrincipal();
		this.setPanelHaut();
		this.setPanelMilieu();
		this.setPanelBas();

		this.button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ctrl.deplacer(textField.getText());
			}
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** Setter du panel principal  */ 
	public void setPanelPrincipal(){

		this.panelPrincipal = new JPanel();
		this.panelPrincipal.setLayout( new BorderLayout());
	}

	/** Setter du panel tout en haut  */ 
	public void setPanelHaut(){

		this.panelHaut = new JPanel();
		this.panelHaut.setLayout( new FlowLayout() );
		this.labelHaut = new JLabel(ctrl.getRobot().toString());
		this.panelHaut.add(this.labelHaut);
		
		this.panelPrincipal.add (this.panelHaut, "North");
	}

	/** Setter du panel du milieu */ 
	public void setPanelMilieu(){

		this.panelMilieu = new JPanel();
		this.panelMilieu.setLayout( new GridLayout(ctrl.getPlateau().getY(), ctrl.getPlateau().getX()));
		this.ensPanels  = new JPanel[ctrl.getPlateau().getY()][ctrl.getPlateau().getX()];

		for( int cpt = 0; cpt < this.ctrl.getPlateau().getY(); cpt++){
			for( int cpt2 = 0; cpt2 < this.ctrl.getPlateau().getX(); cpt2++){

				this.ensPanels[cpt][cpt2] = new JPanel();

				if(this.ctrl.getPlateau().getPlateau()[cpt][cpt2] == null){

					this.ensPanels[cpt][cpt2].setBackground(Color.WHITE);
				}
				else{
					this.ensPanels[cpt][cpt2].setBackground(Color.RED);
				}
		
				this.ensPanels[cpt][cpt2].setBorder(BorderFactory.createLineBorder(Color.BLACK, 3 ));

				this.panelMilieu.add ( this.ensPanels[cpt][cpt2] );
			}
		}

		this.panelPrincipal.add (this.panelMilieu);
	}

	/** Setter du panel du bas */ 
	public void setPanelBas(){

		this.panelBas = new JPanel();
		this.panelBas.setLayout( new GridLayout(0,1 ));
		this.textField = new JTextField();
		this.panelBas.add(textField);
		this.button = new JButton("Valider");
		this.panelBas.add(button);
		this.panelPrincipal.add (this.panelBas, "South");
		this.add(panelPrincipal);
	}

	/** Methode qui permet d'actualiser la fenetre, apres un deplacement */
	public void misAJour(){
		
		this.labelHaut.setText(ctrl.getRobot().toString());

		for( int cpt = 0; cpt < this.ctrl.getPlateau().getY(); cpt++){
			for( int cpt2 = 0; cpt2 < this.ctrl.getPlateau().getX(); cpt2++){

				if(this.ctrl.getPlateau().getPlateau()[cpt][cpt2] == null){

					this.ensPanels[cpt][cpt2].setBackground(Color.WHITE);
				}
				else{
					this.ensPanels[cpt][cpt2].setBackground(Color.RED);
				}
			}	
		}
	}
}