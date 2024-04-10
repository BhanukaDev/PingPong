package PingPongPackage;

public class TableSetting {
	private static int width = 800;
	private static int height = 600;
	private static int unitSize = 5;
	private static int border = unitSize * 2;

	public static int[] getGrid() {
		return new int[] { getWidth() / getUnitSize(), getHeight() / getUnitSize() };
	}

	public static int[] getTableSize() {
		return new int[] { (int) (getWidth() / getUnitSize()) * getUnitSize(),
				(int) (getHeight() / getUnitSize()) * getUnitSize() };
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		TableSetting.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		TableSetting.height = height;
	}

	public static int getUnitSize() {
		return unitSize;
	}

	public static void setUnitSize(int unitSize) {
		TableSetting.unitSize = unitSize;
	}

	public static int getBorder() {
		return border;
	}

	public static void setBorder(int border) {
		TableSetting.border = border * getUnitSize();
	}
}
