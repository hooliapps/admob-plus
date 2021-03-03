// THIS IS AN AUTOGENERATED FILE. DO NOT EDIT THIS FILE DIRECTLY.
package admob.plugin;

import com.google.android.gms.ads.AdSize;

public final class Generated {
    public final class Actions {
        public static final String BANNER_HIDE = "bannerHide";
        public static final String BANNER_SHOW = "bannerShow";
        public static final String CONFIG_REQUEST = "configRequest";
        public static final String INTERSTITIAL_IS_LOADED = "interstitialIsLoaded";
        public static final String INTERSTITIAL_LOAD = "interstitialLoad";
        public static final String INTERSTITIAL_SHOW = "interstitialShow";
        public static final String READY = "ready";
        public static final String REQUEST_TRACKING_AUTHORIZATION = "requestTrackingAuthorization";
        public static final String REWARDED_INTERSTITIAL_IS_LOADED = "rewardedInterstitialIsLoaded";
        public static final String REWARDED_INTERSTITIAL_LOAD = "rewardedInterstitialLoad";
        public static final String REWARDED_INTERSTITIAL_SHOW = "rewardedInterstitialShow";
        public static final String REWARDED_IS_LOADED = "rewardedIsLoaded";
        public static final String REWARDED_LOAD = "rewardedLoad";
        public static final String REWARDED_SHOW = "rewardedShow";
        public static final String SET_APP_MUTED = "setAppMuted";
        public static final String SET_APP_VOLUME = "setAppVolume";
        public static final String START = "start";
    }

    public final class Events {
        public static final String BANNER_CLICK = "admob.banner.click";
        public static final String BANNER_CLOSE = "admob.banner.close";
        public static final String BANNER_IMPRESSION = "admob.banner.impression";
        public static final String BANNER_LOAD = "admob.banner.load";
        public static final String BANNER_LOAD_FAIL = "admob.banner.loadFail";
        public static final String BANNER_OPEN = "admob.banner.open";
        public static final String INTERSTITIAL_DISMISS = "admob.interstitial.dismiss";
        public static final String INTERSTITIAL_LOAD = "admob.interstitial.load";
        public static final String INTERSTITIAL_LOAD_FAIL = "admob.interstitial.loadFail";
        public static final String INTERSTITIAL_SHOW = "admob.interstitial.show";
        public static final String INTERSTITIAL_SHOW_FAIL = "admob.interstitial.showFail";
        public static final String READY = "admob.ready";
        public static final String REWARDED_DISMISS = "admob.rewarded.dismiss";
        public static final String REWARDED_INTERSTITIAL_DISMISS = "admob.rewardedInterstitial.dismiss";
        public static final String REWARDED_INTERSTITIAL_LOAD = "admob.rewardedInterstitial.load";
        public static final String REWARDED_INTERSTITIAL_LOAD_FAIL = "admob.rewardedInterstitial.loadFail";
        public static final String REWARDED_INTERSTITIAL_REWARD = "admob.rewardedInterstitial.reward";
        public static final String REWARDED_INTERSTITIAL_SHOW = "admob.rewardedInterstitial.show";
        public static final String REWARDED_INTERSTITIAL_SHOW_FAIL = "admob.rewardedInterstitial.showFail";
        public static final String REWARDED_LOAD = "admob.rewarded.load";
        public static final String REWARDED_LOAD_FAIL = "admob.rewarded.loadFail";
        public static final String REWARDED_REWARD = "admob.rewarded.reward";
        public static final String REWARDED_SHOW = "admob.rewarded.show";
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
