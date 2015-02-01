package mak.livewire.bunkit;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
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
    //public static int ak=0;
    int val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunkon);
        Button bunkon=(Button)findViewById(R.id.button6); // start here
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
      // final NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE); // notification service new
        //final Notification notify = new Notification(R.drawable.abc_list_pressed_holo_light,"BUNK RECORDED",System.currentTimeMillis());
       //NOTIFICATION_SERVICE);
        //notification service called off
        RadioButton [] rb=new RadioButton[15];
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
                Log.d("val",Integer.toString(val));

                c.moveToPosition(val);

//Log.d("ak",Integer.toString(ak));

                //Toast.makeText(getApplicationContext(),Integer.toString(val),Toast.LENGTH_SHORT).show();
// bunk recording down
                db.execSQL("insert into bunkdb values ( date('now') ,  "+ Integer.toString(val)+ "); "); // some prob here, workin now//
                //Cursor k= db.rawQuery("select * from bunkdb",null);
                //k.moveToLast(); // continoue here
                Toast.makeText(getApplicationContext(),"bunking"+ c.getString(1)+"Success",Toast.LENGTH_SHORT).show(); //
                Toast.makeText(getApplicationContext(),"Click Back or Bunk again",Toast.LENGTH_SHORT).show();

                //below code is for notification
                /*Context con = bunkon.this;
                nm.cancel(0);// to cancel old notifications
                // below are to add notification
                String title="New Bunk Record";
                String detail="bunking"+ c.getString(1)+"Success";
                PendingIntent pending = PendingIntent.getActivity(con,0,new Intent(getApplicationContext(),bunkon.class),0);
                notify.setLatestEventInfo(con,title,detail,pending);

                nm.notify(0,notify);*/
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
    public void onBackPressed() {
        super.onBackPressed();



        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
