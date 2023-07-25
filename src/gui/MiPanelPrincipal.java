package gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiPanelPrincipal extends JPanel {
	
	
	private static final long serialVersionUID = 1L;

	private JFrame Ventana;
	private Image Fondo;
	
	/**
	 * Panel personalizado con fondo de imagen
	 * <p>
	 * @param ventana JFrame que contendra el Panel.
	 * @param fondo imagen que se utilizara de fondo.
	 */
	
	public MiPanelPrincipal(JFrame ventana, Image fondo) {
		this.Ventana=ventana;
		this.Fondo=fondo;
	}
	
	  @Override
	 public void paint(Graphics g) {
		 g.drawImage(Fondo, 0, 0, Ventana.getWidth(), Ventana.getHeight(),Ventana);
		 setOpaque(false);
		 super.paint(g);
		 
	 }

}
