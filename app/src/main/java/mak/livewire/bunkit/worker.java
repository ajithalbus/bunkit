package mak.livewire.bunkit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.*;
import android.util.Log;


import java.util.ArrayList;

public class worker extends ActionBarActivity  {
TextView t,g;
    EditText sname;
    Button next;
int j=0,subs;

ArrayList<String> tit= new ArrayList<String>(); // to get list of subjects


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);

        if(isTableExists(db,"bunkdb")) // if table already exists
        {
            Log.d("exist", "exists");
            // for bunker class if table already exists
        }
        Intent i = getIntent();

       subs = i.getIntExtra("send", 0);

        j=subs;

        t=(TextView)findViewById(R.id.textView4);
        g=(TextView)findViewById(R.id.textView5);
        sname=(EditText)findViewById(R.id.editText2);
        sname.setHint("Subject "+String.valueOf(subs-j+1));
        next=(Button)findViewById(R.id.button2);
        g.setText("");
        t.setText(String.valueOf(subs));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String tem="";
                if(j==1) {
                    db.execSQL("create table if not exists bunkdb (btime date , bhour number );");
                    db.execSQL("create table if not exists subs (code number ,sub varchar(20));");
                    db.execSQL("delete from subs");
                    db.execSQL("delete from bunkdb");


                    //tit.add(tem);
                    tem=sname.getText().toString();

                    if(tem.length()==0) // to cheak if not a valid name is enterd working
                    {Toast.makeText(getApplicationContext(),"Enter valid name",Toast.LENGTH_SHORT).show();
                        return;}
                    if(tit.contains(tem))// to check if sub already exists
                    {Toast.makeText(getApplicationContext(),"Subject Already exists",Toast.LENGTH_SHORT).show();
                        return;

                    }

                    tit.add(tem);
                    //Log.d("subs",Integer.toString(tit.size()));
                    String ks;
                    for(int i=0;i<subs;i++) {
                        ks = tit.get(i);

                        db.execSQL("insert into subs values ( " + Integer.toString(i) + ", ' " + ks + " ' )");

                    }

                    /*db.execSQL("insert into bunkdb values(datetime('2014-12-12 12:34:23.876'),1);");
                    //db.execSQL("insert into bunkdb values(datetime('2015-12-12 12:34:23.876'),1)");


                    //db.execSQL("INSERT INTO cuts");
                    Cursor c = db.rawQuery("select * from bunkdb",null);
                    c.moveToFirst();
                    Log.d("work",c.getString(c.getColumnIndex("btime")));
                    */

                    db.close();
                    Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_LONG).show();
                    Intent j=new Intent(getApplicationContext(),bunker.class); // start bunker activity
                    startActivity(j);

                    finish();

                }

                if(j==2) next.setText("Finish");

                tem=sname.getText().toString();
                if(tem.length()==0) // to cheak if not a valid name is enterd working
                {Toast.makeText(getApplicationContext(),"Enter valid name",Toast.LENGTH_SHORT).show();
                return;}
                if(tit.contains(tem))// to check if sub already exists
                {Toast.makeText(getApplicationContext(),"Subject Already exists",Toast.LENGTH_SHORT).show();
                    return;

                }

                sname.setHint("Subject "+String.valueOf(subs-j+2)); // sub 1 , sub 2 lik that
                tit.add(tem);

               //Log.d("","tilhere");
                g.append(tem);
                g.append(",");
                sname.setText("");

                j--;

            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_worker, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
    finish();
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
