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

import p.purechords.aeolianmeditationadvancedcontroller.databinding.ActivityFourthBinding;

import static p.purechords.aeolianmeditationadvancedcontroller.MainActivity.*;

public class FourthActivity extends AppCompatActivity {



    Random random = new Random();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout with binding
        ActivityFourthBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_fourth);

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


        binding.setObsIntDcKill(obsIntDcKill);

        binding.setObsIntFilterPower(obsIntFilterPower);
        binding.setObsIntFilterCut(obsIntFilterCut);
        binding.setObsIntFilterRes(obsIntFilterRes);
        binding.setObsIntFilterEnv(obsIntFilterEnv);
        binding.setObsIntFilterMod(obsIntFilterMod);
        binding.setObsIntFilterRate(obsIntFilterRate);
        binding.setObsIntFilterSync(obsIntFilterSync);
        binding.setObsIntFilterDiv(obsIntFilterDiv);
        binding.setObsIntFilterRetrig(obsIntFilterRetrig);
        binding.setObsIntFilterInv(obsIntFilterInv);

        binding.setObsIntDecimatePower(obsIntDecimatePower);
        binding.setObsIntDecimateReduce(obsIntDecimateReduce);
        binding.setObsIntDecimateMod(obsIntDecimateMod);
        binding.setObsIntDecimateRate(obsIntDecimateRate);
        binding.setObsIntDecimateSync(obsIntDecimateSync);
        binding.setObsIntDecimateDiv(obsIntDecimateDiv);
        binding.setObsIntDecimateRetrig(obsIntDecimateRetrig);
        binding.setObsIntDecimate8bit(obsIntDecimate8bit);

        binding.setObsIntDelayPower(obsIntDelayPower);
        binding.setObsIntDelayTime(obsIntDelayTime);
        binding.setObsIntDelayTimeR(obsIntDelayTimeR);
        binding.setObsIntDelaySync(obsIntDelaySync);
        binding.setObsIntDelayDiv(obsIntDelayDiv);
        binding.setObsIntDelayDivR(obsIntDelayDivR);
        binding.setObsIntDelayFeed(obsIntDelayFeed);
        binding.setObsIntDelayCross(obsIntDelayCross);
        binding.setObsIntDelayWet(obsIntDelayWet);

        binding.setObsIntChorusPower(obsIntChorusPower);
        binding.setObsIntChorusRate(obsIntChorusRate);
        binding.setObsIntChorusDepth(obsIntChorusDepth);
        binding.setObsIntChorusDelay(obsIntChorusDelay);
        binding.setObsIntChorusFeed(obsIntChorusFeed);
        binding.setObsIntChorusFeedR(obsIntChorusFeedR);
        binding.setObsIntChorusCross(obsIntChorusCross);
        binding.setObsIntChorusWet(obsIntChorusWet);

        binding.setObsIntReverbPower(obsIntReverbPower);
        binding.setObsIntReverbSize(obsIntReverbSize);
        binding.setObsIntReverbDelay(obsIntReverbDelay);
        binding.setObsIntReverbHp(obsIntReverbHp);
        binding.setObsIntReverbDamp(obsIntReverbDamp);
        binding.setObsIntReverbWidth(obsIntReverbWidth);
        binding.setObsIntReverbWet(obsIntReverbWet);

        ///////////////////////////////////////////////////// Navigator Buttons Start

        final Button buttonToMainPageGet = findViewById(R.id.buttonToMainPage);
        buttonToMainPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToMainPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(FourthActivity.this, MainActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToMainPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonHarmonicsPageGet = findViewById(R.id.buttonToHarmonicsPage);
        buttonHarmonicsPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonHarmonicsPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(FourthActivity.this, SecondActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonHarmonicsPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToSourcePageGet = findViewById(R.id.buttonToSourcePage);
        buttonToSourcePageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToSourcePageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(FourthActivity.this, FifthActivity.class);
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

                    Intent intentBundle = new Intent(FourthActivity.this, ThirdActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToNoisePageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonToEffectsPageGet = findViewById(R.id.buttonToEffectsPage);
        buttonToEffectsPageGet.setBackgroundColor(myColorD);

        final Button buttonToPerformPageGet = findViewById(R.id.buttonToPerformPage);
        buttonToPerformPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToPerformPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(FourthActivity.this, SixthActivity.class);
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

                    Intent intentBundle = new Intent(FourthActivity.this, SeventhActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonPlayPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        ///////////////////////////////////////////////////// Navigator Buttons End

        ///////////////////////////////////////////////////// Filter Listeners Start

        //Cut
        final Slider sliderLpFilterCutGet = findViewById(R.id.sliderLpFilterCut);
        sliderLpFilterCutGet.setValue(lpFilterCut, true);
        sliderLpFilterCutGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/151";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderLpFilterCutGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    lpFilterCut = sliderLpFilterCutGet.getValue();
                }
            }
        }); // end listener

        //Res
        final Slider sliderLpFilterResGet = findViewById(R.id.sliderLpFilterRes);
        sliderLpFilterResGet.setValue(lpFilterRes, true);
        sliderLpFilterResGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/152";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderLpFilterResGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    lpFilterRes = sliderLpFilterResGet.getValue();
                }
            }
        }); // end listener

        //Res
        final Slider sliderLpFilterEnvGet = findViewById(R.id.sliderLpFilterEnv);
        sliderLpFilterEnvGet.setValue(lpFilterEnv, true);
        sliderLpFilterEnvGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/198";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderLpFilterEnvGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    lpFilterEnv = sliderLpFilterEnvGet.getValue();
                }
            }
        }); // end listener


        //Mod
        final Slider sliderLpFilterModGet = findViewById(R.id.sliderLpFilterMod);
        sliderLpFilterModGet.setValue(lpFilterMod, true);
        sliderLpFilterModGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/153";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderLpFilterModGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    lpFilterMod = sliderLpFilterModGet.getValue();
                }
            }
        }); // end listener

        //Rate
        final Slider sliderLpFilterRateGet = findViewById(R.id.sliderLpFilterRate);
        sliderLpFilterRateGet.setValue(lpFilterRate, true);
        sliderLpFilterRateGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/154";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderLpFilterRateGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    lpFilterRate = sliderLpFilterRateGet.getValue();
                }
            }
        }); // end listener

        //Sync
        final ToggleButton toggleButtonLpFilterSyncGet = findViewById(R.id.toggleButtonLpFilterSync);
        if (lpFilterSync == 127) {
            toggleButtonLpFilterSyncGet.setChecked(true);
            toggleButtonLpFilterSyncGet.setBackgroundColor(myColorD);
        }
        toggleButtonLpFilterSyncGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/155";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterSyncGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterSync = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/155";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterSyncGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterSync = 0;
                    }
                }
            }
        }); // end listener

        //Div
        final Spinner spinnerLpFilterDivGet = (findViewById(R.id.spinnerLpFilterDiv));
        spinnerLpFilterDivGet.setOnItemSelectedListener(new FourthActivity.CustomOnItemSelectedListenerLpFilterDiv());
        ArrayAdapter adapterLpFilterDiv = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerLpFilterDivGet.setAdapter(adapterLpFilterDiv);
        spinnerLpFilterDivGet.setSelection(lpFilterDiv);

        //Retrig
        final ToggleButton toggleButtonLpFilterRetrigGet = findViewById(R.id.toggleButtonLpFilterRetrig);
        if (lpFilterRetrig == 127) {
            toggleButtonLpFilterRetrigGet.setChecked(true);
            toggleButtonLpFilterRetrigGet.setBackgroundColor(myColorD);
        }
        toggleButtonLpFilterRetrigGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/157";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterRetrigGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterRetrig = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/157";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterRetrigGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterRetrig = 0;
                    }
                }
            }
        }); // end listener


        //Inv R
        final ToggleButton toggleButtonLpFilterInvGet = findViewById(R.id.toggleButtonLpFilterInvR);
        if (lpFilterInv == 127) {
            toggleButtonLpFilterInvGet.setChecked(true);
            toggleButtonLpFilterInvGet.setBackgroundColor(myColorD);
        }
        toggleButtonLpFilterInvGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/199";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterInvGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterInv = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/199";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterInvGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterInv = 0;
                    }
                }
            }
        }); // end listener


        //Power
        final ToggleButton toggleButtonLpFilterPowerGet = findViewById(R.id.toggleButtonLpFilterPower);
        if (lpFilterPower == 127) {
            toggleButtonLpFilterPowerGet.setChecked(true);
            toggleButtonLpFilterPowerGet.setBackgroundColor(myColorD);
        }
        toggleButtonLpFilterPowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/150";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterPowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/150";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonLpFilterPowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Filter Listeners End

        ///////////////////////////////////////////////////// Decimator Listeners Start

        // Reduce
        final Slider sliderDecimatorReduceGet = findViewById(R.id.sliderDecimatorReduce);
        sliderDecimatorReduceGet.setValue(decimatorReduce, true);
        sliderDecimatorReduceGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/159";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDecimatorReduceGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    decimatorReduce = sliderDecimatorReduceGet.getValue();
                }
            }
        }); // end listener

        // Mod
        final Slider sliderDecimatorModGet = findViewById(R.id.sliderDecimatorMod);
        sliderDecimatorModGet.setValue(decimatorMod, true);
        sliderDecimatorModGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/160";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDecimatorModGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    decimatorMod = sliderDecimatorModGet.getValue();
                }
            }
        }); // end listener

        // Rate
        final Slider sliderDecimatorRateGet = findViewById(R.id.sliderDecimatorRate);
        sliderDecimatorRateGet.setValue(decimatorRate, true);
        sliderDecimatorRateGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/161";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDecimatorRateGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    decimatorRate = sliderDecimatorRateGet.getValue();
                }
            }
        }); // end listener

        // Sync
        final ToggleButton toggleButtonDecimatorSyncGet = findViewById(R.id.toggleButtonDecimatorSync);
        if (decimatorSync == 127) {
            toggleButtonDecimatorSyncGet.setChecked(true);
            toggleButtonDecimatorSyncGet.setBackgroundColor(myColorD);
        }
        toggleButtonDecimatorSyncGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/162";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorSyncGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorSync = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/162";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorSyncGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorSync = 0;
                    }
                }
            }
        }); // end listener

        // Div
        final Spinner spinnerDecimatorDivGet = (findViewById(R.id.spinnerDecimatorDiv));
        spinnerDecimatorDivGet.setOnItemSelectedListener(new FourthActivity.CustomOnItemSelectedListenerDecimatorDiv());
        ArrayAdapter adapterDecimatorDiv = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerDecimatorDivGet.setAdapter(adapterDecimatorDiv);
        spinnerDecimatorDivGet.setSelection(decimatorDiv);

        // Retrig
        final ToggleButton toggleButtonDecimatorRetrigGet = findViewById(R.id.toggleButtonDecimatorRetrig);
        if (decimatorRetrig == 127) {
            toggleButtonDecimatorRetrigGet.setChecked(true);
            toggleButtonDecimatorRetrigGet.setBackgroundColor(myColorD);
        }
        toggleButtonDecimatorRetrigGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/164";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorRetrigGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorRetrig = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/164";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorRetrigGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorRetrig = 0;
                    }
                }
            }
        }); // end listener

        // 8bit
        final ToggleButton toggleButtonDecimator8bitGet = findViewById(R.id.toggleButtonDecimator8bit);
        if (decimator8bit == 127) {
            toggleButtonDecimator8bitGet.setChecked(true);
            toggleButtonDecimator8bitGet.setBackgroundColor(myColorD);
        }
        toggleButtonDecimator8bitGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/200";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimator8bitGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimator8bit = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/200";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimator8bitGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimator8bit = 0;
                    }
                }
            }
        }); // end listener

        // Power
        final ToggleButton toggleButtonDecimatorPowerGet = findViewById(R.id.toggleButtonDecimatorPower);
        if (decimatorPower == 127) {
            toggleButtonDecimatorPowerGet.setChecked(true);
            toggleButtonDecimatorPowerGet.setBackgroundColor(myColorD);
        }
        toggleButtonDecimatorPowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/158";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorPowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/158";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDecimatorPowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Decimator Listeners End

        ///////////////////////////////////////////////////// Delay Listeners Start

        // Time L
        final Slider sliderDelayTimeGet = findViewById(R.id.sliderDelayTime);
        sliderDelayTimeGet.setValue(delayTime, true);
        sliderDelayTimeGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/166";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDelayTimeGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    delayTime = sliderDelayTimeGet.getValue();
                }
            }
        }); // end listener

        // Time R
        final Slider sliderDelayTimeGetR = findViewById(R.id.sliderDelayTimeR);
        sliderDelayTimeGetR.setValue(delayTimeR, true);
        sliderDelayTimeGetR.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/196";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDelayTimeGetR.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    delayTimeR = sliderDelayTimeGetR.getValue();
                }
            }
        }); // end listener

        // Sync


        final ToggleButton toggleButtonDelaySyncGet = findViewById(R.id.toggleButtonDelaySync);
        if (delaySync == 127) {
            toggleButtonDelaySyncGet.setChecked(true);
            toggleButtonDelaySyncGet.setBackgroundColor(myColorD);
        }
        toggleButtonDelaySyncGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/167";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelaySyncGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delaySync = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/167";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelaySyncGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delaySync = 0;
                    }
                }
            }
        }); // end listener

        // Div L
        final Spinner spinnerDelayDivGet = (findViewById(R.id.spinnerDelayDiv));
        spinnerDelayDivGet.setOnItemSelectedListener(new FourthActivity.CustomOnItemSelectedListenerDelayDiv());
        ArrayAdapter adapterDelayDiv = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerDelayDivGet.setAdapter(adapterDelayDiv);
        spinnerDelayDivGet.setSelection(delayDiv);

        // Div R
        final Spinner spinnerDelayDivGetR = (findViewById(R.id.spinnerDelayDivR));
        spinnerDelayDivGetR.setOnItemSelectedListener(new FourthActivity.CustomOnItemSelectedListenerDelayDivR());
        ArrayAdapter adapterDelayDivR = ArrayAdapter.createFromResource(this,
                R.array.spinnerDiv, R.layout.spinner_item);
        spinnerDelayDivGetR.setAdapter(adapterDelayDivR);
        spinnerDelayDivGetR.setSelection(delayDivR);

        // Feed
        final Slider sliderDelayFeedGet = findViewById(R.id.sliderDelayFeed);
        sliderDelayFeedGet.setValue(delayFeed, true);
        sliderDelayFeedGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/169";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDelayFeedGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    delayFeed = sliderDelayFeedGet.getValue();
                }
            }
        }); // end listener

        // Cross
        final ToggleButton toggleButtonDelayCrossGet = findViewById(R.id.toggleButtonDelayCross);
        if (delayCross == 127) {
            toggleButtonDelayCrossGet.setChecked(true);
            toggleButtonDelayCrossGet.setBackgroundColor(myColorD);
        }
        toggleButtonDelayCrossGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/201";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelayCrossGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayCross = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/201";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelayCrossGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayCross = 0;
                    }
                }
            }
        }); // end listener


        // Wet
        final Slider sliderDelayWetGet = findViewById(R.id.sliderDelayWet);
        sliderDelayWetGet.setValue(delayWet, true);
        sliderDelayWetGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/170";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderDelayWetGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    delayWet = sliderDelayWetGet.getValue();
                }
            }
        }); // end listener

        // Power
        final ToggleButton toggleButtonDelayPowerGet = findViewById(R.id.toggleButtonDelayPower);
        if (delayPower == 127) {
            toggleButtonDelayPowerGet.setChecked(true);
            toggleButtonDelayPowerGet.setBackgroundColor(myColorD);
        }
        toggleButtonDelayPowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/165";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelayPowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/165";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDelayPowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Delay Listeners End

        ///////////////////////////////////////////////////// Chorus Listeners Start

        // Rate
        final Slider sliderChorusRateGet = findViewById(R.id.sliderChorusRate);
        sliderChorusRateGet.setValue(chorusRate, true);
        sliderChorusRateGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/172";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusRateGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusRate = sliderChorusRateGet.getValue();
                }
            }
        }); // end listener

        // Depth
        final Slider sliderChorusDepthGet = findViewById(R.id.sliderChorusDepth);
        sliderChorusDepthGet.setValue(chorusDepth, true);
        sliderChorusDepthGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/173";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusDepthGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusDepth = sliderChorusDepthGet.getValue();
                }
            }
        }); // end listener

        // Delay
        final Slider sliderChorusDelayGet = findViewById(R.id.sliderChorusDelay);
        sliderChorusDelayGet.setValue(chorusDelay, true);
        sliderChorusDelayGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/174";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusDelayGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusDelay = sliderChorusDelayGet.getValue();
                }
            }
        }); // end listener

        // Feed
        final Slider sliderChorusFeedGet = findViewById(R.id.sliderChorusFeed);
        sliderChorusFeedGet.setValue(chorusFeed, true);
        sliderChorusFeedGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/175";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusFeedGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusFeed = sliderChorusFeedGet.getValue();
                }
            }
        }); // end listener

        // Feed R
        final Slider sliderChorusFeedGetR = findViewById(R.id.sliderChorusFeedR);
        sliderChorusFeedGetR.setValue(chorusFeedR, true);
        sliderChorusFeedGetR.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/202";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusFeedGetR.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusFeedR = sliderChorusFeedGetR.getValue();
                }
            }
        }); // end listener

        // Cross
        final ToggleButton toggleButtonChorusCrossGet = findViewById(R.id.toggleButtonChorusCross);
        if (chorusCross == 127) {
            toggleButtonChorusCrossGet.setChecked(true);
            toggleButtonChorusCrossGet.setBackgroundColor(myColorD);
        }
        toggleButtonChorusCrossGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/203";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonChorusCrossGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusCross = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/203";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonChorusCrossGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusCross = 0;
                    }
                }
            }
        }); // end listener


        // Wet
        final Slider sliderChorusWetGet = findViewById(R.id.sliderChorusWet);
        sliderChorusWetGet.setValue(chorusWet, true);
        sliderChorusWetGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/176";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderChorusWetGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    chorusWet = sliderChorusWetGet.getValue();
                }
            }
        }); // end listener

        // Power
        final ToggleButton toggleButtonChorusPowerGet = findViewById(R.id.toggleButtonChorusPower);
        if (chorusPower == 127) {
            toggleButtonChorusPowerGet.setChecked(true);
            toggleButtonChorusPowerGet.setBackgroundColor(myColorD);
        }
        toggleButtonChorusPowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/171";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonChorusPowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/171";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonChorusPowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Chorus Listeners End

        ///////////////////////////////////////////////////// Reverb Listeners Start

        //Size
        final Spinner spinnerReverbSizeGet = (findViewById(R.id.spinnerReverbSize));
        spinnerReverbSizeGet.setOnItemSelectedListener(new FourthActivity.CustomOnItemSelectedListenerReverbSize());
        ArrayAdapter adapterReverbSize = ArrayAdapter.createFromResource(this,
                R.array.spinnerReverbSize, R.layout.spinner_item);
        spinnerReverbSizeGet.setAdapter(adapterReverbSize);
        spinnerReverbSizeGet.setSelection(reverbSize);

        // Delay
        final Slider sliderReverbDelayGet = findViewById(R.id.sliderReverbDelay);
        sliderReverbDelayGet.setValue(reverbDelay, true);
        sliderReverbDelayGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/204";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderReverbDelayGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    reverbDelay = sliderReverbDelayGet.getValue();
                }
            }
        }); // end listener

        // Hp
        final Slider sliderReverbHpGet = findViewById(R.id.sliderReverbHp);
        sliderReverbHpGet.setValue(reverbHp, true);
        sliderReverbHpGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/205";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderReverbHpGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    reverbHp = sliderReverbHpGet.getValue();
                }
            }
        }); // end listener

        // Damp
        final Slider sliderReverbDampGet = findViewById(R.id.sliderReverbDamp);
        sliderReverbDampGet.setValue(reverbDamp, true);
        sliderReverbDampGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/179";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderReverbDampGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    reverbDamp = sliderReverbDampGet.getValue();
                }
            }
        }); // end listener

        // Width
        final Slider sliderReverbWidthGet = findViewById(R.id.sliderReverbWidth);
        sliderReverbWidthGet.setValue(reverbWidth, true);
        sliderReverbWidthGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/180";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderReverbWidthGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    reverbWidth = sliderReverbWidthGet.getValue();
                }
            }
        }); // end listener

        // Wet
        final Slider sliderReverbWetGet = findViewById(R.id.sliderReverbWet);
        sliderReverbWetGet.setValue(reverbWet, true);
        sliderReverbWetGet.setOnPositionChangeListener(new Slider.OnPositionChangeListener() {
            @Override
            public void onPositionChanged(Slider view, boolean fromUser, float oldPos, float newPos, int oldValue, int newValue) {
                if (connectionCheck == 1) {
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/181";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(sliderReverbWetGet.getValue());
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    reverbWet = sliderReverbWetGet.getValue();
                }
            }
        }); // end listener

        // Power
        final ToggleButton toggleButtonReverbPowerGet = findViewById(R.id.toggleButtonReverbPower);
        if (reverbPower == 127) {
            toggleButtonReverbPowerGet.setChecked(true);
            toggleButtonReverbPowerGet.setBackgroundColor(myColorD);
        }
        toggleButtonReverbPowerGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/177";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonReverbPowerGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        reverbPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/177";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonReverbPowerGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        reverbPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Reverb Listeners End

        ///////////////////////////////////////////////////// DC Kill Start

        final ToggleButton toggleButtonDcKillGet = findViewById(R.id.toggleButtonDcKill);
        if (dcKill == 127) {
            toggleButtonDcKillGet.setChecked(true);
            toggleButtonDcKillGet.setBackgroundColor(myColorD);
        }
        toggleButtonDcKillGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/182";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDcKillGet.setBackgroundColor(myColorD);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        dcKill = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/182";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        toggleButtonDcKillGet.setBackgroundColor(myColorC);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        dcKill = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// DC Kill End

        ///////////////////////////////////////////////////// Effects Random Start

        final Button buttonEffectsRandomGet = findViewById(R.id.buttonEffectsRandom);
        buttonEffectsRandomGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonEffectsRandomGet.setBackgroundColor(myColorC);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonEffectsRandomGet.setBackgroundColor(myColorD);

                        sliderLpFilterCutGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderLpFilterResGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderLpFilterModGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderLpFilterRateGet.setValue(Math.round(random.nextFloat() * 127),true);
                        spinnerLpFilterDivGet.setSelection((Math.round(random.nextFloat() * 21)),true);

                        if (random.nextFloat() > 0.5f){
                            toggleButtonLpFilterInvGet.setChecked(true);
                        }else{toggleButtonLpFilterInvGet.setChecked(false);
                        }

                        sliderDecimatorReduceGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderDecimatorModGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderDecimatorRateGet.setValue(Math.round(random.nextFloat() * 127),true);
                        spinnerDecimatorDivGet.setSelection((Math.round(random.nextFloat() * 21)),true);

                        if (random.nextFloat() > 0.5f){
                            toggleButtonDecimator8bitGet.setChecked(true);
                        }else{toggleButtonDecimator8bitGet.setChecked(false);
                        }

                        sliderDelayTimeGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderDelayFeedGet.setValue(Math.round(random.nextFloat() * 127),true);

                        if (random.nextFloat() > 0.5f){
                            toggleButtonDelayCrossGet.setChecked(true);
                        }else{toggleButtonDelayCrossGet.setChecked(false);
                        }

                        sliderDelayWetGet.setValue(Math.round(random.nextFloat() * 127),true);
                        spinnerDelayDivGet.setSelection((Math.round(random.nextFloat() * 21)),true);

                        sliderChorusRateGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderChorusDepthGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderChorusDelayGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderChorusFeedGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderChorusFeedGetR.setValue(Math.round(random.nextFloat() * 127),true);

                        if (random.nextFloat() > 0.5f){
                            toggleButtonChorusCrossGet.setChecked(true);
                        }else{toggleButtonChorusCrossGet.setChecked(false);
                        }

                        sliderChorusWetGet.setValue(Math.round(random.nextFloat() * 127),true);

                        spinnerReverbSizeGet.setSelection(Math.round(random.nextFloat() * 4),true);
                        sliderReverbDelayGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderReverbHpGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderReverbDampGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderReverbWidthGet.setValue(Math.round(random.nextFloat() * 127),true);
                        sliderReverbWetGet.setValue(Math.round(random.nextFloat() * 127),true);

                    }
                }
                return false;
            }
        });

        ///////////////////////////////////////////////////// Effects Random End

        ///////////////////////////////////////////////////// Power All Start
        final ToggleButton togglebButtonEffectsPowerAllGet = findViewById(R.id.toggleButtonEffectsPowerAll);
        togglebButtonEffectsPowerAllGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        togglebButtonEffectsPowerAllGet.setBackgroundColor(myColorD);

                        toggleButtonLpFilterPowerGet.setChecked(true);
                        toggleButtonLpFilterPowerGet.setBackgroundColor(myColorD);

                        toggleButtonDecimatorPowerGet.setChecked(true);
                        toggleButtonDecimatorPowerGet.setBackgroundColor(myColorD);

                        toggleButtonDelayPowerGet.setChecked(true);
                        toggleButtonDelayPowerGet.setBackgroundColor(myColorD);

                        toggleButtonChorusPowerGet.setChecked(true);
                        toggleButtonChorusPowerGet.setBackgroundColor(myColorD);

                        toggleButtonReverbPowerGet.setChecked(true);
                        toggleButtonReverbPowerGet.setBackgroundColor(myColorD);
                    }
                } else {
                    if (connectionCheck == 1) {
                        togglebButtonEffectsPowerAllGet.setBackgroundColor(myColorC);

                        toggleButtonLpFilterPowerGet.setChecked(false);
                        toggleButtonLpFilterPowerGet.setBackgroundColor(myColorC);

                        toggleButtonDecimatorPowerGet.setChecked(false);
                        toggleButtonDecimatorPowerGet.setBackgroundColor(myColorC);

                        toggleButtonDelayPowerGet.setChecked(false);
                        toggleButtonDelayPowerGet.setBackgroundColor(myColorC);

                        toggleButtonChorusPowerGet.setChecked(false);
                        toggleButtonChorusPowerGet.setBackgroundColor(myColorC);

                        toggleButtonReverbPowerGet.setChecked(false);
                        toggleButtonReverbPowerGet.setBackgroundColor(myColorC);
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Power All End

        ///////////////////////////////////////////////////// Effects Innit Start

        final Button buttonEffectsInnitGet = findViewById(R.id.buttonEffectsInnit);
        buttonEffectsInnitGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonEffectsInnitGet.setBackgroundColor(myColorC);
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (connectionCheck == 1) {
                        buttonEffectsInnitGet.setBackgroundColor(myColorD);

                        sliderLpFilterCutGet.setValue(0,true);
                        sliderLpFilterResGet.setValue(0,true);
                        sliderLpFilterModGet.setValue(0,true);
                        sliderLpFilterRateGet.setValue(0,true);
                        spinnerLpFilterDivGet.setSelection(0,true);

                        toggleButtonLpFilterSyncGet.setChecked(false);
                        toggleButtonLpFilterSyncGet.setBackgroundColor(myColorC);

                        toggleButtonLpFilterRetrigGet.setChecked(false);
                        toggleButtonLpFilterRetrigGet.setBackgroundColor(myColorC);

                        toggleButtonLpFilterInvGet.setChecked(false);
                        toggleButtonLpFilterInvGet.setBackgroundColor(myColorC);

                        sliderDecimatorReduceGet.setValue(0,true);
                        sliderDecimatorModGet.setValue(0,true);
                        sliderDecimatorRateGet.setValue(0,true);
                        spinnerDecimatorDivGet.setSelection(0,true);

                        toggleButtonDecimatorSyncGet.setChecked(false);
                        toggleButtonDecimatorSyncGet.setBackgroundColor(myColorC);

                        toggleButtonDecimatorRetrigGet.setChecked(false);
                        toggleButtonDecimatorRetrigGet.setBackgroundColor(myColorC);

                        toggleButtonDecimator8bitGet.setChecked(false);
                        toggleButtonDecimator8bitGet.setBackgroundColor(myColorC);

                        sliderDelayTimeGet.setValue(0,true);
                        sliderDelayFeedGet.setValue(0,true);
                        sliderDelayWetGet.setValue(0,true);
                        spinnerDelayDivGet.setSelection(0,true);

                        toggleButtonDelaySyncGet.setChecked(false);
                        toggleButtonDelaySyncGet.setBackgroundColor(myColorC);

                        toggleButtonDelayCrossGet.setChecked(false);
                        toggleButtonDelayCrossGet.setBackgroundColor(myColorC);

                        sliderChorusRateGet.setValue(0,true);
                        sliderChorusDepthGet.setValue(0,true);
                        sliderChorusDelayGet.setValue(0,true);
                        sliderChorusFeedGet.setValue(0,true);
                        sliderChorusFeedGetR.setValue(0,true);

                        toggleButtonChorusCrossGet.setChecked(false);
                        toggleButtonChorusCrossGet.setBackgroundColor(myColorC);

                        sliderChorusWetGet.setValue(0,true);

                        spinnerReverbSizeGet.setSelection(0,true);
                        sliderReverbDelayGet.setValue(0,true);
                        sliderReverbHpGet.setValue(0,true);
                        sliderReverbDampGet.setValue(0,true);
                        sliderReverbWidthGet.setValue(0,true);
                        sliderReverbWetGet.setValue(0,true);

                        toggleButtonDcKillGet.setChecked(false);
                        toggleButtonDcKillGet.setBackgroundColor(myColorC);

                        if (togglebButtonEffectsPowerAllGet.isChecked()) {
                            togglebButtonEffectsPowerAllGet.setChecked(false);
                            togglebButtonEffectsPowerAllGet.setBackgroundColor(myColorC);
                        }
                        if (!togglebButtonEffectsPowerAllGet.isChecked()) {

                            toggleButtonLpFilterPowerGet.setChecked(false);
                            toggleButtonLpFilterPowerGet.setBackgroundColor(myColorC);

                            toggleButtonDecimatorPowerGet.setChecked(false);
                            toggleButtonDecimatorPowerGet.setBackgroundColor(myColorC);

                            toggleButtonDelayPowerGet.setChecked(false);
                            toggleButtonDelayPowerGet.setBackgroundColor(myColorC);

                            toggleButtonChorusPowerGet.setChecked(false);
                            toggleButtonChorusPowerGet.setBackgroundColor(myColorC);

                            toggleButtonReverbPowerGet.setChecked(false);
                            toggleButtonReverbPowerGet.setBackgroundColor(myColorC);
                        }

                    }
                }
                return false;
            }
        });
        ///////////////////////////////////////////////////// Noise Innit End

    } // end create

    public class CustomOnItemSelectedListenerLpFilterDiv implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/156";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                lpFilterDiv = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerDecimatorDiv implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/163";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                decimatorDiv = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerDelayDiv implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/168";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                delayDiv = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerDelayDivR implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/197";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                delayDivR = position;
                myOscMessage.add(Math.round((position / 22.0f) * 127.0f));
                oscP5.send(myOscMessage, getBroadcastLocation);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerReverbSize implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/178";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                reverbSize = position;
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
