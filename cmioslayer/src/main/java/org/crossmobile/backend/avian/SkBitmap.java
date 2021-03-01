/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.avian;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;

import java.io.*;
import java.lang.reflect.*;

public class SkBitmap extends NativeElement implements NativeBitmap {   
    SkBitmap(String path) {
        super(init(path));
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }

    private static long init(String path) {
        try {
            InputStream inputStream = SkBitmap.class.getClass().getClassLoader().getResourceAsStream(path);
            Field field  = inputStream.getClass().getField("peer");
            field.setAccessible(true);
            Long peer = (Long)field.get(inputStream);
            return initFromBlob(peer);
        } catch (NoSuchFieldException e) {
            return initFromFileName(path);
        } catch (IllegalAccessException e) {
            return initFromFileName(path);
        }
    }

    private static native long initFromFileName(String path);
    private static native long initFromBlob(long blobPeer);

    protected native void destroy(long peer);
}
