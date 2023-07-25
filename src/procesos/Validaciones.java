package procesos;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Validaciones {
	private static DecimalFormatSymbols SymbolosDecimalLocal = DecimalFormatSymbols.getInstance(Locale.getDefault());
	private static int SDL = SymbolosDecimalLocal.getDecimalSeparator();
	private static DecimalFormatSymbols SymbolosDecimalSistema = DecimalFormatSymbols.getInstance();
	private static int SDS = SymbolosDecimalSistema.getDecimalSeparator();
	
	
	
	/**
	 * Metodo para validar si el proximo caracater ingresado es valido para un campo numerico.
	 * 
	 * @param TextoBase texto que ya este ingresado en el texFile.
	 * @param KeyIntroducida nuevo caracter a ingresar.
	 * @param SimboloNegativo se permite el ingreso del caracater 45 (-)
	 * @param SimboloPositivo se permite el ingreso del caracater 43 (+)
	 * @return Verdadero si es valido el proximo ingreso.
	 */
	public static boolean IngresoValidoCaracterNumerico(
									String TextoBase,
									int KeyIntroducida,
									boolean SimboloNegativo,
									boolean SimboloPositivo) {
		char c=(char)SDL;
		
		if(KeyIntroducida>=48 && KeyIntroducida<=57) {
			return true;
		} else if (KeyIntroducida==43 || KeyIntroducida==45) {
			if (TextoBase.length()==0) {
					if(KeyIntroducida==43 && SimboloPositivo) {return true;}
					else if (KeyIntroducida==45 && SimboloNegativo) {return true;}
					else {return false;}
			} else {return false;}
		} else if(KeyIntroducida==SDL) {
			if (TextoBase.length()==0) {return true;}
			else if (TextoBase.contains(String.valueOf(c))) {return false;}
			else {return true;}			
		} else {return false;}
	}
	
	/**
	 * Metodo para obtener el separador decimal local que utiliza la JVM.
	 * <p> 
	 * @return Entero con el numero ASCII del caracter que se utiliza localmente para separar los decinmales
	 */
	public static int getSeparadorDecimalLocal () {
		return SDL;
	}
	
	/**
	 * Metodo para obtener el separador decimal configurado en el sistema operativo.
	 * <p> 
	 * @return Entero con el numero ASCII del caracter configurado en el sistema operativo para separar los decinmales
	 */
	public static int getSeparadorDecimalSOP () {
		return SDS;
	}
}
