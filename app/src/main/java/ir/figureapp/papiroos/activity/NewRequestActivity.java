package ir.figureapp.papiroos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.royrodriguez.papiroos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewRequestActivity extends AppCompatActivity {

    @BindView(R.id.const_1)
    ConstraintLayout const_1;
    @BindView(R.id.const_2)
    ConstraintLayout const_2;
    @BindView(R.id.spi_new_service)
    Spinner spi_service;
    @BindView(R.id.spi_new_category)
    Spinner spi_category;
    @BindView(R.id.spi_new_priority)
    Spinner spi_priority;
    @BindView(R.id.spi_new_address)
    Spinner spi_address;
    @BindView(R.id.edt_new_name)
    EditText edt_new_name;
    @BindView(R.id.edt_new_phone)
    EditText edt_new_phone;
    @BindView(R.id.btn_new_next)
    Button btn_new_next;
    @BindView(R.id.btn_new_pervious)
    Button btn_new_pervious;

    List<String> service = new ArrayList<String>();
    List<String> category = new ArrayList<String>();
    List<String> priority = new ArrayList<String>();
    List<String> address = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        fillSpinner();


        btn_new_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                const_1.setVisibility(View.INVISIBLE);
                const_2.setVisibility(View.VISIBLE);
            }
        });

        btn_new_pervious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                const_2.setVisibility(View.INVISIBLE);
                const_1.setVisibility(View.VISIBLE);
            }
        });
    }

    private void fillSpinner() {

        service.add("تعمیر انواع پرینتر");
        service.add("تعمیر انواع فتوکپی");
        service.add("شارژ کارتریج");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, service);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_service.setAdapter(adapter);
        spi_service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(NewRequestActivity.this, "spi_service: "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        category.add("خدمات پشتیبانی");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_category.setAdapter(adapter2);
        spi_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(NewRequestActivity.this, "spi_category: "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        priority.add("کم");
        priority.add("متوسط");
        priority.add("بالا");
        priority.add("بحرانی");

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, priority);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_priority.setAdapter(adapter3);
        spi_priority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(NewRequestActivity.this, "spi_category: "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        address.add(" رشت خیابان معلم جنب استانداری کوچه شهید هاشمی ساختمان دیلمان واحد ۲ ");
        address.add("وارد کردن آدرس جدید");

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, address);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi_address.setAdapter(adapter4);
        spi_address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(NewRequestActivity.this, "spi_category: "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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