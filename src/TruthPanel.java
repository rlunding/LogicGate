import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


@SuppressWarnings("serial")
public class TruthPanel extends JPanel{
	
	private String ff = "";
	private String ft = "";
	private String tf = "";
	private String tt = "";
	private JTable table;
	
	private String[] columnNames = {"A", "B", "Output"};
	private String[][] data = {
			{"0", "0", ff},
			{"0", "1", ft},
			{"1", "0", tf},
			{"1", "1", tt}
	};
	private String [] OR = {"0", "1", "1", "1"};
	private String [] AND = {"0", "0", "0", "1"};
	private String [] XOR = {"0", "1", "1", "0"};
	private String [] NOR = {"1", "0", "0", "0"};
	private String [] NAND = {"1", "1", "1", "0"};
	private String [] XNOR = {"1", "0", "0", "1"};

	
	public TruthPanel(){
		setLayout(new BorderLayout());
		tableInit();
	}
	
	public void updateTruthTabel(Gate gate){
		switch(gate){
		case OR: ff = OR[0]; ft = OR[1]; tf = OR[2]; tt = OR[3]; break;
		case AND: ff = AND[0]; ft = AND[1]; tf = AND[2]; tt = AND[3]; break;
		case XOR: ff = XOR[0]; ft = XOR[1]; tf = XOR[2]; tt = XOR[3]; break;
		case NOR: ff = NOR[0]; ft = NOR[1]; tf = NOR[2]; tt = NOR[3]; break;
		case NAND: ff = NAND[0]; ft = NAND[1]; tf = NAND[2]; tt = NAND[3]; break;
		case XNOR: ff = XNOR[0]; ft = XNOR[1]; tf = XNOR[2]; tt = XNOR[3]; break;		
		default: break;
		}
		table.setValueAt(ff, 0, 2);
		table.setValueAt(ft, 1, 2);
		table.setValueAt(tf, 2, 2);
		table.setValueAt(tt, 3, 2);
	}
	
	private void tableInit(){
		table = new JTable(data, columnNames);
		add(table.getTableHeader(), BorderLayout.PAGE_START);
		add(table, BorderLayout.CENTER);
		
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
		cr.setHorizontalAlignment(JLabel.CENTER);
		TableColumn column = null;
		for(int i = 0; i < columnNames.length; i++){
			column = table.getColumnModel().getColumn(i);
			if(i == 2){
				column.setPreferredWidth(50);
			} else {
				column.setPreferredWidth(30);
			}
			column.setCellRenderer(cr);
		}
		table.setAlignmentX(CENTER_ALIGNMENT);
	}
}
