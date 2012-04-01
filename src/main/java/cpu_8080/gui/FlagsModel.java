/*
 * FlagsModel.java
 *
 *  Copyright (C) 2011 vbmacher
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package cpu_8080.gui;

import cpu_8080.impl.Cpu8080;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vbmacher
 */
public class FlagsModel extends AbstractTableModel {
    private String[] flags = {"S", "Z", "A", "P", "C"};
    private int[] flagsI = {0, 0, 0, 0, 0};
    private Cpu8080 cpu;

    public FlagsModel(Cpu8080 cpu) {
        this.cpu = cpu;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return flags[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (rowIndex) {
            case 0:
                return flags[columnIndex];
            case 1:
                return flagsI[columnIndex];
        }
        return null;
    }

    @Override
    public void fireTableDataChanged() {
        short F = cpu.Flags;
        flagsI[0] = ((F & Cpu8080.flagS) != 0) ? 1 : 0;
        flagsI[1] = ((F & Cpu8080.flagZ) != 0) ? 1 : 0;
        flagsI[2] = ((F & Cpu8080.flagAC) != 0) ? 1 : 0;
        flagsI[3] = ((F & Cpu8080.flagP) != 0) ? 1 : 0;
        flagsI[4] = ((F & Cpu8080.flagC) != 0) ? 1 : 0;
        super.fireTableDataChanged();
    }
}