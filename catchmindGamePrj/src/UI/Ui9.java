package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import static javax.swing.ScrollPaneConstants.*;

import gameSound.GameSound;

public class Ui9 extends JPanel {
	public static Ui9 ui9;
	private GameSound sound;
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	
	public Ui9() {
		//sound = new GameSound("bgm/bg1.wav");
		uiTool = new UiTool();
		setLayout(null);
		uI9_DesignLayout();
		uI92_listener();
	}	
	
	public static Ui9 getUi9() {
		if (ui9 == null) {
			ui9 = new Ui9();
		}
		return ui9;
	}
	
	private void uI9_DesignLayout() {
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0,0,1100,750);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBackground(new Color(248, 254, 181));
		MainPanel.setBounds(225, 175, 550, 400);
		
		JLabel playTitle = new JLabel("서버를 시작하시겠습니까?");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(135, 45, 400, 50);
		MainPanel.add(playTitle);
		
		JTextArea Input = new JTextArea();
		JScrollPane jc = new JScrollPane(Input);
		jc.setBounds(300, 280, 400, 175);
		
		plBtn1 = new JButton("YES");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(300, 475, 100, 50);
		
		plBtn2 = new JButton("NO");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(600, 475, 100, 50);
		
		add(plBtn1);
		add(plBtn2);
		add(jc);
		add(MainPanel);
		add(plImg1);
	}
	private void uI92_listener() {
		plBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
