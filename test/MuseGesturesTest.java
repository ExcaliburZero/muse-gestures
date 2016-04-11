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
 * The <code>MuseGesturesTest</code> class contains tests of the <code>
 * MuseGestures</code> class.
 */
public class MuseGesturesTest {

    /**
     * Runs tests of the default gesture recieve methods of the <code>
     * MuseGestures</code> class.
     */
    @Test
    public void onGestureMethodsTest() {
        MuseGesturesDefault museGestures = new MuseGesturesDefault();

        museGestures.onBlink();
        museGestures.onJawClench();
        museGestures.onConcentrationChange(1);

        assertTrue(true);
    }
}
