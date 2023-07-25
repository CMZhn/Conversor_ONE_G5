package procesos;

import javax.swing.ImageIcon;

public enum ListaUnidadesMasa implements ConversorUnidadesLista {
	LB	("Lb ","Libra",453.59),
	KG 	("Kg ","Kilogramo",1000.0),
	OZ 	("Oz ","Onza",28.35),
	T 	("T  ","Tonelada",1000000.0),
	HG 	("hg ","Hectogramo",100.0),
	DAG ("dag","Decagramo",10.0),
	G 	("g  ","Gramo",1),
	DG 	("dg ","Decigramo",0.1),
	CG 	("cg ","Centigramo",0.01),
	MG 	("mg ","Miligramo",0.001);
	
	private String Unidad;
	private String NombreUnidad;
	private ImageIcon Icono;
	private double Factor;
	
	private ListaUnidadesMasa (String Unidad,String NombreUnidad,double Factor) {
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
