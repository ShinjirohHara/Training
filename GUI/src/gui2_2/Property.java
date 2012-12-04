package gui2_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;



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
	private JComboBox color;

	private static final String bkColorKey = "背景色";
	private JComboBox bkColor;

	private DigitalWatch watch;
	private JFrame panel;

	public Property(JFrame panel, DigitalWatch watch) {
		super(panel);
		this.panel = panel;
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

		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (ColorProperty element: ColorProperty.values()) {
			model.addElement(element);
		}
		color = new JComboBox(model);
		color.setRenderer(new ColorRenderer());
		color.setSelectedItem(ColorProperty.valueOf(prefs.get(colorKey, ColorProperty.BLUE.toString())));
		
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

		model = new DefaultComboBoxModel();
		for (ColorProperty element: ColorProperty.values()) {
			model.addElement(element);
		}
		bkColor = new JComboBox(model);
		bkColor.setRenderer(new ColorRenderer());
		
		bkColor.setSelectedItem(ColorProperty.valueOf(prefs.get(bkColorKey, ColorProperty.WHITE.toString())));
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


		this.watch.setColor(((ColorProperty)(color.getSelectedItem())).getColor());
		this.watch.setStringFont(new Font(font.getSelectedItem(), Font.PLAIN, Integer.parseInt(size.getSelectedItem())));
		
		
		
		this.panel.setBackground(((ColorProperty)bkColor.getSelectedItem()).getColor());

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
			watch.setColor(((ColorProperty)(color.getSelectedItem())).getColor());
			watch.setStringFont(new Font(font.getSelectedItem(), Font.PLAIN, Integer.parseInt(size.getSelectedItem())));
			panel.setBackground(((ColorProperty)bkColor.getSelectedItem()).getColor());
			prefs.put(fontKey, font.getSelectedItem());
			prefs.put(sizeKey, size.getSelectedItem());
			prefs.put(colorKey, color.getSelectedItem().toString());
			prefs.put(bkColorKey, bkColor.getSelectedItem().toString());
			setVisible(false);
		} else if ("CANCEL".equals(e.getActionCommand())) {
			setVisible(false);
		}
	}
}
