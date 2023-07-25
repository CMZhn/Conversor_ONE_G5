package procesos;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DirectorioImg {
	
	private static String
		urlPrincipal = "/logos/IcoConversor.png",
		urlGitHubB ="/logos/logoGitHubBlue32.png",
		urlGitHubO ="/logos/logoGitHubOrange32.png",
		urlGitHubW ="/logos/logoGitHubWhite32.png",
		urlFondo ="/imagenes/DarkIronBackground2000.jpg",
		urlMoneda ="/logos/LogoMoneda.png",
		urlMonedaAnimada="/logos/LogoMonedaAnimado.gif",
		urlTemperatura="/logos/LogoTemperatura.png",
		urlTemperaturaAnimada="/logos/LogoTemperaturaAnimado.gif",
		urlMasa="/logos/LogoMasa.png",
		urlMasaAnimada="/logos/LogoMasaAnimado.gif",
		urlDistancia="/logos/LogoDistancia.png",
		urlDistanciaAnimada="/logos/LogoDistanciaAnimado.gif",
		urlMenu ="/logos/LogoMenu.png",
		urlMenuSelec ="/logos/LogoMenuSelecionado.png",
		urlCambio1 ="/logos/LogoCambio1.png",
		urlCambio2 ="/logos/LogoCambio2.png",
		urlCambioSelec1 ="/logos/LogoCambio3.png",
		urlCambioSelec2 ="/logos/LogoCambio4.png",
		urlBRL ="/logos/LogoP_BRL.png",
		urlCAD ="/logos/LogoP_CAD.png",
		urlCNY ="/logos/LogoP_CNY.png",
		urlCRC ="/logos/LogoP_CRC.png",
		urlEUR ="/logos/LogoP_EUR.png",
		urlGBP ="/logos/LogoP_GBP.png",
		urlGTQ ="/logos/LogoP_GTQ.png",
		urlHNL ="/logos/LogoP_HNL.png",
		urlJPY ="/logos/LogoP_JPY.png",
		urlKRW ="/logos/LogoP_KRW.png",
		urlNIO ="/logos/LogoP_NIO.png",
		urlUSD ="/logos/LogoP_USD.png",
		urlMXN ="/logos/LogoP_MXN.png";


	//--Imagenes Iconos ----
	
	public static final ImageIcon 
		icoGitHubB = new ImageIcon (DirectorioImg.class.getResource(urlGitHubB)),
		icoGitHubO = new ImageIcon (DirectorioImg.class.getResource(urlGitHubO)),
		icoGitHubW = new ImageIcon (DirectorioImg.class.getResource(urlGitHubW)),
		icoMoneda = new ImageIcon (DirectorioImg.class.getResource(urlMoneda)),
		icoMonedaAnimada = new ImageIcon (DirectorioImg.class.getResource(urlMonedaAnimada)),
		icoTemperatura= new ImageIcon (DirectorioImg.class.getResource(urlTemperatura)),
		icoTemperaturaAnimada= new ImageIcon (DirectorioImg.class.getResource(urlTemperaturaAnimada)),
		icoMasa= new ImageIcon (DirectorioImg.class.getResource(urlMasa)),
		icoMasaAnimada= new ImageIcon (DirectorioImg.class.getResource(urlMasaAnimada)),
		icoDistancia= new ImageIcon (DirectorioImg.class.getResource(urlDistancia)),
		icoDistanciaAnimada= new ImageIcon (DirectorioImg.class.getResource(urlDistanciaAnimada)),
		icolMenu =new ImageIcon (DirectorioImg.class.getResource(urlMenu)),
		icoMenuSelec =new ImageIcon (DirectorioImg.class.getResource(urlMenuSelec)),
		icoCambio1 =new ImageIcon (DirectorioImg.class.getResource(urlCambio1)),
		icoCambio2 =new ImageIcon (DirectorioImg.class.getResource(urlCambio2)),
		icoCambioSelec1 =new ImageIcon (DirectorioImg.class.getResource(urlCambioSelec1)),
		icoCambioSelec2 =new ImageIcon (DirectorioImg.class.getResource(urlCambioSelec2)),
		icoBRL = new ImageIcon (DirectorioImg.class.getResource(urlBRL)),
		icoCAD = new ImageIcon (DirectorioImg.class.getResource(urlCAD)),
		icoCNY = new ImageIcon (DirectorioImg.class.getResource(urlCNY)),
		icoCRC = new ImageIcon (DirectorioImg.class.getResource(urlCRC)),
		icoEUR = new ImageIcon (DirectorioImg.class.getResource(urlEUR)),
		icoGBP = new ImageIcon (DirectorioImg.class.getResource(urlGBP)),
		icoGTQ = new ImageIcon (DirectorioImg.class.getResource(urlGTQ)),
		icoHNL = new ImageIcon (DirectorioImg.class.getResource(urlHNL)),
		icoJPY = new ImageIcon (DirectorioImg.class.getResource(urlJPY)),
		icoKRW = new ImageIcon (DirectorioImg.class.getResource(urlKRW)),
		icoNIO = new ImageIcon (DirectorioImg.class.getResource(urlNIO)),
		icoUSD = new ImageIcon (DirectorioImg.class.getResource(urlUSD)),
		icoMXN = new ImageIcon (DirectorioImg.class.getResource(urlMXN));

	//-- Imagenes-----------
	
	public static final Image 
		imgFondo =Toolkit.getDefaultToolkit().getImage(DirectorioImg.class.getResource(urlFondo)),
		imgPrincipal = Toolkit.getDefaultToolkit().getImage(DirectorioImg.class.getResource(urlPrincipal));

	
	


	
}
