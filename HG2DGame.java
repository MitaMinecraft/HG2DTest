import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mäx
 * Date: 07.05.13
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */

public class HG2DGame  extends JFrame {
    private Container c;
    private int x, y, w, h;
    private static final int tileW = 80, tileH = 80;
    private GameTile[][] tiles = new GameTile[10][10];
    private GameTile player = new GameTile(GameTile.PLAYER);

    public GameTile getPlayer() {
        return player;
    }

    public HG2DGame() {
        super("HGTest: View from above; Game");
        c = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        x = 200;
        y = 200;
        w = 800;
        h = 800;
        this.setBounds(x, y, w, h);
        this.setResizable(true);

        int tmpX = 0;
        int tmpY = 0;
        player.setBounds(tileW, tileH, tileW, tileH);
        c.add(player);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new GameTile(GameTile.DEFAULTTILE);
                tiles[i][j].setBounds(tmpX, tmpY, tileW, tileH);
                c.add(tiles[i][j]);
                tmpY += tileH;
            }
            tmpY = 0;
            tmpX += tileW;
        }
        this.setVisible(true);
    }
    public void dispMap(int[][] map) {
        if ((map.length != tiles.length) || (map[0].length != tiles[0].length)) {
            System.out.print("Error, wrong map size");
            return;
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].setType(map[i][j]);
            }
        }
    }
}
