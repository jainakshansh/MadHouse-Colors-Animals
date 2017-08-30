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

    private MediaPlayer redS, yellowS, orangeS, blueS, pinkS, greenS;
    private MediaPlayer catS, dogS, lionS, camelS, rabbitS, giraffeS;

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

        //Colors
        redS = MediaPlayer.create(this, R.raw.red);
        yellowS = MediaPlayer.create(this, R.raw.yellow);
        greenS = MediaPlayer.create(this, R.raw.green);
        blueS = MediaPlayer.create(this, R.raw.blue);
        pinkS = MediaPlayer.create(this, R.raw.pink);
        orangeS = MediaPlayer.create(this, R.raw.orange);

        //Animals
        catS = MediaPlayer.create(this, R.raw.cat);
        dogS = MediaPlayer.create(this, R.raw.dog);
        lionS = MediaPlayer.create(this, R.raw.lion);
        camelS = MediaPlayer.create(this, R.raw.camel);
        rabbitS = MediaPlayer.create(this, R.raw.rabbit);
        giraffeS = MediaPlayer.create(this, R.raw.giraffe);

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
        greenDogS = MediaPlayer.create(this, R.raw.yellowdog);
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
        int id = view.getId();

        if (!isAnimalSelected) {

            switch (id) {

                case R.id.red:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                    isColored = true;
                    redS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("RED");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = red;
                    break;

                case R.id.yellow:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
                    isColored = true;
                    yellowS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("YELLOW");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = yellow;
                    break;

                case R.id.orange:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
                    isColored = true;
                    orangeS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("ORANGE");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = orange;
                    break;

                case R.id.blue:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
                    isColored = true;
                    blueS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("BLUE");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = blue;
                    break;

                case R.id.pink:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
                    isColored = true;
                    pinkS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("PINK");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = pink;
                    break;

                case R.id.green:
                    output.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                    isColored = true;
                    greenS.start();

                    outputImage.setVisibility(View.GONE);
                    outputText.setText("GREEN");
                    outputText.setTextSize(50);
                    outputText.setTextColor(ContextCompat.getColor(this, android.R.color.white));
                    colorSelected = green;
                    break;

                case R.id.cat:
                    output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                    outputImage.setBackground(ContextCompat.getDrawable(this, 0));
                    outputImage.setBackground(ContextCompat.getDrawable(this, R.drawable.cat));
                    isAnimalSelected = true;
                    catS.start();
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
                    dogS.start();
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
                    lionS.start();
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
                    camelS.start();
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
                    rabbitS.start();
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
                    giraffeS.start();
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
                            outputImage.setImageResource(R.drawable.redcat);
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
                            outputImage.setImageResource(R.drawable.yellowcat);
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
                            outputImage.setImageResource(R.drawable.orangecat);
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
                            outputImage.setImageResource(R.drawable.bluecat);
                            isColored = true;
                            blueCatS.start();
                            colorSelected = blue;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
                            outputText.setText("BLUE CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.pink:
                            outputImage.setImageResource(R.drawable.pinkcat);
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
                            outputImage.setImageResource(R.drawable.greencat);
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
                            outputImage.setImageResource(R.drawable.cat);
                            catS.start();
                            isAnimalSelected = true;
                            animalSelected = cat;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.dog:
                            outputImage.setImageResource(R.drawable.dog);
                            dogS.start();
                            isAnimalSelected = true;
                            animalSelected = dog;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("DOG");
                            outputText.setTextSize(30);
                            break;

                        case R.id.lion:
                            outputImage.setImageResource(R.drawable.lion);
                            lionS.start();
                            isAnimalSelected = true;
                            animalSelected = lion;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("LION");
                            outputText.setTextSize(30);
                            break;

                        case R.id.camel:
                            outputImage.setImageResource(R.drawable.camel);
                            camelS.start();
                            isAnimalSelected = true;
                            animalSelected = camel;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("CAMEL");
                            outputText.setTextSize(30);
                            break;

                        case R.id.rabbit:
                            outputImage.setImageResource(R.drawable.rabbit);
                            rabbitS.start();
                            isAnimalSelected = true;
                            animalSelected = rabbit;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.VISIBLE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RABBIT");
                            outputText.setTextSize(30);
                            break;

                        case R.id.giraffe:
                            outputImage.setImageResource(R.drawable.giraffe);
                            giraffeS.start();
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
                            outputImage.setImageResource(R.drawable.reddog);
                            isColored = true;
                            redDogS.start();
                            colorSelected = red;

                            output.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
                            outputImage.setVisibility(View.GONE);
                            outputText.setTextColor(ContextCompat.getColor(this, android.R.color.black));
                            outputText.setText("RED DOG");
                            outputText.setTextSize(30);
                            break;
                    }
            }
        }
    }
}
