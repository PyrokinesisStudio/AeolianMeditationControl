package p.purechords.aeolianmeditationadvancedcontroller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.ToggleButton;
import com.rey.material.widget.Slider;

import java.util.Random;


import oscP5.OscMessage;

import p.purechords.aeolianmeditationadvancedcontroller.databinding.ActivitySecondBinding;

import static p.purechords.aeolianmeditationadvancedcontroller.MainActivity.*;


public class SecondActivity extends AppCompatActivity {



    Random random = new Random();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout with binding
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);



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
            lpFilterInv = sharedPref.getInt("lpFilterInv", lpFilterInv);
            lpFilterPower = sharedPref.getInt("lpFilterPower", lpFilterPower);

            // Decimator
            decimatorReduce = sharedPref.getInt("decimatorReduce", decimatorReduce);
            decimatorMod = sharedPref.getInt("decimatorMod", decimatorMod);
            decimatorRate = sharedPref.getInt("decimatorRate", decimatorRate);
            decimatorSync = sharedPref.getInt("decimatorSync", decimatorSync);
            decimatorDiv = sharedPref.getInt("decimatorDiv", decimatorDiv);
            decimatorRetrig = sharedPref.getInt("decimatorRetrig", decimatorRetrig);
            decimator8bit = sharedPref.getInt("decimator8bit", decimator8bit);
            decimatorPower = sharedPref.getInt("decimatorPower", decimatorPower);

            // Delay
            delayTime = sharedPref.getInt("delayTime", delayTime);
            delayTimeR = sharedPref.getInt("delayTimeR", delayTimeR);
            delayFeed = sharedPref.getInt("delayFeed", delayFeed);
            delaySync = sharedPref.getInt("delaySync", delaySync);
            delayDiv = sharedPref.getInt("delayDiv", delayDiv);
            delayDivR = sharedPref.getInt("delayDivR", delayDivR);
            delayWet = sharedPref.getInt("delayWet", delayWet);
            delayCross = sharedPref.getInt("delayCross", delayCross);
            delayPower = sharedPref.getInt("delayPower", delayPower);
            delayChorusSwitch = sharedPref.getInt("delayChorusSwitch", delayChorusSwitch);

            // Chorus
            chorusRate = sharedPref.getInt("chorusRate", chorusRate);
            chorusDepth = sharedPref.getInt("chorusDepth", chorusDepth);
            chorusDelay = sharedPref.getInt("chorusDelay", chorusDelay);
            chorusFeed = sharedPref.getInt("chorusFeed", chorusFeed);
            chorusFeedR = sharedPref.getInt("chorusFeedR", chorusFeedR);
            chorusCross = sharedPref.getInt("chorusCross", chorusCross);
            chorusWet = sharedPref.getInt("chorusWet", chorusWet);
            chorusPower = sharedPref.getInt("chorusPower", chorusPower);

            // Reverb
            reverbSize = sharedPref.getInt("reverbSize", reverbSize);
            reverbDelay = sharedPref.getInt("reverbDelay", reverbDelay);
            reverbHp = sharedPref.getInt("reverbHp", reverbHp);
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
            sourceFreq = sharedPref.getString("sourceFreq", sourceFreq);

            // fm freq
            fmNote = sharedPref.getInt("fmNote", fmNote);
            fmSelect = sharedPref.getInt("fmSelect", fmSelect);
            fmMidiOct = sharedPref.getInt("fmMidiOct", fmMidiOct);
            fmFreq = sharedPref.getString("fmFreq", fmFreq);

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

            fmRateRange = sharedPref.getInt("fmRateRange", fmRateRange);

            /////////////////////////////////////////// Freq Page - Fifth Activity Variables End

            /////////////////////////////////////////// Live Page - Sixth Activity Variables Start

            xyItemX1 = sharedPref.getInt("xyItemX1", xyItemX1);
            xyItemY1 = sharedPref.getInt("xyItemY1", xyItemY1);
            xyItemX2 = sharedPref.getInt("xyItemX2", xyItemX2);
            xyItemY2 = sharedPref.getInt("xyItemY2", xyItemY2);
            xyTrig1 = sharedPref.getInt("xyTrig1", xyTrig1);
            xyTrig2 = sharedPref.getInt("xyTrig2", xyTrig2);

            /////////////////////////////////////////// Live Page - Sixth Activity Variables End

            /////////////////////////////////////////// Play Page - Seventh Activity Variables Start

            playOctave = sharedPref.getInt("playOctave", playOctave);
            glideOn = sharedPref.getInt("glideOn", glideOn);
            glideTime = sharedPref.getInt("glideTime", glideTime);
            bendRange = sharedPref.getInt("bendRange", bendRange);

            /////////////////////////////////////////// Play Page - Seventh Activity Variables End

        } // end sharedpref

        ///////////////////////////////////////////////////// Shared Preferences  End

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

        obsIntFmRateRange.setValue(fmRateRange);

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

        if (lpFilterInv == 127) {
            obsIntFilterInv.setValue(true);
        }
        if (lpFilterInv == 0) {
            obsIntFilterInv.setValue(false);
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

        if (decimator8bit == 127) {
            obsIntDecimate8bit.setValue(true);
        }
        if (decimator8bit == 0) {
            obsIntDecimate8bit.setValue(false);
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

        if (delayChorusSwitch == 127) {
            obsIntDelayChorusSwitch.setValue(true);
        }
        if (delayChorusSwitch == 0) {
            obsIntDelayChorusSwitch.setValue(false);
        }

        if (delaySync == 127) {
            obsIntDelaySync.setValue(true);
        }
        if (delaySync == 0) {
            obsIntDelaySync.setValue(false);
        }

        if (delayCross == 127) {
            obsIntDelayCross.setValue(true);
        }
        if (delayCross == 0) {
            obsIntDelayCross.setValue(false);
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
        obsIntChorusFeedR.setValue(chorusFeedR);
        obsIntChorusWet.setValue(chorusWet);

        if (chorusCross == 127) {
            obsIntChorusCross.setValue(true);
        }
        if (chorusCross == 0) {
            obsIntChorusCross.setValue(false);
        }

        if (chorusPower == 127) {
            obsIntChorusPower.setValue(true);
        }
        if (chorusPower == 0) {
            obsIntChorusPower.setValue(false);
        }

        obsIntReverbSize.setValue(reverbSize);
        obsIntReverbDelay.setValue(reverbDelay);
        obsIntReverbHp.setValue(reverbHp);
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

        if (glideOn == 127) {
            obsIntGlideOn.setValue(true);
        }
        if (glideOn == 0) {
            obsIntGlideOn.setValue(false);
        }

        obsIntGlideTime.setValue(glideTime);
        obsIntBendRange.setValue(bendRange);

        ////////////////////////////////////////////////////////////////
        /////////////////////////////////////////// Observable set end
        ////////////////////////////////////////////////////////////////



        binding.setObsIntHarmVol1(obsIntHarmVol1);
        binding.setObsIntHarmVol2(obsIntHarmVol2);
        binding.setObsIntHarmVol3(obsIntHarmVol3);
        binding.setObsIntHarmVol4(obsIntHarmVol4);
        binding.setObsIntHarmVol5(obsIntHarmVol5);
        binding.setObsIntHarmVol6(obsIntHarmVol6);
        binding.setObsIntHarmVol7(obsIntHarmVol7);
        binding.setObsIntHarmVol8(obsIntHarmVol8);
        binding.setObsIntHarmVol9(obsIntHarmVol9);
        binding.setObsIntHarmVol10(obsIntHarmVol10);
        binding.setObsIntHarmVol11(obsIntHarmVol11);
        binding.setObsIntHarmVol12(obsIntHarmVol12);

        binding.setObsIntHarmMod1(obsIntHarmMod1);
        binding.setObsIntHarmMod2(obsIntHarmMod2);
        binding.setObsIntHarmMod3(obsIntHarmMod3);
        binding.setObsIntHarmMod4(obsIntHarmMod4);
        binding.setObsIntHarmMod5(obsIntHarmMod5);
        binding.setObsIntHarmMod6(obsIntHarmMod6);
        binding.setObsIntHarmMod7(obsIntHarmMod7);
        binding.setObsIntHarmMod8(obsIntHarmMod8);
        binding.setObsIntHarmMod9(obsIntHarmMod9);
        binding.setObsIntHarmMod10(obsIntHarmMod10);
        binding.setObsIntHarmMod11(obsIntHarmMod11);
        binding.setObsIntHarmMod12(obsIntHarmMod12);

        binding.setObsIntHarmRate1(obsIntHarmRate1);
        binding.setObsIntHarmRate2(obsIntHarmRate2);
        binding.setObsIntHarmRate3(obsIntHarmRate3);
        binding.setObsIntHarmRate4(obsIntHarmRate4);
        binding.setObsIntHarmRate5(obsIntHarmRate5);
        binding.setObsIntHarmRate6(obsIntHarmRate6);
        binding.setObsIntHarmRate7(obsIntHarmRate7);
        binding.setObsIntHarmRate8(obsIntHarmRate8);
        binding.setObsIntHarmRate9(obsIntHarmRate9);
        binding.setObsIntHarmRate10(obsIntHarmRate10);
        binding.setObsIntHarmRate11(obsIntHarmRate11);
        binding.setObsIntHarmRate12(obsIntHarmRate12);

        binding.setObsIntHarmRateRange(obsIntHarmRateRange);

        binding.setObsIntHarmSync1(obsIntHarmSync1);
        binding.setObsIntHarmSync2(obsIntHarmSync2);
        binding.setObsIntHarmSync3(obsIntHarmSync3);
        binding.setObsIntHarmSync4(obsIntHarmSync4);
        binding.setObsIntHarmSync5(obsIntHarmSync5);
        binding.setObsIntHarmSync6(obsIntHarmSync6);
        binding.setObsIntHarmSync7(obsIntHarmSync7);
        binding.setObsIntHarmSync8(obsIntHarmSync8);
        binding.setObsIntHarmSync9(obsIntHarmSync9);
        binding.setObsIntHarmSync10(obsIntHarmSync10);
        binding.setObsIntHarmSync11(obsIntHarmSync11);
        binding.setObsIntHarmSync12(obsIntHarmSync12);

        binding.setObsIntHarmRetrig1(obsIntHarmRetrig1);
        binding.setObsIntHarmRetrig2(obsIntHarmRetrig2);
        binding.setObsIntHarmRetrig3(obsIntHarmRetrig3);
        binding.setObsIntHarmRetrig4(obsIntHarmRetrig4);
        binding.setObsIntHarmRetrig5(obsIntHarmRetrig5);
        binding.setObsIntHarmRetrig6(obsIntHarmRetrig6);
        binding.setObsIntHarmRetrig7(obsIntHarmRetrig7);
        binding.setObsIntHarmRetrig8(obsIntHarmRetrig8);
        binding.setObsIntHarmRetrig9(obsIntHarmRetrig9);
        binding.setObsIntHarmRetrig10(obsIntHarmRetrig10);
        binding.setObsIntHarmRetrig11(obsIntHarmRetrig11);
        binding.setObsIntHarmRetrig12(obsIntHarmRetrig12);

        binding.setObsIntHarmDiv1(obsIntHarmDiv1);
        binding.setObsIntHarmDiv2(obsIntHarmDiv2);
        binding.setObsIntHarmDiv3(obsIntHarmDiv3);
        binding.setObsIntHarmDiv4(obsIntHarmDiv4);
        binding.setObsIntHarmDiv5(obsIntHarmDiv5);
        binding.setObsIntHarmDiv6(obsIntHarmDiv6);
        binding.setObsIntHarmDiv7(obsIntHarmDiv7);
        binding.setObsIntHarmDiv8(obsIntHarmDiv8);
        binding.setObsIntHarmDiv9(obsIntHarmDiv9);
        binding.setObsIntHarmDiv10(obsIntHarmDiv10);
        binding.setObsIntHarmDiv11(obsIntHarmDiv11);
        binding.setObsIntHarmDiv12(obsIntHarmDiv12);



        ///////////////////////////////////////////////////// Navigator Buttons Start

        final Button buttonToMainPageGet = findViewById(R.id.buttonToMainPage);
        buttonToMainPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToMainPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToMainPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonHarmonicsPageGet = findViewById(R.id.buttonToHarmonicsPage);
        buttonHarmonicsPageGet.setBackgroundColor(myColorD);

        final Button buttonToSourcePageGet = findViewById(R.id.buttonToSourcePage);
        buttonToSourcePageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToSourcePageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SecondActivity.this, FifthActivity.class);
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

                    Intent intentBundle = new Intent(SecondActivity.this, ThirdActivity.class);
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

                    Intent intentBundle = new Intent(SecondActivity.this, FourthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToEffectsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToPerformPageGet = findViewById(R.id.buttonToPerformPage);
        buttonToPerformPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToPerformPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SecondActivity.this, SixthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToPerformPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonPlayPageGet = findViewById(R.id.buttonToPlayPage);
        buttonPlayPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonPlayPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SecondActivity.this, SeventhActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonPlayPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        ///////////////////////////////////////////////////// Navigator Buttons End

        ////////////////////// Harmonic Volume Sliders Start

        final Slider sliderHarmVolGet1 = findViewById(R.id.sliderHarmVol1);
        sliderHarmVolGet1.setValue(harmVol1, true);
        sliderHarmVolGet1.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/1";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet1.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol1 = sliderHarmVolGet1.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet2 = findViewById(R.id.sliderHarmVol2);
        sliderHarmVolGet2.setValue(harmVol2, true);
        sliderHarmVolGet2.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/2";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet2.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol2 = sliderHarmVolGet2.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet3 = findViewById(R.id.sliderHarmVol3);
        sliderHarmVolGet3.setValue(harmVol3, true);
        sliderHarmVolGet3.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/3";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet3.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol3 = sliderHarmVolGet3.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet4 = findViewById(R.id.sliderHarmVol4);
        sliderHarmVolGet4.setValue(harmVol4, true);
        sliderHarmVolGet4.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/4";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet4.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol4 = sliderHarmVolGet4.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet5 = findViewById(R.id.sliderHarmVol5);
        sliderHarmVolGet5.setValue(harmVol5, true);
        sliderHarmVolGet5.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/5";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet5.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol5 = sliderHarmVolGet5.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet6 = findViewById(R.id.sliderHarmVol6);
        sliderHarmVolGet6.setValue(harmVol6, true);
        sliderHarmVolGet6.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/6";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet6.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol6 = sliderHarmVolGet6.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet7 = findViewById(R.id.sliderHarmVol7);
        sliderHarmVolGet7.setValue(harmVol7, true);
        sliderHarmVolGet7.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/7";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet7.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol7 = sliderHarmVolGet7.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet8 = findViewById(R.id.sliderHarmVol8);
        sliderHarmVolGet8.setValue(harmVol8, true);
        sliderHarmVolGet8.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/8";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet8.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol8 = sliderHarmVolGet8.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet9 = findViewById(R.id.sliderHarmVol9);
        sliderHarmVolGet9.setValue(harmVol9, true);
        sliderHarmVolGet9.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/9";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet9.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol9 = sliderHarmVolGet9.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet10 = findViewById(R.id.sliderHarmVol10);
        sliderHarmVolGet10.setValue(harmVol10, true);
        sliderHarmVolGet10.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/10";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet10.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol10 = sliderHarmVolGet10.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet11 = findViewById(R.id.sliderHarmVol11);
        sliderHarmVolGet11.setValue(harmVol11, true);
        sliderHarmVolGet11.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/11";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet11.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol11 = sliderHarmVolGet11.getValue();
                }
            }
        });

        final Slider sliderHarmVolGet12 = findViewById(R.id.sliderHarmVol12);
        sliderHarmVolGet12.setValue(harmVol12, true);
        sliderHarmVolGet12.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/12";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolGet12.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVol12 = sliderHarmVolGet12.getValue();
                }
            }
        });

        ////////////////////// Harmonic Volume Sliders End



        ////////////////////// Harmonic Volume Mod Depth Start

        final Slider sliderHarmVolModGet1 = findViewById(R.id.sliderHarmVolMod1);
        sliderHarmVolModGet1.setValue(harmVolMod1, true);
        sliderHarmVolModGet1.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/13";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet1.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod1 = sliderHarmVolModGet1.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet2 = findViewById(R.id.sliderHarmVolMod2);
        sliderHarmVolModGet2.setValue(harmVolMod2, true);
        sliderHarmVolModGet2.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/14";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet2.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod2 = sliderHarmVolModGet2.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet3 = findViewById(R.id.sliderHarmVolMod3);
        sliderHarmVolModGet3.setValue(harmVolMod3, true);
        sliderHarmVolModGet3.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/15";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet3.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod3 = sliderHarmVolModGet3.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet4 = findViewById(R.id.sliderHarmVolMod4);
        sliderHarmVolModGet4.setValue(harmVolMod4, true);
        sliderHarmVolModGet4.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/16";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet4.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod4 = sliderHarmVolModGet4.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet5 = findViewById(R.id.sliderHarmVolMod5);
        sliderHarmVolModGet5.setValue(harmVolMod5, true);
        sliderHarmVolModGet5.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/17";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet5.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod5 = sliderHarmVolModGet5.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet6 = findViewById(R.id.sliderHarmVolMod6);
        sliderHarmVolModGet6.setValue(harmVolMod6, true);
        sliderHarmVolModGet6.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/18";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet6.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod6 = sliderHarmVolModGet6.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet7 = findViewById(R.id.sliderHarmVolMod7);
        sliderHarmVolModGet7.setValue(harmVolMod7, true);
        sliderHarmVolModGet7.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/19";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet7.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod7 = sliderHarmVolModGet7.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet8 = findViewById(R.id.sliderHarmVolMod8);
        sliderHarmVolModGet8.setValue(harmVolMod8, true);
        sliderHarmVolModGet8.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/20";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet8.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod8 = sliderHarmVolModGet8.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet9 = findViewById(R.id.sliderHarmVolMod9);
        sliderHarmVolModGet9.setValue(harmVolMod9, true);
        sliderHarmVolModGet9.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/21";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet9.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod9 = sliderHarmVolModGet9.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet10 = findViewById(R.id.sliderHarmVolMod10);
        sliderHarmVolModGet10.setValue(harmVolMod10, true);
        sliderHarmVolModGet10.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/22";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet10.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod10 = sliderHarmVolModGet10.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet11 = findViewById(R.id.sliderHarmVolMod11);
        sliderHarmVolModGet11.setValue(harmVolMod11, true);
        sliderHarmVolModGet11.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/23";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet11.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod11 = sliderHarmVolModGet11.getValue();
                }
            }
        });

        final Slider sliderHarmVolModGet12 = findViewById(R.id.sliderHarmVolMod12);
        sliderHarmVolModGet12.setValue(harmVolMod12, true);
        sliderHarmVolModGet12.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/24";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolModGet12.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolMod12 = sliderHarmVolModGet12.getValue();
                }
            }
        });

        ////////////////////// Harmonic Volume Mod Depth End

        ////////////////////// Harmonic Volume Mod Rate Start

        final Slider sliderHarmVolRateGet1 = findViewById(R.id.sliderHarmVolRate1);
        sliderHarmVolRateGet1.setValue(harmVolRate1, true);
        sliderHarmVolRateGet1.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/25";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet1.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate1 = sliderHarmVolRateGet1.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet2 = findViewById(R.id.sliderHarmVolRate2);
        sliderHarmVolRateGet2.setValue(harmVolRate2, true);
        sliderHarmVolRateGet2.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/26";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet2.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate2 = sliderHarmVolRateGet2.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet3 = findViewById(R.id.sliderHarmVolRate3);
        sliderHarmVolRateGet3.setValue(harmVolRate3, true);
        sliderHarmVolRateGet3.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/27";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet3.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate3 = sliderHarmVolRateGet3.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet4 = findViewById(R.id.sliderHarmVolRate4);
        sliderHarmVolRateGet4.setValue(harmVolRate4, true);
        sliderHarmVolRateGet4.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/28";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet4.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate4 = sliderHarmVolRateGet4.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet5 = findViewById(R.id.sliderHarmVolRate5);
        sliderHarmVolRateGet5.setValue(harmVolRate5, true);
        sliderHarmVolRateGet5.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/29";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet5.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate5 = sliderHarmVolRateGet5.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet6 = findViewById(R.id.sliderHarmVolRate6);
        sliderHarmVolRateGet6.setValue(harmVolRate6, true);
        sliderHarmVolRateGet6.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/30";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet6.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate6 = sliderHarmVolRateGet6.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet7 = findViewById(R.id.sliderHarmVolRate7);
        sliderHarmVolRateGet7.setValue(harmVolRate7, true);
        sliderHarmVolRateGet7.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/31";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet7.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate7 = sliderHarmVolRateGet7.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet8 = findViewById(R.id.sliderHarmVolRate8);
        sliderHarmVolRateGet8.setValue(harmVolRate8, true);
        sliderHarmVolRateGet8.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/32";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet8.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate8 = sliderHarmVolRateGet8.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet9 = findViewById(R.id.sliderHarmVolRate9);
        sliderHarmVolRateGet9.setValue(harmVolRate9, true);
        sliderHarmVolRateGet9.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/33";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet9.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate9 = sliderHarmVolRateGet9.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet10 = findViewById(R.id.sliderHarmVolRate10);
        sliderHarmVolRateGet10.setValue(harmVolRate10, true);
        sliderHarmVolRateGet10.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/34";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet10.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate10 = sliderHarmVolRateGet10.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet11 = findViewById(R.id.sliderHarmVolRate11);
        sliderHarmVolRateGet11.setValue(harmVolRate11, true);
        sliderHarmVolRateGet11.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/35";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet11.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate11 = sliderHarmVolRateGet11.getValue();
                }
            }
        });

        final Slider sliderHarmVolRateGet12 = findViewById(R.id.sliderHarmVolRate12);
        sliderHarmVolRateGet12.setValue(harmVolRate12, true);
        sliderHarmVolRateGet12.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/36";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderHarmVolRateGet12.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    harmVolRate12 = sliderHarmVolRateGet12.getValue();
                }
            }
        });

        ////////////////////// Harmonic Volume Mod Rate End

        ////////////////////// Harmonic Volume Mod Sync Start

        final ToggleButton toggleButtonHarmVolModSyncGet1 = findViewById(R.id.toggleButtonHarmVolModSync1);
        if (harmVolSync1 == 127) {
            toggleButtonHarmVolModSyncGet1.setChecked(true);
            toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/38";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync1 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/38";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync1 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet2 = findViewById(R.id.toggleButtonHarmVolModSync2);
        if (harmVolSync2 == 127) {
            toggleButtonHarmVolModSyncGet2.setChecked(true);
            toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/39";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync2 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/39";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync2 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet3 = findViewById(R.id.toggleButtonHarmVolModSync3);
        if (harmVolSync3 == 127) {
            toggleButtonHarmVolModSyncGet3.setChecked(true);
            toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/40";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync3 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/40";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync3 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet4 = findViewById(R.id.toggleButtonHarmVolModSync4);
        if (harmVolSync4 == 127) {
            toggleButtonHarmVolModSyncGet4.setChecked(true);
            toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/41";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync4 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/41";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync4 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet5 = findViewById(R.id.toggleButtonHarmVolModSync5);
        if (harmVolSync5 == 127) {
            toggleButtonHarmVolModSyncGet5.setChecked(true);
            toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/42";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync5 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/42";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync5 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet6 = findViewById(R.id.toggleButtonHarmVolModSync6);
        if (harmVolSync1 == 127) {
            toggleButtonHarmVolModSyncGet6.setChecked(true);
            toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/43";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync6 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/43";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync6 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet7 = findViewById(R.id.toggleButtonHarmVolModSync7);
        if (harmVolSync7 == 127) {
            toggleButtonHarmVolModSyncGet7.setChecked(true);
            toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/44";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync7 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/44";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync7 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet8 = findViewById(R.id.toggleButtonHarmVolModSync8);
        if (harmVolSync8 == 127) {
            toggleButtonHarmVolModSyncGet8.setChecked(true);
            toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/45";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync8 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/45";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync8 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet9 = findViewById(R.id.toggleButtonHarmVolModSync9);
        if (harmVolSync9 == 127) {
            toggleButtonHarmVolModSyncGet9.setChecked(true);
            toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/46";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync9 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/46";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync9 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet10 = findViewById(R.id.toggleButtonHarmVolModSync10);
        if (harmVolSync10 == 127) {
            toggleButtonHarmVolModSyncGet10.setChecked(true);
            toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/47";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync10 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/47";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync10 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet11 = findViewById(R.id.toggleButtonHarmVolModSync11);
        if (harmVolSync11 == 127) {
            toggleButtonHarmVolModSyncGet11.setChecked(true);
            toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/48";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync11 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/48";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync11 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModSyncGet12 = findViewById(R.id.toggleButtonHarmVolModSync12);
        if (harmVolSync12 == 127) {
            toggleButtonHarmVolModSyncGet12.setChecked(true);
            toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModSyncGet12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/49";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync12 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/49";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolSync12 = 0;
                    }
                }
            }
        }); // end listener

        ////////////////////// Harmonic Volume Mod Sync End

        ////////////////////// Harmonic Volume Mod Retrig Start

        final ToggleButton toggleButtonHarmVolModRetrigGet1 = findViewById(R.id.toggleButtonHarmVolModRetrig1);
        if (harmVolRetrig1 == 127) {
            toggleButtonHarmVolModRetrigGet1.setChecked(true);
            toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/62";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig1 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/62";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig1 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet2 = findViewById(R.id.toggleButtonHarmVolModRetrig2);
        if (harmVolRetrig2 == 127) {
            toggleButtonHarmVolModRetrigGet2.setChecked(true);
            toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/63";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig2 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/63";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig2 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet3 = findViewById(R.id.toggleButtonHarmVolModRetrig3);
        if (harmVolRetrig3 == 127) {
            toggleButtonHarmVolModRetrigGet3.setChecked(true);
            toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/64";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig3 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/64";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig3 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet4= findViewById(R.id.toggleButtonHarmVolModRetrig4);
        if (harmVolRetrig4 == 127) {
            toggleButtonHarmVolModRetrigGet4.setChecked(true);
            toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/65";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig4 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/65";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig4 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet5 = findViewById(R.id.toggleButtonHarmVolModRetrig5);
        if (harmVolRetrig5 == 127) {
            toggleButtonHarmVolModRetrigGet5.setChecked(true);
            toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/66";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig5 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/66";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig5 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet6 = findViewById(R.id.toggleButtonHarmVolModRetrig6);
        if (harmVolRetrig6 == 127) {
            toggleButtonHarmVolModRetrigGet6.setChecked(true);
            toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/67";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig6 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/67";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig6 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet7 = findViewById(R.id.toggleButtonHarmVolModRetrig7);
        if (harmVolRetrig7 == 127) {
            toggleButtonHarmVolModRetrigGet7.setChecked(true);
            toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/68";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig7 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/68";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig7 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet8 = findViewById(R.id.toggleButtonHarmVolModRetrig8);
        if (harmVolRetrig8 == 127) {
            toggleButtonHarmVolModRetrigGet8.setChecked(true);
            toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/69";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig8 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/69";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig8 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet9 = findViewById(R.id.toggleButtonHarmVolModRetrig9);
        if (harmVolRetrig9 == 127) {
            toggleButtonHarmVolModRetrigGet9.setChecked(true);
            toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/70";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig9 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/70";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig9 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet10 = findViewById(R.id.toggleButtonHarmVolModRetrig10);
        if (harmVolRetrig10 == 127) {
            toggleButtonHarmVolModRetrigGet10.setChecked(true);
            toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/71";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig10 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/71";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig10 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet11 = findViewById(R.id.toggleButtonHarmVolModRetrig11);
        if (harmVolRetrig11 == 127) {
            toggleButtonHarmVolModRetrigGet11.setChecked(true);
            toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/72";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig11 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/72";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig11 = 0;
                    }
                }
            }
        }); // end listener

        final ToggleButton toggleButtonHarmVolModRetrigGet12 = findViewById(R.id.toggleButtonHarmVolModRetrig12);
        if (harmVolRetrig12 == 127) {
            toggleButtonHarmVolModRetrigGet12.setChecked(true);
            toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorD);
        }
        toggleButtonHarmVolModRetrigGet12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/73";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig12 = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/73";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        harmVolRetrig12 = 0;
                    }
                }
            }
        }); // end listener

        ////////////////////// Harmonic Volume Mod Retrig End

        ////////////////////// Harmonic Volume Mod Div Start

        final Spinner spinnerHarmVolModDivGet1 = (findViewById(R.id.spinnerHarmVolModDiv1));
        spinnerHarmVolModDivGet1.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv1());
        ArrayAdapter adapterHarmVolModDiv1 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet1.setAdapter(adapterHarmVolModDiv1);
        spinnerHarmVolModDivGet1.setSelection(harmVolModDiv1);

        final Spinner spinnerHarmVolModDivGet2 = (findViewById(R.id.spinnerHarmVolModDiv2));
        spinnerHarmVolModDivGet2.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv2());
        ArrayAdapter adapterHarmVolModDiv2 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet2.setAdapter(adapterHarmVolModDiv2);
        spinnerHarmVolModDivGet2.setSelection(harmVolModDiv2);

        final Spinner spinnerHarmVolModDivGet3 = (findViewById(R.id.spinnerHarmVolModDiv3));
        spinnerHarmVolModDivGet3.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv3());
        ArrayAdapter adapterHarmVolModDiv3 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet3.setAdapter(adapterHarmVolModDiv3);
        spinnerHarmVolModDivGet3.setSelection(harmVolModDiv3);

        final Spinner spinnerHarmVolModDivGet4 = (findViewById(R.id.spinnerHarmVolModDiv4));
        spinnerHarmVolModDivGet4.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv4());
        ArrayAdapter adapterHarmVolModDiv4 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet4.setAdapter(adapterHarmVolModDiv4);
        spinnerHarmVolModDivGet4.setSelection(harmVolModDiv4);

        final Spinner spinnerHarmVolModDivGet5 = (findViewById(R.id.spinnerHarmVolModDiv5));
        spinnerHarmVolModDivGet5.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv5());
        ArrayAdapter adapterHarmVolModDiv5 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet5.setAdapter(adapterHarmVolModDiv5);
        spinnerHarmVolModDivGet5.setSelection(harmVolModDiv5);

        final Spinner spinnerHarmVolModDivGet6 = (findViewById(R.id.spinnerHarmVolModDiv6));
        spinnerHarmVolModDivGet6.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv6());
        ArrayAdapter adapterHarmVolModDiv6 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet6.setAdapter(adapterHarmVolModDiv6);
        spinnerHarmVolModDivGet6.setSelection(harmVolModDiv6);

        final Spinner spinnerHarmVolModDivGet7 = (findViewById(R.id.spinnerHarmVolModDiv7));
        spinnerHarmVolModDivGet7.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv7());
        ArrayAdapter adapterHarmVolModDiv7 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet7.setAdapter(adapterHarmVolModDiv7);
        spinnerHarmVolModDivGet7.setSelection(harmVolModDiv7);

        final Spinner spinnerHarmVolModDivGet8 = (findViewById(R.id.spinnerHarmVolModDiv8));
        spinnerHarmVolModDivGet8.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv8());
        ArrayAdapter adapterHarmVolModDiv8 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet8.setAdapter(adapterHarmVolModDiv8);
        spinnerHarmVolModDivGet8.setSelection(harmVolModDiv8);

        final Spinner spinnerHarmVolModDivGet9 = (findViewById(R.id.spinnerHarmVolModDiv9));
        spinnerHarmVolModDivGet9.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv9());
        ArrayAdapter adapterHarmVolModDiv9 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet9.setAdapter(adapterHarmVolModDiv9);
        spinnerHarmVolModDivGet9.setSelection(harmVolModDiv9);

        final Spinner spinnerHarmVolModDivGet10 = (findViewById(R.id.spinnerHarmVolModDiv10));
        spinnerHarmVolModDivGet10.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv10());
        ArrayAdapter adapterHarmVolModDiv10 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet10.setAdapter(adapterHarmVolModDiv10);
        spinnerHarmVolModDivGet10.setSelection(harmVolModDiv10);

        final Spinner spinnerHarmVolModDivGet11 = (findViewById(R.id.spinnerHarmVolModDiv11));
        spinnerHarmVolModDivGet11.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv11());
        ArrayAdapter adapterHarmVolModDiv11 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet11.setAdapter(adapterHarmVolModDiv11);
        spinnerHarmVolModDivGet11.setSelection(harmVolModDiv11);

        final Spinner spinnerHarmVolModDivGet12 = (findViewById(R.id.spinnerHarmVolModDiv12));
        spinnerHarmVolModDivGet12.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModDiv12());
        ArrayAdapter adapterHarmVolModDiv12 = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerHarmVolModDivGet12.setAdapter(adapterHarmVolModDiv12);
        spinnerHarmVolModDivGet12.setSelection(harmVolModDiv12);

        ////////////////////// Harmonic Volume Mod Div End

        ////////////////////// Harmonic Volume Mod Rate Range Start

        final Spinner spinnerHarmVolModRateRangeGet1 = (findViewById(R.id.spinnerHarmVolModRateRange));
        spinnerHarmVolModRateRangeGet1.setOnItemSelectedListener(new SecondActivity.CustomOnItemSelectedListenerHarmVolModRateRange());
        ArrayAdapter adapterHarmVolModRateRange = ArrayAdapter.createFromResource(this,
                R.array.spinnerRateRange, R.layout.spinner_item);
        spinnerHarmVolModRateRangeGet1.setAdapter(adapterHarmVolModRateRange);
        spinnerHarmVolModRateRangeGet1.setSelection(harmVolModRateRange);

        ////////////////////// Harmonic Volume Mod Rate Range End

        ////////////////////// Harmonic Volume Mod Retrig Start

        final ToggleButton toggleButtonHarmVolModRetrigGet = findViewById(R.id.toggleButtonHarmVolModRetrig);
        toggleButtonHarmVolModRetrigGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {

                        toggleButtonHarmVolModRetrigGet.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet1.setChecked(true);
                        toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet2.setChecked(true);
                        toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet3.setChecked(true);
                        toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet4.setChecked(true);
                        toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet5.setChecked(true);
                        toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet6.setChecked(true);
                        toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet7.setChecked(true);
                        toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet8.setChecked(true);
                        toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet9.setChecked(true);
                        toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet10.setChecked(true);
                        toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet11.setChecked(true);
                        toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModRetrigGet12.setChecked(true);
                        toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorD);
                    }
                } else {
                    if (connectionCheck == 1) {

                        toggleButtonHarmVolModRetrigGet.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet1.setChecked(false);
                        toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet2.setChecked(false);
                        toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet3.setChecked(false);
                        toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet4.setChecked(false);
                        toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet5.setChecked(false);
                        toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet6.setChecked(false);
                        toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet7.setChecked(false);
                        toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet8.setChecked(false);
                        toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet9.setChecked(false);
                        toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet10.setChecked(false);
                        toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet11.setChecked(false);
                        toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModRetrigGet12.setChecked(false);
                        toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorC);

                    }
                }
            }
        }); // end listener

        ////////////////////// Harmonic Volume Mod Retrig End

        ////////////////////// Harmonic Sync All Start

        final ToggleButton toggleButtonHarmSyncAllGet = findViewById(R.id.toggleButtonHarmSyncAll);
        toggleButtonHarmSyncAllGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        toggleButtonHarmSyncAllGet.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet1.setChecked(true);
                        toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet2.setChecked(true);
                        toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet3.setChecked(true);
                        toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet4.setChecked(true);
                        toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet5.setChecked(true);
                        toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet6.setChecked(true);
                        toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet7.setChecked(true);
                        toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet8.setChecked(true);
                        toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet9.setChecked(true);
                        toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet10.setChecked(true);
                        toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet11.setChecked(true);
                        toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorD);

                        toggleButtonHarmVolModSyncGet12.setChecked(true);
                        toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorD);

                    }
                } else {
                    if (connectionCheck == 1) {
                        toggleButtonHarmSyncAllGet.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet1.setChecked(false);
                        toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet2.setChecked(false);
                        toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet3.setChecked(false);
                        toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet4.setChecked(false);
                        toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet5.setChecked(false);
                        toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet6.setChecked(false);
                        toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet7.setChecked(false);
                        toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet8.setChecked(false);
                        toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet9.setChecked(false);
                        toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet10.setChecked(false);
                        toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet11.setChecked(false);
                        toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorC);

                        toggleButtonHarmVolModSyncGet12.setChecked(false);
                        toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorC);
                    }
                }
            }
        }); // end listener

        ////////////////////// Harmonic Sync All End

        ///////////////////////////////////////////////////// Harmonics Random Start

        final Button buttonHarmonicsRandomGet = findViewById(R.id.buttonHarmonicsRandom);
        buttonHarmonicsRandomGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                        buttonHarmonicsRandomGet.setBackgroundColor(myColorC);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonHarmonicsRandomGet.setBackgroundColor(myColorD);

                        sliderHarmVolGet1.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet2.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet3.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet4.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet5.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet6.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet7.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet8.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet9.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet10.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet11.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolGet12.setValue(Math.round(random.nextFloat() * 127),true);

                        sliderHarmVolModGet1.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet2.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet3.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet4.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet5.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet6.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet7.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet8.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet9.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet10.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet11.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolModGet12.setValue(Math.round(random.nextFloat() * 127),true);

                        sliderHarmVolRateGet1.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet2.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet3.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet4.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet5.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet6.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet7.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet8.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet9.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet10.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet11.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderHarmVolRateGet12.setValue(Math.round(random.nextFloat() * 127),true);

                        spinnerHarmVolModDivGet1.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet2.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet3.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet4.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet5.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet6.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet7.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet8.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet9.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet10.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet11.setSelection(Math.round(random.nextFloat() * 21), true);
                        spinnerHarmVolModDivGet12.setSelection(Math.round(random.nextFloat() * 21), true);

                        spinnerHarmVolModRateRangeGet1.setSelection(Math.round(random.nextFloat() * 4), true);
                    }
                }
                return false;
            }
        });
        ///////////////////////////////////////////////////// Harmonics Random End

        ///////////////////////////////////////////////////// Harmonics Innit Start

        final Button buttonHarmonicsInnitGet = findViewById(R.id.buttonHarmonicsInnit);
        buttonHarmonicsInnitGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonHarmonicsInnitGet.setBackgroundColor(myColorC);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonHarmonicsInnitGet.setBackgroundColor(myColorD);

                        sliderHarmVolGet1.setValue(0, true);
                        sliderHarmVolGet2.setValue(0,true);
                        sliderHarmVolGet3.setValue(0,true);
                        sliderHarmVolGet4.setValue(0,true);
                        sliderHarmVolGet5.setValue(0,true);
                        sliderHarmVolGet6.setValue(0,true);
                        sliderHarmVolGet7.setValue(0,true);
                        sliderHarmVolGet8.setValue(0,true);
                        sliderHarmVolGet9.setValue(0,true);
                        sliderHarmVolGet10.setValue(0,true);
                        sliderHarmVolGet11.setValue(0,true);
                        sliderHarmVolGet12.setValue(0,true);

                        sliderHarmVolModGet1.setValue(0,true);
                        sliderHarmVolModGet2.setValue(0,true);
                        sliderHarmVolModGet3.setValue(0,true);
                        sliderHarmVolModGet4.setValue(0,true);
                        sliderHarmVolModGet5.setValue(0,true);
                        sliderHarmVolModGet6.setValue(0,true);
                        sliderHarmVolModGet7.setValue(0,true);
                        sliderHarmVolModGet8.setValue(0,true);
                        sliderHarmVolModGet9.setValue(0,true);
                        sliderHarmVolModGet10.setValue(0,true);
                        sliderHarmVolModGet11.setValue(0,true);
                        sliderHarmVolModGet12.setValue(0,true);

                        sliderHarmVolRateGet1.setValue(0,true);
                        sliderHarmVolRateGet2.setValue(0,true);
                        sliderHarmVolRateGet3.setValue(0,true);
                        sliderHarmVolRateGet4.setValue(0,true);
                        sliderHarmVolRateGet5.setValue(0,true);
                        sliderHarmVolRateGet6.setValue(0,true);
                        sliderHarmVolRateGet7.setValue(0,true);
                        sliderHarmVolRateGet8.setValue(0,true);
                        sliderHarmVolRateGet9.setValue(0,true);
                        sliderHarmVolRateGet10.setValue(0,true);
                        sliderHarmVolRateGet11.setValue(0,true);
                        sliderHarmVolRateGet12.setValue(0,true);

                        spinnerHarmVolModDivGet1.setSelection(0,true);
                        spinnerHarmVolModDivGet2.setSelection(0,true);
                        spinnerHarmVolModDivGet3.setSelection(0,true);
                        spinnerHarmVolModDivGet4.setSelection(0,true);
                        spinnerHarmVolModDivGet5.setSelection(0,true);
                        spinnerHarmVolModDivGet6.setSelection(0,true);
                        spinnerHarmVolModDivGet7.setSelection(0,true);
                        spinnerHarmVolModDivGet8.setSelection(0,true);
                        spinnerHarmVolModDivGet9.setSelection(0,true);
                        spinnerHarmVolModDivGet10.setSelection(0,true);
                        spinnerHarmVolModDivGet11.setSelection(0,true);
                        spinnerHarmVolModDivGet12.setSelection(0,true);

                        spinnerHarmVolModRateRangeGet1.setSelection(0,true);

                        if (toggleButtonHarmSyncAllGet.isChecked()) {
                            toggleButtonHarmSyncAllGet.setChecked(false);
                            toggleButtonHarmSyncAllGet.setBackgroundColor(myColorC);
                        }

                        if (!toggleButtonHarmSyncAllGet.isChecked()) {

                            toggleButtonHarmVolModSyncGet1.setChecked(false);
                            toggleButtonHarmVolModSyncGet1.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet2.setChecked(false);
                            toggleButtonHarmVolModSyncGet2.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet3.setChecked(false);
                            toggleButtonHarmVolModSyncGet3.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet4.setChecked(false);
                            toggleButtonHarmVolModSyncGet4.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet5.setChecked(false);
                            toggleButtonHarmVolModSyncGet5.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet6.setChecked(false);
                            toggleButtonHarmVolModSyncGet6.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet7.setChecked(false);
                            toggleButtonHarmVolModSyncGet7.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet8.setChecked(false);
                            toggleButtonHarmVolModSyncGet8.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet9.setChecked(false);
                            toggleButtonHarmVolModSyncGet9.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet10.setChecked(false);
                            toggleButtonHarmVolModSyncGet10.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet11.setChecked(false);
                            toggleButtonHarmVolModSyncGet11.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModSyncGet12.setChecked(false);
                            toggleButtonHarmVolModSyncGet12.setBackgroundColor(myColorC);
                        }

                        if (toggleButtonHarmVolModRetrigGet.isChecked()) {
                            toggleButtonHarmVolModRetrigGet.setChecked(false);
                            toggleButtonHarmVolModRetrigGet.setBackgroundColor(myColorC);
                        }

                        if (!toggleButtonHarmVolModRetrigGet.isChecked()) {
                            toggleButtonHarmVolModRetrigGet1.setChecked(false);
                            toggleButtonHarmVolModRetrigGet1.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet2.setChecked(false);
                            toggleButtonHarmVolModRetrigGet2.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet3.setChecked(false);
                            toggleButtonHarmVolModRetrigGet3.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet4.setChecked(false);
                            toggleButtonHarmVolModRetrigGet4.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet5.setChecked(false);
                            toggleButtonHarmVolModRetrigGet5.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet6.setChecked(false);
                            toggleButtonHarmVolModRetrigGet6.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet7.setChecked(false);
                            toggleButtonHarmVolModRetrigGet7.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet8.setChecked(false);
                            toggleButtonHarmVolModRetrigGet8.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet9.setChecked(false);
                            toggleButtonHarmVolModRetrigGet9.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet10.setChecked(false);
                            toggleButtonHarmVolModRetrigGet10.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet11.setChecked(false);
                            toggleButtonHarmVolModRetrigGet11.setBackgroundColor(myColorC);

                            toggleButtonHarmVolModRetrigGet12.setChecked(false);
                            toggleButtonHarmVolModRetrigGet12.setBackgroundColor(myColorC);
                        }

                    }
                }
                return false;
            }
        });
        ///////////////////////////////////////////////////// Harmonics Innit End




    } // end create

    public class CustomOnItemSelectedListenerHarmVolModDiv1 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/50";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv1 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv2 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/51";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv2 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv3 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/52";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv3 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv4 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/53";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv4 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv5 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/54";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv5 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv6 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/55";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv6 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv7 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/56";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv7 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv8 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/57";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv8 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv9 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/58";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv9 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv10 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/59";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv10 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv11 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/60";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv11 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModDiv12 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/61";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModDiv12 = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerHarmVolModRateRange implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/37";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                harmVolModRateRange = position;
                myOscMessage.add(Math.round((position / 5.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

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
        editor.putInt("lpFilterInv", lpFilterInv);
        editor.putInt("lpFilterPower", lpFilterPower);

        // Decimator
        editor.putInt("decimatorReduce", decimatorReduce);
        editor.putInt("decimatorMod", decimatorMod);
        editor.putInt("decimatorRate", decimatorRate);
        editor.putInt("decimatorSync", decimatorSync);
        editor.putInt("decimatorDiv", decimatorDiv);
        editor.putInt("decimatorRetrig", decimatorRetrig);
        editor.putInt("decimator8bit", decimator8bit);
        editor.putInt("decimatorPower", decimatorPower);

        // Delay
        editor.putInt("delayTime", delayTime);
        editor.putInt("delayTimeR", delayTimeR);
        editor.putInt("delayFeed", delayFeed);
        editor.putInt("delaySync", delaySync);
        editor.putInt("delayDiv", delayDiv);
        editor.putInt("delayDivR", delayDivR);
        editor.putInt("delayWet", delayWet);
        editor.putInt("delayCross", delayCross);
        editor.putInt("delayPower", delayPower);
        editor.putInt("delayChorusSwitch", delayChorusSwitch);

        // Chorus
        editor.putInt("chorusRate", chorusRate);
        editor.putInt("chorusDepth", chorusDepth);
        editor.putInt("chorusDelay", chorusDelay);
        editor.putInt("chorusFeed", chorusFeed);
        editor.putInt("chorusFeedR", chorusFeedR);
        editor.putInt("chorusCross", chorusCross);
        editor.putInt("chorusWet", chorusWet);
        editor.putInt("chorusPower", chorusPower);

        // Reverb
        editor.putInt("reverbSize", reverbSize);
        editor.putInt("reverbDelay", reverbDelay);
        editor.putInt("reverbHp", reverbHp);
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
        editor.putString("sourceFreq", sourceFreq);

        // fm freq
        editor.putInt("fmNote", fmNote);
        editor.putInt("fmSelect", fmSelect);
        editor.putInt("fmMidiOct", fmMidiOct);
        editor.putString("fmFreq", fmFreq);

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

        editor.putInt("fmRateRange", fmRateRange);

        /////////////////////////////////////////// Freq Page - Fifth Activity Variables End

        /////////////////////////////////////////// Live Page - Sixth Activity Variables Start

        editor.putInt("xyItemX1", xyItemX1);
        editor.putInt("xyItemY1", xyItemY1);
        editor.putInt("xyItemX2", xyItemX2);
        editor.putInt("xyItemY2", xyItemY2);
        editor.putInt("xyTrig1", xyTrig1);
        editor.putInt("xyTrig2", xyTrig2);

        /////////////////////////////////////////// Live Page - Sixth Activity Variables End

        /////////////////////////////////////////// Play Page - Seventh Activity Variables Start

        editor.putInt("playOctave", playOctave);
        editor.putInt("glideOn", glideOn);
        editor.putInt("glideTime", glideTime);
        editor.putInt("bendRange", bendRange);

        /////////////////////////////////////////// Play Page - Seventh Activity Variables End

        editor.apply();

    } //end pause

    @Override
    protected void onDestroy() {
        super.onDestroy(); // Always call the superclass method first

        if (connectionCheck == 1) {
            connectionCheck = 0;
            oscP5.stop();
        }
    } // end destroy

} // end activity
