package p.purechords.aeolianmeditationadvancedcontroller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import oscP5.OscMessage;

import static p.purechords.aeolianmeditationadvancedcontroller.MainActivity.*;

public class SixthActivity extends AppCompatActivity {

    Float x1valData = 1.0f;
    Float y1valData = 1.0f;
    Float x2valData = 1.0f;
    Float y2valData = 1.0f;

    int xyMode = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sixth);

        /////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// Navigator Buttons Start
        /////////////////////////////////////////////////////////////////////////////

        final Button buttonHarmonicsPageGet = findViewById(R.id.buttonToHarmonicsPage);
        buttonHarmonicsPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonHarmonicsPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SixthActivity.this, SecondActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonHarmonicsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToMainPageGet = findViewById(R.id.buttonToMainPage);
        buttonToMainPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToMainPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SixthActivity.this, MainActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToMainPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToSourcePageGet = findViewById(R.id.buttonToSourcePage);
        buttonToSourcePageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToSourcePageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SixthActivity.this, FifthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToSourcePageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToNoisePageGet = findViewById(R.id.buttonToNoisePage);
        buttonToNoisePageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToNoisePageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SixthActivity.this, ThirdActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToNoisePageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToEffectsPageGet = findViewById(R.id.buttonToEffectsPage);
        buttonToEffectsPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToEffectsPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SixthActivity.this, FourthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToEffectsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToPerformPageGet = findViewById(R.id.buttonToPerformPage);
        buttonToPerformPageGet.setBackgroundColor(myColorD);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// Navigator Buttons End
        ////////////////////////////////////////////////////////////////////////////////////////////

        final ToggleButton xyTrig1Get = findViewById(R.id.toggleButtonXyTrig1);
       /* if (devicePower == 127) {
            devicePowerGet.setChecked(true);
            devicePowerGet.setBackgroundColor(myColorD);
        }*/
        xyTrig1Get.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    xyTrig1Get.setBackgroundColor(myColorD);
                } else {
                    xyTrig1Get.setBackgroundColor(myColorC);
                }
            }
        });

        final ToggleButton xyTrig2Get = findViewById(R.id.toggleButtonXyTrig2);
       /* if (devicePower == 127) {
            devicePowerGet.setChecked(true);
            devicePowerGet.setBackgroundColor(myColorD);
        }*/
        xyTrig2Get.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    xyTrig2Get.setBackgroundColor(myColorD);
                } else {
                    xyTrig2Get.setBackgroundColor(myColorC);
                }
            }
        });


        ////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// XY Listeners Start
        ////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////// XY 1  Start

        final Button xyLocator1Get = findViewById(R.id.buttonXyLocator1);
        final Button xybutton1Get = findViewById(R.id.xyButtonBack1);
        xybutton1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int xMax = xybutton1Get.getWidth();
                int yMax = xybutton1Get.getHeight();

                int x = Math.round(event.getX());
                if (x < 0){x = 0;}
                if (x > xMax){
                    x = xMax;
                }

                int normX = Math.round(((float) x / xMax) * 127.0f);

                int y = Math.round(yMax - event.getY());
                if (y < 0){y = 0;}
                if (y > yMax){
                    y = yMax;
                }

                int normY = 0;

                if (xyMode == 0) {
                    normY = Math.round(((float) y / yMax) * 1000.0f);
                }
                if (xyMode == 1 || xyMode == 2) {
                    normY = Math.round(((float) y / yMax) * 127.0f);
                }

                String myMsgAddress;
                OscMessage myOscMessage;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xybutton1Get.setBackgroundColor(myColorD);
                        if (xyTrig1Get.isChecked()) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/194";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(127);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:

                        if (xyMode == 0) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/129";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/133";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        if (xyMode == 1) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/151";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/152";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        if (xyMode == 2) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/99";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/100";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        x1valData = event.getX();
                        y1valData = event.getY();

                        xyLocator1Get.setX(x1valData);
                        xyLocator1Get.setY(y1valData);

                        break;

                    case MotionEvent.ACTION_UP:
                        if (xyTrig1Get.isChecked()) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/194";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(0);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }
                        xybutton1Get.setBackgroundColor(myColorC);


                        break;
                }

                return true;

            }
        }); // end xy listener

        ///////////////////////////////////////////////////// XY 1 End

        ///////////////////////////////////////////////////// XY 2 Start

        final Button xyLocator2Get = findViewById(R.id.buttonXyLocator2);
        final Button xybutton2Get = findViewById(R.id.xyButtonBack2);
        xybutton2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int xMax = xybutton2Get.getWidth();
                int yMax = xybutton2Get.getHeight();

                int x = Math.round(event.getX());
                if (x < 0){x = 0;}
                if (x > xMax){
                    x = xMax;
                }

                int normX = Math.round(((float) x / xMax) * 127.0f);

                int y = Math.round(yMax - event.getY());
                if (y < 0){y = 0;}
                if (y > yMax){
                    y = yMax;
                }

                int normY = 0;

                if (xyMode == 0) {
                    normY = Math.round(((float) y / yMax) * 100.0f);
                }
                if (xyMode == 1 || xyMode == 2) {
                    normY = Math.round(((float) y / yMax) * 127.0f);
                }

                String myMsgAddress;
                OscMessage myOscMessage;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (xyTrig2Get.isChecked()) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/194";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(127);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }
                        xybutton2Get.setBackgroundColor(myColorD);
                        break;
                    case MotionEvent.ACTION_MOVE:

                        if (xyMode == 0) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/139";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/137";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        if (xyMode == 1) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/153";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/154";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        if (xyMode == 2) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/101";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/102";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normY);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }

                        x2valData = event.getX();
                        y2valData = event.getY();

                        xyLocator2Get.setX(x2valData);
                        xyLocator2Get.setY(y2valData);

                        break;

                    case MotionEvent.ACTION_UP:
                        if (xyTrig2Get.isChecked()) {
                            getMyNetAddress();
                            myMsgAddress = "/1/2525/1/194";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(0);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                        }
                        xybutton2Get.setBackgroundColor(myColorC);
                        break;
                }

                return true;

            }
        }); // end xy listener

        ///////////////////////////////////////////////////// XY 2 End

        ////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// XY Listeners End
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        Spinner spinnerXyModeGet = (findViewById(R.id.spinnerXyMode));
        spinnerXyModeGet.setOnItemSelectedListener(new SixthActivity.CustomOnItemSelectedListenerXyMode());
        ArrayAdapter adapterXyMode = ArrayAdapter.createFromResource(this,
                R.array.spinnerLiveMode, R.layout.spinner_item);
        spinnerXyModeGet.setAdapter(adapterXyMode);
        spinnerXyModeGet.setSelection(xyMode);

    } // end create

    public class CustomOnItemSelectedListenerXyMode implements AdapterView.OnItemSelectedListener {

        @SuppressLint("SetTextI18n")
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            final TextView xParam1Get = findViewById(R.id.textViewXparam1);
            final TextView yParam1Get = findViewById(R.id.textViewYparam1);
            final TextView xParam2Get = findViewById(R.id.textViewXparam2);
            final TextView yParam2Get = findViewById(R.id.textViewYparam2);

            xyMode = position;
            switch (xyMode) {
                    case 0:
                        xParam1Get.setText("X = Source Freq");
                        yParam1Get.setText("Y = Harmonic Mix");
                        xParam2Get.setText("X = FM Freq");
                        yParam2Get.setText("Y = FM Depth");
                        break;
                case 1:
                    xParam1Get.setText("X = Filter Cut");
                    yParam1Get.setText("Y = Filter Res");
                    xParam2Get.setText("X = Filter Mod");
                    yParam2Get.setText("Y = Filter Rate");
                    break;
                case 2:
                    xParam1Get.setText("X = Noise Cut 1");
                    yParam1Get.setText("Y = Noise Cut 2");
                    xParam2Get.setText("X = Noise Cut 3");
                    yParam2Get.setText("Y = Noise Cut 4");
                    break;

            } // end switch
            }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

} // end activity
