package vn.edu.poly.animationandroid;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgObject;
    private Button btnProperty;
    private Button btnView;
    private Button btnDrawable;
    private View toolbar;

    private boolean isShow = true;

    private ImageView imgMen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        imgObject = findViewById(R.id.imgObject);
        btnProperty = findViewById(R.id.btnProperty);
        btnView = findViewById(R.id.btnView);
        btnDrawable = findViewById(R.id.btnDrawable);

        imgMen = findViewById(R.id.imgMen);


        btnProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Animation hyperspaceJump = AnimationUtils.loadAnimation(
                        MainActivity.this, R.anim.scale);

                hyperspaceJump.setDuration(3000);
                hyperspaceJump.setRepeatCount(10);

                imgObject.startAnimation(hyperspaceJump);

            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,
                        R.animator.scale);

                animator.setTarget(imgObject);
                animator.setDuration(3000);

                animator.start();
            }
        });
        btnDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imgMen.setImageResource(R.drawable.men_animation);
                AnimationDrawable animationDrawable =
                        (AnimationDrawable) imgMen.getDrawable();

                animationDrawable.start();

            }
        });

    }


    public void showHideToolbar() {

        if (isShow) {

            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(toolbar,
                    "Y", 0f, -toolbar.getHeight());

            objectAnimator.setDuration(1000);

            objectAnimator.start();
            isShow = false;

        } else {

            isShow = true;
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(toolbar,
                    "Y", -toolbar.getHeight(), 0f);

            objectAnimator.setDuration(1000);

            objectAnimator.start();
        }
    }
}
