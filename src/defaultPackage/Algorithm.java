package defaultPackage;

import java.awt.event.KeyEvent;

public class Algorithm {
	private static Object mData[][] = new Object[4][4];
	public static void handleEvents(int keycode,Object data[][]){
		mData = data;
		if(keycode == KeyEvent.VK_RIGHT){
			keyRight();
		}
		else if(keycode == KeyEvent.VK_LEFT){
			
		}
		else if(keycode == KeyEvent.VK_UP){
			
		}
		else if(keycode == KeyEvent.VK_DOWN){
			
		}
	}
	
	public boolean isEnd(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4 ; j++)
				if(mData[i][j] == null)
					return false;
		}
		return true;
	}
	
	private static void keyRight(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				
			}
		}
	}
}
