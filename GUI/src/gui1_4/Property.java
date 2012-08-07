package gui1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;


public class Property extends Dialog implements ActionListener{

	private static final long serialVersionUID = 7331917309522579598L;
	static final String TITLE_NAME = "表示のプロパティ";
	static final String MENU_NAME = "プロパティ";
	private Preferences prefs = Preferences.userNodeForPackage(this.getClass());

	private static final String fontKey = "フォント";
	private Choice font;

	private static final String sizeKey = "サイズ";
	private Choice size;

	private static final String colorKey = "文字色";
	private Choice color;

	private static final String bkColorKey = "背景色";
	private Choice bkColor;

	private DigitalWatch watch;

	public Property(DigitalWatch watch) {
		super(watch);
		this.watch = watch;
		setTitle(TITLE_NAME);
		setSize(350, 200);
		GridBagLayout layOut = new GridBagLayout();
		setLayout(layOut);

		GridBagConstraints gdc = new GridBagConstraints();
		gdc.gridx = 0;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.EAST;
		Label fontLabel = new Label(fontKey);
		layOut.setConstraints(fontLabel, gdc);
		add(fontLabel);

		font = new Choice();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (Font element: ge.getAllFonts()) {
			font.add(element.getName());
		}
		font.select(prefs.get(fontKey, Font.SANS_SERIF));
		gdc.gridx = 1;
		gdc.gridy = 0;
		gdc.anchor = GridBagConstraints.WEST;
		layOut.setConstraints(font, gdc);
		add(font);

		Label sizeLabel = new Label(sizeKey);
		gdc.gridx = 0;
		gdc.gridy = 1;
		gdc.anchor = GridBagConstraints.EAST;
		layOut.setConstraints(sizeLabel, gdc);
		add(sizeLabel);

		size = new Choice();
		size.add("16");
		size.add("32");
		size.add("48");
		size.add("64");
		size.add("96");
		size.add("128");
		size.add("256");
		size.select(prefs.get(sizeKey, "64"));
		gdc.gridx = 1;
		gdc.gridy = 1;
		gdc.anchor = GridBagConstraints.WEST;
		layOut.setConstraints(size, gdc);
		add(size);


		Label colorLabel = new Label(colorKey);
		gdc.gridx = 0;
		gdc.gridy = 2;
		gdc.anchor = GridBagConstraints.EAST;
		layOut.setConstraints(colorLabel, gdc);
		add(colorLabel);

		color = new Choice();
		for (ColorProperty element: ColorProperty.values()) {
			color.add(element.toString());
		}
		color.select(prefs.get(colorKey, Color.BLUE.toString()));
		gdc.gridx = 1;
		gdc.gridy = 2;
		gdc.anchor = GridBagConstraints.WEST;
		layOut.setConstraints(color, gdc);
		add(color);

		Label bkColorLabel = new Label(bkColorKey);
		gdc.gridx = 0;
		gdc.gridy = 3;
		gdc.anchor = GridBagConstraints.EAST;
		layOut.setConstraints(bkColorLabel, gdc);
		add(bkColorLabel);

		bkColor = new Choice();
		for (ColorProperty element: ColorProperty.values()) {
			bkColor.add(element.toString());
		}
		bkColor.select(prefs.get(bkColorKey, Color.WHITE.toString()));
		gdc.gridx = 1;
		gdc.gridy = 3;
		gdc.anchor = GridBagConstraints.WEST;
		layOut.setConstraints(bkColor, gdc);
		add(bkColor);


		Panel decisionPanel = new Panel();
		decisionPanel.setLayout(new FlowLayout());
		Button ok = new Button("OK");
		ok.addActionListener(this);
		Button cancel = new Button("CANCEL");
		cancel.addActionListener(this);
		decisionPanel.add(ok);
		decisionPanel.add(cancel);
		gdc.gridx = 1;
		gdc.gridy = 4;
		gdc.anchor = GridBagConstraints.EAST;
		layOut.setConstraints(decisionPanel, gdc);
		add(decisionPanel);

		int currentSize = Integer.parseInt(size.getSelectedItem());
		watch.setSize(currentSize*5, (int)(currentSize*2.5 + 20));
		watch.setColor(ColorProperty.valueOf(color.getSelectedItem()).getColor());
		watch.setStringFont(new Font(font.getSelectedItem(), Font.PLAIN, Integer.parseInt(size.getSelectedItem())));
		watch.setBackground(ColorProperty.valueOf(bkColor.getSelectedItem()).getColor());

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}


	
	public void actionPerformed(ActionEvent e) {
		if (MENU_NAME.equals(e.getActionCommand())) {
			setVisible(true);
		} else if ("OK".equals(e.getActionCommand())) {
			int currentSize = Integer.parseInt(size.getSelectedItem());
			watch.setSize(currentSize*5, (int)(currentSize*2.5 + 20));
			watch.setColor(ColorProperty.valueOf(color.getSelectedItem()).getColor());
			watch.setStringFont(new Font(font.getSelectedItem(), Font.PLAIN, Integer.parseInt(size.getSelectedItem())));
			watch.setBackground(ColorProperty.valueOf(bkColor.getSelectedItem()).getColor());
			prefs.put(fontKey, font.getSelectedItem());
			prefs.put(sizeKey, size.getSelectedItem());
			prefs.put(colorKey, color.getSelectedItem());
			prefs.put(bkColorKey, bkColor.getSelectedItem());
			setVisible(false);
		} else if ("CANCEL".equals(e.getActionCommand())) {
			setVisible(false);
		}
	}
}
