package mak.livewire.bunkit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;
import android.app.*;
import android.widget.TextView;


public class bunker extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunker);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
       TextView temp=( TextView)findViewById(R.id.textView6);
        Cursor c=db.rawQuery("select * from subs",null);
        temp.setText(Integer.toString(c.getCount()));
          c.moveToLast();
        //c.moveToPrevious();
       Log.d("CI",c.getString(1));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bunker, menu);
        return true;
    }
    public void onBackPressed() { // copied code for back button exit
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        finish();

                    }
                }).setNegativeButton("no", null).show();
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
