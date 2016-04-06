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

import java.util.ArrayList;
import oscP5.OscMessage;
import static musegestures.MuseGesture.*;

/**
 * The <code>GestureAnalyzer</code> class is used to analyze oscP5 messages in
 * order to determine when certain gestures are performed.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class GestureAnalyzer {

    private MuseGestureServer server;

    /**
     * Initializes a <code>GestureAnalyzer</code> object with the given
     * MuseGestureServer.
     *
     * @param server The server of the GestureAnalyzer.
     */
    public GestureAnalyzer(MuseGestureServer server) {
        this.server = server;
    }

    /**
     * Sends any gestures that are performed in the given OscMessage to the
     * MuseGestureServer.
     *
     * @param msg The message to be analyzed.
     */
    public void analyzeMessage(OscMessage msg) {
        ArrayList<MuseGesture> gestures = getGestures(msg);

        for (MuseGesture gesture : gestures) {
            this.server.onGesture(gesture);
        }
    }

    /**
     * Analyzes the given OscMessage and returns a list of all of the performed
     * gestures.
     *
     * @param msg The message to be analyzed.
     * @return A list of the analyzed gestures.
     */
    public ArrayList<MuseGesture> getGestures(OscMessage msg) {
        ArrayList<MuseGesture> gestures = new ArrayList<>();

        switch(msg.getAddress()) {
            case "/muse/elements/blink":
                if (msg.get(0).intValue() == 1) {
                    gestures.add(BLINK);
                }
                break;
            case "/muse/elements/jaw_clench":
                if (msg.get(0).intValue() == 1) {
                    gestures.add(JAW_CLENCH);
                }
                break;
        }

        return gestures;
    }

}
