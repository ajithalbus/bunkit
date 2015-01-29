package mak.livewire.bunkit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class bunkon extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunkon);
        Button bunkon=(Button)findViewById(R.id.button6); // start here
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        final RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
        RadioButton [] rb=new RadioButton[15];
      //  RelativeLayout rl=(RelativeLayout)findViewById(R.id.rl);
       final Cursor c=db.rawQuery("select * from subs",null);
        int i,n=c.getCount();
        c.moveToFirst();
        for(i=0;i<n;i++)
        {rb[i]=new RadioButton(this); // initiates buttones
            rg.addView(rb[i]); // add buttons to view
            rb[i].setText(c.getString(1)); // put text in button
c.moveToNext();

        }

        bunkon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val=rg.getCheckedRadioButtonId()-1; // returns from 1 , not 0  therfor -1
               c.moveToPosition(val);
                //Toast.makeText(getApplicationContext(),Integer.toString(val),Toast.LENGTH_SHORT).show();
// bunk recording down
                db.execSQL("insert into bunkdb values ( date('now') ,  "+ Integer.toString(val)+ "); "); // some prob here, workin now//
                //Cursor k= db.rawQuery("select * from bunkdb",null);
                //k.moveToLast(); // continoue here
                Toast.makeText(getApplicationContext(),"bunking"+ c.getString(1)+"Success",Toast.LENGTH_SHORT).show(); //
                Toast.makeText(getApplicationContext(),"Click Back or Bunk again",Toast.LENGTH_SHORT).show();

                //Log.d(c.getString(1),c.getString(0));
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bunkon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
