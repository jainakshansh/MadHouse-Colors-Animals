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
    private MediaPlayer redCatS, redDogS, redLionS, redCamelS, redRabbitS, redGiraffeS;
    private MediaPlayer yellowCatS, yellowDogS, yellowLionS, yellowCamelS, yellowRabbitS, yellowGiraffeS;
    private MediaPlayer greenCatS, greenDogS, greenLionS, greenCamelS, greenRabbitS, greenGiraffeS;
    private MediaPlayer blueCatS, blueDogS, blueLionS, blueCamelS, blueRabbitS, blueGiraffeS;
    private MediaPlayer pinkCatS, pinkDogS, pinkLionS, pinkCamelS, pinkRabbitS, pinkGiraffeS;
    private MediaPlayer orangeCatS, orangeDogS, orangeLionS, orangeCamelS, orangeRabbitS, orangeGiraffeS;

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

        //Combination of Cat
        redCatS = MediaPlayer.create(this, R.raw.redcat);
        yellowCatS = MediaPlayer.create(this, R.raw.yellowcat);
        greenCatS = MediaPlayer.create(this, R.raw.greencat);
        blueCatS = MediaPlayer.create(this, R.raw.bluecat);
        pinkCatS = MediaPlayer.create(this, R.raw.pinkcat);
        orangeCatS = MediaPlayer.create(this, R.raw.orangecat);

        //Combination of Dog
        redDogS = MediaPlayer.create(this, R.raw.reddog);
        yellowDogS = MediaPlayer.create(this, R.raw.yellowdog);
        greenDogS = MediaPlayer.create(this, R.raw.greendog);
        blueDogS = MediaPlayer.create(this, R.raw.bluedog);
        pinkDogS = MediaPlayer.create(this, R.raw.pinkdog);
        orangeDogS = MediaPlayer.create(this, R.raw.orangedog);

        //Combination of Lion
        redLionS = MediaPlayer.create(this, R.raw.redlion);
        yellowLionS = MediaPlayer.create(this, R.raw.yellowlion);
        greenLionS = MediaPlayer.create(this, R.raw.greenlion);
        blueLionS = MediaPlayer.create(this, R.raw.bluelion);
        pinkLionS = MediaPlayer.create(this, R.raw.pinklion);
        orangeLionS = MediaPlayer.create(this, R.raw.orangelion);

        //Combination of Camel
        redCamelS = MediaPlayer.create(this, R.raw.redcamel);
        yellowCamelS = MediaPlayer.create(this, R.raw.yellowcamel);
        greenCamelS = MediaPlayer.create(this, R.raw.greencamel);
        blueCamelS = MediaPlayer.create(this, R.raw.bluecamel);
        pinkCamelS = MediaPlayer.create(this, R.raw.pinkcamel);
        orangeCamelS = MediaPlayer.create(this, R.raw.orangecamel);

        //Combination of Rabbit
        redRabbitS = MediaPlayer.create(this, R.raw.redrabbit);
        yellowRabbitS = MediaPlayer.create(this, R.raw.yellowrabbit);
        greenRabbitS = MediaPlayer.create(this, R.raw.greenrabbit);
        blueRabbitS = MediaPlayer.create(this, R.raw.bluerabbit);
        pinkRabbitS = MediaPlayer.create(this, R.raw.pinkrabbit);
        orangeRabbitS = MediaPlayer.create(this, R.raw.orangerabbit);

        //Combination of Giraffe
        redGiraffeS = MediaPlayer.create(this, R.raw.redgiraffe);
        yellowGiraffeS = MediaPlayer.create(this, R.raw.yellowgiraffe);
        greenGiraffeS = MediaPlayer.create(this, R.raw.greengiraffe);
        blueGiraffeS = MediaPlayer.create(this, R.raw.bluegiraffe);
        pinkGiraffeS = MediaPlayer.create(this, R.raw.pinkgiraffe);
        orangeGiraffeS = MediaPlayer.create(this, R.raw.orangegiraffe);

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
        if (mediaPlayer != null){
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
                            redCatS.start();
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
                            yellowCatS.start();
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
                            orangeCatS.start();
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
                            blueCatS.start();
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
                            pinkCatS.start();
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
                            greenCatS.start();
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
                            redDogS.start();
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
                            yellowDogS.start();
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
                            orangeDogS.start();
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
                            blueDogS.start();
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
                            pinkDogS.start();
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
                            greenDogS.start();
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
                            redLionS.start();
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
                            yellowLionS.start();
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
                            orangeLionS.start();
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
                            blueLionS.start();
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
                            pinkLionS.start();
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
                            greenLionS.start();
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
                            redCamelS.start();
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
                            yellowCamelS.start();
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
                            orangeCamelS.start();
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
                            blueCamelS.start();
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
                            pinkCamelS.start();
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
                            greenCamelS.start();
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
                            redRabbitS.start();
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
                            yellowRabbitS.start();
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
                            orangeRabbitS.start();
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
                            blueRabbitS.start();
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
                            pinkRabbitS.start();
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
                            greenRabbitS.start();
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
                            redGiraffeS.start();
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
                            yellowGiraffeS.start();
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
                            orangeGiraffeS.start();
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
                            blueGiraffeS.start();
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
                            pinkGiraffeS.start();
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
                            greenGiraffeS.start();
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
