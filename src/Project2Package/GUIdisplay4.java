package Project2Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class GUIdisplay4 extends JFrame {

	private JPanel contentPane4;
	private String[] column;
	private JTable table4;
	private Double[][] Table4;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIdisplay4 frame = new GUIdisplay4();
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
	public GUIdisplay4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		contentPane4 = new JPanel();
		contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane4.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane4);
		
		Table4 = KNN.getClusterFinal4();
		
		column = new String[Table4[0].length];
		for(int i=0; i < Table4[0].length; i+=2){
			column[i] = "Bus " + String.valueOf(i/2+1);
			column[i+1] = "Bus " + String.valueOf(i/2+1);
		}
		table4 = new JTable(Table4, column);
		table4.setBounds(500, 500, 675, 144);
		table4.setFillsViewportHeight(true);
		
						
		JScrollPane scroll = new JScrollPane(table4);
		scroll.setViewportView(table4);
		contentPane4.add(scroll);
		
	}

}
