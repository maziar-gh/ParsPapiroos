package ir.figureapp.papiroos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.figureapp.papiroos.Extras;
import ir.royrodriguez.papiroos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.card_newrequest)
    CardView card_newrequest;
    @BindView(R.id.card_requests)
    CardView card_requests;
    @BindView(R.id.card_address)
    CardView card_address;
    @BindView(R.id.card_profile)
    CardView card_profile;
    @BindView(R.id.card_edt_phone)
    CardView card_edt_phone;
    @BindView(R.id.card_edt_pass)
    CardView card_edt_pass;
    @BindView(R.id.card_exit)
    CardView card_exit;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //WindowUtils.makeStatusbarTransparent(this);
        getSupportActionBar().hide();

        card_newrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewRequestActivity.class));
            }
        });

        card_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RequestsActivity.class));
            }
        });

        card_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddressActivity.class));
            }
        });

        card_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        card_edt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra(Extras.INTENT_DATA.toString(), Extras.EDT_PHONE.toString());
                startActivity(intent);
            }
        });

        card_edt_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra(Extras.INTENT_DATA.toString(), Extras.EDT_PASS.toString());
                startActivity(intent);
            }
        });

        card_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "برای خروج دوباره فشار دهید", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
