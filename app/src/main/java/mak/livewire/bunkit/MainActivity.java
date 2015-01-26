package mak.livewire.bunkit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
EditText t;
TextView g;    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);

        final SharedPreferences setting= getSharedPreferences("subs",0); // get preferences
        final SharedPreferences.Editor editor = setting.edit(); // to change preference
        int subs=setting.getInt("subs",0); // assign preference to subs
        //setting.getInt("subs", 0);
        final Intent i = new Intent(getApplicationContext(), worker.class); // intent to move to worker class

        if(subs!=0&&!isTableExists(db,"bunkdb")) {
            i.putExtra("send",subs); // sends number of subjects
startActivity(i);
            finish();
        }
                    //setContentView(R.layout.activity_worker);
        //else
        setContentView(R.layout.activity_main);


        if(isTableExists(db,"bunkdb")) // if table already exists
        {
            Log.d("exist", "exists");
            Intent j=new Intent(getApplicationContext(),bunker.class); // start bunker activity
            startActivity(j);

            finish();
        // for bunker class if table already exists
        }
        g=(TextView)findViewById(R.id.textView2);
        g.setText("@mak");
        t= (EditText)findViewById(R.id.editText);
        ok= (Button)findViewById(R.id.button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//g.setText(String.valueOf(setting.getInt("subs",0)));
int temp;
               // temp=t1.getValue();
                temp=Integer.parseInt(t.getText().toString());
                if(temp>=0&&temp<=15)         // no of subs >0 and <15
                {    i.putExtra("send",temp); // set preference to intent variable
                editor.putInt("subs",temp);  // set current preference
                editor.commit();
                     startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Enter proper value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //setContentView(R.layout.activity_main);

    }
    boolean isTableExists(SQLiteDatabase db, String tableName) // copied fn to check if table exists in the given db
    {
        if (tableName == null || db == null || !db.isOpen())
        {
            return false;
        }
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[] {"table", tableName});
        if (!cursor.moveToFirst())
        {
            return false;
        }
        int count = cursor.getInt(0);
        cursor.close();
        return count > 0;
    }

    //@Override
    /*protected void onStop() {
        super.onStop();
    SharedPreferences setting = getSharedPreferences("Mak",0);
        SharedPreferences.Editor editor= setting.edit();

        editor.putString("Mak",t.getText().toString());
        editor.commit();
    }*/

    @Override
    protected void onPause() { // to close activity when intent i is launched
        super.onPause();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
