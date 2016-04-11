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

import oscP5.OscMessage;

/**
 * The <code>MuseGestureServerTest</code> class contains tests of the <code>
 * MuseGestureServer</code> class.
 */
public class MuseGestureServerTest {

    /**
     * Runs test of the constructor, start, stop, and isRunning methods of the
     * <code>MuseGestureServer</code> class.
     */
    @Test
    public void constructorTest() {
        MuseGesturesDefault testObj = new MuseGesturesDefault();
        MuseGestureServer server = new MuseGestureServer(testObj, 5000);

        assertFalse(server.isRunning());
        assertTrue(server.start());
        assertFalse(server.start());
        assertTrue(server.isRunning());

        assertTrue(server.stop());
        assertFalse(server.stop());
        assertFalse(server.isRunning());
    }

    /**
     * Runs tests of the setListener and getListener methods of the <code>
     * MuseGestureServer</code> class.
     */
    @Test
    public void listenerMethodsTest() {
        MuseGesturesDefault testObj = new MuseGesturesDefault();
        MuseGestureServer server = new MuseGestureServer(testObj, 5000);

        assertEquals(testObj, server.getListener());

        MuseGesturesDefault testObj2 = new MuseGesturesDefault();
        server.setListener(testObj2);
        assertEquals(testObj2, server.getListener());
    }

    /**
     * Runs tests of the onGesture method of the <code>MuseGestureServer</code>
     * class.
     */
    @Test
    public void onGestureTest() {
        MuseGesturesImplementation testObj = new MuseGesturesImplementation();
        MuseGestureServer server = new MuseGestureServer(testObj, 5000);

        assertEquals(0, testObj.getBlinks());
        assertEquals(0, testObj.getJawClenches());
        assertEquals(0, testObj.getConcentrationZeros());
        assertEquals(0, testObj.getConcentrationOnes());
        assertEquals(0, testObj.getConcentrationTwos());
        assertEquals(0, testObj.getConcentrationThrees());

        server.onGesture(MuseGesture.BLINK);
        assertEquals(1, testObj.getBlinks());
        assertEquals(0, testObj.getJawClenches());

        server.onGesture(MuseGesture.JAW_CLENCH);
        assertEquals(1, testObj.getJawClenches());

        server.onGesture(MuseGesture.CONCENTRATION_0);
        assertEquals(1, testObj.getConcentrationZeros());

        server.onGesture(MuseGesture.CONCENTRATION_1);
        assertEquals(1, testObj.getConcentrationOnes());

        server.onGesture(MuseGesture.CONCENTRATION_2);
        assertEquals(1, testObj.getConcentrationTwos());

        server.onGesture(MuseGesture.CONCENTRATION_3);
        assertEquals(1, testObj.getConcentrationThrees());
    }

    /**
     * Runs test of the oscEvent method of the <code>MuseGestureServer</code>
     * class.
     */
    @Test
    public void oscEventTest() {
        MuseGesturesImplementation testObj = new MuseGesturesImplementation();
        MuseGestureServer server = new MuseGestureServer(testObj, 5000);
        OscMessage oscMessage = new OscMessage("/muse/elements/blink", 1);

        server.oscEvent(oscMessage);
        assertEquals(1, testObj.getBlinks());
    }
}
