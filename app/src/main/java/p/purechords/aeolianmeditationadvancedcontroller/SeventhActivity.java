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

import oscP5.OscMessage;

import p.purechords.aeolianmeditationadvancedcontroller.databinding.ActivitySeventhBinding;

import static p.purechords.aeolianmeditationadvancedcontroller.MainActivity.*;

public class SeventhActivity extends AppCompatActivity {

    int limit = 0;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout with binding
        ActivitySeventhBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_seventh);

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

        ////////////////////////////////////////////////////////////////
        /////////////////////////////////////////// Observable set end
        ////////////////////////////////////////////////////////////////

        binding.setObsIntDrone(obsIntDrone);
        binding.setObsIntFmDepth(obsIntFmDepth);
        binding.setObsIntFilterCut(obsIntFilterCut);
        binding.setObsIntEnvA(obsIntEnvA);
        binding.setObsIntEnvD(obsIntEnvD);
        binding.setObsIntEnvS(obsIntEnvS);
        binding.setObsIntEnvR(obsIntEnvR);

        /////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// Navigator Buttons Start
        /////////////////////////////////////////////////////////////////////////////

        final Button buttonToMainPageGet = findViewById(R.id.buttonToMainPage);
        buttonToMainPageGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    buttonToMainPageGet.setBackgroundColor(myColorD);

                    Intent intentBundle = new Intent(SeventhActivity.this, MainActivity.class);
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

                    Intent intentBundle = new Intent(SeventhActivity.this, SecondActivity.class);
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

                    Intent intentBundle = new Intent(SeventhActivity.this, FifthActivity.class);
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

                    Intent intentBundle = new Intent(SeventhActivity.this, ThirdActivity.class);
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

                    Intent intentBundle = new Intent(SeventhActivity.this, FourthActivity.class);
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

                    Intent intentBundle = new Intent(SeventhActivity.this, SixthActivity.class);
                    startActivity(intentBundle);
                    return true;
                }
                buttonToPerformPageGet.setBackgroundColor(myColorC);
                return false;
            }
        });

        final Button buttonPlayPageGet = findViewById(R.id.buttonToPlayPage);
        buttonPlayPageGet.setBackgroundColor(myColorD);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////// Navigator Buttons End
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////////// Harmonic Source Source Select Start
        final Spinner spinnerSourceSelectGet = (findViewById(R.id.spinnerSourceSelect));
        spinnerSourceSelectGet.setOnItemSelectedListener(new SeventhActivity.CustomOnItemSelectedListenerSourceSelect());
        ArrayAdapter adapterSourceSelect = ArrayAdapter.createFromResource(this,
                R.array.spinnerSource, R.layout.spinner_item);
        spinnerSourceSelectGet.setAdapter(adapterSourceSelect);
        spinnerSourceSelectGet.setSelection(sourceSelect);
        ////////////////////// Harmonic Source Source Select End

        final ToggleButton togglebButtonEffectsPowerAllGet = findViewById(R.id.toggleButtonEffectsPowerAll);
        togglebButtonEffectsPowerAllGet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (connectionCheck == 1) {
                        togglebButtonEffectsPowerAllGet.setBackgroundColor(myColorD);

                        String myMsgAddress = "/1/2525/1/150";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterPower = 127;

                        myMsgAddress = "/1/2525/1/158";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorPower = 127;

                        myMsgAddress = "/1/2525/1/165";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayPower = 127;

                        myMsgAddress = "/1/2525/1/171";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusPower = 127;

                        myMsgAddress = "/1/2525/1/177";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(127);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        reverbPower = 127;
                    }
                } else {
                    if (connectionCheck == 1) {
                        togglebButtonEffectsPowerAllGet.setBackgroundColor(myColorC);

                        String myMsgAddress = "/1/2525/1/150";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        lpFilterPower = 0;

                        myMsgAddress = "/1/2525/1/158";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        decimatorPower = 0;

                        myMsgAddress = "/1/2525/1/165";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        delayPower = 0;

                        myMsgAddress = "/1/2525/1/171";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        chorusPower = 0;

                        myMsgAddress = "/1/2525/1/177";
                        myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        reverbPower = 0;
                    }
                }
            }
        }); // end listener

        ///////////////////////////////////////////////////// Power All End

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

        Spinner spinnerPlayOctGet = (findViewById(R.id.spinnerPlayOct));
        spinnerPlayOctGet.setOnItemSelectedListener(new SeventhActivity.CustomOnItemSelectedListenerPlayOct());
        ArrayAdapter adapterPlayOct = ArrayAdapter.createFromResource(this,
                R.array.spinnerPlayOct, R.layout.spinner_item);
        spinnerPlayOctGet.setAdapter(adapterPlayOct);
        spinnerPlayOctGet.setSelection(playOctave);


        ///////////////////////////////////////////////////////////////////// Notes Start

        final Button noteC1Get = findViewById(R.id.buttonNoteC1);
        noteC1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteC1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteC1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(52325);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteCs1Get = findViewById(R.id.buttonNoteCs1);
        noteCs1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteCs1Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteCs1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(55437);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteD1Get = findViewById(R.id.buttonNoteD1);
        noteD1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteD1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event

                    noteD1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(58733);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteDs1Get = findViewById(R.id.buttonNoteDs1);
        noteDs1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteDs1Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteDs1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(62225);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteE1Get = findViewById(R.id.buttonNoteE1);
        noteE1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteE1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteE1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(65925);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });


        final Button noteF1Get = findViewById(R.id.buttonNoteF1);
        noteF1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteF1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteF1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(69846);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteFs1Get = findViewById(R.id.buttonNoteFs1);
        noteFs1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteFs1Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteFs1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(73999);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteG1Get = findViewById(R.id.buttonNoteG1);
        noteG1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteG1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteG1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(78399);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteGs1Get = findViewById(R.id.buttonNoteGs1);
        noteGs1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteGs1Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteGs1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(83061);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteA1Get = findViewById(R.id.buttonNoteA1);
        noteA1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteA1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteA1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(88000);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteAs1Get = findViewById(R.id.buttonNoteAs1);
        noteAs1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteAs1Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteAs1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(93233);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteB1Get = findViewById(R.id.buttonNoteB1);
        noteB1Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteB1Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteB1Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(98777);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        /////////////////////////////////////////////////// end oct 1

        /////////////////////////////////////////////////// start oct 2

        final Button noteC2Get = findViewById(R.id.buttonNoteC2);
        noteC2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteC2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteC2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(104650);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteCs2Get = findViewById(R.id.buttonNoteCs2);
        noteCs2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteCs2Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteCs2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(110873);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteD2Get = findViewById(R.id.buttonNoteD2);
        noteD2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteD2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteD2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(117466);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteDs2Get = findViewById(R.id.buttonNoteDs2);
        noteDs2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteDs2Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteDs2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(124451);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteE2Get = findViewById(R.id.buttonNoteE2);
        noteE2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteE2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteE2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(131851);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });


        final Button noteF2Get = findViewById(R.id.buttonNoteF2);
        noteF2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteF2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteF2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(139691);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteFs2Get = findViewById(R.id.buttonNoteFs2);
        noteFs2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteFs2Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteFs2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(147998);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteG2Get = findViewById(R.id.buttonNoteG2);
        noteG2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteG2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteG2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(156798);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteGs2Get = findViewById(R.id.buttonNoteGs2);
        noteGs2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteGs2Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteGs2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(166122);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteA2Get = findViewById(R.id.buttonNoteA2);
        noteA2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteA2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteA2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(176000);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteAs2Get = findViewById(R.id.buttonNoteAs2);
        noteAs2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteAs2Get.setBackgroundColor(myColorE);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteAs2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(186466);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        final Button noteB2Get = findViewById(R.id.buttonNoteB2);
        noteB2Get.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (connectionCheck == 1) {
                        noteB2Get.setBackgroundColor(myColorA);
                        getMyNetAddress();
                        String myMsgAddress = "/1/2525/1/194";
                        OscMessage myOscMessage = new OscMessage(myMsgAddress);
                        myOscMessage.add(0);
                        oscP5.send(myOscMessage, getBroadcastLocation);
                        limit = 0; // reset action down limiter
                    }
                    return true;
                }
                if (limit == 0 && connectionCheck == 1) { // respond only to first touch event
                    noteB2Get.setBackgroundColor(myColorB);
                    getMyNetAddress();
                    String myMsgAddress = "/1/2525/1/194";
                    OscMessage myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(1);
                    oscP5.send(myOscMessage, getBroadcastLocation);

                    myMsgAddress = "/1/2525/1/207";
                    myOscMessage = new OscMessage(myMsgAddress);
                    myOscMessage.add(197553);
                    oscP5.send(myOscMessage, getBroadcastLocation);
                    limit = 1; // prevent stacking of action down touch events
                }
                return false;
            }
        });

        ///////////////////////////////////////////////////////////////////// Notes End

    } // end create

    public class CustomOnItemSelectedListenerPlayOct implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/208";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                myOscMessage.add(position);
                oscP5.send(myOscMessage, getBroadcastLocation);
                playOctave = position;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    } // end listener

    public class CustomOnItemSelectedListenerSourceSelect implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (connectionCheck == 1) {
                getMyNetAddress();
                String myMsgAddress = "/1/2525/1/131";
                OscMessage myOscMessage = new OscMessage(myMsgAddress);
                sourceSelect = position;
                myOscMessage.add(Math.round((position / 3.0f) * 127.0f));
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



