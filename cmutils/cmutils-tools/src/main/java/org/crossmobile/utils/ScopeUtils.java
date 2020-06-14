/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.function.Consumer;

public class ScopeUtils {
    public static <T> T with(T input, Consumer<T> it) {
        it.accept(input);
        return input;
    }
}
