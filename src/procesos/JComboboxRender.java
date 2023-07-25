package procesos;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class JComboboxRender extends JLabel implements ListCellRenderer<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hashtable<Object,ImageIcon> Elementos;
	//ImageIcon defaultIcono;
	
	public JComboboxRender(Hashtable<Object,ImageIcon> Elementos) {
		this.Elementos=Elementos;
	}
	
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		if(Elementos.get(value)==null) {
			//setIcon(defaultIcono);
		}else {
			setIcon(Elementos.get(value));
		}
			setText (value.toString());
		
		return this;
	}

}
