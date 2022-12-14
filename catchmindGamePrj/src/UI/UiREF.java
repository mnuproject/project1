package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.Client;
import gameSound.GameSound;
import res.Word_Ref;

public class UiREF extends JFrame {	
	private UiTool uiTool;
	private JButton plBtn1;
	private JLabel plImg1;
	
	public UiREF() {
		setTitle("캐치마인드 정보");
		setResizable(false);
		setSize(1100, 750);
		
		setVisible(true);
		
		uiTool = new UiTool();
		setLayout(null);
		uIRef_DesignLayout();
		uIRef_listener();
	}
	
	private void uIRef_DesignLayout() {
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/catchMindBG.png", 1100, 750));
		plImg1.setBounds(0,0,1100,750);

		JLabel playTitle = new JLabel("캐치마인드 프로그램 정보");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(400, 30, 300, 20);
		add(playTitle);
		
		JTextArea textArea = new JTextArea(Word_Ref.wordREF);
		JScrollPane jc = new JScrollPane(textArea);
		jc.setBounds(150, 120, 800, 450);
		add(jc);
		
		plBtn1 = new JButton("확인");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(150, 570, 800, 50);
		
		add(plBtn1);
		add(plImg1);
	}
	
	private void uIRef_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
