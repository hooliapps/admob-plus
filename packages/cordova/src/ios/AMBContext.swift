class AMBContext {
    static weak var plugin: AMBPlugin!

    let command: CDVInvokedUrlCommand

    init(_ command: CDVInvokedUrlCommand) {
        self.command = command
    }

    var plugin: AMBPlugin {
        return AMBContext.plugin
    }

    var commandDelegate: CDVCommandDelegate {
        return plugin.commandDelegate
    }

    var opts: NSDictionary? {
        return command.argument(at: 0) as? NSDictionary
    }

    func optString(_ key: String) -> String? {
        return opts?.value(forKey: key) as? String
    }

    func optId() -> Int? {
        return opts?.value(forKey: "id") as? Int
    }

    func optAdUnitID() -> String? {
        return optString("adUnitId")
    }

    func optAd() -> AMBAdBase? {
        guard let id = opts?.value(forKey: "id") as? Int,
              let ad = AMBAdBase.ads[id]
        else {
            return nil
        }
        return ad
    }

    func optAdOrError() -> AMBAdBase? {
        if let ad = optAd() {
            return ad
        } else {
            error("Ad not found")
            return nil
        }
    }

    func optMaxAdContentRating() -> GADMaxAdContentRating? {
        switch optString("maxAdContentRating") {
        case "G":
            return GADMaxAdContentRating.general
        case "MA":
            return GADMaxAdContentRating.matureAudience
        case "PG":
            return GADMaxAdContentRating.parentalGuidance
        case "T":
            return GADMaxAdContentRating.teen
        default:
            return nil
        }
    }

    func optChildDirectedTreatmentTag() -> Bool? {
        return opts?["tagForChildDirectedTreatment"] as? Bool
    }

    func optUnderAgeOfConsentTag() -> Bool? {
        return opts?["tagForUnderAgeOfConsent"] as? Bool
    }

    func optTestDeviceIds() -> [String]? {
        if let testDeviceIds = opts?["testDeviceIds"] as? [String] {
            return testDeviceIds
        }
        return nil
    }

    func optGADRequest() -> GADRequest {
        let request = GADRequest()
        if let contentURL = optString("contentUrl") {
            request.contentURL = contentURL
        }
        let extras = GADExtras()
        if let npa = optString("npa") {
            extras.additionalParameters = ["npa": npa]
        }
        request.register(extras)
        return request
    }

    func optAdSize() -> GADAdSize {
        if let adSizeType = opts?.value(forKey: "size") as? Int {
            switch adSizeType {
            case 0:
                return kGADAdSizeBanner
            case 1:
                return kGADAdSizeLargeBanner
            case 2:
                return kGADAdSizeMediumRectangle
            case 3:
                return kGADAdSizeFullBanner
            case 4:
                return kGADAdSizeLeaderboard
            default: break
            }
        }
        guard let adSizeDict = opts?.value(forKey: "size") as? NSDictionary,
              let width = adSizeDict.value(forKey: "width") as? Int,
              let height = adSizeDict.value(forKey: "height") as? Int
        else {
            return kGADAdSizeBanner
        }
        return GADAdSizeFromCGSize(CGSize(width: width, height: height))
    }

    func sendResult(_ message: CDVPluginResult?) {
        self.commandDelegate.send(message, callbackId: command.callbackId)
    }

    func success() {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_OK))
    }

    func success(_ message: Bool) {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message))
    }

    func success(_ message: UInt) {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message))
    }

    func success(_ message: [String: Any]) {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message))
    }

    func error() {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_ERROR))
    }

    func error(_ message: String?) {
        self.sendResult(CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: message))
    }

    func error(_ message: Error?) {
        self.error(message?.localizedDescription)
    }
}
