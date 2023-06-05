import {execAsync} from '../common';

/** @internal */
export type MobileAdOptions = {
  id?: string;
  adUnitId: string;
  contentUrl?: string;
  keywords?: string[];
  npa?: '1';
};

let started = false;
let startPromise: Promise<{version: string}> | null = null;

/** @internal */
export async function start() {
  startPromise = execAsync('start') as Promise<{version: string}>;
  const result = await startPromise;
  started = true;
  return result;
}

/** @internal */
export class MobileAd<T extends MobileAdOptions = MobileAdOptions> {
  private static allAds: {[s: string]: MobileAd} = {};

  public readonly id: string;

  protected readonly opts: T;
  private _init: Promise<unknown> | null = null;
  private _inited = false;

  constructor(opts: T) {
    this.opts = opts;

    this.id = opts.id ?? opts.adUnitId;
    MobileAd.allAds[this.id] = this;
  }

  public static getAdById(id: string) {
    return this.allAds[id];
  }

  public get adUnitId() {
    return this.opts.adUnitId;
  }

  public on(...args: Parameters<typeof document.addEventListener>): () => void {
    const [eventName, cb, ...rest] = args;
    const type = `admob.ad.${eventName.toLowerCase()}`;
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    const listener = (evt: any) => {
      if (evt.adId === this.id) {
        cb(evt);
      }
    };
    document.addEventListener(type, listener, ...rest);

    return () => {
      document.removeEventListener(type, listener, ...rest);
    };
  }

  protected async isLoaded() {
    await this.init();
    return execAsync('adIsLoaded', [{id: this.id}]) as Promise<boolean>;
  }

  protected async load() {
    await this.init();
    // TODO read `opts` in native code?
    await execAsync('adLoad', [{...this.opts, id: this.id}]);
  }

  protected async show(opts?: Record<string, unknown>) {
    await this.init();
    return execAsync('adShow', [{...opts, id: this.id}]);
  }

  protected async hide() {
    await this.init();
    return execAsync('adHide', [{id: this.id}]);
  }

  protected async init() {
    if (this._inited) return;

    if (!started) {
      if (startPromise === null) start();
      await startPromise;
    }

    if (this._init === null) {
      const cls =
        (this.constructor as unknown as {cls?: string}).cls ??
        this.constructor.name;

      this._init = execAsync('adCreate', [{...this.opts, id: this.id, cls}]);
    }

    try {
      await this._init;
    } finally {
      this._inited = true;
    }
  }
}
