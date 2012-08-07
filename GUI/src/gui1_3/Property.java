package gui1_3;


import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Property extends PopupMenu implements ActionListener{

		static final long serialVersionUID = 7331917309522579598L;

		public static final Color getCurrentColor = null;

		private ColorMenu stringColor;
		private SizeMenu size;
		private FontMenu font;
		private ColorMenu backGroundColor;

		
		public Property() {
			super();
			font = new FontMenu("フォント", Font.SANS_SERIF);
			add(font);
			 
			 
			size = new SizeMenu("サイズ", SizeMenu.Value.SIZE64);
			add(size);
			
			stringColor = new ColorMenu("文字色カラー", ColorMenu.Type.BLUE);
			add(stringColor);
			
			backGroundColor = new ColorMenu("背景色", ColorMenu.Type.WHITE);
			add(backGroundColor);
			
			addActionListener(this);
		}


		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}


		public ColorMenu.Type getCurrentColor() {
			return stringColor.getColor();
		}


		public Font getCurrentFont() {
			return new Font(font.getValue(), Font.PLAIN, size.getValue().getValue());
		}
		
		public ColorMenu.Type getBackGround() {
			return backGroundColor.getColor();
		}
	}
