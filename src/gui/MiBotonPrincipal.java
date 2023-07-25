package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import procesos.MisColores;
import procesos.MisHerramientas;

public class MiBotonPrincipal extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Font 
		BtnDefaultFont,
		BtnMouseEnteredFont,
		BtnFosusedFont;
	private ImageIcon icono_1, icono_2, icono_3, icono_4;
	private int tamañoIconos;
	private boolean noEnfocable=false;
	private int ultimoIcono=0;
	
	
	/**
	 * Constructor de boton sin confirgurar iconos.
	 * @param TextoBoton
	 * @author Carlos Melgar
	 */
	public MiBotonPrincipal(String TextoBoton) {
		setText(TextoBoton);
		ConfiguracionGeneral();
		Acciones();
	}

	/**
	 * Contructor de boton con eventos programados.
	 * <p>
	 * Se creará un boton donde el texto cambiara de color y tamaño al entrar o salir con el mouse,
	 * tambien al enfocarse o desenfocarse.
	 * <p>
	 * Tambien se configurará iconos escalados cuadradamente con TamañoIconos ingresado,
	 * estos iconos se alternara al entrar o salir con el mouse y enfocarse o desenfocarse.
	 * 
	 * @param TextoBoton Texto del boton.
	 * @param IconoNoAnimado Incono por defecto.
	 * @param IconoAnimado Incono utilizado al seleccionar con el mouse o entrar al boton.
	 * @param TamañoIconos tamaño al que se escalara los dos iconos.
	 * @param IconoAnimadoEstatico falso si el gif se cargara cada vez que se ingrese con el mouse o se seleccione.
	 * <p> se recomienda uso de icono estatico, cuando la imagen es un gif ciclico o no no se esta utilizando un gif.
	 * @author Carlos Melgar
	 */
	public MiBotonPrincipal (String TextoBoton,
								ImageIcon IconoNoAnimado,
								ImageIcon IconoAnimado,
								int TamañoIconos,
								boolean IconoAnimadoEstatico) {
		tamañoIconos = TamañoIconos;
		icono_1 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, IconoNoAnimado);
		if(IconoAnimadoEstatico) {
			icono_3 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, IconoAnimado);
		}else {
			icono_3 = IconoAnimado;
		}
		setText(TextoBoton);
		ConfiguracionGeneral();
		
		setIcon(icono_1);
		Acciones(icono_1,icono_3,IconoAnimadoEstatico);
		
		
	}
	/**
	 * Constructor de boton NO ENFOCABLE con cuatro iconos escalados cuadradamente.
	 * <p>
	 * Al crear un boton con este constructor, el icono del boton se alterna cada vez que se hace click.
	 * tambien se cambia el icono al entrar o salir con el mouse, segun el icono alternado, 
	 * IconoSeleccion_1 corresponde al icono_1, y viceversa.
	 * @param icono_1 Icono por defecto.
	 * @param icono_2 Icono icono de alternacion.
	 * @param IconoSeleccion_1 icono por defeto.
	 * @param IconoSeleccion_2 icono al seleccionar con mouse de alternacion.
	 * @param TamañoIconos dimension a la que se escalara el icono.
	 * @author Carlos Melgar
	 */
	public MiBotonPrincipal (ImageIcon Icono_1,
							 ImageIcon Icono_2,
							 ImageIcon IconoSeleccion_1,
							 ImageIcon IconoSeleccion_2,
							 int TamañoIconos) {
		tamañoIconos = TamañoIconos;
		
		icono_1 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, Icono_1);
		icono_2 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, Icono_2);
		icono_3 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, IconoSeleccion_1);
		icono_4 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, IconoSeleccion_2);
		
		setFocusable(false);
		noEnfocable=true;
		ConfiguracionGeneral();
		setIcon(icono_1);
		ultimoIcono=1;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered();
				switch (ultimoIcono){
				case 1:
					setIcon(icono_3);
					break;
				case 2:
					setIcon(icono_4);
					break;
				default:
					ultimoIcono=0;
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited();
				switch (ultimoIcono){
				case 1:
					setIcon(icono_1);
					break;
				case 2:
					setIcon(icono_2);
					break;
				default:
					ultimoIcono=0;
				}	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				switch (ultimoIcono){
				case 1:
					setIcon(icono_4);
					ultimoIcono=2;
					break;
				case 2:
					setIcon(icono_3);
					ultimoIcono=1;
					break;
				default:
					ultimoIcono=0;
				}
			}
		});		
	}
	
	/**
	 * Constructor de boton NO ENFOCABLE, con iconos escalados cuadradamente.
	 * <p>
	 * Se cambiara el icnono al entrar o salir con el Mouse, entrar Icono_2, salir Icono_1
	 * @param TextoBoton Texto del boton.
	 * @param Icono_1 Icono utilizado al salir con el mouse.
	 * @param Icono_2 Icono utilizado al entrar con el mouse.
	 * @param TamañoIconos tamaño al que se escalara los iconos cuadradamente.
	 * @author Carlos Melgar
	 */
	public MiBotonPrincipal (String TextoBoton,
							 ImageIcon Icono_1,
							 ImageIcon Icono_2,
							 int TamañoIconos) {
		tamañoIconos = TamañoIconos;
		icono_1 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, Icono_1);
		icono_2 = MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, Icono_2);
		setText(TextoBoton);
		ConfiguracionGeneral();
		setFocusable(false);
		noEnfocable=true;
		setIcon(icono_1);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered();
				setIcon(icono_2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited();
				setIcon(icono_1);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		
	}
	
	
	/**
	 * Metodo donde se configura las caracteristicas generales del Boton
	 */
	private void ConfiguracionGeneral () {
		
		BtnDefaultFont = new Font("Berlin Sans FB Demi", Font.BOLD, 20);
		BtnMouseEnteredFont = new Font("Berlin Sans FB Demi", Font.BOLD, 27);
		BtnFosusedFont = new Font("Berlin Sans FB Demi", Font.BOLD, 27);
		
		setForeground(Color.white);
		setFont(BtnDefaultFont);
		
		setBackground(Color.BLACK);
		setOpaque(false);
		
		setBorderPainted(false);
		setFocusPainted(false);
	}
	/**
	 * Metodo de Acciones sin Icono
	 */
	private void Acciones(){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited();
			}
		});
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				AccionfocusGained();
			}

			@Override
			public void focusLost(FocusEvent e) {
				AccionfocusLost();
			}
		});
		
	}
	/**
	 * Metodo de acciones con Icono estatico y icono gif
	 * @param IconoNoAnimado
	 * @param IconoAnimado
	 * @param Estatico
	 */
	private void Acciones(ImageIcon IconoNoAnimado,ImageIcon IconoAnimado,boolean Estatico){
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AccionMouseEntered(IconoAnimado,Estatico);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AccionMouseExited(IconoNoAnimado);
			}
		});
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				AccionfocusGained(IconoAnimado,Estatico);
			}

			@Override
			public void focusLost(FocusEvent e) {
				AccionfocusLost(IconoNoAnimado);
			}
		});
		
	}
	
	//**------------------Metodos de cada accion-----------------------***
		private void AccionMouseEntered() {
			setForeground(MisColores.LogoAmarilloClaro);
			
			if (getFont()!=BtnFosusedFont) {
				setFont(BtnMouseEnteredFont);
			}
	
		}
		private void AccionMouseEntered (ImageIcon icono, boolean Estatico) {
			AccionMouseEntered();
			if (getFont()!=BtnFosusedFont) {
				if (Estatico) {
					setIcon(icono);
				} else {
					setIcon(MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, icono));
				}
			}
			
		}
		
		private void AccionMouseExited() {
			setForeground(Color.white);
			
			if (getFont()!=BtnFosusedFont) {
				setFont(BtnDefaultFont);	
			}

		}
		private void AccionMouseExited(ImageIcon icono) {
			AccionMouseExited();
			if (getFont()!=BtnFosusedFont) {
				setIcon(icono);	
			}	

		}
		
		private void AccionfocusGained() {
			setFont(BtnFosusedFont);	
		}
		private void AccionfocusGained(ImageIcon icono, boolean Estatico) {
			AccionfocusGained();
			if (Estatico) {
				setIcon(icono);
			} else {
				setIcon(MisHerramientas.icoEscalar(tamañoIconos, tamañoIconos, icono));
			}
		}
		
		public void AccionfocusLost() {
			if (getForeground()!=MisColores.LogoAmarilloClaro) {

				setForeground(Color.white);
				setFont(BtnDefaultFont);
			}
			
		}
		public void AccionfocusLost(ImageIcon icono) {
			AccionfocusLost();
			if (getForeground()!=MisColores.LogoAmarilloClaro) {
				setIcon(icono);
			}
			
		}
///Sobre escritura de metodos
		@Override
		public void setFocusable(boolean focusable) {
			if (noEnfocable) {
				super.setFocusable(false);
			}else {super.setFocusable(focusable);}
		}
}
