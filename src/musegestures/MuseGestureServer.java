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

import oscP5.OscEventListener;
import oscP5.OscMessage;
import oscP5.OscP5;

/**
 * The <code>MuseGestureServer</code> class is used to run methods on objects
 * that implement MuseGestures, whenever an action is performed.
 *
 * @author Christopher Wells <cwellsny@nycap.rr.com>
 */
public class MuseGestureServer implements OscEventListener {

    private MuseGestures listener;
    private final int port;

    private final OscP5 museServer;

    /**
     * Initializes a <code>MuseGestureServer</code> with the given port.
     *
     * @param listener The object that will receive the gesture method calls.
     * @param port The port of the Muse oscP5 server.
     */
    public MuseGestureServer(MuseGestures listener, int port) {
        this.listener = listener;
        this.port = port;
        this.museServer = new OscP5(this, port);
    }

    /**
     * Changes the listener object of the MuseGestureServer to the newly
     * specified object.
     *
     * @param listener The new listener object.
     */
    public void setListener(MuseGestures listener) {
        this.listener = listener;
    }

    /**
     * Returns the listener object of the MuseGestureServer.
     *
     * @return The listener object of the MuseGestureServer.
     */
    public MuseGestures getListener() {
        return this.listener;
    }

    public void oscEvent(OscMessage msg) {

    }

}
