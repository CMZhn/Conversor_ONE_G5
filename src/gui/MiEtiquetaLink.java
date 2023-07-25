package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import procesos.MisColores;
import procesos.MisHerramientas;

public class MiEtiquetaLink extends JLabel{
	
	private static final long serialVersionUID = 1L;

	private String texto, url;
	private Font fontdefault, fontmouseentered;
	private Color colortexto,
				  LinkColor=MisColores.LinkBlue,
				  ClickLinkColor=MisColores.LinkClick;
	
	private ImageIcon iconodefault,
					  iconomouseentered,
					  iconomousepressed;
	
/**
 * Constructor de etiqueta sin icono.
 * <p>
 * se utiliza el color de texto del MisColores por defecto
 * para el evento de presionar el mouse y entrar con el mouse.
 * <p>
 * utilice el metodo setLinkColor y setClickLinkColor para cambiar estos colores.
 * <p>
 * @param Texto texto que mostrara la etiqueta
 * @param Colordetexto Color de texto cuando la etiqueta no esta seleccionada o clickeado
 * @param URL direccion de la paguina web.
 * @param fontDefault tipo de texto de la etiqueta cuando no esta clickeada o seleccionada 
 * @param fontmouseEntered tipo de texto cuando se selecciona o se hace click
 */
	public MiEtiquetaLink(	String Texto,
							Color Colordetexto,
							String URL,
							Font fontDefault,
							Font fontmouseEntered) {
				
		ConfiguracionInicial(Texto,Colordetexto,URL,fontDefault,fontmouseEntered);
		Acciones();
	
	}
	
	/**
	 * Constructor de etiqueta con icono.
	 * <p>
	 * se utiliza el color de texto del MisColores por defecto
	 * para el evento de presionar el mouse y entrar con el mouse.
	 * <p>
	 * utilice el metodo setLinkColor y setClickLinkColor para cambiar estos colores.
	 * <p>
	 * @param Texto texto que mostrara la etiqueta
	 * @param Colordetexto Color de texto cuando la etiqueta no esta seleccionada o clickeado
	 * @param URL direccion de la paguina web.
	 * @param fontDefault tipo de texto de la etiqueta cuando no esta clickeada o seleccionada 
	 * @param fontmouseEntered tipo de texto cuando se selecciona o se hace click
	 * @param IconoDefault Icono cuando la etiqueta no este seleccionada o clickeada.
	 * @param IconoMouseEntered Icono cuando la etiqueta este seleccionada.
	 * @param IconoMousePressed Icono cuando la etiqueta es clickeada.
	 */
	public MiEtiquetaLink(	String Texto,
							Color Colordetexto,
							String URL,
							Font fontDefault,
							Font fontmouseEntered,
							ImageIcon IconoDefault,
							ImageIcon IconoMouseEntered,
							ImageIcon IconoMousePressed) {
		
		ConfiguracionInicial(Texto,Colordetexto,URL,fontDefault,fontmouseEntered);
		SetIconos (IconoDefault, IconoMouseEntered, IconoMousePressed);
		setIcon(iconodefault);
		AccionesConIcon();
		
	 }
	
	
	private void ConfiguracionInicial(String Texto,
			Color Colordetexto,
			String URL,
			Font fontDefault,
			Font fontmouseEntered) {
		
		this.texto=Texto;
		this.url=URL;
		this.fontdefault=fontDefault;
		this.fontmouseentered=fontmouseEntered;
		this.colortexto=Colordetexto;
		
		setText(texto);
		setForeground(colortexto);
		setFont(fontdefault);
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	//--Metodos de Acciones -----------------------------------------------------
	
	private void Acciones() {
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				AccionMousePressed();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				AccionMouseReleased();
			}
		});
	}
	
	private void AccionesConIcon() {
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered(iconomouseentered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited(iconodefault);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				AccionMousePressed(iconomousepressed);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				AccionMouseReleased(iconomouseentered);
			}
		});
	}
	
//**------------------Metodos de cada accion-----------------------***
	private void AccionMouseEntered() {
		setForeground(LinkColor);
		setFont(fontmouseentered);
	}
	private void AccionMouseEntered (ImageIcon icono) {
		AccionMouseEntered();
		setIcon(icono);
	}
	
	private void AccionMouseExited() {
		setForeground(colortexto);
		setFont(fontdefault);
	}
	private void AccionMouseExited(ImageIcon icono) {
		AccionMouseExited();
		setIcon(icono);
	}
	
	private void AccionMousePressed() {
		setFont(fontmouseentered);
		setForeground(ClickLinkColor);
		MisHerramientas.abirIntenetlink(url);
	}
	private void AccionMousePressed(ImageIcon icono) {
		AccionMousePressed();
		setIcon(icono);
	}
	
	private void AccionMouseReleased() {
		if (getForeground()!= colortexto) {
			setForeground(LinkColor);
		}
	}
	
	private void AccionMouseReleased(ImageIcon icono) {
			if (getForeground()!= colortexto) {
				AccionMouseReleased();
				setIcon(icono);
			}
		
	}
//--------Metodos Set de variables -----------------------------------
	
	public void setLinkColor(Color ColordeLink) {
		this.LinkColor=ColordeLink;
	}
	public void setsetClickLinkColor (Color ColordeClickLink) {
		this.ClickLinkColor=ColordeClickLink;
	}
	
	private void SetIconos(ImageIcon IconoDefault,
			   			   ImageIcon IconoMouseEntered,
			   			   ImageIcon IconoMousePressed) {
		this.iconodefault=IconoDefault;
		this.iconomouseentered=IconoMouseEntered;
		this.iconomousepressed=IconoMousePressed;	
	}
}

/*
  	 * @param AnchoIcono: Ancho al que se escalara las imagenes de los iconos.
	 * @param LargoIcono: Largo al que se escalara las imagenes de los iconos.

	/*private void SetIconos(	ImageIcon IconoDefault,
							ImageIcon IconoMouseEntered,
							ImageIcon IconoMousePressed,
							int Ancho, int Largo) {

		SetIconos ( MisHerramientas.icoEscalar(Ancho, Largo, IconoDefault),
					MisHerramientas.icoEscalar(Ancho, Largo, IconoMouseEntered),
					MisHerramientas.icoEscalar(Ancho, Largo, IconoMousePressed));
	}
*/


