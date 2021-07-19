package ir.figureapp.papiroos;

import android.app.Application;

import ir.royrodriguez.papiroos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Base extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Yekan.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }
}
