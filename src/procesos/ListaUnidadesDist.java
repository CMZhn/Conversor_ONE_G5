package procesos;

import javax.swing.ImageIcon;

public enum ListaUnidadesDist implements ConversorUnidadesLista {
	M	("m  ","Metro",1.0),
	MI 	("mi ","Milla",1609.34),
	YD 	("yd ","Yarda",0.9144),
	FT 	("ft ","Pie",0.3048),
	IN 	("in ","Pulgada",0.0254),
	MEM ("Mm ","Megámetro",1000000.0),
	KM  ("Km ","Kilómetro",1000.0),
	HM 	("hm ","Hectómetro",100.0),
	DAM ("dam","Decámetro",10.0),
	DM 	("dm ","Decímetro",0.1),
	CM 	("cm ","Centímetro",0.01),
	MM 	("mm ","Milímetro",0.001),
	µM 	("µm ","Micrómetro",0.000001);
	
	private String Unidad;
	private String NombreUnidad;
	private ImageIcon Icono;
	private double Factor;
	
	private ListaUnidadesDist (String Unidad,String NombreUnidad,double Factor) {
		this.Unidad=Unidad;
		this.NombreUnidad=NombreUnidad;
		this.Factor=Factor;
	}
	
	
	@Override
	public String getUnidad() {
		return this.Unidad;
	}
	
	@Override
	public String getNombreUnidad(){
		return this.NombreUnidad;
	}
	
	@Override
	public double getFactor(){
		return this.Factor;
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return this.Icono;
	}

}
