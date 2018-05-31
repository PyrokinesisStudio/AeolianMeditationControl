package p.purechords.aeolianmeditationadvancedcontroller;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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
                if (xyMode == 1) {
                    normY = Math.round(((float) y / yMax) * 127.0f);
                }

                String myMsgAddress;
                OscMessage myOscMessage;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xybutton1Get.setBackgroundColor(myColorD);

                        if (xyMode == 0) {
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

                        x1valData = event.getX();
                        y1valData = event.getY();

                        xyLocator1Get.setX(x1valData);
                        xyLocator1Get.setY(y1valData);

                        break;

                    case MotionEvent.ACTION_UP:
                        getMyNetAddress();
                        myMsgAddress = "/1/2525/1/194";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);

                        xybutton1Get.setBackgroundColor(myColorC);
                        break;
                }

                return true;

            }
        }); // end xy listener

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
                    normY = Math.round(((float) y / yMax) * 500.0f);
                }
                if (xyMode == 1) {
                    normY = Math.round(((float) y / yMax) * 127.0f);
                }

                String myMsgAddress;
                OscMessage myOscMessage;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xybutton2Get.setBackgroundColor(myColorD);
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
                            myMsgAddress = "/1/2525/1/151";
                            myOscMessage = new OscMessage(myMsgAddress);
                            myOscMessage.add(normX);
                            oscP5.send(myOscMessage, getBroadcastLocation);

                            myMsgAddress = "/1/2525/1/152";
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
                        xybutton2Get.setBackgroundColor(myColorC);
                        break;
                }

                return true;

            }
        }); // end xy listener

        Spinner spinnerXyModeGet = (findViewById(R.id.spinnerXyMode));
        spinnerXyModeGet.setOnItemSelectedListener(new SixthActivity.CustomOnItemSelectedListenerXyMode());
        ArrayAdapter adapterXyMode = ArrayAdapter.createFromResource(this,
                R.array.spinnerLiveMode, R.layout.spinner_item);
        spinnerXyModeGet.setAdapter(adapterXyMode);
        spinnerXyModeGet.setSelection(xyMode);

    } // end create

    public class CustomOnItemSelectedListenerXyMode implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            xyMode = position;

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

} // end activity
