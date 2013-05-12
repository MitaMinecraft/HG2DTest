/**
 * Created with IntelliJ IDEA.
 * User: Mäx
 * Date: 07.05.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameTile extends JLabel {
    private BufferedImage img;
    public static final int PLAYER = -1;
    public static final int DEFAULTTILE = 0;
    public static final int GRASSTILE = 1;
	public static final int HOUSETILE = 2;
	public static final int DOORTILE = 3;
    private int posX, posY;

    public int getPosX() {
        return (int) this.getLocation().getX()/80;
    }

    public int getPosY() {
        return (int) this.getLocation().getY()/80;
    }

    public void setPosX(int x) {
        if(x >= 0 && x < 10) this.setLocation(80*x, (int) this.getLocation().getY());
    }

    public void setPosY(int y) {
        if(y >= 0 && y < 10) this.setLocation((int) this.getLocation().getX(), 80*y);
    }
    public void setPos(int x, int y) {
        if(x >= 0 && x < 10 && y >= 0 && y < 10) this.setLocation(80*x, 80*y);
    }
    public void setPos(int[] coord) {
        setPos(coord[0], coord[1]);
    }
    public void setType(int t) {
         loadType(t);
    }
	public void setDoubleTile(int btm, int top) {
		try{
			BufferedImage img = ImageIO.read(new File(getTileFilePath(btm)));
			img.createGraphics().drawImage(img, 0, 0, null);
			img.createGraphics().drawImage(ImageIO.read(new File(getTileFilePath(top))), 0, 0, null);
			this.setIcon(new ImageIcon(img));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    private String getTileFilePath(int t) {
	    String n = "";
	    switch (t) {
		    case DEFAULTTILE:
			    n = "img/DefaultTile.png";
			    break;
		    case GRASSTILE:
			    n = "img/DefImage.png";
			    break;
		    case PLAYER:
			    n = "img/PlayerTile.png";
			    break;
		    case HOUSETILE:
			    n = "img/HouseTile.png";
			    break;
		    case DOORTILE:
			    n = "img/DoorTile.png";
			    break;
	    }
	    return n;
    }
	private void loadType(int t) {
        try {
	        this.setIcon(new ImageIcon(ImageIO.read(new File(getTileFilePath(t)))));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public GameTile(int type) {
        loadType(type);
    }
}
