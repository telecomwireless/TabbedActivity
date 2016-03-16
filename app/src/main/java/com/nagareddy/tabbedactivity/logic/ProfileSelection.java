package com.nagareddy.tabbedactivity.logic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.nagareddy.tabbedactivity.R;

public class ProfileSelection extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBar1;
    Button button;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button = (Button) findViewById(R.id.savebutton);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //This is back navigation arrow will take back to the parent screen
       /*  for(int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }  */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
             if(checkedId==R.id.ring) {

                seekBar1.setEnabled(true);
             }

                else
             {
                 seekBar1.setEnabled(false);
             }

            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your Preference is Saved", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar1 = (SeekBar) findViewById(R.id.seekbar);
        seekBar1.setOnSeekBarChangeListener(ProfileSelection.this);


    }
       /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        //     Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent productIntent = new Intent(this, Tabs.class);
            startActivity(productIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}






