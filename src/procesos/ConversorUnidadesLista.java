package procesos;

import javax.swing.ImageIcon;

public interface ConversorUnidadesLista {
	/**
	 * Metodo para retornar el nombre de la unidad.
	 * @return
	 */
	public String getUnidad();
	/**
	 * Metodo que optiene el nombre de la unidad
	 * @return
	 */
	public String getNombreUnidad();
	/** 
	 * Metodo para obtener el factor de conversion cuando el tipo de conercion lo permite.
	 * @return
	 */
	public double getFactor();
	/**
	 * Metodo que retorna el ImageIcon del icono asociado a la unidad.
	 * @return
	 */
	public ImageIcon getIcono();

}
