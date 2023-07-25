package procesos;

import javax.swing.ImageIcon;

public enum ListaUnidadesMon implements ConversorUnidadesLista {
	USD	("USD","Dólar",1.0,DirectorioImg.icoUSD),
	HNL	("HNL","Lempira",0.040656685,DirectorioImg.icoHNL),
	EUR	("EUR","Euros",1.1129,DirectorioImg.icoEUR),
	GBP	("GBP","Libras Esterlinas",1.2856,DirectorioImg.icoGBP),
	JPY	("JPY","Yen Japonés",0.007053,DirectorioImg.icoJPY),
	MXN	("MXN","Peso mexicano",0.05886,DirectorioImg.icoMXN),
	NIO	("NIO","Córdoba",0.02736,DirectorioImg.icoNIO),
	GTQ	("GTQ","Quetzal",0.1275,DirectorioImg.icoGTQ),
	CRC	("CRC","Colón costarricense",0.001866,DirectorioImg.icoCRC),
	BRL	("BRL","Real brasileño",0.2094,DirectorioImg.icoBRL),
	CAD	("CAD","Dólar canadiense",0.7558,DirectorioImg.icoCAD),
	CNY	("CNY","Yuan Chino",0.1391,DirectorioImg.icoCNY),
	KRW	("KRW","Won sul-coreano",10.0007772,DirectorioImg.icoKRW);
	
	private String Unidad;
	private String NombreUnidad;
	private ImageIcon Icono;
	private double Factor;
	
	private ListaUnidadesMon (String Unidad,String NombreUnidad,double Factor,ImageIcon Icono) {
		this.Unidad=Unidad;
		this.NombreUnidad=NombreUnidad;
		this.Factor=Factor;
		this.Icono=Icono;
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
		return this.Icono;
	}
}
