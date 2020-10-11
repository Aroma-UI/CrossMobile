/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.webkit.WKWebView;
import org.crossmobile.bridge.CrossMobilePlugin;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;

@CMLib(name = "cmwebkit")
public class WebViewInitializer implements CrossMobilePlugin {
    @Override
    public void initialize() {
        Native.system().registerScrollable(UIWebView.class);
        Native.system().registerScrollable(WKWebView.class);
    }
}
