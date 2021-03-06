/**
 * Created with IntelliJ IDEA.
 * User: Mäx
 * Date: 07.05.13
 * Time: 21:08
 * To change this template use File | Settings | File Templates.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HG2DController implements ActionListener, KeyListener {
    private HG2DStartMenu sm;
    private HG2DGame game;
    private GameTile player;
	private String currentMap;
	private boolean needMapReload;
	HG2DInventory inv;
    public void startGame() {
        sm = new HG2DStartMenu(this);
	    inv = new HG2DInventory(this);
    }
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(sm.getStartGameBtn())) {
            newGame();
        }
    }

	private void openInventory() {
		inv.showInv();
	}

    public void keyReleased(KeyEvent ke) {
        int c = ke.getKeyCode();
        int x = player.getPosX();
	    int y = player.getPosY();
	    switch (c) {
            case KeyEvent.VK_LEFT:
                //Left
	            x--;
                break;
            case  KeyEvent.VK_UP:
                //Up
	            y--;
                break;
            case  KeyEvent.VK_RIGHT:
                //Right
	            x++;
                break;
            case  KeyEvent.VK_DOWN:
                //Down
	            y++;
                break;
            case KeyEvent.VK_I:
		        //Inventory
		        openInventory();
        }
	    String tmp = Maps.getMapTransfer(currentMap, new int[] {x, y});
	    if(!tmp.equals("")) {
		    currentMap = tmp;
		    needMapReload = true;

	    }
	    int[] pos = doMapShift(new int[] {x, y});
	    player.setPos(pos[0], pos[1]);
    }
    public void keyTyped(KeyEvent ke) {

    }
    public void keyPressed(KeyEvent ke) {
    }
    private void newGame() {
	    sm.dispose();
        game = new HG2DGame(this);
	    currentMap = "testmap";
        game.setSize((int) (game.getSize().getWidth()+800-game.getContentPane().getSize().getWidth()),(int) (game.getSize().getHeight()+800-game.getContentPane().getSize().getHeight()));  //Necessary due to window decorations
        player = game.getPlayer();
	    int[] mapStart = Maps.getMapStart(currentMap);
	    int[] startPos = Maps.getStartPos(currentMap);
        player.setPos(startPos[0]-mapStart[0], startPos[1]-mapStart[1]);
        game.dispMap(Maps.loadMap(currentMap, mapStart), currentMap);
        game.addKeyListener(this);
    }
	private int[] doMapShift(int[] pos) {
		//shift the view if player reached edge, initialize new map if necessary, blabla
		if(pos[0] < 0) pos[0] = 0;
		if(pos[0] > 9) pos[0] = 9;
		if(pos[1] < 0) pos[1] = 0;
		if(pos[1] > 9) pos[1] = 9;
		if(needMapReload) {
			int[] mapStart = Maps.getMapStart(currentMap);
			int[] startPos = Maps.getStartPos(currentMap);
			pos = new int[]{startPos[0]-mapStart[0], startPos[1]-mapStart[1]};
			game.dispMap(Maps.loadMap(currentMap, mapStart), currentMap);
			needMapReload = false;
		}
		return pos;
	}
	public boolean isItemStillThere(String mapName, int x, int y) {
		return true; //Needs to be implemented server-client-style
	}
}