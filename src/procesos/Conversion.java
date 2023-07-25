package procesos;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Conversion {
	
	/**
	 * Metodo para seleccionar
	 * @param TC
	 * @throws Exception 
	 */
	public static double Comversor(TipoConversion TC,double Valor, int ValorUnidad, int ResultadoUnidad) throws Exception {
		ArrayList<Double> Factores = new ArrayList<>();
		DecimalFormat df = new DecimalFormat();
		String formato="#.00000000000000000000";
		String r;
		
		switch (TC) {
		case MONEDA:
			for (ListaUnidadesMon Unidad : ListaUnidadesMon.values()) {
				Factores.add(Unidad.getFactor());	
			}
			formato="#.0000";
			break;
		case TEMPERATURA:
			df.applyLocalizedPattern(formato);
			r=df.format(ComversorTem(Valor,ValorUnidad,ResultadoUnidad));
			return Double.valueOf(r);
		case DISTANCIA:
				for (ListaUnidadesDist Unidad : ListaUnidadesDist.values()) {
					Factores.add(Unidad.getFactor());	
				}
			break;
		case MASA:
			for (ListaUnidadesMasa Unidad : ListaUnidadesMasa.values()) {
				Factores.add(Unidad.getFactor());	
			}
			break;
		default:
			throw new Exception("Error Conversor Tipo Conversion no encontrado");
		}
		
		
		df.applyLocalizedPattern(formato);
		r=df.format(ComversorFactor(Valor,Factores.get(ValorUnidad),Factores.get(ResultadoUnidad)));
		return Double.valueOf(r);
		
	}
	
	private static double ComversorTem(double Valor, int ValorUnidad, int ResultadoUnidad) throws Exception {
		if(ValorUnidad == ResultadoUnidad) {
			return Valor;
		} else if(ValorUnidad==0) {
			switch (ResultadoUnidad) {
			case 1: // 0-1: C-> F
				return ((Valor*1.8)+32);
			case 2: // 0-2: C-> K
				return (Valor+273.15);
			default: return 0;
			}
		} else if(ValorUnidad==1) {
			switch (ResultadoUnidad) {
			case 0: // 1-0: F-> C
				return ((Valor-32)/1.8);
			case 2: // 1-2: F-> K
				return (((Valor-32)/1.8)+273.15);
			default: return 0;
			}
		}else if(ValorUnidad==2) {
			switch (ResultadoUnidad) {
			case 0: // 2-0: K-> C
				return (Valor-273.15);
			case 1: // 2-1: K-> F
				return (((Valor-273.15)*1.8)+32);
			default: return 0;
			}
		} else {throw new Exception("Fallo Conversor Temperatura ");}
	}
	
	
	private static double ComversorFactor(double Valor, double FactorValor, double FactorResultado) throws Exception {
		try {
			return ((Valor*FactorValor)/FactorResultado);
		} catch (java.lang.ArithmeticException e) {
			throw new Exception("Fallo Conversor de factor ");
		}
		
		
	}
	

}
