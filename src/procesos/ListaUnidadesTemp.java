package procesos;

import javax.swing.ImageIcon;

public enum ListaUnidadesTemp implements ConversorUnidadesLista{
	C ("°C","Celsius"),
	F ("°F","Fahrenheit"),
	K (" K","Kelvin");
	
	private String Unidad;
	private String NombreUnidad;
	private ImageIcon Icono;
	
	///------------------------------------------------
	private ListaUnidadesTemp (String Unidad,String NombreUnidad) {
		this.Unidad=Unidad;
		this.NombreUnidad=NombreUnidad;
	}
	private ListaUnidadesTemp (String Unidad,String NombreUnidad,ImageIcon Icono) {
		this.Unidad=Unidad;
		this.NombreUnidad=NombreUnidad;
		this.Icono=Icono;
	}
	///------------------------------------------------
	
	@Override
	public String getUnidad() {
		return this.Unidad;
	}
	
	@Override
	public String getNombreUnidad(){
		return this.NombreUnidad;
	}
	
	@Override
	public double getFactor() {
		return 0;
	}
	
	@Override
	public ImageIcon getIcono() {
		return this.Icono;
	}

}
