package mak.livewire.bunkit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class record extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        TextView [] recs = new TextView[15] ;
        TextView [] vals = new TextView[15] ;// for number of txt views
        LinearLayout lv=(LinearLayout)findViewById(R.id.ll); // ll for containin those
        LinearLayout mv=(LinearLayout)findViewById(R.id.ll2);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        final Cursor c=db.rawQuery("select * from subs",null),k=db.rawQuery("select * from bunkdb",null);;
        int i,subs=c.getCount();
       k.moveToFirst();c.moveToFirst();
        for(i=0;i<subs;i++)
        {recs[i]=new TextView(this);
         vals[i]=new TextView(this);// initialize text view

            recs[i].setTextAppearance(this,R.style.TextAppearance_AppCompat_Large);
            vals[i].setTextAppearance(this,R.style.TextAppearance_AppCompat_Large);

            lv.addView(recs[i]); // connecting them to lv
            mv.addView(vals[i]);

            String setter;
            recs[i].setText(c.getString(1)); // seting values
c.moveToNext();
           Cursor temp=db.rawQuery("select * from bunkdb where bhour = "+Integer.toString(i),null);

            vals[i].setText(Integer.toString(temp.getCount()));

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return true;
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
