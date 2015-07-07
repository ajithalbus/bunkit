package mak.livewire.bunkit;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Calibrate extends Activity {

    int select;

    EditText et1,et2,et3,et4,et5,et6,et7;

    @Override
    protected void onPause() {
        super.onPause();
    finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calibrate);


        findViewById(R.id.calilayer2).setVisibility(View.INVISIBLE);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup1);
        select = rg.getCheckedRadioButtonId();

        et1 = (EditText) findViewById(R.id.caliedit1);
        et2 = (EditText) findViewById(R.id.caliedit2);
        et3 = (EditText) findViewById(R.id.caliedit3);
        et4 = (EditText) findViewById(R.id.caliedit4);
        et5 = (EditText) findViewById(R.id.caliedit5);
        et6 = (EditText) findViewById(R.id.caliedit6);
       // et7 = (EditText) findViewById(R.id.caliedit7);


        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");



    }




    public void next(View v) {

        View cali1 = (View) findViewById(R.id.calilayer1);
        View cali2 = (View) findViewById(R.id.calilayer2);

       // Animation left_exit = AnimationUtils.loadAnimation(this,R.anim.left_exit);
        //Animation right_enter = AnimationUtils.loadAnimation(this,R.anim.right_enter);


        RadioButton rb1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton rb5 = (RadioButton) findViewById(R.id.radio5);
        RadioButton rb6 = (RadioButton) findViewById(R.id.radio6);

        if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()||rb4.isChecked()||rb5.isChecked()||rb5.isChecked()||rb6.isChecked())
        {

            //cali1.startAnimation(left_exit);
           // cali2.startAnimation(right_enter);

            cali1.setVisibility(View.INVISIBLE);
            cali2.setVisibility(View.VISIBLE);


        }
        else
        {
            Toast nn = Toast.makeText(this, "Pick a day", Toast.LENGTH_SHORT);
            nn.setGravity(1, 0, 0);
            nn.show();
        }
    }



    public void saave(View v) {


        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup1);
        select = rg.getCheckedRadioButtonId();

        SharedPreferences sharepref =getSharedPreferences("Periods", Context.MODE_APPEND);
        SharedPreferences.Editor editor = sharepref.edit();

        et1 = (EditText) findViewById(R.id.caliedit1);
        et2 = (EditText) findViewById(R.id.caliedit2);
        et3 = (EditText) findViewById(R.id.caliedit3);
        et4 = (EditText) findViewById(R.id.caliedit4);
        et5 = (EditText) findViewById(R.id.caliedit5);
        et6 = (EditText) findViewById(R.id.caliedit6);
      //  et7 = (EditText) findViewById(R.id.caliedit7);



        if(findViewById(R.id.radio1).getId() == select)
        {Toast.makeText(this,"Monday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("monper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("monper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("monper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("monper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("monper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("monper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("monper7", et7.getText().toString());

        }
        else if(findViewById(R.id.radio2).getId() == select)
        {Toast.makeText(this,"Tuesday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("tuesper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("tuesper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("tuesper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("tuesper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("tuesper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("tuesper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("tuesper7", et7.getText().toString());
        }
        else if(findViewById(R.id.radio3).getId() == select)
        {Toast.makeText(this,"Wednesday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("wednesper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("wednesper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("wednesper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("wednesper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("wednesper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("wednesper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("wednesper7", et7.getText().toString());
        }
        else if(findViewById(R.id.radio4).getId() == select)
        {Toast.makeText(this,"Thursday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("thursper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("thursper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("thursper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("thursper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("thursper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("thursper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("thursper7", et7.getText().toString());
        }
        else if(findViewById(R.id.radio5).getId() == select)
        {Toast.makeText(this,"Friday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("friper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("friper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("friper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("friper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("friper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("friper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("friper7", et7.getText().toString());
        }
        else if(findViewById(R.id.radio6).getId() == select)
        {Toast.makeText(this, "Saturday", Toast.LENGTH_SHORT).show();

            if(et1.length() > 0)
                editor.putString("saturper1", et1.getText().toString());

            if(et2.length() > 0)
                editor.putString("saturper2", et2.getText().toString());

            if(et3.length() > 0)
                editor.putString("saturper3", et3.getText().toString());

            if(et4.length() > 0)
                editor.putString("saturper4", et4.getText().toString());

            if(et5.length() > 0)
                editor.putString("saturper5", et5.getText().toString());

            if(et6.length() > 0)
                editor.putString("saturper6", et6.getText().toString());

            if(et7.length() > 0)
                editor.putString("saturper7", et7.getText().toString());
        }
        editor.commit();
    }

    @Override
    public void onBackPressed() {

        et1 = (EditText) findViewById(R.id.caliedit1);
        et2 = (EditText) findViewById(R.id.caliedit2);
        et3 = (EditText) findViewById(R.id.caliedit3);
        et4 = (EditText) findViewById(R.id.caliedit4);
        et5 = (EditText) findViewById(R.id.caliedit5);
        et6 = (EditText) findViewById(R.id.caliedit6);
       // et7 = (EditText) findViewById(R.id.caliedit7);


        if(findViewById(R.id.calilayer1).isShown())
        {

            super.onBackPressed();

        }
        else
        {
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");
            et6.setText("");
            et7.setText("");

            View cali1 = (View) findViewById(R.id.calilayer1);
            View cali2 = (View) findViewById(R.id.calilayer2);

            //Animation right_exit = AnimationUtils.loadAnimation(this, R.anim.right_exit);
            //Animation left_enter = AnimationUtils.loadAnimation(this,R.anim.left_enter);

           // cali1.startAnimation(left_enter);
            //cali2.startAnimation(right_exit);

            cali2.setVisibility(View.INVISIBLE);
            cali1.setVisibility(View.VISIBLE);
        }

    }

}
