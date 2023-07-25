package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import procesos.DirectorioImg;
import procesos.MisHerramientas;
import procesos.TipoConversion;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class JF_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MiPanelPrincipal panelPrincipal;
	private JPanel panelCentral;
	private MiBotonPrincipal btnMoneda, btnTemperatura, btnDistancia,btnMasa;
	private JPanel panelInferior;
	private JLabel lblTituloPanelPrincipal, lblPieVentana, lblAutor;
	private MiEtiquetaLink lblGitHub;
	private JF_Principal EstaVentana= this;

	
	
	
	private Font 
		LinkmouseEntered = new Font("Tahoma", Font.PLAIN, 20),
		LinkDefault = new Font("Tahoma", Font.PLAIN, 18);

	
	
	/**
	 * Venta principal.
	 * <p>
	 * Aqui se muestran los votones para acceder en las diferentes
	 * ventas de coveversion
	 * <p>
	 * <li>Moneda
	 * <li>Temperatura
	 * <li>Distancia
	 * <li>Masa
	 * @param Pantalla
	 * 
	 * @author Carlos Melgar
	 */
	public JF_Principal() {
	
		setTitle("PANEL PRINCIPAL CONVERSOR");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(DirectorioImg.imgPrincipal);
		setSize(900, 500);
		setMinimumSize(new Dimension(900,500));
		int Pantalla=MisHerramientas.getUtimaPantallaIndice();
		MisHerramientas.CentrarPantalla(MisHerramientas.Pantalla(Pantalla), this);
		
		iniciarComponentes();
		ConfigurarAcciones();
		
	}
	
	private void iniciarComponentes () {
		panelPrincipal = new MiPanelPrincipal(this,DirectorioImg.imgFondo);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(10, 10));
		
		setContentPane(panelPrincipal);	
		
//----------------OTROS COMPONENTES EN EL PANEL PRINCIPAL-----------------------
		
		lblTituloPanelPrincipal = new JLabel("Panel principal conversor");
		lblTituloPanelPrincipal.setForeground(Color.WHITE);
		lblTituloPanelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPanelPrincipal.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		panelPrincipal.add(lblTituloPanelPrincipal, BorderLayout.NORTH);
		
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelCentral.setLayout(new GridLayout(2, 2, 10, 10));
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
//- Botones del Menu pricipal---------------------------------------------------------------
		btnMoneda = new MiBotonPrincipal(
				"Moneda",DirectorioImg.icoMoneda,DirectorioImg.icoMonedaAnimada,100,false);
		
		panelCentral.add(btnMoneda);
		
		btnTemperatura = new MiBotonPrincipal(
				"Temperatura",DirectorioImg.icoTemperatura,DirectorioImg.icoTemperaturaAnimada,100,false);
		panelCentral.add(btnTemperatura);
		
		btnDistancia = new MiBotonPrincipal(
				"Distancia",DirectorioImg.icoDistancia,DirectorioImg.icoDistanciaAnimada,100,false);
		panelCentral.add(btnDistancia);
		
		btnMasa = new MiBotonPrincipal(
				"Masa",DirectorioImg.icoMasa,DirectorioImg.icoMasaAnimada,100,false);
		panelCentral.add(btnMasa);
		
		
//--------------------------------------PANEL INFERIOR--------------------
		panelInferior = new JPanel();
		panelInferior.setOpaque(false);
		panelInferior.setLayout(new GridLayout(3, 1, 10, 10));
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		lblPieVentana = new JLabel("Back End Challenge ONE - Creado por:");
		lblPieVentana.setFont(LinkDefault);
		lblPieVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieVentana.setForeground(Color.GRAY);
		panelInferior.add(lblPieVentana);
		
		lblAutor = new JLabel("Carlos Melgar");
		lblAutor.setFont(LinkDefault);
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(Color.GRAY);
		panelInferior.add(lblAutor);
		
		lblGitHub = new MiEtiquetaLink(
				"CMZhn", Color.GRAY, "https://github.com/CMZhn/Conversor_ONE_G5.git", 
				LinkDefault, LinkmouseEntered,DirectorioImg.icoGitHubW,
				DirectorioImg.icoGitHubB, DirectorioImg.icoGitHubO);

		panelInferior.add(lblGitHub);
		
	}
	
	private void ConfigurarAcciones() {
		btnMoneda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MiVentanaConversion VC = new MiVentanaConversion(TipoConversion.MONEDA,MisHerramientas.Pantalla(EstaVentana));
				CerrarVentana(VC);
			}
		});
		
		btnTemperatura.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MiVentanaConversion VC = new MiVentanaConversion(TipoConversion.TEMPERATURA,MisHerramientas.Pantalla(EstaVentana));
				CerrarVentana(VC);	
			}
		});
		
		btnDistancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MiVentanaConversion VC = new MiVentanaConversion(TipoConversion.DISTANCIA,MisHerramientas.Pantalla(EstaVentana));
				CerrarVentana(VC);
			}
		});
		
		btnMasa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MiVentanaConversion VC = new MiVentanaConversion(TipoConversion.MASA,MisHerramientas.Pantalla(EstaVentana));
				CerrarVentana(VC);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        ActualizarINI();
		        System.exit(0);;
		    }
		});
		
	}
	private void CerrarVentana(MiVentanaConversion VC) {
		VC.setSize(this.getSize());
		VC.setLocation(this.getLocation());
		VC.setVisible(true);
		VC.setVentanaMenu(this);
		ActualizarINI();
		this.setVisible(false);
		//this.dispose();
	}
	private void ActualizarINI() {
		MisHerramientas.GuardarPantalla(MisHerramientas.getPantallaIndice(this));
	}
	
	
}
