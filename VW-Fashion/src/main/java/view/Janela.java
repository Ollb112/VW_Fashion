package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Janela extends JFrame {
	private static Janela container;

	private Janela() {

		setSize(800, 450);
		setLayout(null);
		setResizable(false);
		setTitle("Vw Fashion");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void setPanel(JPanel painel) {
		SwingUtilities.updateComponentTreeUI(Janela.getInstance());
		getInstance().setContentPane(painel);
	}


	public static Janela getInstance() {
		if (container == null)
			container = new Janela();
		return container;
	}
}
