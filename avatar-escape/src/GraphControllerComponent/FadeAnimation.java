package GraphControllerComponent;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public class FadeAnimation extends AnimationTimer {
    private ImageView image;
    private double decreaseOpacity;

    public FadeAnimation(ImageView image, double decreaseOpacity){
        this.image = image;
        this.decreaseOpacity = decreaseOpacity;
    }

    public FadeAnimation()  {
        try{
            Thread.sleep( 500 );
        } catch (Exception ex){
            //pass
        }
    }

    public void handle(long a){
        doHandle();
    }

    private void doHandle(){
        double opacity = image.opacityProperty().get();

        if(opacity <= 0)
            stop();
        else
            image.opacityProperty().set(opacity - decreaseOpacity);
    }
}
