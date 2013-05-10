/**
 * Created with IntelliJ IDEA.
 * User: Mäx
 * Date: 08.05.13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Maps {
    public static int[][] loadMap(String mapName, int[] topLeft) {
	    int[][] map = new int[10][10];
	    try {
		    BufferedReader in = new BufferedReader(new FileReader("maps/" + mapName + ".map"));
		    String[] line = {in.readLine()};
		    line[0] = in.readLine();
		    int ctrX = 0, ctrY = 0;
		    for (int i = 0; i < topLeft[1]; i++) {
			    line[0] = in.readLine();
		    }
		    for (int i = 0; i < map.length; i++) {
			    line[0] = in.readLine();
			    line = line[0].split(" ");
			    for (int j = topLeft[0]; j < map[i].length+topLeft[0]; j++) {
				    map[ctrX][ctrY] = Integer.parseInt(line[j].split(":")[0]);
				    ctrX++;
			    }
			    ctrX = 0;
			    ctrY++;
		    }
		    in.close();
	    } catch (Exception e) {
		    System.out.println(e);
	    }
		return map;
    }

    public static int[] getStartPos(String mapName) {
	    int[] startPos = new int[] {0, 0};
	    try {
		    BufferedReader in = new BufferedReader(new FileReader("maps/" + mapName + ".map"));
		    return getPosFromMapfile(mapName, in);
	    } catch (Exception e) {
		    System.out.println(e);
	    }
	    return startPos;
    }
	public static int[] getMapStart(String mapName) {
		int[] startPos = new int[] {0, 0};
		try {
			BufferedReader in = new BufferedReader(new FileReader("maps/" + mapName + ".map"));
			in.readLine();
			return getPosFromMapfile(mapName, in);
		} catch (Exception e) {
			System.out.println(e);
		}
		return startPos;
	}
	public static String getMapTransfer(String mapName, int[] pos) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("maps/" + mapName + ".map"));
			for (int i = 0; i < pos[1]+2; i++) {
				in.readLine();
			}
			String[] line = {in.readLine()};
			line = line[0].split(" ");
			if(line[pos[0]].split(":").length > 1) {
				return line[pos[0]].split(":")[1];
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static int[] getPosFromMapfile(String mapName, BufferedReader in) {
		int[] pos = new int[] {0, 0};
		try {
			String[] line = {in.readLine()};
			line = line[0].split(" ");
			pos[0] = Integer.parseInt(line[0]);
			pos[1] = Integer.parseInt(line[1]);
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return pos;
	}
}