package mak.livewire.bunkit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;


public class bunkon extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunkon);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        RadioGroup rg=(RadioGroup)findViewById(R.id.rg);
        RadioButton [] rb=new RadioButton[15];
        RelativeLayout rl=(RelativeLayout)findViewById(R.id.rl);
        Cursor c=db.rawQuery("select * from subs",null);
        int i,n=c.getCount();
        c.moveToFirst();
        for(i=0;i<n;i++)
        {rb[i]=new RadioButton(this);
            rg.addView(rb[i]);
            rb[i].setText(c.getString(1));
c.moveToNext();

        }

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
