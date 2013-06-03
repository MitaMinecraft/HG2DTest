import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 03.06.13
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public class HG2DInventory extends JFrame implements KeyListener{
	private HG2DController ctrl;
	private Container c;
	int x, y, w, h;

	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_I) {
			hideInv();
		}
	}
	public void keyTyped(KeyEvent ke) {}
	public void keyPressed(KeyEvent ke) {}

	public  HG2DInventory (HG2DController ct) {
		super("Inventory");
		c = this.getContentPane();
		ctrl = ct;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		x = 200;
		y = 200;
		w = 800;
		h = 600;
		this.setBounds(x, y, w, h);
		this.setResizable(false);
		addKeyListener(this);

		HG2DInvData d = new HG2DInvData();
	}

	public  void showInv() {
		this.setVisible(true);
	}
	public  void hideInv() {
		this.setVisible(false);
	}
	public boolean isOpen() {
		return this.isVisible();
	}
}
