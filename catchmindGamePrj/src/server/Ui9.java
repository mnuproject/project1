package server;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import UI.MainFrame;
import UI.UiTool;

import static javax.swing.ScrollPaneConstants.*;

import gameSound.GameSound;

public class Ui9 extends JPanel {
	public static Ui9 ui9;
	public static JLabel playTitle;
	public static JTextArea Input;
	
	private JPanel MainPanel;
	private TextField IpInput;
	private TextField ServerInput;
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	private JPanel M1Panel;
	
	
	public Ui9() {
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
		
		MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBackground(new Color(248, 254, 181));
		MainPanel.setBounds(225, 175, 550, 400);
		
		playTitle = new JLabel("서버를 시작하시겠습니까?");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(135, 45, 400, 50);
		MainPanel.add(playTitle);
		
		IpInput = new TextField("localhost");
		IpInput.setBounds(200, 110, 300, 40);
		MainPanel.add(IpInput);
		
		ServerInput = new TextField("3000");
		ServerInput.setBounds(200, 200, 300, 40);
		MainPanel.add(ServerInput);
		
		JLabel subTitle1 = new JLabel("IP");
		subTitle1.setFont(uiTool.ftMedium());
		subTitle1.setBounds(100, 100, 200, 50);
		MainPanel.add(subTitle1);
		
		JLabel subTitle2 = new JLabel("Port");
		subTitle2.setFont(uiTool.ftMedium());
		subTitle2.setBounds(85, 195, 200, 50);
		MainPanel.add(subTitle2);
		
		plBtn1 = new JButton("YES");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(300, 475, 100, 50);
		add(plBtn1);
		
		plBtn2 = new JButton("NO");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(600, 475, 100, 50);
		add(plBtn2);
		
		M1Panel = new JPanel();
		M1Panel.setLayout(null);
		M1Panel.setBackground(new Color(248, 254, 181));
		M1Panel.setBounds(225, 175, 550, 400);
		
		playTitle = new JLabel();
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(135, 45, 400, 50);
		M1Panel.add(playTitle);
		
		Input = new JTextArea();
		JScrollPane jc = new JScrollPane(Input);
		jc.setBounds(120, 100, 400, 175);
		M1Panel.add(jc);
		M1Panel.setVisible(false);
		
		add(M1Panel);
		add(MainPanel);
		add(plImg1);
	}
	private void uI9_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameServer.ip = IpInput.getText();
				GameServer.PortNum = Integer.parseInt(ServerInput.getText());
				MainPanel.setVisible(false);
				M1Panel.setVisible(true);
				
				new Thread() {
		            public void run() {
						GameServer.start();
		            }
		        }.start();
			}
		});
		
		plBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
