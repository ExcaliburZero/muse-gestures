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

/**
 * The <code>MuseGestureServerTest</code> class contains tests of the <code>
 * MuseGestureServer</code> class.
 */
public class MuseGestureServerTest {

    /**
     * Runs test of the constructor, start, and stop methods of the <code>
     * MuseGestureServer</code> class.
     */
    @Test
    public void constructorTest() {
        MuseGesturesImplementation testObj = new MuseGesturesImplementation();
        MuseGestureServer server = new MuseGestureServer(testObj, 5000);

        assertTrue(server.start());
        assertFalse(server.start());

        assertTrue(server.stop());
        assertFalse(server.stop());
    }
}
