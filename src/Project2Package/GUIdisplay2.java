package Project2Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class GUIdisplay2 extends JFrame {

	private JPanel contentPane2;
	private String[] column;
	private JTable table2;
	private Double[][] Table2;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIdisplay2 frame = new GUIdisplay2();
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
	public GUIdisplay2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane2);
		
		Table2 = KNN.getClusterFinal2();
		
		column = new String[Table2[0].length];
		for(int i=0; i < Table2[0].length; i+=2){
			column[i] = "Bus " + String.valueOf(i/2+1);
			column[i+1] = "Bus " + String.valueOf(i/2+1);
		}
		table2 = new JTable(Table2, column);
		table2.setBounds(500, 500, 675, 144);
		table2.setFillsViewportHeight(true);
		
						
		JScrollPane scroll = new JScrollPane(table2);
		scroll.setViewportView(table2);
		contentPane2.add(scroll);
		

	}

}
