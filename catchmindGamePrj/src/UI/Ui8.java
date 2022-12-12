package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import gameSound.GameSound;

public class Ui8 extends JPanel {
	public static Ui8 ui8;
	private GameSound sound;
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	
	public Ui8() {
		//sound = new GameSound("bgm/bg1.wav");
		uiTool = new UiTool();
		setLayout(null);
		uI8_DesignLayout();
	}	
	
	public static Ui8 getUi8() {
		if (ui8 == null) {
			ui8 = new Ui8();
		}
		return ui8;
	}
	
	private void uI8_DesignLayout() {
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cloud_img.jpg", 1100, 750));
		plImg1.setBounds(0,0,1100,750);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBackground(new Color(248, 254, 181));
		MainPanel.setBounds(225, 175, 550, 400);
		JLabel playTitle = new JLabel("서버 연결");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(225, 25, 200, 50);
		MainPanel.add(playTitle);
		
		TextField IdInput = new TextField();
		IdInput.setBounds(200, 110, 300, 40);
		MainPanel.add(IdInput);
		
		TextField ServerInput = new TextField();
		ServerInput.setBounds(200, 200, 300, 40);
		MainPanel.add(ServerInput);
		
		JLabel subTitle1 = new JLabel("IP");
		subTitle1.setFont(uiTool.ftMedium());
		subTitle1.setBounds(100, 100, 200, 50);
		MainPanel.add(subTitle1);
		
		JLabel subTitle2 = new JLabel("서버");
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
	
	class ColorTable extends JTable {
		public ColorTable(DefaultTableModel dtm) {
			// TODO Auto-generated constructor stub
			super(dtm);
		}

		@Override
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			// TODO Auto-generated method stub
			JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
			if (row==0) {
				component.setBackground(new Color(255, 215, 0));
			}
			else if (row==1) {
				component.setBackground(new Color(192, 192, 192));
			}
			else if (row==2) {
				component.setBackground(new Color(196, 156, 49));
			}
			else if (row==3) {
				component.setBackground(new Color(255, 255, 255));
			}
			return component;
		}
	}
}
