package map;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private final int width;
	private final int heigth;
	public final int[] pixels;

	// Collection Sprites;
	public static SpriteSheet map = new SpriteSheet("/textures/map.jpg", 1000, 459);
	// End collection;

	public SpriteSheet(final String rute, final int width, int heigth) {
		this.width = width;
		this.heigth = heigth;

		pixels = new int[width * heigth];

		BufferedImage image;
		try {
			image = ImageIO.read(SpriteSheet.class.getResource(rute));
			image.getRGB(0, 0, width, heigth, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getWidth() {
		return this.width;
	}

}
