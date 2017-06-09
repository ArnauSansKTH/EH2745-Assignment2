package Project2Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class GUIdisplay3 extends JFrame {

	private JPanel contentPane3;
	private String[] column;
	private JTable table3;
	private Double[][] Table3;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIdisplay3 frame = new GUIdisplay3();
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
	public GUIdisplay3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane3 = new JPanel();
		contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane3.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane3);
		
		Table3 = KNN.getClusterFinal3();
		
		column = new String[Table3[0].length];
		for(int i=0; i < Table3[0].length; i+=2){
			column[i] = "Bus " + String.valueOf(i/2+1);
			column[i+1] = "Bus " + String.valueOf(i/2+1);
		}
		table3 = new JTable(Table3, column);
		table3.setBounds(500, 500, 675, 144);
		table3.setFillsViewportHeight(true);
		
						
		JScrollPane scroll = new JScrollPane(table3);
		scroll.setViewportView(table3);
		contentPane3.add(scroll);
		
	}

}
