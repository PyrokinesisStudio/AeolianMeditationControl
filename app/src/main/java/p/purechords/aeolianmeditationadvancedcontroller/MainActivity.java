package p.purechords.aeolianmeditationadvancedcontroller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.rey.material.widget.Slider;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import netP5.NetAddress;
import oscP5.OscMessage;
import oscP5.OscP5;
import oscP5.OscProperties;
import p.purechords.aeolianmeditationadvancedcontroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////////// Color declarations Start

    public static int myColorA = Color.parseColor("#FFFFFFFF");
    public static int myColorB = Color.parseColor("#d5dae2");
    public static int myColorC = Color.parseColor("#ff4F75A1");
    public static int myColorD = Color.parseColor("#7dd0f4");
    public static int myColorE = Color.parseColor("#000000");
    public static int myColorF = Color.parseColor("#353535");

    ///////////////////////////////////////////////////////// Color declarations End

    ///////////////////////////////////////////////////////// OSC Variables Start

    // Innit OSC
    public static OscP5 oscP5;

    //  NetAddress myBroadcastLocation;
    public static NetAddress getBroadcastLocation;

    // ip and port
    public static String ipData = "84.111.138.155";
    public static int portData = 8000;
    public static String myIp = "xxx.xxx.xxx.xxx";

    // Connection Check
    public static int connectionCheck = 0;

    //
    public static OscMessage theOscMessage;

    /////////////////////// Observables
    public static ObsInt obsInt;
    public static ObsIntNoiseMix obsIntNoiseMix;
    public static ObsIntOutputVol obsIntOutputVol;
    public static ObsIntDevicePower obsIntDevicePower;
    public static ObsIntDrone obsIntDrone;

    public static ObsIntBpm obsIntBpm;
    public static ObsIntMidiChan obsIntMidiChan;
    public static ObsIntKeyboardOct obsIntkeyboardOct;

    public static ObsIntEnvA obsIntEnvA;
    public static ObsIntEnvD obsIntEnvD;
    public static ObsIntEnvS obsIntEnvS;
    public static ObsIntEnvR obsIntEnvR;

    public static ObsIntHarmVol1 obsIntHarmVol1;
    public static ObsIntHarmVol2 obsIntHarmVol2;
    public static ObsIntHarmVol3 obsIntHarmVol3;
    public static ObsIntHarmVol4 obsIntHarmVol4;
    public static ObsIntHarmVol5 obsIntHarmVol5;
    public static ObsIntHarmVol6 obsIntHarmVol6;
    public static ObsIntHarmVol7 obsIntHarmVol7;
    public static ObsIntHarmVol8 obsIntHarmVol8;
    public static ObsIntHarmVol9 obsIntHarmVol9;
    public static ObsIntHarmVol10 obsIntHarmVol10;
    public static ObsIntHarmVol11 obsIntHarmVol11;
    public static ObsIntHarmVol12 obsIntHarmVol12;

    public static ObsIntHarmMod1 obsIntHarmMod1;
    public static ObsIntHarmMod2 obsIntHarmMod2;
    public static ObsIntHarmMod3 obsIntHarmMod3;
    public static ObsIntHarmMod4 obsIntHarmMod4;
    public static ObsIntHarmMod5 obsIntHarmMod5;
    public static ObsIntHarmMod6 obsIntHarmMod6;
    public static ObsIntHarmMod7 obsIntHarmMod7;
    public static ObsIntHarmMod8 obsIntHarmMod8;
    public static ObsIntHarmMod9 obsIntHarmMod9;
    public static ObsIntHarmMod10 obsIntHarmMod10;
    public static ObsIntHarmMod11 obsIntHarmMod11;
    public static ObsIntHarmMod12 obsIntHarmMod12;

    public static ObsIntHarmRate1 obsIntHarmRate1;
    public static ObsIntHarmRate2 obsIntHarmRate2;
    public static ObsIntHarmRate3 obsIntHarmRate3;
    public static ObsIntHarmRate4 obsIntHarmRate4;
    public static ObsIntHarmRate5 obsIntHarmRate5;
    public static ObsIntHarmRate6 obsIntHarmRate6;
    public static ObsIntHarmRate7 obsIntHarmRate7;
    public static ObsIntHarmRate8 obsIntHarmRate8;
    public static ObsIntHarmRate9 obsIntHarmRate9;
    public static ObsIntHarmRate10 obsIntHarmRate10;
    public static ObsIntHarmRate11 obsIntHarmRate11;
    public static ObsIntHarmRate12 obsIntHarmRate12;

    public static ObsIntHarmRateRange obsIntHarmRateRange;

    public static ObsIntHarmRetrig1 obsIntHarmRetrig1;
    public static ObsIntHarmRetrig2 obsIntHarmRetrig2;
    public static ObsIntHarmRetrig3 obsIntHarmRetrig3;
    public static ObsIntHarmRetrig4 obsIntHarmRetrig4;
    public static ObsIntHarmRetrig5 obsIntHarmRetrig5;
    public static ObsIntHarmRetrig6 obsIntHarmRetrig6;
    public static ObsIntHarmRetrig7 obsIntHarmRetrig7;
    public static ObsIntHarmRetrig8 obsIntHarmRetrig8;
    public static ObsIntHarmRetrig9 obsIntHarmRetrig9;
    public static ObsIntHarmRetrig10 obsIntHarmRetrig10;
    public static ObsIntHarmRetrig11 obsIntHarmRetrig11;
    public static ObsIntHarmRetrig12 obsIntHarmRetrig12;

    public static ObsIntHarmSync1 obsIntHarmSync1;
    public static ObsIntHarmSync2 obsIntHarmSync2;
    public static ObsIntHarmSync3 obsIntHarmSync3;
    public static ObsIntHarmSync4 obsIntHarmSync4;
    public static ObsIntHarmSync5 obsIntHarmSync5;
    public static ObsIntHarmSync6 obsIntHarmSync6;
    public static ObsIntHarmSync7 obsIntHarmSync7;
    public static ObsIntHarmSync8 obsIntHarmSync8;
    public static ObsIntHarmSync9 obsIntHarmSync9;
    public static ObsIntHarmSync10 obsIntHarmSync10;
    public static ObsIntHarmSync11 obsIntHarmSync11;
    public static ObsIntHarmSync12 obsIntHarmSync12;

    public static ObsIntHarmDiv1 obsIntHarmDiv1;
    public static ObsIntHarmDiv2 obsIntHarmDiv2;
    public static ObsIntHarmDiv3 obsIntHarmDiv3;
    public static ObsIntHarmDiv4 obsIntHarmDiv4;
    public static ObsIntHarmDiv5 obsIntHarmDiv5;
    public static ObsIntHarmDiv6 obsIntHarmDiv6;
    public static ObsIntHarmDiv7 obsIntHarmDiv7;
    public static ObsIntHarmDiv8 obsIntHarmDiv8;
    public static ObsIntHarmDiv9 obsIntHarmDiv9;
    public static ObsIntHarmDiv10 obsIntHarmDiv10;
    public static ObsIntHarmDiv11 obsIntHarmDiv11;
    public static ObsIntHarmDiv12 obsIntHarmDiv12;

    public static ObsIntNoiseVol1 obsIntNoiseVol1;
    public static ObsIntNoiseVol2 obsIntNoiseVol2;
    public static ObsIntNoiseVol3 obsIntNoiseVol3;
    public static ObsIntNoiseVol4 obsIntNoiseVol4;

    public static ObsIntNoiseVolMod1 obsIntNoiseVolMod1;
    public static ObsIntNoiseVolMod2 obsIntNoiseVolMod2;
    public static ObsIntNoiseVolMod3 obsIntNoiseVolMod3;
    public static ObsIntNoiseVolMod4 obsIntNoiseVolMod4;

    public static ObsIntNoiseVolRate1 obsIntNoiseVolRate1;
    public static ObsIntNoiseVolRate2 obsIntNoiseVolRate2;
    public static ObsIntNoiseVolRate3 obsIntNoiseVolRate3;
    public static ObsIntNoiseVolRate4 obsIntNoiseVolRate4;

    public static ObsIntNoiseVolDiv1 obsIntNoiseVolDiv1;
    public static ObsIntNoiseVolDiv2 obsIntNoiseVolDiv2;
    public static ObsIntNoiseVolDiv3 obsIntNoiseVolDiv3;
    public static ObsIntNoiseVolDiv4 obsIntNoiseVolDiv4;

    public static ObsIntNoiseVolSync1 obsIntNoiseVolSync1;
    public static ObsIntNoiseVolSync2 obsIntNoiseVolSync2;
    public static ObsIntNoiseVolSync3 obsIntNoiseVolSync3;
    public static ObsIntNoiseVolSync4 obsIntNoiseVolSync4;

    public static ObsIntNoiseVolRetrig1 obsIntNoiseVolRetrig1;
    public static ObsIntNoiseVolRetrig2 obsIntNoiseVolRetrig2;
    public static ObsIntNoiseVolRetrig3 obsIntNoiseVolRetrig3;
    public static ObsIntNoiseVolRetrig4 obsIntNoiseVolRetrig4;

    public static ObsIntNoiseCut1 obsIntNoiseCut1;
    public static ObsIntNoiseCut2 obsIntNoiseCut2;
    public static ObsIntNoiseCut3 obsIntNoiseCut3;
    public static ObsIntNoiseCut4 obsIntNoiseCut4;

    public static ObsIntNoiseRes1 obsIntNoiseRes1;
    public static ObsIntNoiseRes2 obsIntNoiseRes2;
    public static ObsIntNoiseRes3 obsIntNoiseRes3;
    public static ObsIntNoiseRes4 obsIntNoiseRes4;

    public static ObsIntNoiseCutMod1 obsIntNoiseCutMod1;
    public static ObsIntNoiseCutMod2 obsIntNoiseCutMod2;
    public static ObsIntNoiseCutMod3 obsIntNoiseCutMod3;
    public static ObsIntNoiseCutMod4 obsIntNoiseCutMod4;

    public static ObsIntNoiseCutRate1 obsIntNoiseCutRate1;
    public static ObsIntNoiseCutRate2 obsIntNoiseCutRate2;
    public static ObsIntNoiseCutRate3 obsIntNoiseCutRate3;
    public static ObsIntNoiseCutRate4 obsIntNoiseCutRate4;

    public static ObsIntNoiseCutDiv1 obsIntNoiseCutDiv1;
    public static ObsIntNoiseCutDiv2 obsIntNoiseCutDiv2;
    public static ObsIntNoiseCutDiv3 obsIntNoiseCutDiv3;
    public static ObsIntNoiseCutDiv4 obsIntNoiseCutDiv4;

    public static ObsIntNoiseCutSync1 obsIntNoiseCutSync1;
    public static ObsIntNoiseCutSync2 obsIntNoiseCutSync2;
    public static ObsIntNoiseCutSync3 obsIntNoiseCutSync3;
    public static ObsIntNoiseCutSync4 obsIntNoiseCutSync4;

    public static ObsIntNoiseCutRetrig1 obsIntNoiseCutRetrig1;
    public static ObsIntNoiseCutRetrig2 obsIntNoiseCutRetrig2;
    public static ObsIntNoiseCutRetrig3 obsIntNoiseCutRetrig3;
    public static ObsIntNoiseCutRetrig4 obsIntNoiseCutRetrig4;

    public static ObsIntNoisePink obsIntNoisePink;
    public static ObsIntNoiseRateRangeVol obsIntNoiseRateRangeVol;
    public static ObsIntNoiseRateRangeCut obsIntNoiseRateRangeCut;

    public static ObsIntSourceSelect obsIntSourceSelect;
    public static ObsIntSourceNote obsIntSourceNote;
    public static ObsIntSourceFreq obsIntSourceFreq;
    public static ObsIntSourceMidiOct obsIntSourceMidiOct;

    public static ObsIntFmSelect obsIntFmSelect;
    public static ObsIntFmNote obsIntFmNote;
    public static ObsIntFmFreq obsIntFmFreq;
    public static ObsIntFmMidiOct obsIntFmMidiOct;

    public static ObsIntFmDepth obsIntFmDepth;

    public static ObsIntFmDepthModDepth obsIntFmDepthModDepth;
    public static ObsIntFmDepthModRate obsIntFmDepthModRate;
    public static ObsIntFmDepthModSync obsIntFmDepthModSync;
    public static ObsIntFmDepthModDiv obsIntFmDepthModDiv;
    public static ObsIntFmDepthModRetrig obsIntFmDepthModRetrig;

    public static ObsIntFmFreqModDepth obsIntFmFreqModDepth;
    public static ObsIntFmFreqModRate obsIntFmFreqModRate;
    public static ObsIntFmFreqModSync obsIntFmFreqModSync;
    public static ObsIntFmFreqModDiv obsIntFmFreqModDiv;
    public static ObsIntFmFreqModRetrig obsIntFmFreqModRetrig;

    public static ObsIntDcKill obsIntDcKill;

    public static ObsIntFilterPower obsIntFilterPower;
    public static ObsIntFilterCut obsIntFilterCut;
    public static ObsIntFilterRes obsIntFilterRes;
    public static ObsIntFilterEnv obsIntFilterEnv;
    public static ObsIntFilterMod obsIntFilterMod;
    public static ObsIntFilterRate obsIntFilterRate;
    public static ObsIntFilterSync obsIntFilterSync;
    public static ObsIntFilterDiv obsIntFilterDiv;
    public static ObsIntFilterRetrig obsIntFilterRetrig;

    public static ObsIntDecimatePower obsIntDecimatePower;
    public static ObsIntDecimateReduce obsIntDecimateReduce;
    public static ObsIntDecimateMod obsIntDecimateMod;
    public static ObsIntDecimateRate obsIntDecimateRate;
    public static ObsIntDecimateSync obsIntDecimateSync;
    public static ObsIntDecimateDiv obsIntDecimateDiv;
    public static ObsIntDecimateRetrig obsIntDecimateRetrig;

    public static ObsIntDelayPower obsIntDelayPower;
    public static ObsIntDelayTime obsIntDelayTime;
    public static ObsIntDelayTimeR obsIntDelayTimeR;
    public static ObsIntDelaySync obsIntDelaySync;
    public static ObsIntDelayDiv obsIntDelayDiv;
    public static ObsIntDelayDivR obsIntDelayDivR;
    public static ObsIntDelayFeed obsIntDelayFeed;
    public static ObsIntDelayWet obsIntDelayWet;

    public static ObsIntChorusPower obsIntChorusPower;
    public static ObsIntChorusRate obsIntChorusRate;
    public static ObsIntChorusDepth obsIntChorusDepth;
    public static ObsIntChorusDelay obsIntChorusDelay;
    public static ObsIntChorusFeed obsIntChorusFeed;
    public static ObsIntChorusWet obsIntChorusWet;

    public static ObsIntReverbPower obsIntReverbPower;
    public static ObsIntReverbSize obsIntReverbSize;
    public static ObsIntReverbDamp obsIntReverbDamp;
    public static ObsIntReverbWidth obsIntReverbWidth;
    public static ObsIntReverbWet obsIntReverbWet;

    ///////////////////////////////////////////////////////// OSC Variables End

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////// All Parameter Shared Pref Variables Start

    /////////////////////////////////////////// Main Page - Main Activity Variables Start

    // mix section
    public static int harmMix = 0;
    public static int noiseMix = 0;
    public static int outputVolume = 1;

    // envelope
    public static int envelopeA =1;
    public static int envelopeD =1;
    public static int envelopeS =1;
    public static int envelopeR =1;
    public static int droneVal = 0;

    // main settings
    public static int devicePower = 0;
    public static int bpmData = 120;
    public static int midiChan = 0;

    public static int keyboardOctave = 5;
    /////////////////////////////////////////// Main Page - Main Activity Variables End

    /////////////////////////////////////////// Harmonics Page - Second Activity Variables Start

    // harmonics volumes
    public static int harmVol1 = 1;
    public static int harmVol2 = 1;
    public static int harmVol3 = 1;
    public static int harmVol4 = 1;
    public static int harmVol5 = 1;
    public static int harmVol6 = 1;
    public static int harmVol7 = 1;
    public static int harmVol8 = 1;
    public static int harmVol9 = 1;
    public static int harmVol10 = 1;
    public static int harmVol11 = 1;
    public static int harmVol12 = 1;

    // harmonics mod
    public static int harmVolMod1 = 1;
    public static int harmVolMod2 = 1;
    public static int harmVolMod3 = 1;
    public static int harmVolMod4 = 1;
    public static int harmVolMod5 = 1;
    public static int harmVolMod6 = 1;
    public static int harmVolMod7 = 1;
    public static int harmVolMod8 = 1;
    public static int harmVolMod9 = 1;
    public static int harmVolMod10 = 1;
    public static int harmVolMod11 = 1;
    public static int harmVolMod12 = 1;

    // harmonics rates
    public static int harmVolRate1 = 1;
    public static int harmVolRate2 = 1;
    public static int harmVolRate3 = 1;
    public static int harmVolRate4 = 1;
    public static int harmVolRate5 = 1;
    public static int harmVolRate6 = 1;
    public static int harmVolRate7 = 1;
    public static int harmVolRate8 = 1;
    public static int harmVolRate9 = 1;
    public static int harmVolRate10 = 1;
    public static int harmVolRate11 = 1;
    public static int harmVolRate12 = 1;

    // harmonics sync
    public static int harmVolSync1 = 0;
    public static int harmVolSync2 = 0;
    public static int harmVolSync3 = 0;
    public static int harmVolSync4 = 0;
    public static int harmVolSync5 = 0;
    public static int harmVolSync6 = 0;
    public static int harmVolSync7 = 0;
    public static int harmVolSync8 = 0;
    public static int harmVolSync9 = 0;
    public static int harmVolSync10 = 0;
    public static int harmVolSync11 = 0;
    public static int harmVolSync12 = 0;

    // harmonics retrig
    public static int harmVolRetrig1 = 0;
    public static int harmVolRetrig2 = 0;
    public static int harmVolRetrig3 = 0;
    public static int harmVolRetrig4 = 0;
    public static int harmVolRetrig5 = 0;
    public static int harmVolRetrig6 = 0;
    public static int harmVolRetrig7 = 0;
    public static int harmVolRetrig8 = 0;
    public static int harmVolRetrig9 = 0;
    public static int harmVolRetrig10 = 0;
    public static int harmVolRetrig11 = 0;
    public static int harmVolRetrig12 = 0;

    // harmonics div
    public static int harmVolModDiv1 = 0;
    public static int harmVolModDiv2 = 0;
    public static int harmVolModDiv3 = 0;
    public static int harmVolModDiv4 = 0;
    public static int harmVolModDiv5 = 0;
    public static int harmVolModDiv6 = 0;
    public static int harmVolModDiv7 = 0;
    public static int harmVolModDiv8 = 0;
    public static int harmVolModDiv9 = 0;
    public static int harmVolModDiv10 = 0;
    public static int harmVolModDiv11 = 0;
    public static int harmVolModDiv12 = 0;

    // harmonics extra
    public static int harmVolModRetrig = 0;
    public static int harmVolModRateRange = 0;

    /////////////////////////////////////////// Harmonics Page - Second Activity Variables End

    /////////////////////////////////////////// Noise Page - Third Activity Variables Start

    // noise volume
    public static int noiseVol1 = 1;
    public static int noiseVol2 = 1;
    public static int noiseVol3 = 1;
    public static int noiseVol4 = 1;

    // noise vol mod
    public static int noiseVolMod1 = 1;
    public static int noiseVolMod2 = 1;
    public static int noiseVolMod3 = 1;
    public static int noiseVolMod4 = 1;

    // noise vol rate
    public static int noiseVolRate1 = 1;
    public static int noiseVolRate2 = 1;
    public static int noiseVolRate3 = 1;
    public static int noiseVolRate4 = 1;

    // noise vol sync
    public static int noiseVolSync1 = 1;
    public static int noiseVolSync2 = 1;
    public static int noiseVolSync3 = 1;
    public static int noiseVolSync4 = 1;

    // noise vol retrig
    public static int noiseVolRetrig1 = 0;
    public static int noiseVolRetrig2 = 0;
    public static int noiseVolRetrig3 = 0;
    public static int noiseVolRetrig4 = 0;

    // noise cut
    public static int noiseCut1 = 1;
    public static int noiseCut2 = 1;
    public static int noiseCut3 = 1;
    public static int noiseCut4 = 1;

    // noise res
    public static int noiseRes1 = 1;
    public static int noiseRes2 = 1;
    public static int noiseRes3 = 1;
    public static int noiseRes4 = 1;

    // noise cut mod
    public static int noiseCutMod1 = 1;
    public static int noiseCutMod2 = 1;
    public static int noiseCutMod3 = 1;
    public static int noiseCutMod4 = 1;

    // noise cut rate
    public static int noiseCutRate1 = 1;
    public static int noiseCutRate2 = 1;
    public static int noiseCutRate3 = 1;
    public static int noiseCutRate4 = 1;

    // noise cut sync
    public static int noiseCutSync1 = 1;
    public static int noiseCutSync2 = 1;
    public static int noiseCutSync3 = 1;
    public static int noiseCutSync4 = 1;

    // noise cut retrig
    public static int noiseCutRetrig1 = 0;
    public static int noiseCutRetrig2 = 0;
    public static int noiseCutRetrig3 = 0;
    public static int noiseCutRetrig4 = 0;

    // noise vol div
    public static int noiseVolModDiv1 = 1;
    public static int noiseVolModDiv2 = 1;
    public static int noiseVolModDiv3 = 1;
    public static int noiseVolModDiv4 = 1;

    // noise cut div
    public static int noiseCutModDiv1 = 1;
    public static int noiseCutModDiv2 = 1;
    public static int noiseCutModDiv3 = 1;
    public static int noiseCutModDiv4 = 1;

    // noise extra
    public static int noiseType = 0;
    public static int noiseModRateRangeCut = 0;
    public static int noiseModRateRangeVol = 0;
    public static int noiseModRetrig = 0;

    /////////////////////////////////////////// Noise Page - Third Activity Variables End

    /////////////////////////////////////////// Effects Page - Fourth Activity Variables Start

    // Filter
    public static int lpFilterCut = 1;
    public static int lpFilterRes = 1;
    public static int lpFilterEnv = 1;
    public static int lpFilterMod = 1;
    public static int lpFilterRate = 1;
    public static int lpFilterSync = 1;
    public static int lpFilterDiv = 1;
    public static int lpFilterRetrig = 1;
    public static int lpFilterPower = 1;

    // Decimator
    public static int decimatorReduce = 0;
    public static int decimatorMod = 0;
    public static int decimatorRate = 0;
    public static int decimatorSync = 0;
    public static int decimatorDiv = 0;
    public static int decimatorRetrig = 0;
    public static int decimatorPower = 0;

    // Delay
    public static int delayTime = 0;
    public static int delayTimeR = 0;
    public static int delayFeed = 0;
    public static int delaySync = 0;
    public static int delayDiv = 0;
    public static int delayDivR = 0;
    public static int delayWet = 0;
    public static int delayPower = 0;

    // Chorus
    public static int chorusRate = 0;
    public static int chorusDepth = 0;
    public static int chorusDelay = 0;
    public static int chorusFeed = 0;
    public static int chorusWet = 0;
    public static int chorusPower = 0;

    // Reverb
    public static int reverbSize = 0;
    public static int reverbDamp = 0;
    public static int reverbWidth = 0;
    public static int reverbWet = 0;
    public static int reverbPower = 0;

    // DC Kill
    public static int dcKill = 0;

    /////////////////////////////////////////// Effects Page - Fourth Activity Variables End

    /////////////////////////////////////////// Freq Page - Fifth Activity Variables Start

    // source freq
    public static int sourceNote = 0;
    public static int sourceSelect = 0;
    public static int sourceMidiOct = 0;
    public static int sourceFreq = 0;

    // fm freq
    public static int fmNote = 0;
    public static int fmSelect = 0;
    public static int fmMidiOct = 0;
    public static int fmFreq = 0;

    // fm modulation
    public static int fmDepth = 0;
    public static int fmDepthModDepth = 0;
    public static int fmFreqModDepth = 0;
    public static int fmDepthModRate = 0;
    public static int fmFreqModRate = 0;
    public static int fmDepthModSync = 0;
    public static int fmFreqModSync = 0;
    public static int fmDepthModRetrig = 0;
    public static int fmFreqModRetrig = 0;
    public static int fmDepthModDiv = 0;
    public static int fmFreqModDiv = 0;

    /////////////////////////////////////////// Freq Page - Fifth Activity Variables End

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////// All Parameter Shared Pref Variables End

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout with binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        ///////////////////////////////////////////////////// Shared Preferences Start
        SharedPreferences sharedPref= getSharedPreferences("OsAmaControlPref", 0);
        if (sharedPref.contains("fmFreq")) {

            // OSC Variables Start
            ipData = sharedPref.getString("ipData", ipData);
            portData = sharedPref.getInt("portData", portData);
            // OSC Variables End

            /////////////////////////////////////////// Main Page - Main Activity Variables Start

            // mix section
            harmMix = sharedPref.getInt("harmMix", harmMix);
            noiseMix = sharedPref.getInt("noiseMix", noiseMix);
            outputVolume = sharedPref.getInt("outputVolume", outputVolume);

            // envelope
            envelopeA = sharedPref.getInt("envelopeA", envelopeA);
            envelopeD = sharedPref.getInt("envelopeD", envelopeD);
            envelopeS = sharedPref.getInt("envelopeS", envelopeS);
            envelopeR = sharedPref.getInt("envelopeR", envelopeR);
            droneVal = sharedPref.getInt("droneVal", droneVal);

            // main settings
            devicePower = sharedPref.getInt("devicePower", devicePower);
            bpmData = sharedPref.getInt("bpmData", bpmData);
            midiChan = sharedPref.getInt("midiChan", midiChan);
            keyboardOctave = sharedPref.getInt("keyboardOctave", keyboardOctave);

            /////////////////////////////////////////// Main Page - Main Activity Variables End

            /////////////////////////////////////////// Harmonics Page - Second Activity Variables Start

            // harmonics volumes
             harmVol1 = sharedPref.getInt("harmVol1", harmVol1);
             harmVol2 = sharedPref.getInt("harmVol2", harmVol2);
             harmVol3 = sharedPref.getInt("harmVol3", harmVol3);
             harmVol4 = sharedPref.getInt("harmVol4", harmVol4);
             harmVol5 = sharedPref.getInt("harmVol5", harmVol5);
             harmVol6 = sharedPref.getInt("harmVol6", harmVol6);
             harmVol7 = sharedPref.getInt("harmVol7", harmVol7);
             harmVol8 = sharedPref.getInt("harmVol8", harmVol8);
             harmVol9 = sharedPref.getInt("harmVol9", harmVol9);
             harmVol10 = sharedPref.getInt("harmVol10", harmVol10);
             harmVol11 = sharedPref.getInt("harmVol11", harmVol11);
             harmVol12 = sharedPref.getInt("harmVol12", harmVol12);

            // harmonics mod
             harmVolMod1 = sharedPref.getInt("harmVolMod1", harmVolMod1);
             harmVolMod2 = sharedPref.getInt("harmVolMod2", harmVolMod2);
             harmVolMod3 = sharedPref.getInt("harmVolMod3", harmVolMod3);
             harmVolMod4 = sharedPref.getInt("harmVolMod4", harmVolMod4);
             harmVolMod5 = sharedPref.getInt("harmVolMod5", harmVolMod5);
             harmVolMod6 = sharedPref.getInt("harmVolMod6", harmVolMod6);
             harmVolMod7 = sharedPref.getInt("harmVolMod7", harmVolMod7);
             harmVolMod8 = sharedPref.getInt("harmVolMod8", harmVolMod8);
             harmVolMod9 = sharedPref.getInt("harmVolMod9", harmVolMod9);
             harmVolMod10 = sharedPref.getInt("harmVolMod10", harmVolMod10);
             harmVolMod11 = sharedPref.getInt("harmVolMod11", harmVolMod11);
             harmVolMod12 = sharedPref.getInt("harmVolMod12", harmVolMod12);

            // harmonics rates
             harmVolRate1 = sharedPref.getInt("harmVolRate1", harmVolRate1);
             harmVolRate2 = sharedPref.getInt("harmVolRate2", harmVolRate2);
             harmVolRate3 = sharedPref.getInt("harmVolRate3", harmVolRate3);
             harmVolRate4 = sharedPref.getInt("harmVolRate4", harmVolRate4);
             harmVolRate5 = sharedPref.getInt("harmVolRate5", harmVolRate5);
             harmVolRate6 = sharedPref.getInt("harmVolRate6", harmVolRate6);
             harmVolRate7 = sharedPref.getInt("harmVolRate7", harmVolRate7);
             harmVolRate8 = sharedPref.getInt("harmVolRate8", harmVolRate8);
             harmVolRate9 = sharedPref.getInt("harmVolRate9", harmVolRate9);
             harmVolRate10 = sharedPref.getInt("harmVolRate10", harmVolRate10);
             harmVolRate11 = sharedPref.getInt("harmVolRate11", harmVolRate11);
             harmVolRate12 = sharedPref.getInt("harmVolRate12", harmVolRate12);

            // harmonics sync
             harmVolSync1 = sharedPref.getInt("harmVolSync1", harmVolSync1);
             harmVolSync2 = sharedPref.getInt("harmVolSync2", harmVolSync2);
             harmVolSync3 = sharedPref.getInt("harmVolSync3", harmVolSync3);
             harmVolSync4 = sharedPref.getInt("harmVolSync4", harmVolSync4);
             harmVolSync5 = sharedPref.getInt("harmVolSync5", harmVolSync5);
             harmVolSync6 = sharedPref.getInt("harmVolSync6", harmVolSync6);
             harmVolSync7 = sharedPref.getInt("harmVolSync7", harmVolSync7);
             harmVolSync8 = sharedPref.getInt("harmVolSync8", harmVolSync8);
             harmVolSync9 = sharedPref.getInt("harmVolSync9", harmVolSync9);
             harmVolSync10 = sharedPref.getInt("harmVolSync10", harmVolSync10);
             harmVolSync11 = sharedPref.getInt("harmVolSync11", harmVolSync11);
             harmVolSync12 = sharedPref.getInt("harmVolSync12", harmVolSync12);

            // harmonics Retrig
            harmVolRetrig1 = sharedPref.getInt("harmVolRetrig1", harmVolRetrig1);
            harmVolRetrig2 = sharedPref.getInt("harmVolRetrig2", harmVolRetrig2);
            harmVolRetrig3 = sharedPref.getInt("harmVolRetrig3", harmVolRetrig3);
            harmVolRetrig4 = sharedPref.getInt("harmVolRetrig4", harmVolRetrig4);
            harmVolRetrig5 = sharedPref.getInt("harmVolRetrig5", harmVolRetrig5);
            harmVolRetrig6 = sharedPref.getInt("harmVolRetrig6", harmVolRetrig6);
            harmVolRetrig7 = sharedPref.getInt("harmVolRetrig7", harmVolRetrig7);
            harmVolRetrig8 = sharedPref.getInt("harmVolRetrig8", harmVolRetrig8);
            harmVolRetrig9 = sharedPref.getInt("harmVolRetrig9", harmVolRetrig9);
            harmVolRetrig10 = sharedPref.getInt("harmVolRetrig10", harmVolRetrig10);
            harmVolRetrig11 = sharedPref.getInt("harmVolRetrig11", harmVolRetrig11);
            harmVolRetrig12 = sharedPref.getInt("harmVolRetrig12", harmVolRetrig12);

            // harmonics div
             harmVolModDiv1 = sharedPref.getInt("harmVolModDiv1", harmVolModDiv1);
             harmVolModDiv2 = sharedPref.getInt("harmVolModDiv2", harmVolModDiv2);
             harmVolModDiv3 = sharedPref.getInt("harmVolModDiv3", harmVolModDiv3);
             harmVolModDiv4 = sharedPref.getInt("harmVolModDiv4", harmVolModDiv4);
             harmVolModDiv5 = sharedPref.getInt("harmVolModDiv5", harmVolModDiv5);
             harmVolModDiv6 = sharedPref.getInt("harmVolModDiv6", harmVolModDiv6);
             harmVolModDiv7 = sharedPref.getInt("harmVolModDiv7", harmVolModDiv7);
             harmVolModDiv8 = sharedPref.getInt("harmVolModDiv8", harmVolModDiv8);
             harmVolModDiv9 = sharedPref.getInt("harmVolModDiv9", harmVolModDiv9);
             harmVolModDiv10 = sharedPref.getInt("harmVolModDiv10", harmVolModDiv10);
             harmVolModDiv11 = sharedPref.getInt("harmVolModDiv11", harmVolModDiv11);
             harmVolModDiv12 = sharedPref.getInt("harmVolModDiv12", harmVolModDiv12);

            // harmonics extra
             harmVolModRetrig = sharedPref.getInt("harmVolModRetrig", harmVolModRetrig);
             harmVolModRateRange = sharedPref.getInt("harmVolModRateRange", harmVolModRateRange);

            /////////////////////////////////////////// Harmonics Page - Second Activity Variables End

            /////////////////////////////////////////// Noise Page - Third Activity Variables Start

            // noise volume
             noiseVol1 = sharedPref.getInt("noiseVol1", noiseVol1);
             noiseVol2 = sharedPref.getInt("noiseVol2", noiseVol2);
             noiseVol3 = sharedPref.getInt("noiseVol3", noiseVol3);
             noiseVol4 = sharedPref.getInt("noiseVol4", noiseVol4);

            // noise vol mod
             noiseVolMod1 = sharedPref.getInt("noiseVolMod1", noiseVolMod1);
             noiseVolMod2 = sharedPref.getInt("noiseVolMod2", noiseVolMod2);
             noiseVolMod3 = sharedPref.getInt("noiseVolMod3", noiseVolMod3);
             noiseVolMod4 = sharedPref.getInt("noiseVolMod4", noiseVolMod4);

            // noise vol rate
             noiseVolRate1 = sharedPref.getInt("noiseVolRate1", noiseVolRate1);
             noiseVolRate2 = sharedPref.getInt("noiseVolRate2", noiseVolRate2);
             noiseVolRate3 = sharedPref.getInt("noiseVolRate3", noiseVolRate3);
             noiseVolRate4 = sharedPref.getInt("noiseVolRate4", noiseVolRate4);

            // noise vol sync
             noiseVolSync1 = sharedPref.getInt("noiseVolSync1", noiseVolSync1);
             noiseVolSync2 = sharedPref.getInt("noiseVolSync2", noiseVolSync2);
             noiseVolSync3 = sharedPref.getInt("noiseVolSync3", noiseVolSync3);
             noiseVolSync4 = sharedPref.getInt("noiseVolSync4", noiseVolSync4);

            // noise vol Retrig
            noiseVolRetrig1 = sharedPref.getInt("noiseVolRetrig1", noiseVolRetrig1);
            noiseVolRetrig2 = sharedPref.getInt("noiseVolRetrig2", noiseVolRetrig2);
            noiseVolRetrig3 = sharedPref.getInt("noiseVolRetrig3", noiseVolRetrig3);
            noiseVolRetrig4 = sharedPref.getInt("noiseVolRetrig4", noiseVolRetrig4);

            // noise cut
             noiseCut1 = sharedPref.getInt("noiseCut1", noiseCut1);
             noiseCut2 = sharedPref.getInt("noiseCut2", noiseCut2);
             noiseCut3 = sharedPref.getInt("noiseCut3", noiseCut3);
             noiseCut4 = sharedPref.getInt("noiseCut4", noiseCut4);

            // noise res
             noiseRes1 = sharedPref.getInt("noiseRes1", noiseRes1);
             noiseRes2 = sharedPref.getInt("noiseRes2", noiseRes2);
             noiseRes3 = sharedPref.getInt("noiseRes3", noiseRes3);
             noiseRes4 = sharedPref.getInt("noiseRes4", noiseRes4);

            // noise cut mod
             noiseCutMod1 = sharedPref.getInt("noiseCutMod1", noiseCutMod1);
             noiseCutMod2 = sharedPref.getInt("noiseCutMod2", noiseCutMod2);
             noiseCutMod3 = sharedPref.getInt("noiseCutMod3", noiseCutMod3);
             noiseCutMod4 = sharedPref.getInt("noiseCutMod4", noiseCutMod4);

            // noise cut rate
             noiseCutRate1 = sharedPref.getInt("noiseCutRate1", noiseCutRate1);
             noiseCutRate2 = sharedPref.getInt("noiseCutRate2", noiseCutRate2);
             noiseCutRate3 = sharedPref.getInt("noiseCutRate3", noiseCutRate3);
             noiseCutRate4 = sharedPref.getInt("noiseCutRate4", noiseCutRate4);

            // noise cut Sync
             noiseCutSync1 = sharedPref.getInt("noiseCutSync1", noiseCutSync1);
             noiseCutSync2 = sharedPref.getInt("noiseCutSync2", noiseCutSync2);
             noiseCutSync3 = sharedPref.getInt("noiseCutSync3", noiseCutSync3);
             noiseCutSync4 = sharedPref.getInt("noiseCutSync4", noiseCutSync4);

            // noise cut Retrig
            noiseCutRetrig1 = sharedPref.getInt("noiseCutRetrig1", noiseCutRetrig1);
            noiseCutRetrig2 = sharedPref.getInt("noiseCutRetrig2", noiseCutRetrig2);
            noiseCutRetrig3 = sharedPref.getInt("noiseCutRetrig3", noiseCutRetrig3);
            noiseCutRetrig4 = sharedPref.getInt("noiseCutRetrig4", noiseCutRetrig4);

            // noise vol div
             noiseVolModDiv1 = sharedPref.getInt("noiseVolModDiv1", noiseVolModDiv1);
             noiseVolModDiv2 = sharedPref.getInt("noiseVolModDiv2", noiseVolModDiv2);
             noiseVolModDiv3 = sharedPref.getInt("noiseVolModDiv3", noiseVolModDiv3);
             noiseVolModDiv4 = sharedPref.getInt("noiseVolModDiv4", noiseVolModDiv4);

            // noise cut div
             noiseCutModDiv1 = sharedPref.getInt("noiseCutModDiv1", noiseCutModDiv1);
             noiseCutModDiv2 = sharedPref.getInt("noiseCutModDiv2", noiseCutModDiv2);
             noiseCutModDiv3 = sharedPref.getInt("noiseCutModDiv3", noiseCutModDiv3);
             noiseCutModDiv4 = sharedPref.getInt("noiseCutModDiv4", noiseCutModDiv4);

            // noise extra
             noiseType = sharedPref.getInt("noiseType", noiseType);
            noiseModRateRangeVol = sharedPref.getInt("noiseModRateRangeVol", noiseModRateRangeVol);
            noiseModRateRangeCut = sharedPref.getInt("noiseModRateRangeVol", noiseModRateRangeCut);
             noiseModRetrig = sharedPref.getInt("noiseModRetrig", noiseModRetrig);

            /////////////////////////////////////////// Noise Page - Third Activity Variables End

            /////////////////////////////////////////// Effects Page - Fourth Activity Variables Start

            // Filter
             lpFilterCut = sharedPref.getInt("lpFilterCut", lpFilterCut);
             lpFilterRes = sharedPref.getInt("lpFilterRes", lpFilterRes);
             lpFilterEnv = sharedPref.getInt("lpFilterEnv", lpFilterEnv);
             lpFilterMod = sharedPref.getInt("lpFilterMod", lpFilterMod);
             lpFilterRate = sharedPref.getInt("lpFilterRate", lpFilterRate);
             lpFilterSync = sharedPref.getInt("lpFilterSync", lpFilterSync);
             lpFilterDiv = sharedPref.getInt("lpFilterDiv", lpFilterDiv);
             lpFilterRetrig = sharedPref.getInt("lpFilterRetrig", lpFilterRetrig);
             lpFilterPower = sharedPref.getInt("lpFilterPower", lpFilterPower);

            // Decimator
             decimatorReduce = sharedPref.getInt("decimatorReduce", decimatorReduce);
             decimatorMod = sharedPref.getInt("decimatorMod", decimatorMod);
             decimatorRate = sharedPref.getInt("decimatorRate", decimatorRate);
             decimatorSync = sharedPref.getInt("decimatorSync", decimatorSync);
             decimatorDiv = sharedPref.getInt("decimatorDiv", decimatorDiv);
             decimatorRetrig = sharedPref.getInt("decimatorRetrig", decimatorRetrig);
             decimatorPower = sharedPref.getInt("decimatorPower", decimatorPower);

            // Delay
             delayTime = sharedPref.getInt("delayTime", delayTime);
             delayTimeR = sharedPref.getInt("delayTimeR", delayTimeR);
             delayFeed = sharedPref.getInt("delayFeed", delayFeed);
             delaySync = sharedPref.getInt("delaySync", delaySync);
             delayDiv = sharedPref.getInt("delayDiv", delayDiv);
             delayDivR = sharedPref.getInt("delayDivR", delayDivR);
             delayWet = sharedPref.getInt("delayWet", delayWet);
             delayPower = sharedPref.getInt("delayPower", delayPower);

            // Chorus
             chorusRate = sharedPref.getInt("chorusRate", chorusRate);
             chorusDepth = sharedPref.getInt("chorusDepth", chorusDepth);
             chorusDelay = sharedPref.getInt("chorusDelay", chorusDelay);
             chorusFeed = sharedPref.getInt("chorusFeed", chorusFeed);
             chorusWet = sharedPref.getInt("chorusWet", chorusWet);
             chorusPower = sharedPref.getInt("chorusPower", chorusPower);

            // Reverb
             reverbSize = sharedPref.getInt("reverbSize", reverbSize);
             reverbDamp = sharedPref.getInt("reverbDamp", reverbDamp);
             reverbWidth = sharedPref.getInt("reverbWidth", reverbWidth);
             reverbWet = sharedPref.getInt("reverbWet", reverbWet);
             reverbPower = sharedPref.getInt("reverbPower", reverbPower);

            // DC Kill
             dcKill = sharedPref.getInt("dcKill", dcKill);

            /////////////////////////////////////////// Effects Page - Fourth Activity Variables End

            /////////////////////////////////////////// Freq Page - Fifth Activity Variables Start

            // source freq
             sourceNote = sharedPref.getInt("sourceNote", sourceNote);
             sourceSelect = sharedPref.getInt("sourceSelect", sourceSelect);
             sourceMidiOct = sharedPref.getInt("sourceMidiOct", sourceMidiOct);
             sourceFreq = sharedPref.getInt("sourceFreq", sourceFreq);

            // fm freq
             fmNote = sharedPref.getInt("fmNote", fmNote);
             fmSelect = sharedPref.getInt("fmSelect", fmSelect);
             fmMidiOct = sharedPref.getInt("fmMidiOct", fmMidiOct);
             fmFreq = sharedPref.getInt("fmFreq", fmFreq);

            // fm modulation
             fmDepth = sharedPref.getInt("fmDepth", fmDepth);
             fmDepthModDepth = sharedPref.getInt("fmDepthModDepth", fmDepthModDepth);
             fmFreqModDepth = sharedPref.getInt("fmFreqModDepth", fmFreqModDepth);
             fmDepthModRate = sharedPref.getInt("fmDepthModRate", fmDepthModRate);
             fmFreqModRate = sharedPref.getInt("fmFreqModRate", fmFreqModRate);
             fmDepthModSync = sharedPref.getInt("fmDepthModSync", fmDepthModSync);
             fmFreqModSync = sharedPref.getInt("fmFreqModSync", fmFreqModSync);
             fmDepthModRetrig = sharedPref.getInt("fmDepthModRetrig", fmDepthModRetrig);
             fmFreqModRetrig = sharedPref.getInt("fmFreqModRetrig", fmFreqModRetrig);
             fmDepthModDiv = sharedPref.getInt("fmDepthModDiv", fmDepthModDiv);
             fmFreqModDiv = sharedPref.getInt("fmFreqModDiv", fmFreqModDiv);

            /////////////////////////////////////////// Freq Page - Fifth Activity Variables End

        } // end sharedpref

        ///////////////////////////////////////////////////// Shared Preferences  End

        obsInt = new ObsInt(); // harmonics mix
        obsIntNoiseMix = new ObsIntNoiseMix();
        obsIntOutputVol = new ObsIntOutputVol();

        obsIntDevicePower = new ObsIntDevicePower();
        obsIntDrone = new ObsIntDrone();

        obsIntBpm = new ObsIntBpm();
        obsIntMidiChan = new ObsIntMidiChan();
        obsIntkeyboardOct = new ObsIntKeyboardOct();

        obsIntEnvA = new ObsIntEnvA();
        obsIntEnvD = new ObsIntEnvD();
        obsIntEnvS = new ObsIntEnvS();
        obsIntEnvR = new ObsIntEnvR();

        obsIntHarmVol1 = new ObsIntHarmVol1();
        obsIntHarmVol2 = new ObsIntHarmVol2();
        obsIntHarmVol3 = new ObsIntHarmVol3();
        obsIntHarmVol4 = new ObsIntHarmVol4();
        obsIntHarmVol5 = new ObsIntHarmVol5();
        obsIntHarmVol6 = new ObsIntHarmVol6();
        obsIntHarmVol7 = new ObsIntHarmVol7();
        obsIntHarmVol8 = new ObsIntHarmVol8();
        obsIntHarmVol9 = new ObsIntHarmVol9();
        obsIntHarmVol10 = new ObsIntHarmVol10();
        obsIntHarmVol11 = new ObsIntHarmVol11();
        obsIntHarmVol12 = new ObsIntHarmVol12();

        obsIntHarmMod1 = new ObsIntHarmMod1();
        obsIntHarmMod2 = new ObsIntHarmMod2();
        obsIntHarmMod3 = new ObsIntHarmMod3();
        obsIntHarmMod4 = new ObsIntHarmMod4();
        obsIntHarmMod5 = new ObsIntHarmMod5();
        obsIntHarmMod6 = new ObsIntHarmMod6();
        obsIntHarmMod7 = new ObsIntHarmMod7();
        obsIntHarmMod8 = new ObsIntHarmMod8();
        obsIntHarmMod9 = new ObsIntHarmMod9();
        obsIntHarmMod10 = new ObsIntHarmMod10();
        obsIntHarmMod11 = new ObsIntHarmMod11();
        obsIntHarmMod12 = new ObsIntHarmMod12();

        obsIntHarmRate1 = new ObsIntHarmRate1();
        obsIntHarmRate2 = new ObsIntHarmRate2();
        obsIntHarmRate3 = new ObsIntHarmRate3();
        obsIntHarmRate4 = new ObsIntHarmRate4();
        obsIntHarmRate5 = new ObsIntHarmRate5();
        obsIntHarmRate6 = new ObsIntHarmRate6();
        obsIntHarmRate7 = new ObsIntHarmRate7();
        obsIntHarmRate8 = new ObsIntHarmRate8();
        obsIntHarmRate9 = new ObsIntHarmRate9();
        obsIntHarmRate10 = new ObsIntHarmRate10();
        obsIntHarmRate11 = new ObsIntHarmRate11();
        obsIntHarmRate12 = new ObsIntHarmRate12();

        obsIntHarmRateRange = new ObsIntHarmRateRange();

        obsIntHarmSync1 = new ObsIntHarmSync1();
        obsIntHarmSync2 = new ObsIntHarmSync2();
        obsIntHarmSync3 = new ObsIntHarmSync3();
        obsIntHarmSync4 = new ObsIntHarmSync4();
        obsIntHarmSync5 = new ObsIntHarmSync5();
        obsIntHarmSync6 = new ObsIntHarmSync6();
        obsIntHarmSync7 = new ObsIntHarmSync7();
        obsIntHarmSync8 = new ObsIntHarmSync8();
        obsIntHarmSync9 = new ObsIntHarmSync9();
        obsIntHarmSync10 = new ObsIntHarmSync10();
        obsIntHarmSync11 = new ObsIntHarmSync11();
        obsIntHarmSync12 = new ObsIntHarmSync12();

        obsIntHarmRetrig1 = new ObsIntHarmRetrig1();
        obsIntHarmRetrig2 = new ObsIntHarmRetrig2();
        obsIntHarmRetrig3 = new ObsIntHarmRetrig3();
        obsIntHarmRetrig4 = new ObsIntHarmRetrig4();
        obsIntHarmRetrig5 = new ObsIntHarmRetrig5();
        obsIntHarmRetrig6 = new ObsIntHarmRetrig6();
        obsIntHarmRetrig7 = new ObsIntHarmRetrig7();
        obsIntHarmRetrig8 = new ObsIntHarmRetrig8();
        obsIntHarmRetrig9 = new ObsIntHarmRetrig9();
        obsIntHarmRetrig10 = new ObsIntHarmRetrig10();
        obsIntHarmRetrig11 = new ObsIntHarmRetrig11();
        obsIntHarmRetrig12 = new ObsIntHarmRetrig12();

        obsIntHarmDiv1 = new ObsIntHarmDiv1();
        obsIntHarmDiv2 = new ObsIntHarmDiv2();
        obsIntHarmDiv3 = new ObsIntHarmDiv3();
        obsIntHarmDiv4 = new ObsIntHarmDiv4();
        obsIntHarmDiv5 = new ObsIntHarmDiv5();
        obsIntHarmDiv6 = new ObsIntHarmDiv6();
        obsIntHarmDiv7 = new ObsIntHarmDiv7();
        obsIntHarmDiv8 = new ObsIntHarmDiv8();
        obsIntHarmDiv9 = new ObsIntHarmDiv9();
        obsIntHarmDiv10 = new ObsIntHarmDiv10();
        obsIntHarmDiv11 = new ObsIntHarmDiv11();
        obsIntHarmDiv12 = new ObsIntHarmDiv12();

        obsIntNoiseVol1 = new ObsIntNoiseVol1();
        obsIntNoiseVol2 = new ObsIntNoiseVol2();
        obsIntNoiseVol3 = new ObsIntNoiseVol3();
        obsIntNoiseVol4 = new ObsIntNoiseVol4();

        obsIntNoiseVolMod1 = new ObsIntNoiseVolMod1();
        obsIntNoiseVolMod2 = new ObsIntNoiseVolMod2();
        obsIntNoiseVolMod3 = new ObsIntNoiseVolMod3();
        obsIntNoiseVolMod4 = new ObsIntNoiseVolMod4();

        obsIntNoiseVolRate1 = new ObsIntNoiseVolRate1();
        obsIntNoiseVolRate2 = new ObsIntNoiseVolRate2();
        obsIntNoiseVolRate3 = new ObsIntNoiseVolRate3();
        obsIntNoiseVolRate4 = new ObsIntNoiseVolRate4();

        obsIntNoiseVolDiv1 = new ObsIntNoiseVolDiv1();
        obsIntNoiseVolDiv2 = new ObsIntNoiseVolDiv2();
        obsIntNoiseVolDiv3 = new ObsIntNoiseVolDiv3();
        obsIntNoiseVolDiv4 = new ObsIntNoiseVolDiv4();

        obsIntNoiseVolSync1 = new ObsIntNoiseVolSync1();
        obsIntNoiseVolSync2 = new ObsIntNoiseVolSync2();
        obsIntNoiseVolSync3 = new ObsIntNoiseVolSync3();
        obsIntNoiseVolSync4 = new ObsIntNoiseVolSync4();

        obsIntNoiseVolRetrig1 = new ObsIntNoiseVolRetrig1();
        obsIntNoiseVolRetrig2 = new ObsIntNoiseVolRetrig2();
        obsIntNoiseVolRetrig3 = new ObsIntNoiseVolRetrig3();
        obsIntNoiseVolRetrig4 = new ObsIntNoiseVolRetrig4();

        obsIntNoiseCut1 = new ObsIntNoiseCut1();
        obsIntNoiseCut2 = new ObsIntNoiseCut2();
        obsIntNoiseCut3 = new ObsIntNoiseCut3();
        obsIntNoiseCut4 = new ObsIntNoiseCut4();

        obsIntNoiseRes1 = new ObsIntNoiseRes1();
        obsIntNoiseRes2 = new ObsIntNoiseRes2();
        obsIntNoiseRes3 = new ObsIntNoiseRes3();
        obsIntNoiseRes4 = new ObsIntNoiseRes4();

        obsIntNoiseCutMod1 = new ObsIntNoiseCutMod1();
        obsIntNoiseCutMod2 = new ObsIntNoiseCutMod2();
        obsIntNoiseCutMod3 = new ObsIntNoiseCutMod3();
        obsIntNoiseCutMod4 = new ObsIntNoiseCutMod4();

        obsIntNoiseCutRate1 = new ObsIntNoiseCutRate1();
        obsIntNoiseCutRate2 = new ObsIntNoiseCutRate2();
        obsIntNoiseCutRate3 = new ObsIntNoiseCutRate3();
        obsIntNoiseCutRate4 = new ObsIntNoiseCutRate4();

        obsIntNoiseCutDiv1 = new ObsIntNoiseCutDiv1();
        obsIntNoiseCutDiv2 = new ObsIntNoiseCutDiv2();
        obsIntNoiseCutDiv3 = new ObsIntNoiseCutDiv3();
        obsIntNoiseCutDiv4 = new ObsIntNoiseCutDiv4();

        obsIntNoiseCutSync1 = new ObsIntNoiseCutSync1();
        obsIntNoiseCutSync2 = new ObsIntNoiseCutSync2();
        obsIntNoiseCutSync3 = new ObsIntNoiseCutSync3();
        obsIntNoiseCutSync4 = new ObsIntNoiseCutSync4();

        obsIntNoiseCutRetrig1 = new ObsIntNoiseCutRetrig1();
        obsIntNoiseCutRetrig2 = new ObsIntNoiseCutRetrig2();
        obsIntNoiseCutRetrig3 = new ObsIntNoiseCutRetrig3();
        obsIntNoiseCutRetrig4 = new ObsIntNoiseCutRetrig4();

        obsIntNoisePink = new ObsIntNoisePink();
        obsIntNoiseRateRangeVol = new ObsIntNoiseRateRangeVol();
        obsIntNoiseRateRangeCut = new ObsIntNoiseRateRangeCut();

        obsIntSourceSelect = new ObsIntSourceSelect();
        obsIntSourceNote = new ObsIntSourceNote();
        obsIntSourceFreq = new ObsIntSourceFreq();
        obsIntSourceMidiOct = new ObsIntSourceMidiOct();

        obsIntFmSelect = new ObsIntFmSelect();
        obsIntFmNote = new ObsIntFmNote();
        obsIntFmFreq = new ObsIntFmFreq();
        obsIntFmMidiOct = new ObsIntFmMidiOct();

        obsIntFmDepth = new ObsIntFmDepth();

        obsIntFmDepthModDepth = new ObsIntFmDepthModDepth();
        obsIntFmDepthModRate = new ObsIntFmDepthModRate();
        obsIntFmDepthModSync = new ObsIntFmDepthModSync();
        obsIntFmDepthModDiv = new ObsIntFmDepthModDiv();
        obsIntFmDepthModRetrig = new ObsIntFmDepthModRetrig();

        obsIntFmFreqModDepth = new ObsIntFmFreqModDepth();
        obsIntFmFreqModRate = new ObsIntFmFreqModRate();
        obsIntFmFreqModSync = new ObsIntFmFreqModSync();
        obsIntFmFreqModDiv = new ObsIntFmFreqModDiv();
        obsIntFmFreqModRetrig = new ObsIntFmFreqModRetrig();

        obsIntDcKill = new ObsIntDcKill();

        obsIntFilterPower = new ObsIntFilterPower();
        obsIntFilterCut = new ObsIntFilterCut();
        obsIntFilterRes = new ObsIntFilterRes();
        obsIntFilterEnv = new ObsIntFilterEnv();
        obsIntFilterMod = new ObsIntFilterMod();
        obsIntFilterRate = new ObsIntFilterRate();
        obsIntFilterSync = new ObsIntFilterSync();
        obsIntFilterDiv = new ObsIntFilterDiv();
        obsIntFilterRetrig = new ObsIntFilterRetrig();

        obsIntDecimatePower = new ObsIntDecimatePower();
        obsIntDecimateReduce = new ObsIntDecimateReduce();
        obsIntDecimateMod = new ObsIntDecimateMod();
        obsIntDecimateRate = new ObsIntDecimateRate();
        obsIntDecimateSync = new ObsIntDecimateSync();
        obsIntDecimateDiv = new ObsIntDecimateDiv();
        obsIntDecimateRetrig = new ObsIntDecimateRetrig();

        obsIntDelayPower = new ObsIntDelayPower();
        obsIntDelayTime = new ObsIntDelayTime();
        obsIntDelayTimeR = new ObsIntDelayTimeR();
        obsIntDelaySync = new ObsIntDelaySync();
        obsIntDelayDiv = new ObsIntDelayDiv();
        obsIntDelayDivR = new ObsIntDelayDivR();
        obsIntDelayFeed = new ObsIntDelayFeed();
        obsIntDelayWet = new ObsIntDelayWet();

        obsIntChorusPower = new ObsIntChorusPower();
        obsIntChorusRate = new ObsIntChorusRate();
        obsIntChorusDepth = new ObsIntChorusDepth();
        obsIntChorusDelay = new ObsIntChorusDelay();
        obsIntChorusFeed = new ObsIntChorusFeed();
        obsIntChorusWet = new ObsIntChorusWet();

        obsIntReverbPower = new ObsIntReverbPower();
        obsIntReverbSize = new ObsIntReverbSize();
        obsIntReverbDamp = new ObsIntReverbDamp();
        obsIntReverbWidth = new ObsIntReverbWidth();
        obsIntReverbWet = new ObsIntReverbWet();

        ////////////////////////////////////////////////////////////////
        /////////////////////////////////////////// Observable set start
        ////////////////////////////////////////////////////////////////

        obsInt.setValue(harmMix);
        obsIntNoiseMix.setValue(noiseMix);
        obsIntOutputVol.setValue(outputVolume);
        obsIntEnvA.setValue(envelopeA);
        obsIntEnvD.setValue(envelopeD);
        obsIntEnvS.setValue(envelopeS);
        obsIntEnvR.setValue(envelopeR);

        if (devicePower == 127) {
            obsIntDevicePower.setValue(true);
        }
        if (devicePower == 0) {
            obsIntDevicePower.setValue(false);
        }

        if (droneVal == 127) {
            obsIntDrone.setValue(true);
        }
        if (droneVal == 0) {
            obsIntDrone.setValue(false);
        }

        obsIntBpm.setValue(bpmData);
        obsIntMidiChan.setValue(midiChan);
        obsIntkeyboardOct.setValue(keyboardOctave);

        obsIntHarmVol1.setValue(harmVol1);
        obsIntHarmVol2.setValue(harmVol2);
        obsIntHarmVol3.setValue(harmVol3);
        obsIntHarmVol4.setValue(harmVol4);
        obsIntHarmVol5.setValue(harmVol5);
        obsIntHarmVol6.setValue(harmVol6);
        obsIntHarmVol7.setValue(harmVol7);
        obsIntHarmVol8.setValue(harmVol8);
        obsIntHarmVol9.setValue(harmVol9);
        obsIntHarmVol10.setValue(harmVol10);
        obsIntHarmVol11.setValue(harmVol11);
        obsIntHarmVol12.setValue(harmVol12);

        obsIntHarmMod1.setValue(harmVolMod1);
        obsIntHarmMod2.setValue(harmVolMod2);
        obsIntHarmMod3.setValue(harmVolMod3);
        obsIntHarmMod4.setValue(harmVolMod4);
        obsIntHarmMod5.setValue(harmVolMod5);
        obsIntHarmMod6.setValue(harmVolMod6);
        obsIntHarmMod7.setValue(harmVolMod7);
        obsIntHarmMod8.setValue(harmVolMod8);
        obsIntHarmMod9.setValue(harmVolMod9);
        obsIntHarmMod10.setValue(harmVolMod10);
        obsIntHarmMod11.setValue(harmVolMod11);
        obsIntHarmMod12.setValue(harmVolMod12);

        obsIntHarmRate1.setValue(harmVolRate1);
        obsIntHarmRate2.setValue(harmVolRate2);
        obsIntHarmRate3.setValue(harmVolRate3);
        obsIntHarmRate4.setValue(harmVolRate4);
        obsIntHarmRate5.setValue(harmVolRate5);
        obsIntHarmRate6.setValue(harmVolRate6);
        obsIntHarmRate7.setValue(harmVolRate7);
        obsIntHarmRate8.setValue(harmVolRate8);
        obsIntHarmRate9.setValue(harmVolRate9);
        obsIntHarmRate10.setValue(harmVolRate10);
        obsIntHarmRate11.setValue(harmVolRate11);
        obsIntHarmRate12.setValue(harmVolRate12);

        obsIntHarmDiv1.setValue(harmVolModDiv1);
        obsIntHarmDiv2.setValue(harmVolModDiv2);
        obsIntHarmDiv3.setValue(harmVolModDiv3);
        obsIntHarmDiv4.setValue(harmVolModDiv4);
        obsIntHarmDiv5.setValue(harmVolModDiv5);
        obsIntHarmDiv6.setValue(harmVolModDiv6);
        obsIntHarmDiv7.setValue(harmVolModDiv7);
        obsIntHarmDiv8.setValue(harmVolModDiv8);
        obsIntHarmDiv9.setValue(harmVolModDiv9);
        obsIntHarmDiv10.setValue(harmVolModDiv10);
        obsIntHarmDiv11.setValue(harmVolModDiv11);
        obsIntHarmDiv12.setValue(harmVolModDiv12);

        if (harmVolSync1 == 127) {
            obsIntHarmSync1.setValue(true);
        }
        if (harmVolSync1 == 0) {
            obsIntHarmSync1.setValue(false);
        }

        if (harmVolSync2 == 127) {
            obsIntHarmSync2.setValue(true);
        }
        if (harmVolSync2 == 0) {
            obsIntHarmSync2.setValue(false);
        }

        if (harmVolSync3 == 127) {
            obsIntHarmSync3.setValue(true);
        }
        if (harmVolSync3 == 0) {
            obsIntHarmSync3.setValue(false);
        }

        if (harmVolSync4 == 127) {
            obsIntHarmSync4.setValue(true);
        }
        if (harmVolSync4 == 0) {
            obsIntHarmSync4.setValue(false);
        }

        if (harmVolSync5 == 127) {
            obsIntHarmSync5.setValue(true);
        }
        if (harmVolSync5 == 0) {
            obsIntHarmSync5.setValue(false);
        }

        if (harmVolSync6 == 127) {
            obsIntHarmSync6.setValue(true);
        }
        if (harmVolSync6 == 0) {
            obsIntHarmSync6.setValue(false);
        }

        if (harmVolSync7 == 127) {
            obsIntHarmSync7.setValue(true);
        }
        if (harmVolSync7 == 0) {
            obsIntHarmSync7.setValue(false);
        }

        if (harmVolSync8 == 127) {
            obsIntHarmSync8.setValue(true);
        }
        if (harmVolSync8 == 0) {
            obsIntHarmSync8.setValue(false);
        }

        if (harmVolSync9 == 127) {
            obsIntHarmSync9.setValue(true);
        }
        if (harmVolSync9 == 0) {
            obsIntHarmSync9.setValue(false);
        }

        if (harmVolSync10 == 127) {
            obsIntHarmSync10.setValue(true);
        }
        if (harmVolSync10 == 0) {
            obsIntHarmSync10.setValue(false);
        }

        if (harmVolSync11 == 127) {
            obsIntHarmSync11.setValue(true);
        }
        if (harmVolSync11 == 0) {
            obsIntHarmSync11.setValue(false);
        }

        if (harmVolSync12 == 127) {
            obsIntHarmSync12.setValue(true);
        }
        if (harmVolSync12 == 0) {
            obsIntHarmSync12.setValue(false);
        }

        if (harmVolRetrig1 == 127) {
            obsIntHarmRetrig1.setValue(true);
        }
        if (harmVolRetrig1 == 0) {
            obsIntHarmRetrig1.setValue(false);
        }

        if (harmVolRetrig2 == 127) {
            obsIntHarmRetrig2.setValue(true);
        }
        if (harmVolRetrig2 == 0) {
            obsIntHarmRetrig2.setValue(false);
        }

        if (harmVolRetrig3 == 127) {
            obsIntHarmRetrig3.setValue(true);
        }
        if (harmVolRetrig3 == 0) {
            obsIntHarmRetrig3.setValue(false);
        }

        if (harmVolRetrig4 == 127) {
            obsIntHarmRetrig4.setValue(true);
        }
        if (harmVolRetrig4 == 0) {
            obsIntHarmRetrig4.setValue(false);
        }

        if (harmVolRetrig5 == 127) {
            obsIntHarmRetrig5.setValue(true);
        }
        if (harmVolRetrig5== 0) {
            obsIntHarmRetrig5.setValue(false);
        }

        if (harmVolRetrig6 == 127) {
            obsIntHarmRetrig6.setValue(true);
        }
        if (harmVolRetrig6 == 0) {
            obsIntHarmRetrig6.setValue(false);
        }

        if (harmVolRetrig7 == 127) {
            obsIntHarmRetrig7.setValue(true);
        }
        if (harmVolRetrig7 == 0) {
            obsIntHarmRetrig7.setValue(false);
        }

        if (harmVolRetrig8 == 127) {
            obsIntHarmRetrig8.setValue(true);
        }
        if (harmVolRetrig8 == 0) {
            obsIntHarmRetrig8.setValue(false);
        }

        if (harmVolRetrig9 == 127) {
            obsIntHarmRetrig9.setValue(true);
        }
        if (harmVolRetrig9 == 0) {
            obsIntHarmRetrig9.setValue(false);
        }

        if (harmVolRetrig10 == 127) {
            obsIntHarmRetrig10.setValue(true);
        }
        if (harmVolRetrig10 == 0) {
            obsIntHarmRetrig10.setValue(false);
        }

        if (harmVolRetrig11 == 127) {
            obsIntHarmRetrig11.setValue(true);
        }
        if (harmVolRetrig11 == 0) {
            obsIntHarmRetrig11.setValue(false);
        }

        if (harmVolRetrig12 == 127) {
            obsIntHarmRetrig12.setValue(true);
        }
        if (harmVolRetrig12 == 0) {
            obsIntHarmRetrig12.setValue(false);
        }

        obsIntHarmRateRange.setValue(harmVolModRateRange);

        obsIntNoiseVol1.setValue(noiseVol1);
        obsIntNoiseVol2.setValue(noiseVol2);
        obsIntNoiseVol3.setValue(noiseVol3);
        obsIntNoiseVol4.setValue(noiseVol4);

        obsIntNoiseVolMod1.setValue(noiseVolMod1);
        obsIntNoiseVolMod2.setValue(noiseVolMod2);
        obsIntNoiseVolMod3.setValue(noiseVolMod3);
        obsIntNoiseVolMod4.setValue(noiseVolMod4);

        obsIntNoiseVolRate1.setValue(noiseVolRate1);
        obsIntNoiseVolRate2.setValue(noiseVolRate2);
        obsIntNoiseVolRate3.setValue(noiseVolRate3);
        obsIntNoiseVolRate4.setValue(noiseVolRate4);

        obsIntNoiseVolDiv1.setValue(noiseVolModDiv1);
        obsIntNoiseVolDiv2.setValue(noiseVolModDiv2);
        obsIntNoiseVolDiv3.setValue(noiseVolModDiv3);
        obsIntNoiseVolDiv4.setValue(noiseVolModDiv4);

        if (noiseVolSync1 == 127) {
            obsIntNoiseVolSync1.setValue(true);
        }
        if (noiseVolSync1 == 0) {
            obsIntNoiseVolSync1.setValue(false);
        }

        if (noiseVolSync2 == 127) {
            obsIntNoiseVolSync2.setValue(true);
        }
        if (noiseVolSync2 == 0) {
            obsIntNoiseVolSync2.setValue(false);
        }

        if (noiseVolSync3 == 127) {
            obsIntNoiseVolSync3.setValue(true);
        }
        if (noiseVolSync3 == 0) {
            obsIntNoiseVolSync3.setValue(false);
        }

        if (noiseVolSync4 == 127) {
            obsIntNoiseVolSync4.setValue(true);
        }
        if (noiseVolSync4 == 0) {
            obsIntNoiseVolSync4.setValue(false);
        }

        if (noiseVolRetrig1 == 127) {
            obsIntNoiseVolRetrig1.setValue(true);
        }
        if (noiseVolRetrig1 == 0) {
            obsIntNoiseVolRetrig1.setValue(false);
        }

        if (noiseVolRetrig2 == 127) {
            obsIntNoiseVolRetrig2.setValue(true);
        }
        if (noiseVolRetrig2 == 0) {
            obsIntNoiseVolRetrig2.setValue(false);
        }

        if (noiseVolRetrig3 == 127) {
            obsIntNoiseVolRetrig3.setValue(true);
        }
        if (noiseVolRetrig3 == 0) {
            obsIntNoiseVolRetrig3.setValue(false);
        }

        if (noiseVolRetrig4 == 127) {
            obsIntNoiseVolRetrig4.setValue(true);
        }
        if (noiseVolRetrig4 == 0) {
            obsIntNoiseVolRetrig4.setValue(false);
        }

        obsIntNoiseCut1.setValue(noiseCut1);
        obsIntNoiseCut2.setValue(noiseCut2);
        obsIntNoiseCut3.setValue(noiseCut3);
        obsIntNoiseCut4.setValue(noiseCut4);

        obsIntNoiseRes1.setValue(noiseRes1);
        obsIntNoiseRes2.setValue(noiseRes2);
        obsIntNoiseRes3.setValue(noiseRes3);
        obsIntNoiseRes4.setValue(noiseRes4);

        obsIntNoiseCutMod1.setValue(noiseCutMod1);
        obsIntNoiseCutMod2.setValue(noiseCutMod2);
        obsIntNoiseCutMod3.setValue(noiseCutMod3);
        obsIntNoiseCutMod4.setValue(noiseCutMod4);

        obsIntNoiseCutRate1.setValue(noiseCutRate1);
        obsIntNoiseCutRate2.setValue(noiseCutRate2);
        obsIntNoiseCutRate3.setValue(noiseCutRate3);
        obsIntNoiseCutRate4.setValue(noiseCutRate4);

        obsIntNoiseCutDiv1.setValue(noiseCutModDiv1);
        obsIntNoiseCutDiv2.setValue(noiseCutModDiv2);
        obsIntNoiseCutDiv3.setValue(noiseCutModDiv3);
        obsIntNoiseCutDiv4.setValue(noiseCutModDiv4);

        if (noiseCutSync1 == 127) {
            obsIntNoiseCutSync1.setValue(true);
        }
        if (noiseCutSync1 == 0) {
            obsIntNoiseCutSync1.setValue(false);
        }

        if (noiseCutSync2 == 127) {
            obsIntNoiseCutSync2.setValue(true);
        }
        if (noiseCutSync2 == 0) {
            obsIntNoiseCutSync2.setValue(false);
        }

        if (noiseCutSync3 == 127) {
            obsIntNoiseCutSync3.setValue(true);
        }
        if (noiseCutSync3 == 0) {
            obsIntNoiseCutSync3.setValue(false);
        }

        if (noiseCutSync4 == 127) {
            obsIntNoiseCutSync4.setValue(true);
        }
        if (noiseCutSync4 == 0) {
            obsIntNoiseCutSync4.setValue(false);
        }

        if (noiseCutRetrig1 == 127) {
            obsIntNoiseCutRetrig1.setValue(true);
        }
        if (noiseCutRetrig1 == 0) {
            obsIntNoiseCutRetrig1.setValue(false);
        }

        if (noiseCutRetrig2 == 127) {
            obsIntNoiseCutRetrig2.setValue(true);
        }
        if (noiseCutRetrig2 == 0) {
            obsIntNoiseCutRetrig2.setValue(false);
        }

        if (noiseCutRetrig3 == 127) {
            obsIntNoiseCutRetrig3.setValue(true);
        }
        if (noiseCutRetrig3 == 0) {
            obsIntNoiseCutRetrig3.setValue(false);
        }

        if (noiseCutRetrig4 == 127) {
            obsIntNoiseCutRetrig4.setValue(true);
        }
        if (noiseCutRetrig4 == 0) {
            obsIntNoiseCutRetrig4.setValue(false);
        }

        if (noiseType == 127) {
            obsIntNoisePink.setValue(true);
        }
        if (noiseType == 0) {
            obsIntNoisePink.setValue(false);
        }

        obsIntNoiseRateRangeVol.setValue(noiseModRateRangeVol);
        obsIntNoiseRateRangeCut.setValue(noiseModRateRangeCut);

        obsIntSourceSelect.setValue(sourceSelect);
        obsIntSourceNote.setValue(sourceNote);
        obsIntSourceFreq.setValue(sourceFreq);
        obsIntSourceMidiOct.setValue(sourceMidiOct);

        obsIntFmSelect.setValue(fmSelect);
        obsIntFmNote.setValue(fmNote);
        obsIntFmFreq.setValue(fmFreq);
        obsIntFmMidiOct.setValue(fmMidiOct);

        obsIntFmDepth.setValue(fmDepth);

        obsIntFmDepthModDepth.setValue(fmDepthModDepth);
        obsIntFmDepthModRate.setValue(fmDepthModRate);
        obsIntFmDepthModDiv.setValue(fmDepthModDiv);

        if (fmDepthModSync == 127) {
            obsIntFmDepthModSync.setValue(true);
        }
        if (fmDepthModSync == 0) {
            obsIntFmDepthModSync.setValue(false);
        }

        if (fmDepthModRetrig == 127) {
            obsIntFmDepthModRetrig.setValue(true);
        }
        if (fmDepthModRetrig == 0) {
            obsIntFmDepthModRetrig.setValue(false);
        }

        obsIntFmFreqModDepth.setValue(fmFreqModDepth);
        obsIntFmFreqModRate.setValue(fmFreqModRate);
        obsIntFmFreqModDiv.setValue(fmFreqModDiv);

        if (fmFreqModSync == 127) {
            obsIntFmFreqModSync.setValue(true);
        }
        if (fmFreqModSync == 0) {
            obsIntFmFreqModSync.setValue(false);
        }

        if (fmFreqModRetrig == 127) {
            obsIntFmFreqModRetrig.setValue(true);
        }
        if (fmDepthModRetrig == 0) {
            obsIntFmFreqModRetrig.setValue(false);
        }

        obsIntFilterCut.setValue(lpFilterCut);
        obsIntFilterRes.setValue(lpFilterRes);
        obsIntFilterEnv.setValue(lpFilterEnv);
        obsIntFilterMod.setValue(lpFilterMod);
        obsIntFilterRate.setValue(lpFilterRate);
        obsIntFilterDiv.setValue(lpFilterDiv);

        if (lpFilterSync == 127) {
            obsIntFilterSync.setValue(true);
        }
        if (lpFilterSync == 0) {
            obsIntFilterSync.setValue(false);
        }

        if (lpFilterRetrig == 127) {
            obsIntFilterRetrig.setValue(true);
        }
        if (lpFilterRetrig == 0) {
            obsIntFilterRetrig.setValue(false);
        }

        if (lpFilterPower == 127) {
            obsIntFilterPower.setValue(true);
        }
        if (lpFilterPower == 0) {
            obsIntFilterPower.setValue(false);
        }

        obsIntDecimateReduce.setValue(decimatorReduce);
        obsIntDecimateMod.setValue(decimatorMod);
        obsIntDecimateRate.setValue(decimatorRate);
        obsIntDecimateDiv.setValue(decimatorDiv);

        if (decimatorSync == 127) {
            obsIntDecimateSync.setValue(true);
        }
        if (decimatorSync == 0) {
            obsIntDecimateSync.setValue(false);
        }

        if (decimatorRetrig == 127) {
            obsIntDecimateRetrig.setValue(true);
        }
        if (decimatorRetrig == 0) {
            obsIntDecimateRetrig.setValue(false);
        }

        if (decimatorPower == 127) {
            obsIntDecimatePower.setValue(true);
        }
        if (decimatorPower == 0) {
            obsIntDecimatePower.setValue(false);
        }

        obsIntDelayTime.setValue(delayTime);
        obsIntDelayTimeR.setValue(delayTimeR);
        obsIntDelayDiv.setValue(delayDiv);
        obsIntDelayDivR.setValue(delayDivR);
        obsIntDelayFeed.setValue(delayFeed);
        obsIntDelayWet.setValue(delayWet);

        if (delaySync == 127) {
            obsIntDelaySync.setValue(true);
        }
        if (delaySync == 0) {
            obsIntDelaySync.setValue(false);
        }

        if (delayPower == 127) {
            obsIntDelayPower.setValue(true);
        }
        if (delayPower == 0) {
            obsIntDelayPower.setValue(false);
        }


        obsIntChorusRate.setValue(chorusRate);
        obsIntChorusDepth.setValue(chorusDepth);
        obsIntChorusDelay.setValue(chorusDelay);
        obsIntChorusFeed.setValue(chorusFeed);
        obsIntChorusWet.setValue(chorusWet);

        if (chorusPower == 127) {
            obsIntChorusPower.setValue(true);
        }
        if (chorusPower == 0) {
            obsIntChorusPower.setValue(false);
        }

        obsIntReverbSize.setValue(reverbSize);
        obsIntReverbDamp.setValue(reverbDamp);
        obsIntReverbWidth.setValue(reverbWidth);
        obsIntReverbWet.setValue(reverbWet);

        if (reverbPower == 127) {
            obsIntReverbPower.setValue(true);
        }
        if (reverbPower == 0) {
            obsIntReverbPower.setValue(false);
        }

        if (dcKill == 127) {
            obsIntDcKill.setValue(true);
        }
        if (dcKill == 0) {
            obsIntDcKill.setValue(false);
        }

        ////////////////////////////////////////////////////////////////
        /////////////////////////////////////////// Observable set end
        ////////////////////////////////////////////////////////////////

        binding.setObsInt(obsInt);
        binding.setObsIntNoiseMix(obsIntNoiseMix);
        binding.setObsIntOutputVol(obsIntOutputVol);
        binding.setObsIntEnvA(obsIntEnvA);
        binding.setObsIntEnvD(obsIntEnvD);
        binding.setObsIntEnvS(obsIntEnvS);
        binding.setObsIntEnvR(obsIntEnvR);

        binding.setObsIntDevicePower(obsIntDevicePower);
        binding.setObsIntDrone(obsIntDrone);

        binding.setObsIntBpm(obsIntBpm);
        binding.setObsIntMidiChan(obsIntMidiChan);
        binding.setObsIntKeyboardOct(obsIntkeyboardOct);


        ///////////////////////////////////////////////////// Navigator Buttons Start

        final Button buttonHarmonicsPageGet = findViewById(R.id.buttonToHarmonicsPage);
        buttonHarmonicsPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonHarmonicsPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonHarmonicsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonMainPageGet = findViewById(R.id.buttonToMainPage);
        buttonMainPageGet.setBackgroundColor(myColorD);

        final Button buttonToSourcePageGet = findViewById(R.id.buttonToSourcePage);
        buttonToSourcePageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToSourcePageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(MainActivity.this, FifthActivity.class);
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

                    Intent intentBundle = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToNoisePageGet.setBackgroundColor(myColorC);
                return false;
            }
        });


        // 11

        final Button buttonToEffectsPageGet = findViewById(R.id.buttonToEffectsPage);
        buttonToEffectsPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToEffectsPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(MainActivity.this, FourthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToEffectsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        ///////////////////////////////////////////////////// Navigator Buttons End

        ///////////////////////////////////////////////////// My IP Start
        final TextView textViewMyIpViewGet = (findViewById(R.id.textViewThisIpValue));
        textViewMyIpViewGet.setText(myIp);

        ///////////////////////////////////////////////////// My IP Start End

        ///////////////////////////////////////////////////// Preset Browser Start

        final Button buttonPresetUpGet = findViewById(R.id.buttonPresetUp);
        buttonPresetUpGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/192";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        buttonPresetUpGet.setBackgroundColor(myColorC);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                    }
                }

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonPresetUpGet.setBackgroundColor(myColorD);
                    }
                }
                return false;
            }
        });

        final Button buttonPresetDownGet = findViewById(R.id.buttonPresetDown);
        buttonPresetDownGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/193";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        buttonPresetDownGet.setBackgroundColor(myColorC);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonPresetDownGet.setBackgroundColor(myColorD);
                    }
                }
                return false;
            }
        });

        ///////////////////////////////////////////////////// Preset Browser End

        ///////////////////////////////////////////////////// Envelope Trigger Start

        final Button buttonTriggerGet = findViewById(R.id.buttonTrigger);
        buttonTriggerGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        buttonTriggerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        buttonTriggerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                    }
                }
                return false;
            }
        });
        ///////////////////////////////////////////////////// Envelope Trigger End

        final ToggleButton devicePowerGet = findViewById(R.id.toggleButtonDevicePower);
        if (devicePower == 127) {
            devicePowerGet.setChecked(true);
            devicePowerGet.setBackgroundColor(myColorD);
        }
        devicePowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/190";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        devicePowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        devicePower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/190";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        devicePowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        devicePower = 0;
                    }
                }
            }
        });


        final ToggleButton connectGet = findViewById(R.id.toggleButtonConnect);
        if (connectionCheck == 1) {
            connectGet.setChecked(true);
            connectGet.setBackgroundColor(myColorD);
        }
        connectGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    connectGet.setBackgroundColor(myColorD);
                    oscLink();
                     getLocalIpAddress();
                    textViewMyIpViewGet.setText(myIp);
                    System.out.println(myIp);
                    connectionCheck = 1;
                }
                else
                {
                    connectGet.setBackgroundColor(myColorC);
                    oscP5.stop();
                    myIp = "xxx.xxx.xxx.xxx";
                    textViewMyIpViewGet.setText(myIp);
                    connectionCheck = 0;
                }
            }
        });

        final ToggleButton droneGet = findViewById(R.id.toggleButtonDrone);
        if (droneVal == 127) {
            droneGet.setChecked(true);
            droneGet.setBackgroundColor(myColorD);
        }
        droneGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (connectionCheck == 1) {
                            getMyNetAddress();
                            String myMsgAddress = "/1/2525/1/183";
                            OscMessage myOscMessage = new OscMessage(myMsgAddress);
                            droneGet.setBackgroundColor(myColorD);
                            myOscMessage.add(127);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                            droneVal = 127;
                        }
                    } else {
                        if (connectionCheck == 1) {
                            getMyNetAddress();
                            String myMsgAddress = "/1/2525/1/183";
                            OscMessage myOscMessage = new OscMessage(myMsgAddress);
                            droneGet.setBackgroundColor(myColorC);
                            myOscMessage.add(0);
                            oscP5.send(myOscMessage, getBroadcastLocation);
                            droneVal = 0;
                        }
                    }
                }
        });

        Spinner spinnerBPMGet = (findViewById(R.id.spinnerBpm));
        spinnerBPMGet.setOnItemSelectedListener(new MainActivity.CustomOnItemSelectedListenerBPM());
        ArrayAdapter adapterBpm = ArrayAdapter.createFromResource(this,
                R.array.spinnerBpmData, R.layout.spinner_item);
        spinnerBPMGet.setAdapter(adapterBpm);
        spinnerBPMGet.setSelection(bpmData);

        Spinner spinnerMidiChanGet = (findViewById(R.id.spinnerMidiChan));
        spinnerMidiChanGet.setOnItemSelectedListener(new MainActivity.CustomOnItemSelectedListenerMidiChan());
        ArrayAdapter adapterMidiChan = ArrayAdapter.createFromResource(this,
                R.array.spinnerMidiChan, R.layout.spinner_item);
        spinnerMidiChanGet.setAdapter(adapterMidiChan);
        spinnerMidiChanGet.setSelection(midiChan);

        Spinner spinnerKeyboardOctGet = (findViewById(R.id.spinnerKeyboardOct));
        spinnerKeyboardOctGet.setOnItemSelectedListener(new MainActivity.CustomOnItemSelectedListenerKeyboardOct());
        ArrayAdapter adapterKeyboardOct = ArrayAdapter.createFromResource(this,
                R.array.spinnerOctavesFlip, R.layout.spinner_item);
        spinnerKeyboardOctGet.setAdapter(adapterKeyboardOct);
        spinnerKeyboardOctGet.setSelection(keyboardOctave);

        final Slider sliderHarmMixGet = findViewById(R.id.sliderHarmMix);
        sliderHarmMixGet.setValue(harmMix, true);
        sliderHarmMixGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/129";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmMixGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmMix = sliderHarmMixGet.getValue();
                }
            }
        });

        final Slider sliderNoiseMixGet = findViewById(R.id.sliderNoiseMix);
        sliderNoiseMixGet.setValue(noiseMix, true);
        sliderNoiseMixGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/130";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderNoiseMixGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    noiseMix = sliderNoiseMixGet.getValue();
                }
            }
        });


        final Slider sliderOutputVolumeGet = findViewById(R.id.sliderOutputVolume);
        sliderOutputVolumeGet.setValue(outputVolume, true);
        sliderOutputVolumeGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/189";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderOutputVolumeGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    outputVolume = sliderOutputVolumeGet.getValue();
                }
            }
        });

        final Slider sliderEnvAGet = findViewById(R.id.sliderEnvA);
        sliderEnvAGet.setValue(envelopeA, true);
        sliderEnvAGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/184";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderEnvAGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    envelopeA = sliderEnvAGet.getValue();
                }
            }
        });

        final Slider sliderEnvDGet = findViewById(R.id.sliderEnvD);
        sliderEnvDGet.setValue(envelopeD, true);
        sliderEnvDGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/185";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderEnvDGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    envelopeD = sliderEnvDGet.getValue();
                }
            }
        });

        final Slider sliderEnvSGet = findViewById(R.id.sliderEnvS);
        sliderEnvSGet.setValue(envelopeS, true);
        sliderEnvSGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/186";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderEnvSGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    envelopeS = sliderEnvSGet.getValue();
                }
            }
        });

        final Slider sliderEnvRGet = findViewById(R.id.sliderEnvR);
        sliderEnvRGet.setValue(envelopeR, true);
        sliderEnvRGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/187";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderEnvRGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    envelopeR = sliderEnvRGet.getValue();
                }
            }
        });

        final EditText ipGet = findViewById(R.id.editTextIP);
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start,
                                       int end, Spanned dest, int dstart, int dend) {
                if (end > start) {
                    String destTxt = dest.toString();
                    String resultingTxt = destTxt.substring(0, dstart) +
                            source.subSequence(start, end) +
                            destTxt.substring(dend);
                    if (!resultingTxt.matches ("^\\d{1,3}(\\." +
                            "(\\d{1,3}(\\.(\\d{1,3}(\\.(\\d{1,3})?)?)?)?)?)?")) {
                        return "";
                    } else {
                        String[] splits = resultingTxt.split("\\.");
                        for (int i=0; i<splits.length; i++) {
                            if (Integer.valueOf(splits[i]) > 255) {
                                return "";
                            }
                        }
                    }
                }
                return null;
            }
        };
        ipGet.setFilters(filters);

        ipGet.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                                           @SuppressLint("SetTextI18n")
                                           @Override
                                           public void onFocusChange(View v, boolean hasFocus) {
                                               if (!hasFocus) {
                                                   if (ipGet.getText().toString().equals("")) {
                                                       ipGet.setText("192.168.1.1");
                                                       ipData = ipGet.getText().toString();
                                                   }
                                               }

                                           }
                                       }
        );

        ipGet.setText(ipData);
        ipGet.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String msgGetCheckS = ipGet.getText().toString();
                if (msgGetCheckS.equals("0")) {
                    ipGet.setText("");
                }
                ipData = ipGet.getText().toString();
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        final EditText portGet = findViewById(R.id.editTextPort);
        portGet.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (portGet.getText().toString().equals("")) portGet.setText("8000");
                    portData = Integer.parseInt(portGet.getText().toString());
                }
            }
        });

        portGet.setText(String.valueOf(portData));
        portGet.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String msgGetCheckS = portGet.getText().toString();
                if (msgGetCheckS.equals("0")) {
                    portGet.setText("");
                }
                if (!msgGetCheckS.equals("")) {
                    portData = Integer.parseInt(portGet.getText().toString());
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });


        //////////////////////////////////////////////////// obs int



        //////////////////////////////////////////////////// obs int

    } // end create bundle


    ////////////////////////////////////////// Osc Link start

    void oscLink(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        oscP5 = new OscP5(this,9000);

    }

    ////////////////////////////////////////// Osc Link end

    public static void getMyNetAddress(){
        getBroadcastLocation = new NetAddress(ipData,portData);
    }

    public class CustomOnItemSelectedListenerBPM implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/188";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                myOscMessage.add(position);
                oscP5.send(myOscMessage, getBroadcastLocation);
                bpmData = position;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    } // end listener

    public class CustomOnItemSelectedListenerMidiChan implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/191";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                myOscMessage.add(Math.round(((position + 1) / 16.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
                midiChan = position;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    } // end listener

    public class CustomOnItemSelectedListenerKeyboardOct implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/195";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                myOscMessage.add(Math.round((position / 11.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
                keyboardOctave = position;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }
    } // end listener

    //////////////////////////////// Clear Focus Start

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    //////////////////////////////// Clear Focus End

    @Override
    protected void onResume() {
        super.onResume(); // Always call the superclass method first
        // oscLink();
    } // end resume

    @Override
    protected void onPause() {
        super.onPause(); // Always call the superclass method first

        SharedPreferences sharedPref= getSharedPreferences("OsAmaControlPref", 0);
        SharedPreferences.Editor editor= sharedPref.edit();

        // OSC Variables Start
        editor.putString("ipData", ipData);
        editor.putInt("portData", portData);
        // OSC Variables End

        /////////////////////////////////////////// Main Page - Main Activity Variables Start

        // mix section
        editor.putInt("harmMix", harmMix);
        editor.putInt("noiseMix", noiseMix);
        editor.putInt("outputVolume", outputVolume);

        // envelope
        editor.putInt("envelopeA", envelopeA);
        editor.putInt("envelopeD", envelopeD);
        editor.putInt("envelopeS", envelopeS);
        editor.putInt("envelopeR", envelopeR);
        editor.putInt("droneVal", droneVal);


        // main settings
        editor.putInt("devicePower", devicePower);
        editor.putInt("bpmData", bpmData);
        editor.putInt("midiChan", midiChan);
        editor.putInt("keyboardOctave", keyboardOctave);

        /////////////////////////////////////////// Main Page - Main Activity Variables End

        /////////////////////////////////////////// Harmonics Page - Second Activity Variables Start

        // harmonics volumes
        editor.putInt("harmVol1", harmVol1);
        editor.putInt("harmVol2", harmVol2);
        editor.putInt("harmVol3", harmVol3);
        editor.putInt("harmVol4", harmVol4);
        editor.putInt("harmVol5", harmVol5);
        editor.putInt("harmVol6", harmVol6);
        editor.putInt("harmVol7", harmVol7);
        editor.putInt("harmVol8", harmVol8);
        editor.putInt("harmVol9", harmVol9);
        editor.putInt("harmVol10", harmVol10);
        editor.putInt("harmVol11", harmVol11);
        editor.putInt("harmVol12", harmVol12);

        // harmonics mod
        editor.putInt("harmVolMod1", harmVolMod1);
        editor.putInt("harmVolMod2", harmVolMod2);
        editor.putInt("harmVolMod3", harmVolMod3);
        editor.putInt("harmVolMod4", harmVolMod4);
        editor.putInt("harmVolMod5", harmVolMod5);
        editor.putInt("harmVolMod6", harmVolMod6);
        editor.putInt("harmVolMod7", harmVolMod7);
        editor.putInt("harmVolMod8", harmVolMod8);
        editor.putInt("harmVolMod9", harmVolMod9);
        editor.putInt("harmVolMod10", harmVolMod10);
        editor.putInt("harmVolMod11", harmVolMod11);
        editor.putInt("harmVolMod12", harmVolMod12);

        // harmonics rates
        editor.putInt("harmVolRate1", harmVolRate1);
        editor.putInt("harmVolRate2", harmVolRate2);
        editor.putInt("harmVolRate3", harmVolRate3);
        editor.putInt("harmVolRate4", harmVolRate4);
        editor.putInt("harmVolRate5", harmVolRate5);
        editor.putInt("harmVolRate6", harmVolRate6);
        editor.putInt("harmVolRate7", harmVolRate7);
        editor.putInt("harmVolRate8", harmVolRate8);
        editor.putInt("harmVolRate9", harmVolRate9);
        editor.putInt("harmVolRate10", harmVolRate10);
        editor.putInt("harmVolRate11", harmVolRate11);
        editor.putInt("harmVolRate12", harmVolRate12);

        // harmonics sync
        editor.putInt("harmVolSync1", harmVolSync1);
        editor.putInt("harmVolSync2", harmVolSync2);
        editor.putInt("harmVolSync3", harmVolSync3);
        editor.putInt("harmVolSync4", harmVolSync4);
        editor.putInt("harmVolSync5", harmVolSync5);
        editor.putInt("harmVolSync6", harmVolSync6);
        editor.putInt("harmVolSync7", harmVolSync7);
        editor.putInt("harmVolSync8", harmVolSync8);
        editor.putInt("harmVolSync9", harmVolSync9);
        editor.putInt("harmVolSync10", harmVolSync10);
        editor.putInt("harmVolSync11", harmVolSync11);
        editor.putInt("harmVolSync12", harmVolSync12);

        editor.putInt("harmVolRetrig1", harmVolRetrig1);
        editor.putInt("harmVolRetrig2", harmVolRetrig2);
        editor.putInt("harmVolRetrig3", harmVolRetrig3);
        editor.putInt("harmVolRetrig4", harmVolRetrig4);
        editor.putInt("harmVolRetrig5", harmVolRetrig5);
        editor.putInt("harmVolRetrig6", harmVolRetrig6);
        editor.putInt("harmVolRetrig7", harmVolRetrig7);
        editor.putInt("harmVolRetrig8", harmVolRetrig8);
        editor.putInt("harmVolRetrig9", harmVolRetrig9);
        editor.putInt("harmVolRetrig10", harmVolRetrig10);
        editor.putInt("harmVolRetrig11", harmVolRetrig11);
        editor.putInt("harmVolRetrig12", harmVolRetrig12);

        // harmonics div
        editor.putInt("harmVolModDiv1", harmVolModDiv1);
        editor.putInt("harmVolModDiv2", harmVolModDiv2);
        editor.putInt("harmVolModDiv3", harmVolModDiv3);
        editor.putInt("harmVolModDiv4", harmVolModDiv4);
        editor.putInt("harmVolModDiv5", harmVolModDiv5);
        editor.putInt("harmVolModDiv6", harmVolModDiv6);
        editor.putInt("harmVolModDiv7", harmVolModDiv7);
        editor.putInt("harmVolModDiv8", harmVolModDiv8);
        editor.putInt("harmVolModDiv9", harmVolModDiv9);
        editor.putInt("harmVolModDiv10", harmVolModDiv10);
        editor.putInt("harmVolModDiv11", harmVolModDiv11);
        editor.putInt("harmVolModDiv12", harmVolModDiv12);

        // harmonics extra
        editor.putInt("harmVolModRetrig", harmVolModRetrig);
        editor.putInt("harmVolModRateRange", harmVolModRateRange);

        /////////////////////////////////////////// Harmonics Page - Second Activity Variables End

        /////////////////////////////////////////// Noise Page - Third Activity Variables Start

        // noise volume
        editor.putInt("noiseVol1", noiseVol1);
        editor.putInt("noiseVol2", noiseVol2);
        editor.putInt("noiseVol3", noiseVol3);
        editor.putInt("noiseVol4", noiseVol4);

        // noise vol mod
        editor.putInt("noiseVolMod1", noiseVolMod1);
        editor.putInt("noiseVolMod2", noiseVolMod2);
        editor.putInt("noiseVolMod3", noiseVolMod3);
        editor.putInt("noiseVolMod4", noiseVolMod4);

        // noise vol rate
        editor.putInt("noiseVolRate1", noiseVolRate1);
        editor.putInt("noiseVolRate2", noiseVolRate2);
        editor.putInt("noiseVolRate3", noiseVolRate3);
        editor.putInt("noiseVolRate4", noiseVolRate4);

        // noise vol sync
        editor.putInt("noiseVolSync1", noiseVolSync1);
        editor.putInt("noiseVolSync2", noiseVolSync2);
        editor.putInt("noiseVolSync3", noiseVolSync3);
        editor.putInt("noiseVolSync4", noiseVolSync4);

        // noise vol retrig
        editor.putInt("noiseVolRetrig1", noiseVolRetrig1);
        editor.putInt("noiseVolRetrig2", noiseVolRetrig2);
        editor.putInt("noiseVolRetrig3", noiseVolRetrig3);
        editor.putInt("noiseVolRetrig4", noiseVolRetrig4);

        // noise cut
        editor.putInt("noiseCut1", noiseCut1);
        editor.putInt("noiseCut2", noiseCut2);
        editor.putInt("noiseCut3", noiseCut3);
        editor.putInt("noiseCut4", noiseCut4);

        // noise res
        editor.putInt("noiseRes1", noiseRes1);
        editor.putInt("noiseRes2", noiseRes2);
        editor.putInt("noiseRes3", noiseRes3);
        editor.putInt("noiseRes4", noiseRes4);

        // noise cut mod
        editor.putInt("noiseCutMod1", noiseCutMod1);
        editor.putInt("noiseCutMod2", noiseCutMod2);
        editor.putInt("noiseCutMod3", noiseCutMod3);
        editor.putInt("noiseCutMod4", noiseCutMod4);

        // noise cut rate
        editor.putInt("noiseCutRate1", noiseCutRate1);
        editor.putInt("noiseCutRate2", noiseCutRate2);
        editor.putInt("noiseCutRate3", noiseCutRate3);
        editor.putInt("noiseCutRate4", noiseCutRate4);

        // noise cut Sync
        editor.putInt("noiseCutSync1", noiseCutSync1);
        editor.putInt("noiseCutSync2", noiseCutSync2);
        editor.putInt("noiseCutSync3", noiseCutSync3);
        editor.putInt("noiseCutSync4", noiseCutSync4);

        // noise cut Retrig
        editor.putInt("noiseCutRetrig1", noiseCutRetrig1);
        editor.putInt("noiseCutRetrig2", noiseCutRetrig2);
        editor.putInt("noiseCutRetrig3", noiseCutRetrig3);
        editor.putInt("noiseCutRetrig4", noiseCutRetrig4);

        // noise vol div
        editor.putInt("noiseVolModDiv1", noiseVolModDiv1);
        editor.putInt("noiseVolModDiv2", noiseVolModDiv2);
        editor.putInt("noiseVolModDiv3", noiseVolModDiv3);
        editor.putInt("noiseVolModDiv4", noiseVolModDiv4);

        // noise cut div
        editor.putInt("noiseCutModDiv1", noiseCutModDiv1);
        editor.putInt("noiseCutModDiv2", noiseCutModDiv2);
        editor.putInt("noiseCutModDiv3", noiseCutModDiv3);
        editor.putInt("noiseCutModDiv4", noiseCutModDiv4);

        // noise extra
        editor.putInt("noiseType", noiseType);
        editor.putInt("noiseModRateRangeVol", noiseModRateRangeVol);
        editor.putInt("noiseModRateRangeVol", noiseModRateRangeCut);
        editor.putInt("noiseModRetrig", noiseModRetrig);

        /////////////////////////////////////////// Noise Page - Third Activity Variables End

        /////////////////////////////////////////// Effects Page - Fourth Activity Variables Start

        // Filter
        editor.putInt("lpFilterCut", lpFilterCut);
        editor.putInt("lpFilterRes", lpFilterRes);
        editor.putInt("lpFilterEnv", lpFilterEnv);
        editor.putInt("lpFilterMod", lpFilterMod);
        editor.putInt("lpFilterRate", lpFilterRate);
        editor.putInt("lpFilterSync", lpFilterSync);
        editor.putInt("lpFilterDiv", lpFilterDiv);
        editor.putInt("lpFilterRetrig", lpFilterRetrig);
        editor.putInt("lpFilterPower", lpFilterPower);

        // Decimator
        editor.putInt("decimatorReduce", decimatorReduce);
        editor.putInt("decimatorMod", decimatorMod);
        editor.putInt("decimatorRate", decimatorRate);
        editor.putInt("decimatorSync", decimatorSync);
        editor.putInt("decimatorDiv", decimatorDiv);
        editor.putInt("decimatorRetrig", decimatorRetrig);
        editor.putInt("decimatorPower", decimatorPower);

        // Delay
        editor.putInt("delayTime", delayTime);
        editor.putInt("delayTimeR", delayTimeR);
        editor.putInt("delayFeed", delayFeed);
        editor.putInt("delaySync", delaySync);
        editor.putInt("delayDiv", delayDiv);
        editor.putInt("delayDivR", delayDivR);
        editor.putInt("delayWet", delayWet);
        editor.putInt("delayPower", delayPower);

        // Chorus
        editor.putInt("chorusRate", chorusRate);
        editor.putInt("chorusDepth", chorusDepth);
        editor.putInt("chorusDelay", chorusDelay);
        editor.putInt("chorusFeed", chorusFeed);
        editor.putInt("chorusWet", chorusWet);
        editor.putInt("chorusPower", chorusPower);

        // Reverb
        editor.putInt("reverbSize", reverbSize);
        editor.putInt("reverbDamp", reverbDamp);
        editor.putInt("reverbWidth", reverbWidth);
        editor.putInt("reverbWet", reverbWet);
        editor.putInt("reverbPower", reverbPower);

        // DC Kill
        editor.putInt("dcKill", dcKill);

        /////////////////////////////////////////// Effects Page - Fourth Activity Variables End

        /////////////////////////////////////////// Freq Page - Fifth Activity Variables Start

        // source freq
        editor.putInt("sourceNote", sourceNote);
        editor.putInt("sourceSelect", sourceSelect);
        editor.putInt("sourceMidiOct", sourceMidiOct);
        editor.putInt("sourceFreq", sourceFreq);

        // fm freq
        editor.putInt("fmNote", fmNote);
        editor.putInt("fmSelect", fmSelect);
        editor.putInt("fmMidiOct", fmMidiOct);
        editor.putInt("fmFreq", fmFreq);

        // fm modulation
        editor.putInt("fmDepth", fmDepth);
        editor.putInt("fmDepthModDepth", fmDepthModDepth);
        editor.putInt("fmFreqModDepth", fmFreqModDepth);
        editor.putInt("fmDepthModRate", fmDepthModRate);
        editor.putInt("fmFreqModRate", fmFreqModRate);
        editor.putInt("fmDepthModSync", fmDepthModSync);
        editor.putInt("fmFreqModSync", fmFreqModSync);
        editor.putInt("fmDepthModRetrig", fmDepthModRetrig);
        editor.putInt("fmFreqModRetrig", fmFreqModRetrig);
        editor.putInt("fmDepthModDiv", fmDepthModDiv);
        editor.putInt("fmFreqModDiv", fmFreqModDiv);

        /////////////////////////////////////////// Freq Page - Fifth Activity Variables End

        editor.apply();

    } //end pause

    @Override
    protected void onDestroy() {
        super.onDestroy(); // Always call the superclass method first
        final ToggleButton connectGet = findViewById(R.id.toggleButtonConnect);
        if (connectGet.isChecked()) {
            oscP5.stop();
        }
    } // end destroy

    //////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// OSC Event Start

    public void oscEvent(OscMessage theOscMessage) {

        System.out.println(" addrpattern: "+theOscMessage.addrPattern());
        System.out.println(" typetag: "+theOscMessage.typetag());
        System.out.println(" msg: "+theOscMessage.get(0).intValue());
             if (theOscMessage.addrPattern().equals("/1/2525/2/129")) {
                 obsInt.setValue(theOscMessage.get(0).intValue());
                 harmMix = obsInt.value;
            }
             if (theOscMessage.addrPattern().equals("/1/2525/2/130")) {
                 obsIntNoiseMix.setValue(theOscMessage.get(0).intValue());
                 noiseMix = obsIntNoiseMix.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/189")) {
                obsIntOutputVol.setValue(theOscMessage.get(0).intValue());
                outputVolume = obsIntOutputVol.value;
             }
            if (theOscMessage.addrPattern().equals("/1/2525/2/190")) {
                 if (theOscMessage.get(0).intValue() == 127) {
                     obsIntDevicePower.setValue(true);
                     devicePower = 127;
                 }
                if (theOscMessage.get(0).intValue() == 0) {
                    obsIntDevicePower.setValue(false);
                    devicePower = 0;
                }
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/183")) {
                 if (theOscMessage.get(0).intValue() == 127) {
                     obsIntDrone.setValue(true);
                     droneVal = 127;
            }
                 if (theOscMessage.get(0).intValue() == 0) {
                    obsIntDrone.setValue(false);
                     droneVal = 0;
            }
             }
            if (theOscMessage.addrPattern().equals("/1/2525/2/184")) {
                obsIntEnvA.setValue(theOscMessage.get(0).intValue());
                envelopeA = obsIntEnvA.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/185")) {
                obsIntEnvD.setValue(theOscMessage.get(0).intValue());
                envelopeD = obsIntEnvD.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/186")) {
                obsIntEnvS.setValue(theOscMessage.get(0).intValue());
                envelopeS = obsIntEnvS.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/187")) {
                obsIntEnvR.setValue(theOscMessage.get(0).intValue());
                envelopeR = obsIntEnvR.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/1")) {
            obsIntHarmVol1.setValue(theOscMessage.get(0).intValue());
            harmVol1 = obsIntHarmVol1.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/2")) {
            obsIntHarmVol2.setValue(theOscMessage.get(0).intValue());
            harmVol2 = obsIntHarmVol2.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/3")) {
            obsIntHarmVol3.setValue(theOscMessage.get(0).intValue());
                harmVol3 = obsIntHarmVol3.value;
             }
             if (theOscMessage.addrPattern().equals("/1/2525/2/4")) {
            obsIntHarmVol4.setValue(theOscMessage.get(0).intValue());
                 harmVol4 = obsIntHarmVol4.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/5")) {
            obsIntHarmVol5.setValue(theOscMessage.get(0).intValue());
                harmVol5 = obsIntHarmVol5.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/6")) {
            obsIntHarmVol6.setValue(theOscMessage.get(0).intValue());
                harmVol6 = obsIntHarmVol6.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/7")) {
            obsIntHarmVol7.setValue(theOscMessage.get(0).intValue());
                harmVol7 = obsIntHarmVol7.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/8")) {
            obsIntHarmVol8.setValue(theOscMessage.get(0).intValue());
                harmVol8 = obsIntHarmVol8.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/9")) {
            obsIntHarmVol9.setValue(theOscMessage.get(0).intValue());
                harmVol9 = obsIntHarmVol9.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/10")) {
            obsIntHarmVol10.setValue(theOscMessage.get(0).intValue());
                harmVol10 = obsIntHarmVol10.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/11")) {
            obsIntHarmVol11.setValue(theOscMessage.get(0).intValue());
                harmVol11 = obsIntHarmVol11.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/12")) {
            obsIntHarmVol12.setValue(theOscMessage.get(0).intValue());
                harmVol12 = obsIntHarmVol12.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/13")) {
            obsIntHarmMod1.setValue(theOscMessage.get(0).intValue());
            harmVolMod1 = obsIntHarmMod1.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/14")) {
            obsIntHarmMod2.setValue(theOscMessage.get(0).intValue());
                harmVolMod2 = obsIntHarmMod2.value;
             }
             if (theOscMessage.addrPattern().equals("/1/2525/2/15")) {
            obsIntHarmMod3.setValue(theOscMessage.get(0).intValue());
                 harmVolMod3 = obsIntHarmMod3.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/16")) {
            obsIntHarmMod4.setValue(theOscMessage.get(0).intValue());
                harmVolMod4 = obsIntHarmMod4.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/17")) {
            obsIntHarmMod5.setValue(theOscMessage.get(0).intValue());
                harmVolMod5 = obsIntHarmMod5.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/18")) {
            obsIntHarmMod6.setValue(theOscMessage.get(0).intValue());
                harmVolMod6 = obsIntHarmMod6.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/19")) {
            obsIntHarmMod7.setValue(theOscMessage.get(0).intValue());
                harmVolMod7 = obsIntHarmMod7.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/20")) {
            obsIntHarmMod8.setValue(theOscMessage.get(0).intValue());
                harmVolMod8 = obsIntHarmMod8.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/21")) {
            obsIntHarmMod9.setValue(theOscMessage.get(0).intValue());
                harmVolMod9 = obsIntHarmMod9.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/22")) {
            obsIntHarmMod10.setValue(theOscMessage.get(0).intValue());
                harmVolMod10 = obsIntHarmMod10.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/23")) {
            obsIntHarmMod11.setValue(theOscMessage.get(0).intValue());
                harmVolMod11 = obsIntHarmMod11.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/24")) {
            obsIntHarmMod12.setValue(theOscMessage.get(0).intValue());
                harmVolMod12 = obsIntHarmMod12.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/25")) {
            obsIntHarmRate1.setValue(theOscMessage.get(0).intValue());
                harmVolRate1 = obsIntHarmRate1.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/26")) {
            obsIntHarmRate2.setValue(theOscMessage.get(0).intValue());
                harmVolRate2 = obsIntHarmRate2.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/27")) {
            obsIntHarmRate3.setValue(theOscMessage.get(0).intValue());
                harmVolRate3 = obsIntHarmRate3.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/28")) {
            obsIntHarmRate4.setValue(theOscMessage.get(0).intValue());
                harmVolRate4 = obsIntHarmRate4.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/29")) {
            obsIntHarmRate5.setValue(theOscMessage.get(0).intValue());
                harmVolRate5 = obsIntHarmRate5.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/30")) {
            obsIntHarmRate6.setValue(theOscMessage.get(0).intValue());
                harmVolRate6 = obsIntHarmRate6.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/31")) {
            obsIntHarmRate7.setValue(theOscMessage.get(0).intValue());
                harmVolRate7 = obsIntHarmRate7.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/32")) {
            obsIntHarmRate8.setValue(theOscMessage.get(0).intValue());
                harmVolRate8 = obsIntHarmRate8.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/33")) {
            obsIntHarmRate9.setValue(theOscMessage.get(0).intValue());
                harmVolRate9 = obsIntHarmRate9.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/34")) {
            obsIntHarmRate10.setValue(theOscMessage.get(0).intValue());
                harmVolRate10 = obsIntHarmRate10.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/35")) {
            obsIntHarmRate11.setValue(theOscMessage.get(0).intValue());
                harmVolRate11 = obsIntHarmRate11.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/36")) {
            obsIntHarmRate12.setValue(theOscMessage.get(0).intValue());
                harmVolRate12 = obsIntHarmRate12.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/37")) {
            obsIntHarmRateRange.setValue(theOscMessage.get(0).intValue());
                harmVolModRateRange = obsIntHarmRateRange.value;
            }
            if (theOscMessage.addrPattern().equals("/1/2525/2/38")) {
                if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync1.setValue(true);
                harmVolSync1 = 127;
                }
                if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync1.setValue(false);
                harmVolSync1 = 0;
                }
            }
        if (theOscMessage.addrPattern().equals("/1/2525/2/39")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync2.setValue(true);
                harmVolSync2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync2.setValue(false);
                harmVolSync2 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/40")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync3.setValue(true);
                harmVolSync3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync3.setValue(false);
                harmVolSync3 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/41")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync4.setValue(true);
                harmVolSync4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync4.setValue(false);
                harmVolSync4 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/42")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync5.setValue(true);
                harmVolSync5 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync5.setValue(false);
                harmVolSync5 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/43")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync6.setValue(true);
                harmVolSync6 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync6.setValue(false);
                harmVolSync6 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/44")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync7.setValue(true);
                harmVolSync7 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync7.setValue(false);
                harmVolSync7 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/45")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync8.setValue(true);
                harmVolSync8 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync8.setValue(false);
                harmVolSync8 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/46")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync9.setValue(true);
                harmVolSync9 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync9.setValue(false);
                harmVolSync9 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/47")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync10.setValue(true);
                harmVolSync10 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync10.setValue(false);
                harmVolSync10 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/48")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync11.setValue(true);
                harmVolSync11 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync11.setValue(false);
                harmVolSync11 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/49")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmSync12.setValue(true);
                harmVolSync12 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmSync12.setValue(false);
                harmVolSync12 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/50")) {
            obsIntHarmDiv1.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv1 = obsIntHarmDiv1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/51")) {
            obsIntHarmDiv2.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv2 = obsIntHarmDiv2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/52")) {
            obsIntHarmDiv3.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv3 = obsIntHarmDiv3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/53")) {
            obsIntHarmDiv4.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv4 = obsIntHarmDiv4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/54")) {
            obsIntHarmDiv5.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv5 = obsIntHarmDiv5.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/55")) {
            obsIntHarmDiv6.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv6 = obsIntHarmDiv6.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/56")) {
            obsIntHarmDiv7.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv7 = obsIntHarmDiv7.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/57")) {
            obsIntHarmDiv8.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv8 = obsIntHarmDiv8.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/58")) {
            obsIntHarmDiv9.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv9 = obsIntHarmDiv9.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/59")) {
            obsIntHarmDiv10.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv10 = obsIntHarmDiv10.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/60")) {
            obsIntHarmDiv11.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv11 = obsIntHarmDiv11.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/61")) {
            obsIntHarmDiv12.setValue(theOscMessage.get(0).intValue());
            harmVolModDiv12 = obsIntHarmDiv12.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/74")) {
            obsIntNoiseVol1.setValue(theOscMessage.get(0).intValue());
            noiseVol1 = obsIntNoiseVol1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/75")) {
            obsIntNoiseVol2.setValue(theOscMessage.get(0).intValue());
            noiseVol2 = obsIntNoiseVol2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/76")) {
            obsIntNoiseVol3.setValue(theOscMessage.get(0).intValue());
            noiseVol3 = obsIntNoiseVol3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/77")) {
            obsIntNoiseVol4.setValue(theOscMessage.get(0).intValue());
            noiseVol4 = obsIntNoiseVol4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/78")) {
            obsIntNoiseVolMod1.setValue(theOscMessage.get(0).intValue());
            noiseVolMod1 = obsIntNoiseVolMod1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/79")) {
            obsIntNoiseVolMod2.setValue(theOscMessage.get(0).intValue());
            noiseVolMod2 = obsIntNoiseVolMod2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/80")) {
            obsIntNoiseVolMod3.setValue(theOscMessage.get(0).intValue());
            noiseVolMod3 = obsIntNoiseVolMod3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/81")) {
            obsIntNoiseVolMod4.setValue(theOscMessage.get(0).intValue());
            noiseVolMod4 = obsIntNoiseVolMod4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/82")) {
            obsIntNoiseVolRate1.setValue(theOscMessage.get(0).intValue());
            noiseVolRate1 = obsIntNoiseVolRate1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/83")) {
            obsIntNoiseVolRate2.setValue(theOscMessage.get(0).intValue());
            noiseVolRate2 = obsIntNoiseVolRate2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/84")) {
            obsIntNoiseVolRate3.setValue(theOscMessage.get(0).intValue());
            noiseVolRate3 = obsIntNoiseVolRate3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/85")) {
            obsIntNoiseVolRate4.setValue(theOscMessage.get(0).intValue());
            noiseVolRate4 = obsIntNoiseVolRate4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/87")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolSync1.setValue(true);
                noiseVolSync1 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolSync1.setValue(false);
                noiseVolSync1 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/88")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolSync2.setValue(true);
                noiseVolSync2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolSync2.setValue(false);
                noiseVolSync2 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/89")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolSync3.setValue(true);
                noiseVolSync3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolSync3.setValue(false);
                noiseVolSync3 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/90")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolSync4.setValue(true);
                noiseVolSync4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolSync4.setValue(false);
                noiseVolSync4 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/95")) {
            obsIntNoiseVolDiv1.setValue(theOscMessage.get(0).intValue());
            noiseVolModDiv1 = obsIntNoiseVolDiv1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/96")) {
            obsIntNoiseVolDiv2.setValue(theOscMessage.get(0).intValue());
            noiseVolModDiv2 = obsIntNoiseVolDiv2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/97")) {
            obsIntNoiseVolDiv3.setValue(theOscMessage.get(0).intValue());
            noiseVolModDiv3 = obsIntNoiseVolDiv3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/98")) {
            obsIntNoiseVolDiv4.setValue(theOscMessage.get(0).intValue());
            noiseVolModDiv4 = obsIntNoiseVolDiv4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/99")) {
         /*   System.out.println(" addrpattern: "+theOscMessage.addrPattern());
            System.out.println(" typetag: "+theOscMessage.typetag());
            System.out.println(" msg: "+theOscMessage.get(0).intValue());*/
            obsIntNoiseCut1.setValue(theOscMessage.get(0).intValue());
            noiseCut1 = obsIntNoiseCut1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/100")) {
            obsIntNoiseCut2.setValue(theOscMessage.get(0).intValue());
            noiseCut2 = obsIntNoiseCut2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/101")) {
            obsIntNoiseCut3.setValue(theOscMessage.get(0).intValue());
            noiseCut3 = obsIntNoiseCut3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/102")) {
            obsIntNoiseCut4.setValue(theOscMessage.get(0).intValue());
            noiseCut4 = obsIntNoiseCut4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/103")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoisePink.setValue(true);
                noiseType = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoisePink.setValue(false);
                noiseType = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/104")) {
            obsIntNoiseRes1.setValue(theOscMessage.get(0).intValue());
            noiseRes1 = obsIntNoiseRes1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/105")) {
            obsIntNoiseRes2.setValue(theOscMessage.get(0).intValue());
            noiseRes2 = obsIntNoiseRes2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/106")) {
            obsIntNoiseRes3.setValue(theOscMessage.get(0).intValue());
            noiseRes3 = obsIntNoiseRes3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/107")) {
            obsIntNoiseRes4.setValue(theOscMessage.get(0).intValue());
            noiseRes4 = obsIntNoiseRes4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/108")) {
            obsIntNoiseCutMod1.setValue(theOscMessage.get(0).intValue());
            noiseCutMod1 = obsIntNoiseCutMod1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/109")) {
            obsIntNoiseCutMod2.setValue(theOscMessage.get(0).intValue());
            noiseCutMod2 = obsIntNoiseCutMod2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/110")) {
            obsIntNoiseCutMod3.setValue(theOscMessage.get(0).intValue());
            noiseCutMod3 = obsIntNoiseCutMod3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/111")) {
            obsIntNoiseCutMod4.setValue(theOscMessage.get(0).intValue());
            noiseCutMod4 = obsIntNoiseCutMod4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/112")) {
            obsIntNoiseCutRate1.setValue(theOscMessage.get(0).intValue());
            noiseCutRate1 = obsIntNoiseCutRate1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/113")) {
            obsIntNoiseCutRate2.setValue(theOscMessage.get(0).intValue());
            noiseCutRate2 = obsIntNoiseCutRate2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/114")) {
            obsIntNoiseCutRate3.setValue(theOscMessage.get(0).intValue());
            noiseCutRate3 = obsIntNoiseCutRate3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/115")) {
            obsIntNoiseCutRate4.setValue(theOscMessage.get(0).intValue());
            noiseCutRate4 = obsIntNoiseCutRate4.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/117")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutSync1.setValue(true);
                noiseCutSync1 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutSync1.setValue(false);
                noiseCutSync1 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/118")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutSync2.setValue(true);
                noiseCutSync2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutSync2.setValue(false);
                noiseCutSync2 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/119")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutSync3.setValue(true);
                noiseCutSync3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutSync3.setValue(false);
                noiseCutSync3 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/120")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutSync4.setValue(true);
                noiseCutSync4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutSync4.setValue(false);
                noiseCutSync4 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/121")) {
            obsIntNoiseCutDiv1.setValue(theOscMessage.get(0).intValue());
            noiseCutModDiv1 = obsIntNoiseCutDiv1.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/122")) {
            obsIntNoiseCutDiv2.setValue(theOscMessage.get(0).intValue());
            noiseCutModDiv2 = obsIntNoiseCutDiv2.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/123")) {
            obsIntNoiseCutDiv3.setValue(theOscMessage.get(0).intValue());
            noiseCutModDiv3 = obsIntNoiseCutDiv3.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/124")) {
            obsIntNoiseCutDiv4.setValue(theOscMessage.get(0).intValue());
            noiseCutModDiv4 = obsIntNoiseCutDiv4.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/131")) {
            obsIntSourceSelect.setValue(theOscMessage.get(0).intValue());
            sourceSelect = obsIntSourceSelect.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/132")) {
            obsIntSourceNote.setValue(theOscMessage.get(0).intValue());
            sourceNote = obsIntSourceNote.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/133")) {
            obsIntSourceFreq.setValue(theOscMessage.get(0).intValue());
            sourceFreq = obsIntSourceFreq.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/134")) {
            obsIntSourceMidiOct.setValue(theOscMessage.get(0).intValue());
            sourceMidiOct = obsIntSourceMidiOct.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/135")) {
            obsIntFmSelect.setValue(theOscMessage.get(0).intValue());
            fmSelect = obsIntFmSelect.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/136")) {
            obsIntFmNote.setValue(theOscMessage.get(0).intValue());
            fmNote = obsIntFmNote.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/137")) {
            obsIntFmFreq.setValue(theOscMessage.get(0).intValue());
            fmFreq = obsIntFmFreq.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/138")) {
            obsIntFmMidiOct.setValue(theOscMessage.get(0).intValue());
            fmMidiOct = obsIntFmMidiOct.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/139")) {
            obsIntFmDepth.setValue(theOscMessage.get(0).intValue());
            fmDepth = obsIntFmDepth.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/140")) {
            obsIntFmDepthModDepth.setValue(theOscMessage.get(0).intValue());
            fmDepthModDepth = obsIntFmDepthModDepth.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/141")) {
            obsIntFmDepthModRate.setValue(theOscMessage.get(0).intValue());
            fmDepthModRate = obsIntFmDepthModRate.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/142")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFmDepthModSync.setValue(true);
                fmDepthModSync = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFmDepthModSync.setValue(false);
                fmDepthModSync = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/143")) {
            obsIntFmDepthModDiv.setValue(theOscMessage.get(0).intValue());
            fmDepthModDiv = obsIntFmDepthModDiv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/144")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFmDepthModRetrig.setValue(true);
                fmDepthModRetrig = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFmDepthModRetrig.setValue(false);
                fmDepthModRetrig = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/145")) {
            obsIntFmFreqModDepth.setValue(theOscMessage.get(0).intValue());
            fmFreqModDepth = obsIntFmFreqModDepth.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/146")) {
            obsIntFmFreqModRate.setValue(theOscMessage.get(0).intValue());
            fmFreqModRate = obsIntFmFreqModRate.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/147")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFmFreqModSync.setValue(true);
                fmFreqModSync = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFmFreqModSync.setValue(false);
                fmFreqModSync = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/148")) {
            obsIntFmFreqModDiv.setValue(theOscMessage.get(0).intValue());
            fmFreqModDiv = obsIntFmFreqModDiv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/149")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFmFreqModRetrig.setValue(true);
                fmFreqModRetrig = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFmFreqModRetrig.setValue(false);
                fmFreqModRetrig = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/182")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDcKill.setValue(true);
                dcKill = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDcKill.setValue(false);
                dcKill = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/150")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFilterPower.setValue(true);
                lpFilterPower = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFilterPower.setValue(false);
                lpFilterPower = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/151")) {
            obsIntFilterCut.setValue(theOscMessage.get(0).intValue());
            lpFilterCut = obsIntFilterCut.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/152")) {
            obsIntFilterRes.setValue(theOscMessage.get(0).intValue());
            lpFilterRes = obsIntFilterRes.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/198")) {
            obsIntFilterEnv.setValue(theOscMessage.get(0).intValue());
            lpFilterEnv = obsIntFilterEnv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/153")) {
            obsIntFilterMod.setValue(theOscMessage.get(0).intValue());
            lpFilterMod = obsIntFilterMod.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/154")) {
            obsIntFilterRate.setValue(theOscMessage.get(0).intValue());
            lpFilterRate = obsIntFilterRate.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/155")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFilterSync.setValue(true);
                lpFilterSync = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFilterSync.setValue(false);
                lpFilterSync = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/156")) {
            obsIntFilterDiv.setValue(theOscMessage.get(0).intValue());
            lpFilterDiv = obsIntFilterDiv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/157")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntFilterRetrig.setValue(true);
                lpFilterRetrig = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntFilterRetrig.setValue(false);
                lpFilterRetrig = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/158")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDecimatePower.setValue(true);
                decimatorPower = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDecimatePower.setValue(false);
                decimatorPower = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/159")) {
            obsIntDecimateReduce.setValue(theOscMessage.get(0).intValue());
            decimatorReduce = obsIntDecimateReduce.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/160")) {
            obsIntDecimateMod.setValue(theOscMessage.get(0).intValue());
            decimatorMod = obsIntDecimateMod.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/161")) {
            obsIntDecimateRate.setValue(theOscMessage.get(0).intValue());
            decimatorRate = obsIntDecimateRate.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/162")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDecimateSync.setValue(true);
                decimatorSync = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDecimateSync.setValue(false);
                decimatorSync = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/163")) {
            obsIntDecimateDiv.setValue(theOscMessage.get(0).intValue());
            decimatorDiv = obsIntDecimateDiv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/164")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDecimateRetrig.setValue(true);
                decimatorRetrig = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDecimateRetrig.setValue(false);
                decimatorRetrig = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/165")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDelayPower.setValue(true);
                delayPower = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDelayPower.setValue(false);
                delayPower = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/166")) {
            obsIntDelayTime.setValue(theOscMessage.get(0).intValue());
            delayTime = obsIntDelayTime.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/196")) {
            obsIntDelayTimeR.setValue(theOscMessage.get(0).intValue());
            delayTimeR = obsIntDelayTimeR.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/167")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntDelaySync.setValue(true);
                delaySync = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntDelaySync.setValue(false);
                delaySync = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/168")) {
            obsIntDelayDiv.setValue(theOscMessage.get(0).intValue());
            delayDiv = obsIntDelayDiv.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/197")) {
            obsIntDelayDivR.setValue(theOscMessage.get(0).intValue());
            delayDivR = obsIntDelayDivR.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/169")) {
            obsIntDelayFeed.setValue(theOscMessage.get(0).intValue());
            delayFeed = obsIntDelayFeed.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/170")) {
            obsIntDelayWet.setValue(theOscMessage.get(0).intValue());
            delayWet = obsIntDelayWet.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/171")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntChorusPower.setValue(true);
                chorusPower = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntChorusPower.setValue(false);
                chorusPower = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/172")) {
            obsIntChorusRate.setValue(theOscMessage.get(0).intValue());
            chorusRate = obsIntChorusRate.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/173")) {
            obsIntChorusDepth.setValue(theOscMessage.get(0).intValue());
            chorusDepth = obsIntChorusDepth.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/174")) {
            obsIntChorusDelay.setValue(theOscMessage.get(0).intValue());
            chorusDelay = obsIntChorusDelay.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/175")) {
            obsIntChorusFeed.setValue(theOscMessage.get(0).intValue());
            chorusFeed = obsIntChorusFeed.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/176")) {
            obsIntChorusWet.setValue(theOscMessage.get(0).intValue());
            chorusWet = obsIntChorusWet.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/177")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntReverbPower.setValue(true);
                reverbPower = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntReverbPower.setValue(false);
                reverbPower = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/178")) {
            obsIntReverbSize.setValue(theOscMessage.get(0).intValue());
            reverbSize = obsIntReverbSize.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/179")) {
            obsIntReverbDamp.setValue(theOscMessage.get(0).intValue());
            reverbDamp = obsIntReverbDamp.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/180")) {
            obsIntReverbWidth.setValue(theOscMessage.get(0).intValue());
            reverbWidth = obsIntReverbWidth.value;
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/181")) {
            obsIntReverbWet.setValue(theOscMessage.get(0).intValue());
            reverbWet = obsIntReverbWet.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/188")) {
            obsIntBpm.setValue(theOscMessage.get(0).intValue());
            bpmData = obsIntBpm.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/191")) {
            obsIntMidiChan.setValue(theOscMessage.get(0).intValue());
            midiChan = obsIntMidiChan.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/195")) {
            obsIntkeyboardOct.setValue(theOscMessage.get(0).intValue());
            keyboardOctave = obsIntkeyboardOct.value;
        }

         if (theOscMessage.addrPattern().equals("/1/2525/2/62")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig1.setValue(true);
                harmVolRetrig1 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig1.setValue(false);
                harmVolRetrig1 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/63")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig2.setValue(true);
                harmVolRetrig2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig2.setValue(false);
                harmVolRetrig2 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/64")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig3.setValue(true);
                harmVolRetrig3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig3.setValue(false);
                harmVolRetrig3 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/65")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig4.setValue(true);
                harmVolRetrig4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig4.setValue(false);
                harmVolRetrig4 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/66")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig5.setValue(true);
                harmVolRetrig5 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig5.setValue(false);
                harmVolRetrig5 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/67")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig6.setValue(true);
                harmVolRetrig6 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig6.setValue(false);
                harmVolRetrig6 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/68")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig7.setValue(true);
                harmVolRetrig7 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig7.setValue(false);
                harmVolRetrig7 = 0;
            }
        }
         if (theOscMessage.addrPattern().equals("/1/2525/2/69")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig8.setValue(true);
                harmVolRetrig8 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig8.setValue(false);
                harmVolRetrig8 = 0;
            }
        }
         if (theOscMessage.addrPattern().equals("/1/2525/2/70")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig9.setValue(true);
                harmVolRetrig9 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig9.setValue(false);
                harmVolRetrig9 = 0;
            }
        }
         if (theOscMessage.addrPattern().equals("/1/2525/2/71")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig10.setValue(true);
                harmVolRetrig10 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig10.setValue(false);
                harmVolRetrig10 = 0;
            }
        }
         if (theOscMessage.addrPattern().equals("/1/2525/2/72")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig11.setValue(true);
                harmVolRetrig11 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig11.setValue(false);
                harmVolRetrig11 = 0;
            }
        }
         if (theOscMessage.addrPattern().equals("/1/2525/2/73")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntHarmRetrig12.setValue(true);
                harmVolRetrig12 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntHarmRetrig12.setValue(false);
                harmVolRetrig12 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/91")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolRetrig1.setValue(true);
                noiseVolRetrig1 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolRetrig1.setValue(false);
                noiseVolRetrig1 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/92")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolRetrig2.setValue(true);
                noiseVolRetrig2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolRetrig2.setValue(false);
                noiseVolRetrig2 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/93")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolRetrig3.setValue(true);
                noiseVolRetrig3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolRetrig3.setValue(false);
                noiseVolRetrig3 = 0;
            }
        }
        if (theOscMessage.addrPattern().equals("/1/2525/2/94")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseVolRetrig4.setValue(true);
                noiseVolRetrig4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseVolRetrig4.setValue(false);
                noiseVolRetrig4 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/125")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutRetrig1.setValue(true);
                noiseCutRetrig1 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutRetrig1.setValue(false);
                noiseCutRetrig1 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/126")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutRetrig2.setValue(true);
                noiseCutRetrig2 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutRetrig2.setValue(false);
                noiseCutRetrig2 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/127")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutRetrig3.setValue(true);
                noiseCutRetrig3 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutRetrig3.setValue(false);
                noiseCutRetrig3 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/128")) {
            if (theOscMessage.get(0).intValue() == 127) {
                obsIntNoiseCutRetrig4.setValue(true);
                noiseCutRetrig4 = 127;
            }
            if (theOscMessage.get(0).intValue() == 0) {
                obsIntNoiseCutRetrig4.setValue(false);
                noiseCutRetrig4 = 0;
            }
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/86")) {
            obsIntNoiseRateRangeVol.setValue(theOscMessage.get(0).intValue());
            noiseModRateRangeVol = obsIntNoiseRateRangeVol.value;
        }

        if (theOscMessage.addrPattern().equals("/1/2525/2/116")) {
            obsIntNoiseRateRangeCut.setValue(theOscMessage.get(0).intValue());
            noiseModRateRangeCut = obsIntNoiseRateRangeCut.value;
        }

        } // end osc listener



    ////////////////////////////////////////// OSC Event End
    //////////////////////////////////////////////////////////////////////////////////////////////
   /* public static class ObsInt {
        public static final ObservableInt value =
                new ObservableInt();
    }*/

   //////////////////////////////////////////////////////////////////////////////////////////////

    public interface OnIntegerChangeListener
    {
        public void onIntegerChanged(int newValue);
    }

    public class ObsInt extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseMix extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntOutputVol extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDevicePower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDrone extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntEnvA extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntEnvD extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntEnvS extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntEnvR extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmVol12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmMod12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRate12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRateRange extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmSync12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmDiv12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVol1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVol2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVol3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVol4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolMod1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolMod2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolMod3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolMod4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRate1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRate2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRate3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRate4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolSync1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolSync2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolSync3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolSync4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolDiv1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolDiv2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolDiv3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolDiv4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCut1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCut2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCut3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCut4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRes1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRes2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRes3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRes4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutMod1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutMod2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutMod3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutMod4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRate1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRate2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRate3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRate4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutDiv1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutDiv2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutDiv3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutDiv4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutSync1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutSync2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutSync3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutSync4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoisePink extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRateRangeVol extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseRateRangeCut extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntSourceSelect extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntSourceNote extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntSourceFreq extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntSourceMidiOct extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmSelect extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmNote extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreq extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmMidiOct extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepth extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepthModDepth extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepthModRate extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepthModDiv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepthModSync extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmDepthModRetrig extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreqModDepth extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreqModRate extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreqModDiv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreqModSync extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFmFreqModRetrig extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDcKill extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimatePower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateReduce extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateMod extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateRate extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateSync extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateDiv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDecimateRetrig extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterPower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterCut extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterRes extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterEnv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterMod extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterRate extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterSync extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterDiv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntFilterRetrig extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayPower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayTime extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayTimeR extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelaySync extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayDiv extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayDivR extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayFeed extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntDelayWet extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusPower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusRate extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusDepth extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusDelay extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusFeed extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntChorusWet extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntReverbPower extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntReverbSize extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntReverbDamp extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntReverbWidth extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntReverbWet extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntMidiChan extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntBpm extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntKeyboardOct extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public int value;

        public void setOnIntegerChangeListener(OnIntegerChangeListener listener)
        {
            this.listener = listener;
        }

        @Bindable
        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);
            if(listener != null)
            {
                listener.onIntegerChanged(value);
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig5 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig6 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig7 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig8 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig9 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig10 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig11 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntHarmRetrig12 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRetrig1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRetrig2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRetrig3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseVolRetrig4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRetrig1 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRetrig2 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRetrig3 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////

    public class ObsIntNoiseCutRetrig4 extends BaseObservable
    {
        private OnIntegerChangeListener listener;

        public boolean value;

        @Bindable
        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
            notifyPropertyChanged(BR.value);

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

   ////////////////////////////////////// Binding Adapters

    @BindingAdapter("sl_value")
    public static void setValue(Slider slider, int sliderVal) {
            slider.setValue(sliderVal, true);
        }

    public static class BindingUtils
    {
        @BindingAdapter({"selection"})
        public static void setSelection(Spinner spinner, int position)
        {
            spinner.setSelection(position);
        }
    }

    void  getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        myIp = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            myIp = "no network";
            ex.printStackTrace();
        }
    }

} // end activity
