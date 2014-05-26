

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class LogicGateGUI extends JFrame{
	
	private HashMap<String, ImageIcon> pictures = new HashMap<String, ImageIcon>();
	private Gate current = null;
	
	private TruthPanel tp;
	private GatesPanel gp;
	private PicturePanel pp;
	
	private JLabel headline = new JLabel("Logic gates");
	
	public LogicGateGUI(){
		init();
	}
	
	private void init(){
		setLayout(new BorderLayout(5,5));
		
		pp = new PicturePanel(updateStatusListener());
		tp = new TruthPanel();
		gp = new GatesPanel(buttonListener());
		add(tp, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5, 5));
		panel.add(gp, BorderLayout.NORTH);
		panel.add(pp, BorderLayout.CENTER);		
		add(panel, BorderLayout.CENTER);
		headline.setHorizontalAlignment(SwingConstants.CENTER);
		add(headline, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setTitle(LogicGateGUI.class.getSimpleName());
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	private ActionListener buttonListener(){
		return new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				current = Gate.valueOf(e.getActionCommand());
				updatePicture(current.toString());
				updateStatus();
				tp.updateTruthTabel(current);
				
			}
		};
	}
	
	private ItemListener updateStatusListener(){
		return new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				updateStatus();
			}
		};
	}
	
	private void updatePicture(String name){
		if(pictures.containsKey(name)){
			pp.setImageLabel(pictures.get(name));
		} else {
			try {
				BufferedImage img = ImageIO.read(ResourceLoader.load(name+".png"));
				Image dimg = img.getScaledInstance(175, 100, Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(dimg);
				pp.setImageLabel(imageIcon);
				pictures.put(name, imageIcon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	private void updateStatus(){
		TruthTables t = new TruthTables();
		String text = "";
		Boolean value = null;	
		
		switch(current){
		case OR: value = t.OR(pp.getA(), pp.getB()); break;
		case AND: value = t.AND(pp.getA(), pp.getB()); break;
		case XOR: value = t.XOR(pp.getA(), pp.getB()); break;
		case NOR: value = t.NOR(pp.getA(), pp.getB()); break;
		case NAND: value = t.NAND(pp.getA(), pp.getB()); break;
		case XNOR: value = t.XNOR(pp.getA(), pp.getB()); break;		
		default: break;
		}

		text = String.valueOf(value);
		pp.setResultText(text);
	}
}
