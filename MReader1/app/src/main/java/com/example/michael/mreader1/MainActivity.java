package com.example.michael.mreader1;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import android.graphics.drawable.AnimationDrawable;



public class MainActivity extends ActionBarActivity implements OnClickListener {

    private Button JNewGame;
    private Button JNextStep;
    private TextView JMessage;
    private ImageView JPattern1;
    private ImageView JMindImage;
    private int Pattern_Select=1;

    final int Remember_Symbol_Step = 1;
    final int Add_Numbers_Step = 2;
    final int Subtract_Step = 3;
    final int Check_Ans_Step = 4;
    final int Renew_Step = 0;

    private int At_Step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Reference from ScreenWidget
        JNewGame = (Button) findViewById(R.id.NewGame);
        JNextStep = (Button) findViewById(R.id.NextStep);
        JMessage = (TextView) findViewById(R.id.Thinking);
        JPattern1 = (ImageView) findViewById(R.id.ImgPatern1);
        JMindImage = (ImageView) findViewById(R.id.MindImage);

        JMessage.setText("Please Select Number Between (10-99)\n");
        JMessage.setVisibility(View.VISIBLE);

        JNewGame.setOnClickListener(this);
        JNextStep.setOnClickListener(this);
        At_Step = Remember_Symbol_Step;
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


    @Override
    public void onClick(View v) {

        ImageView temp_Pattern1;
        Drawable new_image1;

        ImageView temp_MindImage;
        Drawable new_image2;
        temp_MindImage = (ImageView) findViewById(R.id.MindImage);

        if (v == JNewGame) {
            At_Step = Remember_Symbol_Step;
            JMessage.setText("Please Select Number Between (10-99)\n");
            JMessage.setVisibility(View.VISIBLE);
            JMindImage.setVisibility(View.INVISIBLE);

            temp_Pattern1 = (ImageView) findViewById(R.id.ImgPatern1);
            if (Pattern_Select == 1) {
                new_image1 = getResources().getDrawable(R.drawable.template1);
                new_image2 = getResources().getDrawable(R.drawable.pattern1ans);
                Pattern_Select++;
            } else if (Pattern_Select == 2) {
                new_image1 = getResources().getDrawable(R.drawable.template2);
                new_image2 = getResources().getDrawable(R.drawable.pattern2ans);
                Pattern_Select++;
            } else {
                new_image1 = getResources().getDrawable(R.drawable.template3);
                new_image2 = getResources().getDrawable(R.drawable.pattern3ans);
                Pattern_Select = 1;
            }
            temp_Pattern1.setImageDrawable(new_image1);
            temp_MindImage.setImageDrawable(new_image2);

            JPattern1.setVisibility(View.VISIBLE);
        }
        else if (v == JNextStep){
            if (At_Step == Remember_Symbol_Step) {
                JMessage.setText("Please Add the Digits\nExample (25) is 2 + 5 = 7");
                JMessage.setVisibility(View.VISIBLE);
                At_Step = Add_Numbers_Step;
            }
            else if (At_Step == Add_Numbers_Step){
                JMessage.setText("Subtract Sum from Original Number\nExample (25 - 7) = 18, Remember Symbol");
                JMessage.setVisibility(View.VISIBLE);
                At_Step = Subtract_Step;
            }
            else if (At_Step == Subtract_Step){
                JMessage.setText("I believe, I read your mind\nPlease Examine Symbol");
                JMessage.setVisibility(View.VISIBLE);
                //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
                //width and height of your Image ,if it is inside Relative change the LinearLayout to RelativeLayout.
                //JMindImage.setLayoutParams(layoutParams);
                JMindImage.setVisibility(View.VISIBLE);
                At_Step = Renew_Step;
            }
            else {
                JMessage.setVisibility(View.INVISIBLE);

                JMindImage.setVisibility(View.INVISIBLE);
            }
        }

    }

}
