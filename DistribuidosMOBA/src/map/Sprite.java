package map;

public class Sprite {
	private final int size;

	private int x;
	private int y;

	public int[] pixels;
	private final SpriteSheet sheet;
	
	//Sprite Collection;
	public static Sprite test = new Sprite(128,0,0,SpriteSheet.map);
	//End Collection;

	public Sprite(final int size, final int col, final int row, final SpriteSheet sheet) {
		this.size = size;
		
		pixels = new int[this.size*this.size];
		
		this.x = col*this.size;
		this.y = row*this.size;
		this.sheet = sheet;
		
		for(  int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				pixels[(j+i)*size] = sheet.pixels[(j+this.x)*(i*this.y)*sheet.getWidth()]; 
			}
		}
	}
}
