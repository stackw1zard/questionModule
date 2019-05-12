package com.stackwizards.custom.questionapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.stackwizards.custom.mcq_module.Ihandler;
import com.stackwizards.custom.mcq_module.MultpleChoiceQuestionFragment;

import static com.stackwizards.custom.mcq_module.MultpleChoiceQuestionFragment.newInstance;


public class MainActivity extends AppCompatActivity implements Ihandler {

    MultpleChoiceQuestionFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Bitmap defaultProfilPicture = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background);
//        ((ImageView) findViewById(R.id.imageView)).setImageBitmap(GraphicsUtils.getRoundedCornerBitmap(defaultProfilPicture, 1000));
        ((ImageView) findViewById(R.id.imageView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadFragment(new MultpleChoiceQuestionFragment());
                fragment = newInstance(MainActivity.this,MainActivity.this);
                fragment.loadDataObjects("http://www.stackwizards.org/json/mcq/qwert.json");
//                fragment = new MultpleChoiceQuestionFragment();
                ((ImageView) findViewById(R.id.imageView)).setVisibility(View.GONE);
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void fhandle() {
        loadFragment(fragment);
    }
}

