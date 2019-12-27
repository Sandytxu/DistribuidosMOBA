package map;

public final class Screen {

	private final int width;
	private final int heigth;

	public final int[] pixels;

	// Temporal
	private final static int SIDE_SPRITE = 32;
	private final static int MASK_SPRITE = SIDE_SPRITE - 1;
	// End Temporal

	public Screen(final int width, final int heigth) {
		this.width = width;
		this.heigth = heigth;

		this.pixels = new int[width * heigth];
	}

	public void clean() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void draw(final int compX, final int compY) {
		for (int i = 0; i < heigth; i++) {
			int posY = i + compY;

			if (posY < 0 || posY >= heigth) { // Así controlamos que no nos salimos;
				continue;// Cut the loop;
			}

			for (int j = 0; j < width; j++) {
				int posX = j + compX;

				if (posX < 0 || posX >= heigth) { // Asi controlamos que no nos salimos;
					continue;// Cut the loop;
				}
				// Temporal
				pixels[posX + posY * width] = Sprite.test.pixels[(j & MASK_SPRITE) + (i & MASK_SPRITE) * SIDE_SPRITE];

			}
		}
	}
}
