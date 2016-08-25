package cogentdatasolutions.mydoctorapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button phybtn,pedbtn,dermbtn,psychobtn,denbtn,orthobtn;
    boolean doublebackpressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phybtn = (Button)findViewById(R.id.physicianBtn);
        pedbtn = (Button)findViewById(R.id.pedBtn);
        dermbtn = (Button)findViewById(R.id.dermBtn);
        psychobtn = (Button)findViewById(R.id.psychoBtn);
        denbtn = (Button)findViewById(R.id.dentBtn);
        orthobtn = (Button)findViewById(R.id.orthoBtn);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Basic Treatment");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setLogo(R.drawable.toollogo);

        phybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PhysicianInfo.class));
            }
        });
        pedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PedInfo.class));

            }
        });
        dermbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DermaInfo.class));
            }
        });
        psychobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PsychoInfo.class));
            }
        });
        denbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DentistInfo.class));
            }
        });
        orthobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,OrthoInfo.class));
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (doublebackpressed) {
            super.onBackPressed();
            return;
        }
        this.doublebackpressed = true;
        Toast.makeText(MainActivity.this, "Press again to Exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doublebackpressed = false;
            }
        },2000);
    }
}
