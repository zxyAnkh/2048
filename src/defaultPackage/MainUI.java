package defaultPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainUI extends JFrame implements KeyListener {
	private JPanel panel = new JPanel();
	private JLabel lblCurrent = new JLabel("当前分数：");
	private JLabel lblTop = new JLabel("最高分数：");
	private JButton btnRestart = new JButton("重新开始");
	private static JTable tbl;
	private static Object tblData[][] = new Object[4][4];
	static DefaultTableModel tblModel = new DefaultTableModel();

	public void reloadTbl() {
		tblModel.setDataVector(tblData, tblData);
		tbl.validate();
		tbl.repaint();
	}

	private void resetTbl(){
		int count = 0;
		tblData = new Object[4][4];
		while(count != 5){
			int row = (int)(Math.random() * 4);
			int column = (int)(Math.random() * 4);
			if(tblData[row][column] == null){
				tblData[row][column] = 2;
	    		count++;
			}
		}
		reloadTbl();
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
		btnRestart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Algorithm.resetScore();
				int score = Algorithm.getScore();
				lblCurrent.setText("当前分数：" + score);
				resetTbl();
			}
		});
		this.setTitle("2048");
		this.setSize(300, 250);
		// 屏幕居中显示
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
		/* 测试数据 */
		tblData[0][1] = 2;
		tblData[0][2] = 2;
		tblData[0][3] = 2;
		tblData[1][1] = 2;
		tblData[2][1] = 2;
		new MainUI();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Algorithm.handleEvents(e.getKeyCode(), tblData);
		tblData = Algorithm.getData();
		int score = Algorithm.getScore();
		this.lblCurrent.setText("当前分数：" + score);
		this.reloadTbl();
		if(Algorithm.isFull())
			System.out.println("full");
		if(Algorithm.isEnd()){
			JOptionPane.showMessageDialog(this, "游戏结束！", "通知", EXIT_ON_CLOSE, null);
		}
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
