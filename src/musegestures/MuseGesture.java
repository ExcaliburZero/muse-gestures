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
 * The <code>MuseGesture</code> enum is used to define the various different
 * Muse gestures that can be analyzed.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public enum MuseGesture {
    /**
     * When the user blinks.
     */
    BLINK,

    /**
     * When the user clenches their jaw.
     */
    JAW_CLENCH,

    /**
     * When the user's concentration is very low.
     */
    CONCENTRATION_0,

    /**
     * When the user's concentration is low.
     */
    CONCENTRATION_1,

    /**
     * When the user's concentration is medium.
     */
    CONCENTRATION_2,

    /**
     * When the user's concentration is high.
     */
    CONCENTRATION_3,
}
