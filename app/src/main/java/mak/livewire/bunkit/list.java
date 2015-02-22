package mak.livewire.bunkit;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Mak on 20-02-2015.
 */
public class list extends ListActivity{
    String[] a=new String[] {"Name"} ;
    int[] b= new int[] {android.R.layout.simple_list_item_1};
    final SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
    final Cursor c=db.rawQuery("select bhour from bunkdb",null);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleCursorAdapter k = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,a,b);
        setListAdapter(k);

    }
}
