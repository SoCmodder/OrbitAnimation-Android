package world.mitchmiller.orbitanimation.example;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import world.mitchmiller.orbitanimation.R;

import java.util.concurrent.TimeUnit;

public class CircleConstraintsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageView mercuryImage = findViewById(R.id.mercury_imageview);
        ImageView venusImage = findViewById(R.id.venus_imageview);
        ImageView earthImage = findViewById(R.id.earth_imageview);
        ImageView marsImage = findViewById(R.id.mars_image);
        ImageView saturnImage = findViewById(R.id.saturn_image);
        ImageView neptuneImage = findViewById(R.id.neptune_imageview);

        // Them 'nacci numbers, yo
        ValueAnimator mercuryAnimator = animatePlanet(mercuryImage, TimeUnit.SECONDS.toMillis(1));
        ValueAnimator venusAnimator = animatePlanet(venusImage, TimeUnit.SECONDS.toMillis(2));
        ValueAnimator earthAnimator = animatePlanet(earthImage, TimeUnit.SECONDS.toMillis(3));
        ValueAnimator marsAnimator = animatePlanet(marsImage, TimeUnit.SECONDS.toMillis(5));
        ValueAnimator saturnAnimator = animatePlanet(saturnImage, TimeUnit.SECONDS.toMillis(8));
        ValueAnimator neptuneAnimator = animatePlanet(neptuneImage, TimeUnit.SECONDS.toMillis(13));

        mercuryAnimator.start();
        venusAnimator.start();
        earthAnimator.start();
        marsAnimator.start();
        saturnAnimator.start();
        neptuneAnimator.start();
    }

    private ValueAnimator animatePlanet(ImageView planet, long orbitDuration) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);
        anim.addUpdateListener(valueAnimator -> {
            int val = (Integer) valueAnimator.getAnimatedValue();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) planet.getLayoutParams();
            layoutParams.circleAngle = val;
            planet.setLayoutParams(layoutParams);
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);

        return anim;
    }

}
