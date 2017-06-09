package Project2Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class GUIdisplay1 extends JFrame {

	private JPanel contentPane;
	private String[] column;
	private JTable table;
	private Double[][] Table1;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIdisplay1 frame = new GUIdisplay1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIdisplay1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Table1 = KNN.getClusterFinal1();
		
		column = new String[Table1[0].length];
		for(int i=0; i < Table1[0].length; i+=2){
			column[i] = "Bus " + String.valueOf(i/2+1);
			column[i+1] = "Bus " + String.valueOf(i/2+1);
		}
		table = new JTable(Table1, column);
		table.setBounds(500, 500, 675, 144);
		table.setFillsViewportHeight(true);
		
						
		JScrollPane scroll = new JScrollPane(table);
		scroll.setViewportView(table);
		contentPane.add(scroll);
		
		
	}

}
