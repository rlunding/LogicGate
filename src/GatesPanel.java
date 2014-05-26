import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class GatesPanel extends JPanel{

	private JRadioButton or;
	private JRadioButton and;
	private JRadioButton xor;
	private JRadioButton nor;
	private JRadioButton nand;
	private JRadioButton xnor;
	private JRadioButton [] buttons = {or, and, xor, nor, nand, xnor};
	private Gate [] buttonNames = {Gate.OR, Gate.AND, Gate.XOR, Gate.NOR, Gate.NAND, Gate.XNOR};
	private ButtonGroup group;
	
	public GatesPanel(ActionListener al){
		setLayout(new GridLayout(2,3));
		buttonInit(al);
	}
	
	private void buttonInit(ActionListener al){
		group = new ButtonGroup();
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JRadioButton(buttonNames[i].toString());
			buttons[i].setActionCommand(buttonNames[i].toString());
			buttons[i].addActionListener(al);
			group.add(buttons[i]);
			add(buttons[i]);
		}
		buttons[0].doClick();
	}
}
