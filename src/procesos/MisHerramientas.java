package procesos;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MisHerramientas {
	/**
	 * Metodo para abrir paguina web
	 * @param link Direccion de paguina web que desea abrir en el explorador
	 */
	public static void abirIntenetlink (String link) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			
			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(link);
					desktop.browse(uri);
				}catch (URISyntaxException | IOException e) {
				
				}
			}
		}
	}
	/**
	 * Metodo de escalado de imagen tipo ImageIcon.
	 * @param Ancho Ancho al que se desea escalar la imagen
	 * @param Alto Alto al que se desea escalar la imagen
	 * @param icono imagen tipoImagenIcon que se desea escalar
	 * @return Una imagen clase ImageIcon escalada.
	 */
	public static ImageIcon icoEscalar (int Ancho, int Alto, ImageIcon icono) {
		ImageIcon i =new ImageIcon (icono.getImage().getScaledInstance(Ancho, Alto, Image.SCALE_DEFAULT));
		return i;
	}
	/**
	 * Metodo de escalado de imagen tipo Image.
	 * @param Ancho Ancho Ancho al que se desea escalar la imagen
	 * @param Alto Alto Alto al que se desea escalar la imagen
	 * @param imagen icono Image tipoImagenIcon que se desea escalar
	 * @return Una imagen clase Image escalada.
	 */
	public static Image imgEscalar (int Ancho, int Alto, Image imagen) {
		return imagen.getScaledInstance(Ancho, Alto, Image.SCALE_DEFAULT);
	}
	
	/**
	 * Metodo que copia un texto al Clipboard.
	 * <p> 
	 * @param text texto que se copiara
	 */
	 public static void copy(String text)
	    {
		 	Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(new StringSelection(text), null);
	    }
	 
	 /**
	  * Metodo que optiene una pantalla del ambiente grafico
	  * a partir de un indice.
	  * <p>
	  * Si el indice no es valido, se retorna la pantalla por defecto
	  * del ambiente grafico.
	  * @param IndicePantalla
	  * @return
	  */
	 public static GraphicsDevice Pantalla (int IndicePantalla) {
		 
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 GraphicsDevice[] gd = ge.getScreenDevices();
		 
		 if( IndicePantalla > -1 && IndicePantalla < gd.length ) {
			 return gd[IndicePantalla];
		    }
		 
		 	return ge.getDefaultScreenDevice();
	 }
	
	 /**
	  * Método para obtener el índice de la pantalla donde se encuentra la ventana.
	  * @param Ventana
	  * @return Índice de la Pantalla el ambiente grafico.
	  */
	public static int getPantallaIndice (JFrame Ventana) {
		 try {
			 GraphicsConfiguration config = Ventana.getGraphicsConfiguration();
				GraphicsDevice myScreen = config.getDevice();
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				GraphicsDevice[] gds = ge.getScreenDevices();
				int  PantallaIndice = 0;
				for (int i = 0; i < gds.length; i++) {
					if (gds[i].equals(myScreen)) {
						PantallaIndice=i;
						break;
					};	
				}
				return PantallaIndice;
		} catch (Exception e) {
			 return 0;
		}
		 
	 }
	/**
	 * Metodo para obtener la pantalla de la ventana
	 * @param Ventana
	 * @return
	 */
	public static GraphicsDevice Pantalla (JFrame Ventana) {
		
		GraphicsConfiguration config = Ventana.getGraphicsConfiguration();
		GraphicsDevice myScreen = config.getDevice();
		return myScreen;

	}
	
	/**
	 * Metodo para centrar la pantalla.
	 * @param Pantalla
	 * @param Ventana
	 */
	public static void CentrarPantalla(GraphicsDevice Pantalla , JFrame Ventana) {
        
        int dx = 0, dy = 0;

        GraphicsConfiguration gc = Pantalla.getDefaultConfiguration();
        Rectangle gcBounds = gc.getBounds();
 
        int OrigenPantallaX=gcBounds.x;
        int OrigenPantallaY=gcBounds.y;
        int AnchoPantallaX =  gcBounds.width;
        int largoPantallaY =  gcBounds.height;

        dx = OrigenPantallaX + (AnchoPantallaX/2) - Ventana.getSize().width / 2;
        dy = OrigenPantallaY + (largoPantallaY/2) - Ventana.getSize().height / 2;

        Ventana.setLocation(dx, dy);
    }
	
	
	/**
	 * Metodo para guardar el indice de pantalla que actualmente se esta utilizando
	 *
	 * @param IndicePantalla
	 */
	public static void GuardarPantalla(int IndicePantalla) {
		File archivo;
		FileWriter escribir;
		PrintWriter linea;
		
		archivo=new File("ini.txt");
		
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		try {
			escribir = new FileWriter(archivo,false);
			linea = new PrintWriter(escribir);
			linea.println(IndicePantalla);
			linea.close();
			escribir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para obtener la ultima pantalla utilizada
	 * @return
	 */
	public static int getUtimaPantallaIndice() {
		File archivo;
		FileReader leer;
		BufferedReader almacenamiento;
		String texto;
		
		archivo=new File("ini.txt");
		
		if (!archivo.exists()) {
			GuardarPantalla(0);
			return 0;
		}
		
		
			try {
				leer = new FileReader(archivo);
				almacenamiento = new BufferedReader(leer);
				texto= almacenamiento.readLine();
				almacenamiento.close();
				return Integer.valueOf(texto);
				
			} catch (IOException e) {
				e.printStackTrace();
				
				return 0;
			} catch (java.lang.NumberFormatException e) {
				GuardarPantalla(0);
				
				return 0;
			}
			
		
	}
	
}
