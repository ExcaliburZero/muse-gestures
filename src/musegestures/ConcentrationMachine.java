/*
 * Copyright (c) 2016 Christopher Wells <cwellsny@nycap.rr.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package musegestures;

/**
 * The <code>ConcentrationMachine</code> is used to detect changes in the
 * concentration states.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class ConcentrationMachine {

    private int state;
    private float[] thresholds;

    /**
     * Initializes an object of the <code>ConcentrationMachine</code> class.
     */
    public ConcentrationMachine() {
        this.thresholds = new float[]{
            (float) 0.0,
            (float) 0.25,
            (float) 0.5,
            (float) 0.75,
            (float) 1.0,
        };
        this.state = 0;
    }

    public MuseGesture move(float value) {
        if (value > thresholds[0] && value < thresholds[1]) {
            if (this.state != 0) {
                this.state = 0;
                return MuseGesture.CONCENTRATION_0;
            }
        } else if (value < thresholds[2]) {
            if (this.state != 1) {
                this.state = 1;
                return MuseGesture.CONCENTRATION_1;
            }
        } else if (value < thresholds[3]) {
            if (this.state != 2) {
                this.state = 2;
                return MuseGesture.CONCENTRATION_2;
            }
        } else if (value <= thresholds[4]) {
            if (this.state != 3) {
                this.state = 3;
                return MuseGesture.CONCENTRATION_3;
            }
        }
        return null;
    }
}
