// THIS IS AN AUTOGENERATED FILE. DO NOT EDIT THIS FILE DIRECTLY.
package admob.plugin;

import com.google.android.gms.ads.AdSize;

public final class Generated {
    public final class Actions {
        public static final String BANNER_HIDE = "banner.hide";
        public static final String BANNER_SHOW = "banner.show";
        public static final String CONFIG_REQUEST = "configRequest";
        public static final String INTERSTITIAL_IS_LOADED = "interstitial.isLoaded";
        public static final String INTERSTITIAL_LOAD = "interstitial.load";
        public static final String INTERSTITIAL_SHOW = "interstitial.show";
        public static final String READY = "ready";
        public static final String REWARDED_IS_READY = "rewarded.isReady";
        public static final String REWARDED_LOAD = "rewarded.load";
        public static final String REWARDED_SHOW = "rewarded.show";
        public static final String SET_APP_MUTED = "setAppMuted";
        public static final String SET_APP_VOLUME = "setAppVolume";
    }

    public final class Events {
        public static final String BANNER_CLICK = "admob.banner.click";
        public static final String BANNER_CLOSE = "admob.banner.close";
        public static final String BANNER_IMPRESSION = "admob.banner.impression";
        public static final String BANNER_LOAD = "admob.banner.load";
        public static final String BANNER_LOAD_FAIL = "admob.banner.loadFail";
        public static final String BANNER_OPEN = "admob.banner.open";
        public static final String INIT_COMPLETE = "admob.initComplete";
        public static final String INTERSTITIAL_CLICK = "admob.interstitial.click";
        public static final String INTERSTITIAL_CLOSE = "admob.interstitial.close";
        public static final String INTERSTITIAL_IMPRESSION = "admob.interstitial.impression";
        public static final String INTERSTITIAL_LOAD = "admob.interstitial.load";
        public static final String INTERSTITIAL_LOAD_FAIL = "admob.interstitial.loadFail";
        public static final String INTERSTITIAL_OPEN = "admob.interstitial.open";
        public static final String READY = "admob.ready";
        public static final String REWARDED_CLOSE = "admob.rewarded.close";
        public static final String REWARDED_LOAD = "admob.rewarded.load";
        public static final String REWARDED_LOAD_FAIL = "admob.rewarded.loadFail";
        public static final String REWARDED_OPEN = "admob.rewarded.open";
        public static final String REWARDED_REWARD = "admob.rewarded.reward";
        public static final String REWARDED_SHOW_FAIL = "admob.rewarded.showFail";
    }

    public enum AdSizeType {
        BANNER, LARGE_BANNER, MEDIUM_RECTANGLE, FULL_BANNER, LEADERBOARD, SMART_BANNER;

        public static AdSize getAdSize(Object adSize) {
            if (AdSizeType.BANNER.equals(adSize)) {
                return AdSize.BANNER;
            }
            if (AdSizeType.LARGE_BANNER.equals(adSize)) {
                return AdSize.LARGE_BANNER;
            }
            if (AdSizeType.MEDIUM_RECTANGLE.equals(adSize)) {
                return AdSize.MEDIUM_RECTANGLE;
            }
            if (AdSizeType.FULL_BANNER.equals(adSize)) {
                return AdSize.FULL_BANNER;
            }
            if (AdSizeType.LEADERBOARD.equals(adSize)) {
                return AdSize.LEADERBOARD;
            }
            if (AdSizeType.SMART_BANNER.equals(adSize)) {
                return AdSize.SMART_BANNER;
            }
            return null;
        }
    }
}
