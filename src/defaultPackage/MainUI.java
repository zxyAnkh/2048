package defaultPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainUI extends JFrame implements KeyListener{
	JPanel panel = new JPanel();
	JLabel lblCurrent = new JLabel("\u5F53\u524D\u5206\u6570\uFF1A");
	JLabel lblTop = new JLabel("\u6700\u9AD8\u5206\u6570\uFF1A");
	JButton btnRestart = new JButton("\u91CD\u65B0\u5F00\u59CB");
	private static JTable tbl;
	private static Object tblData[][] = new Object[4][4];
	static DefaultTableModel tblModel = new DefaultTableModel();

	public static void reloadTbl() {
		tblModel.setDataVector(tblData, tblData);
		tbl.validate();
		tbl.repaint();

	}

	public MainUI() {
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(lblCurrent);
		panel.add(lblTop);
		panel.add(btnRestart);
		tbl = new JTable(tblModel);
		tbl.setRowHeight(43);
		tbl.addKeyListener(this);
		getContentPane().add(tbl, BorderLayout.CENTER);
		reloadTbl();
		this.setTitle("2048");
		this.setSize(300, 250);
		// ∆¡ƒªæ”÷–œ‘ æ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2, (int) (height - this.getHeight()) / 2);

		this.validate();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		tblData[0][1] = 2;
		tblData[0][2] = 2;
		tblData[0][3] = 4;
		new MainUI();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Algorithm.handleEvents(e.getKeyCode(), tblData);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
