package p.purechords.aeolianmeditationadvancedcontroller;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import oscP5.OscMessage;

import static p.purechords.aeolianmeditationadvancedcontroller.MainActivity.*;

public class SixthActivity extends AppCompatActivity {

    Float x1valData = 1.0f;
    Float y1valData = 1.0f;
    Float x2valData = 1.0f;
    Float y2valData = 1.0f;

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

                int normY = Math.round(((float) y / yMax) * 1000.0f);


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xybutton1Get.setBackgroundColor(myColorD);

                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        break;
                    case MotionEvent.ACTION_MOVE:

                        getMyNetAddress();
                        myMsgAddress = "/1/2525/1/129";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(normX);
                        oscP5.send(myOscMessage, getBroadcastLocation);

                        myMsgAddress = "/1/2525/1/133";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(normY);
                        oscP5.send(myOscMessage, getBroadcastLocation);

                        x1valData = event.getX();
                        y1valData = event.getY();

                        xyLocator1Get.setX(x1valData);
                        xyLocator1Get.setY(y1valData);

                        break;

                    case MotionEvent.ACTION_UP:
                        myMsgAddress = "/1/2525/1/194";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);

                        xybutton1Get.setBackgroundColor(myColorC);
                        break;
                }

                return true;

            }
        });

    } // end create

} // end activity
