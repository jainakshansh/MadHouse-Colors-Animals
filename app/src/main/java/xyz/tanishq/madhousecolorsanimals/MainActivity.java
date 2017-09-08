package xyz.tanishq.madhousecolorsanimals;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout cat, dog, lion, camel, rabbit, giraffe;
    private LinearLayout red, yellow, orange, blue, pink, green;
    private LinearLayout output;
    private ImageView outputImage;
    private TextView outputText;
    private boolean isColored = false;
    private boolean isAnimalSelected = false;

    private LinearLayout colorSelected;
    private LinearLayout animalSelected;

    private MediaPlayer mediaPlayer;

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the app into fullscreen mode before the layout is set for the activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Referencing all the views from the layout file
        cat = (LinearLayout) findViewById(R.id.cat);
        dog = (LinearLayout) findViewById(R.id.dog);
        camel = (LinearLayout) findViewById(R.id.camel);
        lion = (LinearLayout) findViewById(R.id.lion);
        rabbit = (LinearLayout) findViewById(R.id.rabbit);
        giraffe = (LinearLayout) findViewById(R.id.giraffe);

        red = (LinearLayout) findViewById(R.id.red);
        yellow = (LinearLayout) findViewById(R.id.yellow);
        green = (LinearLayout) findViewById(R.id.green);
        blue = (LinearLayout) findViewById(R.id.blue);
        orange = (LinearLayout) findViewById(R.id.orange);
        pink = (LinearLayout) findViewById(R.id.pink);

        output = (LinearLayout) findViewById(R.id.output_main);
        outputImage = (ImageView) findViewById(R.id.output);
        outputText = (TextView) findViewById(R.id.outputtext);

        //Implementing the onClickListener
        cat.setOnClickListener(this);
        dog.setOnClickListener(this);
        camel.setOnClickListener(this);
        lion.setOnClickListener(this);
        rabbit.setOnClickListener(this);
        giraffe.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        orange.setOnClickListener(this);
        pink.setOnClickListener(this);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onClick(View view) {

        //Releasing all the unused resources when any item is clicked anytime.
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        int id = view.getId();

        if (!isAnimalSelected) {

            switch (id) {

                case R.id.red:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.red);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("RED");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = red;
                    break;

                case R.id.yellow:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.yellow);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("YELLOW");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = yellow;
                    break;

                case R.id.orange:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.orange);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("ORANGE");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = orange;
                    break;

                case R.id.blue:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.blue);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("BLUE");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = blue;
                    break;

                case R.id.pink:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.pink);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("PINK");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = pink;
                    break;

                case R.id.green:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                    isColored = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.green);
                    mediaPlayer.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("GREEN");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = green;
                    break;

                case R.id.cat:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                    mediaPlayer.start();
                    animalSelected = cat;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("CAT");
                    outputText.setTextSize(30);
                    break;

                case R.id.dog:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                    mediaPlayer.start();
                    animalSelected = dog;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("DOG");
                    outputText.setTextSize(30);
                    break;

                case R.id.lion:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                    mediaPlayer.start();
                    animalSelected = lion;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("LION");
                    outputText.setTextSize(30);
                    break;

                case R.id.camel:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                    mediaPlayer.start();
                    animalSelected = camel;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("CAMEL");
                    outputText.setTextSize(30);
                    break;

                case R.id.rabbit:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                    mediaPlayer.start();
                    animalSelected = rabbit;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("RABBIT");
                    outputText.setTextSize(30);
                    break;

                case R.id.giraffe:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                    isAnimalSelected = true;
                    mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                    mediaPlayer.start();
                    animalSelected = giraffe;

                    outputImage.setVisibility(View.VISIBLE);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                    outputText.setText("GIRAFFE");
                    outputText.setTextSize(30);
                    break;
            }
        } else {

            switch (animalSelected.getId()) {

                case R.id.cat:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.redcat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.redcat);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("RED CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowcat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowcat);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.yellow));
                            outputText.setText("YELLOW CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangecat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangecat);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.orange));
                            outputText.setText("ORANGE CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluecat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluecat);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.blue));
                            outputText.setText("BLUE CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinkcat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinkcat);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.pink));
                            outputText.setText("PINK CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greencat));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greencat);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.green));
                            outputText.setText("GREEN CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                    }
                    break;

                case R.id.dog:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.reddog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.reddog);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("RED DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowdog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowdog);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("YELLOW DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangedog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangedog);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("ORANGE DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluedog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluedog);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("BLUE DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinkdog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinkdog);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("PINK DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greendog));
                            isColored = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greendog);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.red));
                            outputText.setText("GREEN DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                            break;
                    }
                    break;

                case R.id.lion:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.redlion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.redlion);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RED LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowlion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowlion);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("YELLOW LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangelion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangelion);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("ORANGE LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluelion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluelion);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("BLUE LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinklion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinklion);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("PINK LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greenlion));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greenlion);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GREEN LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                            break;
                    }
                    break;

                case R.id.camel:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.redcamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.redcamel);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RED CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowcamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowcamel);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("YELLOW CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangecamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangecamel);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("ORANGE CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluecamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluecamel);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("BLUE CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinkcamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinkcamel);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("PINK CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greencamel));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greencamel);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GREEN CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                            break;
                    }
                    break;

                case R.id.rabbit:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.redrabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.redrabbit);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RED RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowrabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowrabbit);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("YELLOW RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangerabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangerabbit);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("ORANGE RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluerabbit);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("BLUE RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinkrabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinkrabbit);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("PINK RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greenrabbit));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greenrabbit);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GREEN RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                            break;
                    }
                    break;

                case R.id.giraffe:

                    switch (id) {

                        case R.id.red:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.redgiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.redgiraffe);
                            mediaPlayer.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RED GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.yellow:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.yellowgiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.yellowgiraffe);
                            mediaPlayer.start();
                            colorSelected = yellow;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("YELLOW GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.orange:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.orangegiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.orangegiraffe);
                            mediaPlayer.start();
                            colorSelected = orange;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("ORANGE GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.blue:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.bluegiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.bluegiraffe);
                            mediaPlayer.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("BLUE GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.pinkgiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.pinkgiraffe);
                            mediaPlayer.start();
                            colorSelected = pink;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("PINK GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.green:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.greengiraffe));
                            isAnimalSelected = true;
                            mediaPlayer = MediaPlayer.create(this, R.raw.greengiraffe);
                            mediaPlayer.start();
                            colorSelected = green;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GREEN GIRAFFE");
                            outputText.setTextSize(30);
                            break;

                        case R.id.cat:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                            mediaPlayer = MediaPlayer.create(this, R.raw.cat);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.dog));
                            mediaPlayer = MediaPlayer.create(this, R.raw.dog);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.lion));
                            mediaPlayer = MediaPlayer.create(this, R.raw.lion);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.camel));
                            mediaPlayer = MediaPlayer.create(this, R.raw.camel);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.rabbit));
                            mediaPlayer = MediaPlayer.create(this, R.raw.rabbit);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.giraffe));
                            mediaPlayer = MediaPlayer.create(this, R.raw.giraffe);
                            mediaPlayer.start();
                            isAnimalSelected = true;
                            animalSelected = giraffe;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("GIRAFFE");
                            outputText.setTextSize(30);
                            break;
                    }
                    break;
            }
        }
    }
}
