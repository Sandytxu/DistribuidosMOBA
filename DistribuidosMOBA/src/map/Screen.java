package map;

public final class Screen {

	private final int width;
	private final int heigth;
	
	public final int[] pixels;
	
	public Screen(final int width, final int heigth) {
		this.width = width;
		this.heigth = heigth;
		
		this.pixels = new int[width*heigth];
	}
	
	public void clean() {
		for(int i = 0; i<pixels.length;i++) {
			pixels[i]=0;
		}
	}
	
	public void draw(final int compX, final int compY) {
		for(int i=0; i<heigth;i++) {
			int posY = i+compY;
			
			if(posY<0||posY>=heigth) { //Así controlamos que no nos salimos;
				continue;//Cut the loop;
			}
			
			for(int j=0;j<width;j++) {
				int posX = j+compX;
				
				if(posX<0||posX>=heigth) { //Asi controlamos que no nos salimos;
					continue;//Cut the loop;
				}
			}
			
			//Code 4 redraw;
		}
	}
}
