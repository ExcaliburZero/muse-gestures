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
 * The <code>MuseGesturesImplementation</code> class is a basic implementation
 * of the MuseGestures interface used for testing the library.
 */
public class MuseGesturesImplementation implements MuseGestures {

    private int blinks;
    private int jawClenches;
    private int concentrationZeros;
    private int concentrationOnes;
    private int concentrationTwos;
    private int concentrationThrees;

    public MuseGesturesImplementation() {
        this.blinks = 0;
        this.jawClenches = 0;
        this.concentrationZeros = 0;
        this.concentrationOnes = 0;
        this.concentrationTwos = 0;
        this.concentrationThrees = 0;
    }

    public int getBlinks() {
        return this.blinks;
    }

    public int getJawClenches() {
        return this.jawClenches;
    }

    public int getConcentrationZeros() {
        return this.concentrationZeros;
    }

    public int getConcentrationOnes() {
        return this.concentrationOnes;
    }

    public int getConcentrationTwos() {
        return this.concentrationTwos;
    }

    public int getConcentrationThrees() {
        return this.concentrationThrees;
    }

    public void onBlink() {
        this.blinks++;
    }

    public void onJawClench() {
        this.jawClenches++;
    }

    public void onConcentrationChange(int state) {
        switch (state) {
            case 0:
                this.concentrationZeros++;
                break;
            case 1:
                this.concentrationOnes++;
                break;
            case 2:
                this.concentrationTwos++;
                break;
            case 3:
                this.concentrationThrees++;
                break;
        }
    }
}
