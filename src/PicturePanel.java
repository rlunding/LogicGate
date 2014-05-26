import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PicturePanel extends JPanel{
	
	private JCheckBox a = new JCheckBox("A");
	private JCheckBox b = new JCheckBox("B");
	private JLabel picture = new JLabel();
	private JLabel result = new JLabel("0");

	public PicturePanel(ItemListener al){
		init(al);
	}
	
	public void setResultText(String text){
		result.setText(text);
	}
	
	public void setImageLabel(ImageIcon image){
		picture.setIcon(image);
	}
	
	public boolean getA(){
		return a.isSelected();
	}
	
	public boolean getB(){
		return b.isSelected();
	}
	
	private void init(ItemListener al){
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new GridLayout(3,1));
		a.addItemListener(al);
		b.addItemListener(al);
		boxPanel.add(a);
		boxPanel.add(new JPanel());
		boxPanel.add(b);
		add(boxPanel);
		
		add(picture);
		add(result);
	}
}
