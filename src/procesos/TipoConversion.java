package procesos;

import javax.swing.ImageIcon;

public enum TipoConversion {
	MONEDA ("Moneda","Comversion de Moneda",
			"",false,DirectorioImg.icoMoneda),
	
	TEMPERATURA("Temperatura","Comversion de Temperatura",
			    "",
				true,DirectorioImg.icoTemperatura),
	
	DISTANCIA("Distancia","Comversion de Distancia",
			"",false,DirectorioImg.icoDistancia),
	
	MASA("Masa","Comversion de Masa",
			"",false,DirectorioImg.icoMasa);

	private String TituloVentana, TituloEncabezado, Mensaje;
	private boolean PermitirNegativos;
	private  ImageIcon IconoEncabezado;

	
	private TipoConversion(String TituloVentana,
			  String TituloEncabezado,
			  String Mensaje,
			  boolean PermitirNegativos,
			  ImageIcon IconoEncabezado) {
		
		this.TituloVentana=TituloVentana;
		this.TituloEncabezado=TituloEncabezado; 
		this.Mensaje=Mensaje;
		this.PermitirNegativos=PermitirNegativos;
		this.IconoEncabezado=IconoEncabezado;
		
	}

	/**
	 * Metodo para obtener el titulo de la ventana de conversion
	 * @return Texto
	 */
	public String getTituloVentana() {
		return this.TituloVentana;
	}
	/**
	 * Método para obtener el titulo del Encabezado
	 * @return Texto
	 */
	public String getTituloEncabezado() {
		return this.TituloEncabezado;
	}
	/**
	 * Método para obtener el texto por defecto en el pie de la ventana
	 * @return Texto
	 */
	public String getMensaje() {
		return this.Mensaje;
	}
	/**
	 * Método para obtener si es o no permitido el ingreso de numero negativos,
	 * (verdadero significa que si se permite)
	 * @return Verdadero o Falso
	 */
	public boolean isPermitirNegativos() {
		return this.PermitirNegativos;
	}
	/**
	 * Método para obtener el icono del encabezado.
	 * @return Imagen icono
	 */
	public ImageIcon getIconoEncabezado() {
		return this.IconoEncabezado;
	}
	
	
	

}
