/*
 * Copyright (C) 2016 Christopher Wells <cwellsny@nycap.rr.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package musegestures;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import oscP5.OscMessage;

/**
 * The <code>GestureAnaluzerTest<code> class contains tests of the
 * GestureAnalyzer class.
 */
public class GestureAnalyzerTest {

    /**
     * Test of the analysis of the Blink gesture.
     */
    @Test
    public void testBlink() {
        MuseGesture expectedGesture = MuseGesture.BLINK;
        GestureAnalyzer gestureAnalyzer = new GestureAnalyzer(null);
        OscMessage oscMessage = new OscMessage("/muse/elements/blink", 0);
        OscMessage oscMessage2 = new OscMessage("/muse/elements/blink", 1);
        OscMessage oscMessage3 = new OscMessage("/muse/elements/blink", 0);
        OscMessage oscMessage4 = new OscMessage("/muse/elements/blink", 1);
        OscMessage oscMessage5 = new OscMessage("/muse/elements/blink", 1);
        OscMessage oscMessage6 = new OscMessage("/muse/elements/blink", 0);

        ArrayList<MuseGesture> gestures = gestureAnalyzer.getGestures(oscMessage);
        ArrayList<MuseGesture> gestures2 = gestureAnalyzer.getGestures(oscMessage2);
        ArrayList<MuseGesture> gestures3 = gestureAnalyzer.getGestures(oscMessage3);
        ArrayList<MuseGesture> gestures4 = gestureAnalyzer.getGestures(oscMessage4);
        ArrayList<MuseGesture> gestures5 = gestureAnalyzer.getGestures(oscMessage5);
        ArrayList<MuseGesture> gestures6 = gestureAnalyzer.getGestures(oscMessage6);

        assertFalse(gestures.contains(expectedGesture));
        assertTrue(gestures2.contains(expectedGesture));
        assertFalse(gestures3.contains(expectedGesture));
        assertTrue(gestures4.contains(expectedGesture));
        assertFalse(gestures5.contains(expectedGesture));
        assertFalse(gestures6.contains(expectedGesture));
    }

    /**
     * Test of the analysis of the Jaw Clench gesture.
     */
    @Test
    public void testJawClench() {
        MuseGesture expectedGesture = MuseGesture.JAW_CLENCH;
        GestureAnalyzer gestureAnalyzer = new GestureAnalyzer(null);
        OscMessage oscMessage = new OscMessage("/muse/elements/jaw_clench", 0);
        OscMessage oscMessage2 = new OscMessage("/muse/elements/jaw_clench", 1);
        OscMessage oscMessage3 = new OscMessage("/muse/elements/jaw_clench", 1);
        OscMessage oscMessage4 = new OscMessage("/muse/elements/jaw_clench", 1);
        OscMessage oscMessage5 = new OscMessage("/muse/elements/jaw_clench", 0);

        ArrayList<MuseGesture> gestures = gestureAnalyzer.getGestures(oscMessage);
        ArrayList<MuseGesture> gestures2 = gestureAnalyzer.getGestures(oscMessage2);
        ArrayList<MuseGesture> gestures3 = gestureAnalyzer.getGestures(oscMessage3);
        ArrayList<MuseGesture> gestures4 = gestureAnalyzer.getGestures(oscMessage4);
        ArrayList<MuseGesture> gestures5 = gestureAnalyzer.getGestures(oscMessage5);

        assertFalse(gestures.contains(expectedGesture));
        assertTrue(gestures2.contains(expectedGesture));
        assertFalse(gestures3.contains(expectedGesture));
        assertFalse(gestures4.contains(expectedGesture));
        assertFalse(gestures5.contains(expectedGesture));
    }

    /**
     * Test of the analysis of the Concentration gestures.
     */
    @Test
    public void testConcentration() {
        MuseGesture expectedGesture = MuseGesture.CONCENTRATION_1;
        GestureAnalyzer gestureAnalyzer = new GestureAnalyzer(null);
        OscMessage oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.30);

        ArrayList<MuseGesture> gestures = gestureAnalyzer.getGestures(oscMessage);

        assertTrue(gestures.contains(expectedGesture));

        expectedGesture = MuseGesture.CONCENTRATION_0;
        oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.10);
        gestures = gestureAnalyzer.getGestures(oscMessage);
        assertTrue(gestures.contains(expectedGesture));

        expectedGesture = MuseGesture.CONCENTRATION_2;
        oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.60);
        gestures = gestureAnalyzer.getGestures(oscMessage);
        assertTrue(gestures.contains(expectedGesture));

        expectedGesture = MuseGesture.CONCENTRATION_3;
        oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.80);
        gestures = gestureAnalyzer.getGestures(oscMessage);
        assertTrue(gestures.contains(expectedGesture));

        expectedGesture = MuseGesture.CONCENTRATION_0;
        oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.10);
        gestures = gestureAnalyzer.getGestures(oscMessage);
        assertTrue(gestures.contains(expectedGesture));

        // Same state twice in a row
        expectedGesture = MuseGesture.CONCENTRATION_0;
        oscMessage = new OscMessage("/muse/elements/experimental/concentration", (float) 0.10);
        gestures = gestureAnalyzer.getGestures(oscMessage);
        assertFalse(gestures.contains(expectedGesture));
    }
}
