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
import android.widget.Toast;


public class unbunk extends ActionBarActivity { // most of the code is copies from bunkon class
int val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unbunk);

        Button bunkon=(Button)findViewById(R.id.unbunk); // start here
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        RadioGroup rg=(RadioGroup)findViewById(R.id.rgunbunk);
        // final NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE); // notification service new
        //final Notification notify = new Notification(R.drawable.abc_list_pressed_holo_light,"BUNK RECORDED",System.currentTimeMillis());
        //NOTIFICATION_SERVICE);
        //notification service called off
        RadioButton[] rb=new RadioButton[15];
        //  RelativeLayout rl=(RelativeLayout)findViewById(R.id.rl);
        final Cursor c=db.rawQuery("select * from subs",null);
        int i,n=c.getCount();
        c.moveToFirst();
        for(i=0;i<n;i++)
        {rb[i]=new RadioButton(this); // initiates buttons
            rg.addView(rb[i]); // add buttons to view
            rb[i].setText(c.getString(1)); // put text in button
            c.moveToNext();

        }
        //rg.check(1);

        bunkon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
                //below produces more counts
                RadioButton temp=(RadioButton)findViewById(rg.getCheckedRadioButtonId()); // temp = clickd button id , for each button clicked
                String kit=temp.getText().toString(); // get string from radio button temp
                Cursor t = db.rawQuery("select code from subs where sub ='" + kit + "'",null); // retrive the code(subject code) of the kit(string) from subs

                t.moveToFirst();
                // val=(rg.getCheckedRadioButtonId()-1);//%c.getCount(); // radio buttons created one on one , so
// returns from 1 , not 0  therfor -1
                //rg.clearCheck();
                val=t.getInt(0);
                Log.d("val", Integer.toString(val));

                c.moveToPosition(val);

//Log.d("ak",Integer.toString(ak));

                //Toast.makeText(getApplicationContext(),Integer.toString(val),Toast.LENGTH_SHORT).show();
// bunk recording down

Cursor last=db.rawQuery("select * from bunkdb where bhour="+ Integer.toString(val)+";",null);
                last.moveToLast();
                
                db.execSQL("insert into bunkdb values ( date('now') ,  "+ Integer.toString(val)+ "); "); // some prob here, workin now//
                //Cursor k= db.rawQuery("select * from bunkdb",null);
                //k.moveToLast(); // continoue here
                Toast.makeText(getApplicationContext(), "bunking" + c.getString(1) + "Success", Toast.LENGTH_SHORT).show(); //
                Toast.makeText(getApplicationContext(),"Click Back or Bunk again",Toast.LENGTH_SHORT).show();


            }
        });
    }



}
