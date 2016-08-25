package cogentdatasolutions.mydoctorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import cogentdatasolutions.mydoctorapp.information.DentDoc;
import cogentdatasolutions.mydoctorapp.information.DermDoc;

public class DermaInfo extends AppCompatActivity {
    private Toolbar tb;
    private static final String TITLE = " Derm Info";
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derma_info);

        tb = (Toolbar)findViewById(R.id.dermTb);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle(TITLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        tb.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setLogo(R.drawable.spa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.call:
                uri = Uri.parse("tel:9666073099");
                startActivity(new Intent(Intent.ACTION_DIAL,uri));
                break;
            case R.id.sms:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
                startActivity(sendIntent);
                break;
            case R.id.mail:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"padagalahimaja7@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Hello Dear");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Hi Hima Madame.....");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
                startActivity(emailIntent);
                break;
            case R.id.dctr:
                startActivity(new Intent(DermaInfo.this, DermDoc.class));
                break;
            case R.id.repPrb:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Report Problem");
                builder.setCancelable(false);
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DermaInfo.this, "Your Report Submitted", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

        }

        return super.onOptionsItemSelected(item);
    }
}
