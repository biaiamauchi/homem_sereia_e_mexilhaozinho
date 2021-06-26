package GraphControllerComponent.BoardScreen;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public class Timer extends AnimationTimer {
    private ImageView fireVillain;

    public Timer(ImageView fireVillain){
        this.fireVillain = fireVillain;
    }

    public Timer()  {
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
        double opacity = fireVillain.opacityProperty().get();

        if(opacity <= 0)
            stop();
        else
            fireVillain.opacityProperty().set(opacity - 0.05);
    }
}
