/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Gilles Teuwen u21465772
 */
import com.teuwen.gilles.permutationgeneratormathu.Latex;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class LatexExample extends JFrame implements ActionListener {

	private JTextArea latexSource;
	private JButton btnRender;
	private JButton btnGenerateP1;
	private JButton btnGenerateP2;
	private JButton btnGenerateP3;
	private JButton btnGenerateP4;
	private JSpinner permNum;
	private JPanel drawingArea;

	public LatexExample() {
		this.setTitle("JLatexMath Example");
		this.setSize(500, 500);
		Container content = this.getContentPane();
		content.setLayout(new GridLayout(2, 1));
		this.latexSource = new JTextArea();

		JPanel editorArea = new JPanel();

		JPanel buttonPane = new JPanel();
		editorArea.setLayout(new BorderLayout());

		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		editorArea.add(new JScrollPane(this.latexSource), BorderLayout.CENTER);
		buttonPane.add(btnRender = new JButton("Render"));
		buttonPane.add(btnGenerateP1 = new JButton("Genrerate P1"));
		buttonPane.add(btnGenerateP2 = new JButton("Genrerate P2"));
		buttonPane.add(btnGenerateP3 = new JButton("Genrerate P3"));
		buttonPane.add(btnGenerateP4 = new JButton("Genrerate P4"));
		buttonPane.add(permNum = new JSpinner());
		editorArea.add(buttonPane, BorderLayout.SOUTH);

		content.add(editorArea);
		content.add(this.drawingArea = new JPanel());
		this.btnRender.addActionListener(this);
		this.btnGenerateP1.addActionListener(this);
		this.btnGenerateP2.addActionListener(this);
		this.btnGenerateP3.addActionListener(this);
		this.btnGenerateP4.addActionListener(this);

		
		Dimension d = new Dimension(40, 20);
		this.permNum.setPreferredSize(d);

		this.latexSource.setText("x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}");
		this.latexSource.setText("x=" + Latex.Syntax.fraction("-b \\pm \\sqrt {b^2-4ac}", "2a"));
		int start = (int) ((Math.random() * (10 - 1)) + 1);
		int diff = (int) ((Math.random() * (10 - 1)) + 1);
		this.latexSource.setText(Latex.Series.generateSequence(start, diff, 4));
	}

	public void render() {
		try {

			// get the text
			String latex = this.latexSource.getText();

			// create a formula
			TeXFormula formula = new TeXFormula(latex);

			// render the formla to an icon of the same size as the formula.
			TeXIcon icon = formula
				.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

			// insert a border 
			icon.setInsets(new Insets(5, 5, 5, 5));

			// now create an actual image of the rendered equation
			BufferedImage image = new BufferedImage(icon.getIconWidth(),
				icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = image.createGraphics();
			g2.setColor(Color.white);
			g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
			JLabel jl = new JLabel();
			jl.setForeground(new Color(0, 0, 0));
			icon.paintIcon(jl, g2, 0, 0);
			// at this point the image is created, you could also save it with ImageIO

			// now draw it to the screen			
			Graphics g = this.drawingArea.getGraphics();
			g.drawImage(image, 0, 0, null);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
				JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void generateP1() {
		this.latexSource.setText(Latex.PropertiesOfOperations.generateBoxesSection(Integer.parseInt(permNum.getValue().toString())));
	}

	private void generateP2() {
		this.latexSource.setText(Latex.PropertiesOfOperations.generateWaterSequenceSection(Integer.parseInt(permNum.getValue().toString())));
	}

	private void generateP3() {
		this.latexSource.setText(Latex.PropertiesOfOperations.generateLearnersSection(Integer.parseInt(permNum.getValue().toString())));
	}

	private void generateP4() {
		this.latexSource.setText(Latex.PropertiesOfOperations.generateOrangesSection(Integer.parseInt(permNum.getValue().toString())));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnRender) {
			render();
		}
		if (e.getSource() == this.btnGenerateP1) {
			generateP1();
		}
		if (e.getSource() == this.btnGenerateP2) {
			generateP2();
		}
		if (e.getSource() == this.btnGenerateP3) {
			generateP3();
		}
		if (e.getSource() == this.btnGenerateP4) {
			generateP4();
		}

	}
}
