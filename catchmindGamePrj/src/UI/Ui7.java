package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import gameSound.GameSound;

public class Ui7 extends JPanel{
	public static Ui7 ui7;
	private GameSound sound;
	private UiTool uiTool;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	
	private String[] columnType = {"순위", "이름", "점수"};
	public static Object[][] data = {
		       {"", "", ""},
		       {"", "", ""},
		       {"", "", ""},
		       {"", "", ""}
	};
	
	public Ui7() {
		//sound = new GameSound("bgm/bg1.wav");
		uiTool = new UiTool();
		setLayout(null);
		uI7_DesignLayout();
		uI71_listener();
		uI72_listener();
	}	
	
	public static Ui7 getUi7() {
		if (ui7 == null) {
			ui7 = new Ui7();
		}
		return ui7;
	}
	
	private void uI7_DesignLayout() {
		//for (int i=0;i<4;i++) {
			//idlist[i] = readidlist.split("&")[i];
			//System.out.println(idlist[i]);
		//}
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/cong.png", 1100, 750));
		plImg1.setBounds(0,0,1100,750);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(13, 152, 186));
		titlePanel.setBounds(345, 70, 400, 100);
		JLabel playTitle = new JLabel("최종 결과");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(145, 30, 200, 30);
		titlePanel.add(playTitle);
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnType);
		ColorTable jtable = new ColorTable(dtm);
		jtable.setRowHeight(50);
		jtable.setIntercellSpacing(new Dimension(5,2));
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		jtable.setFont(new Font("굴림", Font.BOLD, 20));
		jtable.getColumn("순위").setCellRenderer(celAlignCenter);
		jtable.getColumn("이름").setCellRenderer(celAlignCenter);
		jtable.getColumn("점수").setCellRenderer(celAlignCenter);
		
		JScrollPane jc = new JScrollPane(jtable);
		jc.setBounds(345, 170, 400, 223);
		
		plBtn1 = new JButton("방선택");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(345, 420, 150, 50);
		
		plBtn2 = new JButton("나가기");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(595, 420, 150, 50);
		
		add(titlePanel);
		add(jc);
		add(plBtn1);
		add(plBtn2);
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
	private void uI71_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//sound.playEffect("bgm/effect_turn.wav");
				//sound.stopBg();
				uiTool.setUI(Ui7.getUi7(), Ui3.getUi3());
			}
		});
	}
	private void uI72_listener() {
		plBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
