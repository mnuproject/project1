package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Ui7 extends JPanel{
	private UiTool uiTool;
	private JLabel plId1;
	private JLabel plId2;
	private JButton plBtn1;
	private JButton plBtn2;
	private JLabel plImg1;
	
	private String[] columnType = {"순위", "이름", "점수"};
	private Object[][] data = {
		       {"1", "A", "100"},
		       {"2", "B", "85"},
		       {"3", "C", "77"},
		       {"4", "D", "50"}
	};

	public Ui7() {
		uiTool = new UiTool();
		setLayout(null);
		uI7_DesignLayout();
		uI71_listener();
		uI72_listener();
	}	
	
	private void uI7_DesignLayout() {
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(255, 255, 0));
		titlePanel.setBounds(345, 70, 400, 100);
		JLabel playTitle = new JLabel("최종 결과");
		playTitle.setFont(uiTool.ftMedium());
		playTitle.setBounds(145, 30, 200, 30);
		titlePanel.add(playTitle);
		
		plId1 = new JLabel("UI7 라벨생성 예시1");
		plId1.setBackground(new Color(255, 215, 0));
		plId1.setBounds(00, 50, 400, 50);
		
		plId2 = new JLabel("UI7 라벨생성 예시2");
		plId2.setBackground(new Color(255, 215, 0));
		plId2.setBounds(1000, 100, 400, 50);
		
		JTable table = new JTable(data, columnType);
		table.setRowHeight(50);
		table.setIntercellSpacing(new Dimension(5,2));
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("순위").setCellRenderer(celAlignCenter);
		table.getColumn("이름").setCellRenderer(celAlignCenter);
		table.getColumn("점수").setCellRenderer(celAlignCenter);
		table.setBackground(new Color(255, 0, 255));
		table.setBackground(new Color(0, 255, 255));
		
		JScrollPane jc = new JScrollPane(table);
		jc.setBounds(345, 170, 400, 223);
		
		plBtn1 = new JButton("방선택");
		plBtn1.setBackground(new Color(255, 255, 255));
		plBtn1.setBounds(345, 500, 150, 50);
		
		plBtn2 = new JButton("나가기");
		plBtn2.setBackground(new Color(255, 255, 255));
		plBtn2.setBounds(595, 500, 150, 50);
		
		plImg1 = new JLabel();
		plImg1.setIcon(uiTool.getImg("img/drawBlackPen.png", 50, 100));
		plImg1.setBounds(150, 100, 100, 100);
		
		JPanel IdProfile = new JPanel();
		IdProfile.setLayout(null);
		IdProfile.setBackground(new Color(239, 228, 176));
		IdProfile.setBounds(0, 0, 1090, 715);
		
		add(titlePanel);
		//add(IdProfile);
		//add(plId2);
		add(jc);
		add(plBtn1);
		add(plBtn2);
		//add(plImg1);
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
			component.setBackground(Color.YELLOW);
			return component;
		}
	}
	private void uI71_listener() {
		plBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//sound.playEffect("bgm/effect_turn.wav");
				//sound.stopBg();
				uiTool.setUI(Ui7.this, new Ui3());
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
