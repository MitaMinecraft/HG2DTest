/**
 * Created with IntelliJ IDEA.
 * User: Mäx
 * Date: 07.05.13
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class HG2DStartMenu extends JFrame {
    private Container c;
    private JButton startGameBtn;
    private int x, y, w, h;
    HG2DController ctrl;

    public HG2DStartMenu(HG2DController ct) {
        super("HGTest: View from above; Start menu");
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

        startGameBtn = new JButton("Start Game");
        startGameBtn.setBounds(w/2-50, h/2-21, 100, 42);
        startGameBtn.addActionListener(ctrl);

        c.add(startGameBtn);
        this.setVisible(true);
    }
    public JButton getStartGameBtn() {
        return startGameBtn;
    }
}