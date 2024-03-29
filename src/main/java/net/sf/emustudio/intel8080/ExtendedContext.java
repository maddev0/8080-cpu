/*
 * ExtendedContext.java
 *
 * Created on 18.6.2008, 8:56:44
 *
 * Copyright (C) 2008-2012 Peter Jakubčo
 * KISS, YAGNI, DRY
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package net.sf.emustudio.intel8080;

import emulib.annotations.ContextType;
import emulib.plugins.cpu.CPUContext;
import emulib.plugins.device.DeviceContext;

/**
 * Extended CPU context for 8080 processor.
 * 
 * @author Peter Jakubčo
 */
@ContextType
public interface ExtendedContext extends CPUContext {
    
    /**
     * Attach a device into the CPU.
     * 
     * @param device the device
     * @param port CPU port where the device should be attached
     * @return true on success, false otherwise
     */
    public boolean attachDevice(DeviceContext<Short> device, int port);
    
    /**
     * Detach a device from the CPU.
     * 
     * @param port the CPU port number which will be freed.
     */
    public void detachDevice(int port);
    
    public void setCPUFrequency(int freq);
}
