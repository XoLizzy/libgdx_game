package java_source;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Travis on 1/20/14.
 */
public class WorldController {
//a
    private Sprite testSprites[];
    private int selectedSprite;

    public WorldController() {
    }

    private void init(){

    }

    private void initTestObjects(){
        testSprites = new Sprite[5];
        int width = 32, height = 32;

        Pixmap pixmap = createProceduralPixmap(width, height);

        Texture texture = new Texture(pixmap);
        for (int i = 0; i < testSprites.length; i++) {
            Sprite spr = new Sprite(texture);

            spr.setSize(1, 1);

            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);

            float randomX = MathUtils.random(-2.0f, 2.0f);
            float randomY = MathUtils.random(-2.0f, 2.0f);
            spr.setPosition(randomX, randomY);

            testSprites[i] = spr;
        }
        selectedSprite = 0;
    }

    private Pixmap createProceduralPixmap (int width, int height){
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();
        pixmap.drawLine(0, 0, width, height);
        pixmap.drawLine(width, 0, 0, height);
        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, width, height);
        return pixmap;
    }

    public void update(float deltaTime){
        updateTestObjects(deltaTime);
    }

    private void updateTestObjects(float deltaTime) {

        float rotation = testSprites[selectedSprite].getRotation();

        rotation += 90 * deltaTime;

        rotation %= 360;

        testSprites[selectedSprite].setRotation(rotation);
    }
}