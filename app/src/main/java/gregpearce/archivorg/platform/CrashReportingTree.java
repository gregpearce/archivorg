package gregpearce.archivorg.platform;

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import timber.log.Timber;

public class CrashReportingTree extends Timber.Tree {
  @Override
  protected void log(int priority, String tag, String message, Throwable t) {
    if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
      return;
    }
    Crashlytics.log(priority, tag, message);

    if (t != null) {
      Crashlytics.logException(t);
    }
  }
}
