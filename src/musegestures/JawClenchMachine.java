/*
 * Copyright (c) 2016 Christopher Wells <cwellsny@nycap.rr.com>
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
 * The <code>JawClenchMachine</code> is used to handle recognition of jaw
 * clench gestures.
 *
 * @author Christopher Wells {@literal <cwellsny@nycap.rr.com>}
 */
public class JawClenchMachine {

    private boolean state;

    /**
     * Instantiates an object of the <code>JawClenchMachine</code> class.
     */
    public JawClenchMachine(){
        this.state = false;
    }

    /**
     * Performs a move of the machine, and returns any output.
     *
     * @param symbol The symbol given as input to the machine.
     * @return The output of the machine.
     */
    public boolean move(int symbol) {
        if (this.state) {
            if (symbol == 1) {
                this.state = true;
            } else {
                this.state = false;
            }
        } else {
            if (symbol == 1) {
                this.state = true;
                return true;
            } else {
                this.state = false;
            }
        }
        return false;
    }
}
