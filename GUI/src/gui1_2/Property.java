package gui1_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Property extends Dialog implements ActionListener{

		static final long serialVersionUID = 7331917309522579598L;
		static final String TITLE_NAME = "表示のプロパティ";
		static final String MENU_NAME = "プロパティ";
		
		Choice font = new Choice();
		Choice size = new Choice();
		Choice color = new Choice();
		Choice bkColor = new Choice();

		Display watch;
		
		public Property(Display watch) {

			super(watch);
			this.watch = watch;
			setTitle(TITLE_NAME);
			setSize(400, 300);
			setLayout(new GridLayout(5, 1));
			
			Panel fontPanel = new Panel();
			fontPanel.setLayout(new FlowLayout());
			Label fontLabel = new Label("フォント");
			fontPanel.add(fontLabel);
			font.add(Font.SERIF);
			font.add(Font.SANS_SERIF);
			font.add(Font.MONOSPACED);
			font.add(Font.DIALOG);
			fontPanel.add(font);
			add(fontPanel);
			
			Panel fontSizePanel = new Panel();
			fontSizePanel.setLayout(new FlowLayout());
			fontSizePanel.add(new Label("サイズ"));
			size.add("16");
			size.add("32");
			size.add("48");
			size.add("64");
			size.add("96");
			size.add("128");
			size.add("256");
			size.add("512");
			fontSizePanel.add(size);
			add(fontSizePanel);
			
			Panel stringColorPanel = new Panel();
			stringColorPanel.setLayout(new FlowLayout());
			stringColorPanel.add(new Label("文字色"));
			stringColorPanel.add(color);
			for (ColorProperty element: ColorProperty.values()) {
				color.add(element.toString());
			}
			add(stringColorPanel);
			
			
			Panel backGroundColorPanel = new Panel();
			backGroundColorPanel.setLayout(new FlowLayout());
			backGroundColorPanel.add(new Label("背景色"));
			backGroundColorPanel.add(bkColor);
			for (ColorProperty element: ColorProperty.values()) {
				bkColor.add(element.toString());
			}
			add(backGroundColorPanel);
			
			
			Panel decisionPanel = new Panel();
			decisionPanel.setLayout(new FlowLayout());
			Button ok = new Button("OK");
			ok.addActionListener(this);
			Button cancel = new Button("CANCEL");
			cancel.addActionListener(this);
			decisionPanel.add(ok);
			decisionPanel.add(cancel);
			add(decisionPanel);
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e) {
					setVisible(false);
				}
			});
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if (MENU_NAME.equals(e.getActionCommand())) {
				setVisible(true);
			} else if ("OK".equals(e.getActionCommand())) {
				int cuurentSize = Integer.parseInt(size.getSelectedItem());
				watch.setStringColor(ColorProperty.valueOf(color.getSelectedItem()).getColor());
				watch.setStringFont(new Font(font.getSelectedItem(), Font.PLAIN, cuurentSize));
				watch.setBackground(ColorProperty.valueOf(bkColor.getSelectedItem()).getColor());
				watch.setSize(cuurentSize*5, (int)(cuurentSize*2.5 + 20));
				setVisible(false);
			} else if ("CANCEL".equals(e.getActionCommand())) {
				setVisible(false);
			}
		}
	}
