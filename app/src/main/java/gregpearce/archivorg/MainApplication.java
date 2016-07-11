package gregpearce.archivorg;

import android.app.Application;

import timber.log.Timber;

public class MainApplication extends Application {

  // This is used to do dependency injection using the Application scope.
  public static ApplicationComponent APP_COMPONENT;

  @Override public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());

    ApplicationComponent component = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
    APP_COMPONENT = component;
  }
}