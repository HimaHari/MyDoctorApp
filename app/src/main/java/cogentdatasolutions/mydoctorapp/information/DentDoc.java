package cogentdatasolutions.mydoctorapp.information;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import cogentdatasolutions.mydoctorapp.R;

public class DentDoc extends AppCompatActivity {

    private Toolbar tb;
    private String TITLE = " About Dentist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dent_doc);

        tb = (Toolbar)findViewById(R.id.dent_tool_doc);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle(TITLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setTitle(TITLE);
        tb.setTitleTextColor(getResources().getColor(android.R.color.white));
    }
}
