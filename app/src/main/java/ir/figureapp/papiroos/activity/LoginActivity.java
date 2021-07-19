package ir.figureapp.papiroos.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.royrodriguez.papiroos.TransitionButton;
import com.royrodriguez.papiroos.utils.WindowUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.royrodriguez.papiroos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.transition_button)
    TransitionButton transitionButton;
    @BindView(R.id.img_logo)
    ImageView img_logo;
    @BindView(R.id.constraint_main)
    FrameLayout constraint_footer;
    @BindView(R.id.edt_pass)
    EditText edt_pass;
    @BindView(R.id.edt_phone)
    EditText edt_phone;
    @BindView(R.id.btn_down)
    Button btn_down;
    @BindView(R.id.tv_forgotpass)
    TextView tv_forgotpass;
    @BindView(R.id.tv_register)
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        WindowUtils.makeStatusbarTransparent(this);
        getSupportActionBar().hide();



        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Then start the loading animation when the user tap the button
                transitionButton.startAnimation();

                // Do your networking task or background work here.
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean isSuccessful = true;

                        if (isSuccessful) {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                                @Override
                                public void onAnimationStopEnd() {
                                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } else {
                            transitionButton.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                        }
                    }
                }, 2000);
            }
        });


        transitionButton.setVisibility(View.INVISIBLE);
        edt_pass.setVisibility(View.INVISIBLE);
        edt_phone.setVisibility(View.INVISIBLE);
        btn_down.setVisibility(View.INVISIBLE);
        tv_forgotpass.setVisibility(View.INVISIBLE);
        tv_register.setVisibility(View.INVISIBLE);

        HeaderAnimation();


    }



    public void Fadein() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600);
        transitionButton.startAnimation(alphaAnimation);
        edt_pass.startAnimation(alphaAnimation);
        edt_phone.startAnimation(alphaAnimation);
        btn_down.startAnimation(alphaAnimation);
        tv_forgotpass.startAnimation(alphaAnimation);
        tv_register.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                transitionButton.setVisibility(View.VISIBLE);
                edt_pass.setVisibility(View.VISIBLE);
                edt_phone.setVisibility(View.VISIBLE);
                btn_down.setVisibility(View.VISIBLE);
                tv_forgotpass.setVisibility(View.VISIBLE);
                tv_register.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void HeaderAnimation() {

        int fadeOutAnimation = R.anim.footer;
        Animation animation = AnimationUtils.loadAnimation(this, fadeOutAnimation);
        img_logo.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Fadein();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
