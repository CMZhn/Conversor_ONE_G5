package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import procesos.Conversion;
import procesos.DirectorioImg;
import procesos.JComboboxRender;
import procesos.ListaUnidadesDist;
import procesos.ListaUnidadesMasa;
import procesos.ListaUnidadesMon;
import procesos.ListaUnidadesTemp;
import procesos.MisColores;
import procesos.MisHerramientas;
import procesos.TipoConversion;
import procesos.Validaciones;

public class MiVentanaConversion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Componentes	
	private MiPanelPrincipal contentPane;
	private JPanel PanelSuperior,PanelCentral;
	private JLabel lblEtiqueta0, lblEtiqueta1, lblEtiqueta2,lblMensaje, lblTitulo,lblicono;
	private JTextField txt1, txt2;
	private JComboBox<String> comboBox1,comboBox2;
	private MiBotonPrincipal btnMenu,btnCambio,btnCopiar;
	//Otras variables
	private Font TituloFont,SubTituloFont,GeneralFont,MensajeFont;
	private boolean PermitirIngresoNegativo=true;
	private ImageIcon iconoEncabezado;
	private TipoConversion TC;
	private Hashtable<Object,ImageIcon> Elementos;	
	private JF_Principal VentanaMenu;
	
	/**
	 * Ventana de conversion segun el tipo de Comvercion selecionado.
	 * @param TC Enum con el tipo de Conversion
	 * @VentanaMenu Ventana de menu donde se regresara al precionar el boton de Menu
	 */
	public MiVentanaConversion (TipoConversion TC, GraphicsDevice Pantalla) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TC.getTituloVentana());
		setIconImage(DirectorioImg.imgPrincipal);
	
		setSize(900, 500);
		setMinimumSize(new Dimension(900,500));
		MisHerramientas.CentrarPantalla(Pantalla, this);
		
		this.TC=TC;
				
		IniciarComponentes();
		ConfigurarComponentes();
		OrdenarComponentes();
		IngresarComponentes();
		ConfigurarAcciones();
	}
	

	private void IniciarComponentes() {
		//MiPanelPrincipal
		contentPane = new MiPanelPrincipal(this,DirectorioImg.imgFondo);				
		//JPanel-Paneles
		PanelSuperior = new JPanel();
		PanelCentral = new JPanel();
		//JLabel - Etiquetas
		lblEtiqueta0 = new JLabel("CAMBIO");
		lblEtiqueta1 = new JLabel("DE");
		lblEtiqueta2 = new JLabel("A");
		lblMensaje = new JLabel(TC.getMensaje());
		lblTitulo = new JLabel(TC.getTituloEncabezado());
		lblicono = new JLabel("");
		//JTextField - Campos de Texto
		txt1 = new JTextField();
		txt2 = new JTextField();
		//JComboBox - listas de Opciones
		comboBox1 = new JComboBox<String>();
		comboBox2 = new JComboBox<String>();
		//MiBotonPrincipal - Botones
		btnMenu = new MiBotonPrincipal("Menu",DirectorioImg.icolMenu,
										DirectorioImg.icoMenuSelec,70);
		btnCambio = new MiBotonPrincipal(DirectorioImg.icoCambio1,
										 DirectorioImg.icoCambio2,
										 DirectorioImg.icoCambioSelec1,
										 DirectorioImg.icoCambioSelec2,90);
		btnCopiar = new MiBotonPrincipal("Copiar resultado");
		//Font -Formatos de Texto
		TituloFont = new Font("Berlin Sans FB Demi", Font.BOLD, 30);
		SubTituloFont = new Font("Berlin Sans FB Demi", Font.BOLD, 25);
		GeneralFont = new Font("Berlin Sans FB", Font.PLAIN, 23);
		MensajeFont  = new Font("Berlin Sans FB Demi", Font.BOLD, 20);
		
		PermitirIngresoNegativo=TC.isPermitirNegativos();
		iconoEncabezado=MisHerramientas.icoEscalar(70, 70, TC.getIconoEncabezado());
		Elementos= new Hashtable<>();
	}
	
	public void setVentanaMenu(JF_Principal VentanaMenu) {
		this.VentanaMenu =VentanaMenu;
	}
	private void ConfigurarComponentes() {
		//MiPanelPrincipal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		//JPanel
		JPanel [] Paneles= {PanelSuperior,PanelCentral};
		for(JPanel i:Paneles) {
			i.setOpaque(false);
		}
				
		//JLabel- Etiquetas
		JLabel [] Etiquetas= {lblEtiqueta0,lblEtiqueta1,lblEtiqueta2,lblMensaje,lblTitulo};
		for(JLabel i:Etiquetas) {
			
			i.setForeground(Color.white);
			i.setHorizontalAlignment(SwingConstants.CENTER);
			i.setVerticalAlignment(SwingConstants.CENTER);
			
			if (i==lblTitulo) {
				i.setFont(TituloFont);
				
			} else if (i==lblMensaje) {
				i.setFont(MensajeFont);
				i.setHorizontalAlignment(SwingConstants.LEFT);
				
			} else {
				i.setFont(SubTituloFont);
				i.setVerticalAlignment(SwingConstants.BOTTOM);
			}
		}
		lblicono.setIcon(iconoEncabezado);
		//JTexFieles campos de Texto
		txt1.setFont(GeneralFont);
		txt2.setFont(GeneralFont);
		
		//txt1.setForeground(Color.white);
		//txt2.setForeground(Color.white);
		
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		
		//txt1.setBackground(MisColores.LogoAmarilloClaro_2);
		txt2.setBackground(MisColores.LogoAzulClaro_2);
		
		
		
		txt2.setFocusable(false);
		//txt2.setText("123");
		
		//---------JComboBox - listas de Opciones---------------------------
		comboBox1.setFont(GeneralFont);
		comboBox2.setFont(GeneralFont);
		//comboBox1.setForeground(Color.white);
		//comboBox2.setForeground(Color.white);
		
		comboBox1.setBackground(MisColores.LogoAmarilloClaro_2);
		comboBox2.setBackground(MisColores.LogoAzulClaro_2);
		
		switch (TC) {
		case MONEDA:
			for (ListaUnidadesMon Unidad : ListaUnidadesMon.values()) {
				comboBox1.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
				comboBox2.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
				Elementos.put(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad(), 
							  MisHerramientas.icoEscalar(61, 35, Unidad.getIcono()));
			}
			JComboboxRender miRender = new JComboboxRender(Elementos);
			comboBox1.setRenderer(miRender);
			comboBox2.setRenderer(miRender);
			break;
		case TEMPERATURA:
			for (ListaUnidadesTemp Unidad : ListaUnidadesTemp.values()) {
				comboBox1.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
				comboBox2.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
			}
			break;
		case DISTANCIA:
			for (ListaUnidadesDist Unidad : ListaUnidadesDist.values()) {
				comboBox1.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
				comboBox2.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
			}
			break;
		case MASA:
			for (ListaUnidadesMasa Unidad : ListaUnidadesMasa.values()) {
				comboBox1.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
				comboBox2.addItem(Unidad.getUnidad()+" - "+Unidad.getNombreUnidad());
			}
			break;
		default:
			break;
		}

		if (comboBox1.getItemCount()>=2 && comboBox2.getItemCount()>=2) {
			comboBox2.setSelectedIndex(1);
		}
		
		
		//MiBotonPrincipal - Botones
		btnCopiar.setFocusable(false);
	}
	
	private void OrdenarComponentes() {
		
		
		//Panel Superior
		GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
		gl_PanelSuperior.setHorizontalGroup(
			gl_PanelSuperior.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_PanelSuperior.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addGap(40)
					.addComponent(lblicono, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		gl_PanelSuperior.setVerticalGroup(
			gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelSuperior.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_PanelSuperior.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblicono, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		PanelSuperior.setLayout(gl_PanelSuperior);
		
		
		
		//Panel Central
		GroupLayout gl_PanelCentral = new GroupLayout(PanelCentral);
		gl_PanelCentral.setHorizontalGroup(
			gl_PanelCentral.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelCentral.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_PanelCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMensaje, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGroup(gl_PanelCentral.createSequentialGroup()
							.addGroup(gl_PanelCentral.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBox1, 0, 278, Short.MAX_VALUE)
								.addComponent(txt1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
								.addComponent(lblEtiqueta1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_PanelCentral.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_PanelCentral.createSequentialGroup()
									.addComponent(lblEtiqueta0, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblEtiqueta2, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
								.addGroup(gl_PanelCentral.createSequentialGroup()
									.addComponent(btnCambio, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_PanelCentral.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox2, 0, 278, Short.MAX_VALUE)
										.addComponent(txt2, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
										.addComponent(btnCopiar, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))))
					.addGap(40))
		);
		gl_PanelCentral.setVerticalGroup(
			gl_PanelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelCentral.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PanelCentral.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEtiqueta1, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(lblEtiqueta0, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(lblEtiqueta2, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_PanelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PanelCentral.createSequentialGroup()
							.addComponent(txt2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_PanelCentral.createSequentialGroup()
							.addComponent(txt1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCambio, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCopiar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addGap(20))
		);
		PanelCentral.setLayout(gl_PanelCentral);		
	}
	
	private void IngresarComponentes() {
		setContentPane(contentPane);
		contentPane.add(PanelSuperior, BorderLayout.NORTH);
		contentPane.add(PanelCentral, BorderLayout.CENTER);	
		
		
	}
	
	/**
	 * Metodo donde se agregan las acciones de los metodos con Lisener.
	 */
	private void ConfigurarAcciones() {
		
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				String t= txt1.getText();
				boolean Valido=Validaciones.IngresoValidoCaracterNumerico(t,key,PermitirIngresoNegativo,false);
				
				if (!Valido) {
					e.consume();
				} else if (key==Validaciones.getSeparadorDecimalLocal()) {
					//System.out.println("Entro");
					if (t.length()==0) {txt1.setText("0");}
					else if (t.length()==1) {
						if (t.contains("-")) {txt1.setText("-0");}
						else if (t.contains("+")) {txt1.setText("+0");}
					}
				}
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				AccionConversor();
			}
		});
		
		
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					comoboxseleAccion (1);
				}
			}
		});
		
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					comoboxseleAccion (2);
				}
			}
		});
		
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (VentanaMenu==null) {
					VentanaMenu = new JF_Principal();
				}
				
				CerrarVentana();
			}
		});
		
		btnCambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int IndexJCB0 = comboBox1.getSelectedIndex();
				String[] Text0= {txt1.getText(),txt2.getText()};
				Color colorInicial=comboBox1.getBackground();
				
				txt1.setText("");
				comboBox1.setSelectedIndex(comboBox2.getSelectedIndex());
				comboBox2.setSelectedIndex(IndexJCB0);
				txt1.setText(Text0[1]);
				txt2.setText(Text0[0]);
				
				//txt1.setBackground(comboBox2.getBackground());
				comboBox1.setBackground(comboBox2.getBackground());
				txt2.setBackground(colorInicial);
				comboBox2.setBackground(colorInicial);
				
			}
		});
		
		btnCopiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MisHerramientas.copy(txt2.getText());
			}
		});
		
	}
	/**
	 * Metodo que cierre la venta
	 */
	private void CerrarVentana() {
		VentanaMenu.setSize(this.getSize());
		VentanaMenu.setLocation(this.getLocation());
		VentanaMenu.setVisible(true);
		this.dispose();
	}
	/**
	 * Metodo para aplicar la comversion
	 */
	private void AccionConversor() {
		String t=txt1.getText();
		
		if (t.length()>0) {
			if (t.length()==1 && t.contains("-")) {
				txt2.setText("");
			} else {
				try {
					double d= Double.parseDouble(t);
					
					d=Conversion.Comversor(TC, d,
							comboBox1.getSelectedIndex(),
							comboBox2.getSelectedIndex());
					
					txt2.setText(String.valueOf(d));
				} catch (Exception e) {
					txt2.setText("");
				}
				
				
				
			}
			
		} else {
			txt2.setText(t);
		}
	}
	/**
	 * Metodo para cambiar los valores de los combo box.
	 * @param a
	 */
	public void comoboxseleAccion (int a) {
		if (comboBox1.getItemCount()>=2 && comboBox2.getItemCount()>=2) {
			if (comboBox1.getSelectedIndex()== comboBox2.getSelectedIndex()) {
				switch (a) {
				case 1:
					if (comboBox1.getSelectedIndex()==0) {
						comboBox2.setSelectedIndex(1);
					} else comboBox2.setSelectedIndex(0);
					break;
				case 2:
					if (comboBox2.getSelectedIndex()==0) {
						comboBox1.setSelectedIndex(1);
					} else comboBox1.setSelectedIndex(0);
					break;
				default:
					break;
				}
			}
			
			
		}
		AccionConversor();
	}

}
