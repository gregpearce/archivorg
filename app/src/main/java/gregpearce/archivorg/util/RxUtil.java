package gregpearce.archivorg.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public final class RxUtil {
  private RxUtil() {
  }

  public static <T> Observable.Transformer<T, T> viewDefaults() {
    return observable -> observable
        .observeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread());
  }

  public static <T> Observable.Transformer<T, T> subscriberDefaults() {
    return observable -> observable
        .doOnError(error -> Timber.e(error, "Default Error Handler: %s", error.getMessage()))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
