/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 03.06.13
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */

public class HG2DInvData {
	private HG2DItem[] items;
	private int[] amounts;
	private final int maxItems = 10;

	public HG2DInvData() {
		amounts = new int[maxItems];
		items = new HG2DItem[maxItems];

		for (int i = 0; i < maxItems; i++) {
			amounts[i] = 0;
			items[i] = new HG2DItem(-1); //Empty item, since in the beginning you don't have any items!
		}
	}
}
