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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class bunker extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunker);
        Button bunkon=(Button)findViewById(R.id.button3);
        Button exit=(Button)findViewById(R.id.button5);
       final Button tt=(Button)findViewById(R.id.button7); //change to 7 when details added
        //Button =(Button)findViewById(R.id.button7);
        final Button record=(Button)findViewById(R.id.button4);
        final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
       TextView temp=( TextView)findViewById(R.id.textView6);
        Cursor c=db.rawQuery("select * from subs",null);
        temp.setText(Integer.toString(c.getCount()));
          c.moveToLast();
        //c.moveToPrevious();
        /*clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                                
            /*  db.execSQL("drop table bunkdb");
                db.execSQL("drop table subs");
                final SharedPreferences setting= getSharedPreferences("subs",0); // get preferences
                final SharedPreferences.Editor editor = setting.edit();

                editor.putInt("subs",0);  // set current preference
                editor.commit(); // for clearing the preference data


               startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("return",0));//start here
                finish();
 // once it was doing job for clear button
            }
        });
        */
       Log.d("CI",c.getString(1));
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent torecord=new Intent(getApplicationContext(),record.class);
                startActivity(torecord);
            }
        });



tt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),Table.class));
    }
});
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});
        bunkon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),bunkon.class);
                startActivity(i);
            }
        });

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
if(id==R.id.about)

{
    startActivity(new Intent(getApplicationContext(),About.class));
}
        if(id==R.id.clear) {

            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Clear data")
                    .setMessage("Are you sure wanna clear data?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
                            db.execSQL("drop table bunkdb");
                            db.execSQL("drop table subs");
                            final SharedPreferences setting= getSharedPreferences("subs",0); // get preferences
                            final SharedPreferences.Editor editor = setting.edit();

                            editor.putInt("subs",0);  // set current preference
                            editor.commit(); // for clearing the preference data


                            SharedPreferences sharepref =getSharedPreferences("Periods", Context.MODE_APPEND);
                            SharedPreferences.Editor edito = sharepref.edit();
                            edito.clear().commit();

                            startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("return",0));//start here
                            finish();



                        }
                    }).setNegativeButton("no", null).show();


            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
