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

/**
 * The <code>MuseGestures</code> class is used to create classes that have
 * handling for different Muse gestures.
 * <br><br>
 * Each of the gesture methods defined are called when the corresponding gesture
 * is performed.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public abstract class MuseGestures {

    /**
     * Runs when a blink is performed.
     */
    public void onBlink() {

    }

    /**
     * Runs when a jaw clench is performed.
     */
    public void onJawClench() {

    }
}
