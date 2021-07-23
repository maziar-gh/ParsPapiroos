package ir.figureapp.papiroos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.figureapp.papiroos.Extras;
import ir.royrodriguez.papiroos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class EditActivity extends AppCompatActivity {

    @BindView(R.id.const_register)
    ConstraintLayout const_phone;
    @BindView(R.id.const_pass)
    ConstraintLayout const_pass;

    boolean isPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);


        Bundle ex = getIntent().getExtras();
        if (ex != null)
            if(ex.getString(Extras.INTENT_DATA.toString()).equals(Extras.EDT_PHONE.toString()))
            isPhone = true;
            else isPhone = false;


        if(isPhone){
            const_phone.setVisibility(View.VISIBLE);
            const_pass.setVisibility(View.INVISIBLE);
        }
        else{
            const_pass.setVisibility(View.VISIBLE);
            const_phone.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}