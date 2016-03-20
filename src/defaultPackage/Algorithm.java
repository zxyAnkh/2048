package defaultPackage;

import java.awt.event.KeyEvent;

public class Algorithm {
	private static Object mData[][] = new Object[4][4];
	private static int mScore = 0;

	public static void handleEvents(int keycode, Object data[][]) {
		mData = data;
		if (keycode == KeyEvent.VK_RIGHT) {
			keyRight();
			zeroToNull();
			randomAddRight();
		} else if (keycode == KeyEvent.VK_LEFT) {
			keyLeft();
			zeroToNull();
			randomAddLeft();
		} else if (keycode == KeyEvent.VK_UP) {
			keyUp();
			zeroToNull();
			randomAddUp();
		} else if (keycode == KeyEvent.VK_DOWN) {
			keyDown();
			zeroToNull();
			randomAddDown();
		}

	}

	public static boolean isFull() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (mData[i][j] == null)
					return false;
			}
		}
		return true;
	}

	public static boolean isEnd() {
		int num[][] = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (mData[i][j] == null)
					return false;
				else {
					num[i][j] = (int) mData[i][j];
				}
			}
		}
		int i = 0, j = 0;
		if (num[0][0] == num[0][1] || num[0][0] == num[1][0])
			return false;
		if (num[0][3] == num[0][2] || num[0][3] == num[1][3])
			return false;
		if (num[3][0] == num[3][1] || num[3][0] == num[2][0])
			return false;
		if (num[3][3] == num[3][2] || num[3][3] == num[2][3])
			return false;
		for (i = 1; i < 3; i++) {
			if (num[i][0] == num[i - 1][0] || num[i][0] == num[i][1] || num[i][0] == num[i + 1][0])
				return false;
			if (num[i][3] == num[i - 1][3] || num[i][3] == num[i][2] || num[i][3] == num[i + 1][3])
				return false;
		}
		for (j = 1; j < 3; i++) {
			if (num[0][j] == num[0][j - 1] || num[0][j] == num[1][j] || num[0][j] == num[0][j + 1])
				return false;
			if (num[3][j] == num[3][j - 1] || num[3][j] == num[2][j] || num[3][j] == num[3][j + 1])
				return false;
		}
		for (i = 1; i < 3; i++) {
			for (int k = 1; k < 3; k++) {
				if (num[i][k] == num[i - 1][k] || num[i][k] == num[i][k - 1] || num[i][k] == num[i][k + 1]
						|| num[i][k] == num[i + 1][k])
					return false;
			}
		}
		return true;
	}

	private static void zeroToNull() {
		for (int i = 0; i < 4; i++) {
			int num[] = new int[4];
			for (int j = 0; j < 4; j++) {
				if ((int) mData[i][j] == 0)
					mData[i][j] = null;
			}
		}
	}

	private static void keyRight() {
		for (int i = 0; i < 4; i++) {
			int num[] = new int[4];
			for (int j = 0; j < 4; j++) {
				if (mData[i][j] == null)
					mData[i][j] = 0;
				num[j] = (int) mData[i][j];
			}
			for (int j = 3; j >= 0; j--) {
				if (j != 0 && num[j] != 0) {
					if (num[j - 1] == num[j]) {
						num[j] += num[j - 1];
						num[j - 1] = 0;
						mScore += num[j];
					}
				}
				if (j != 3 && num[j + 1] == 0) {
					num[j + 1] = num[j];
					num[j] = 0;
				}
			}
			for (int j = 0; j < 4; j++) {
				mData[i][j] = num[j];
			}
		}
	}

	private static void keyLeft() {
		for (int i = 0; i < 4; i++) {
			int num[] = new int[4];
			for (int j = 0; j < 4; j++) {
				if (mData[i][j] == null)
					mData[i][j] = 0;
				num[j] = (int) mData[i][j];
			}
			for (int j = 0; j <= 3; j++) {
				if (j != 3 && num[j] != 0) {
					if (num[j + 1] == num[j]) {
						num[j] += num[j + 1];
						num[j + 1] = 0;
						mScore += num[j];
					}
				}
				if (j != 0 && num[j - 1] == 0) {
					num[j - 1] = num[j];
					num[j] = 0;
				}
			}
			for (int j = 0; j < 4; j++) {
				mData[i][j] = num[j];
			}
		}
	}

	private static void keyDown() {
		for (int i = 0; i < 4; i++) {
			int num[] = new int[4];
			for (int j = 0; j < 4; j++) {
				if (mData[j][i] == null)
					mData[j][i] = 0;
				num[j] = (int) mData[j][i];
			}
			for (int j = 3; j >= 0; j--) {
				if (j != 0 && num[j] != 0) {
					if (num[j - 1] == num[j]) {
						num[j] += num[j - 1];
						num[j - 1] = 0;
						mScore += num[j];
					}
				}
				if (j != 3 && num[j + 1] == 0) {
					num[j + 1] = num[j];
					num[j] = 0;
				}
			}
			for (int j = 0; j < 4; j++) {
				mData[j][i] = num[j];
			}
		}
	}

	private static void keyUp() {
		for (int i = 0; i < 4; i++) {
			int num[] = new int[4];
			for (int j = 0; j < 4; j++) {
				if (mData[j][i] == null)
					mData[j][i] = 0;
				num[j] = (int) mData[j][i];
			}
			for (int j = 0; j <= 3; j++) {
				if (j != 3 && num[j] != 0) {
					if (num[j + 1] == num[j]) {
						num[j] += num[j + 1];
						num[j + 1] = 0;
						mScore += num[j];
					}
				}
				if (j != 0 && num[j - 1] == 0) {
					num[j - 1] = num[j];
					num[j] = 0;
				}
			}
			for (int j = 0; j < 4; j++) {
				mData[j][i] = num[j];
			}
		}
	}

	private static void randomAddDown() {
		// TODO Auto-generated method stub
		while (true) {
			int random = (int) (Math.random() * 4);
			if (mData[0][random] == null) {
				mData[0][random] = 2;
				break;
			}
		}
	}

	private static void randomAddUp() {
		// TODO Auto-generated method stub
		while (true) {
			int random = (int) (Math.random() * 4);
			if (mData[3][random] == null) {
				mData[3][random] = 2;
				break;
			}
		}
	}

	private static void randomAddLeft() {
		// TODO Auto-generated method stub
		while (true) {
			int random = (int) (Math.random() * 4);
			if (mData[random][3] == null) {
				mData[random][3] = 2;
				break;
			}
		}
	}

	private static void randomAddRight() {
		// TODO Auto-generated method stub
		while (true) {
			int random = (int) (Math.random() * 4);
			if (mData[random][0] == null) {
				mData[random][0] = 2;
				break;
			}
		}
	}

	public static int getScore() {
		return mScore;
	}

	public static void resetScore() {
		mScore = 0;
	}

	public static Object[][] getData() {
		return mData;
	}

}
