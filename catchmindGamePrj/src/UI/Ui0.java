package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.Client;
import gameSound.GameSound;

public class Ui0 extends JPanel {
	public static Ui0 ui0;
	
	private GameSound sound;
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtnInfo;
	private JLabel plImg1;
	private TextField IpInput;
	private TextField ServerInput;
	
	private Ui0() {
		sound = new GameSound(null);
		uiTool = new UiTool();
		setLayout(null);
		uI0_DesignLayout();
		uI0_listener();
	}	
	
	public static Ui0 getUi0() {
		if (ui0 == null) {
			ui0 = new Ui0();
		}
		return ui0;
	}
	
	private void uI0_DesignLayout() {
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0,0,1100,750);
		
		plBtnInfo = new JButton("정보");
		plBtnInfo.setBounds(0, 0, 100, 40);
		plBtnInfo.setBackground(new Color(255, 255, 255));
		add(plBtnInfo);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBackground(new Color(248, 254, 181));
		MainPanel.setBounds(225, 175, 550, 400);
		JLabel playTitle = new JLabel("서버 연결");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(225, 25, 200, 50);
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
		
		plBtn1 = new JButton("확인");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(625, 475, 100, 50);
		
		add(plBtn1);
		add(MainPanel);
		add(plImg1);
	}
	
	private void uI0_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sound.playEffect("bgm/effect_gamestart.wav");
					
					Client.ip = IpInput.getText();
					Client.PortNum = Integer.parseInt(ServerInput.getText());

					new Thread() {
			            public void run() {
							MainFrame.clnt.connectServer();
			            }
			        }.start();
					uiTool.setUI(Ui0.this, Ui1.getUi1());
					
				} catch (Exception e1) {
				}
			}
		});
		
		plBtnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UiREF();
			}
		});
	}
}
