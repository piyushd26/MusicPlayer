package me.dev.superavesome.musicplayer;

import android.app.Application;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Vardan sharma on 8/5/16.
 * Base application for our application enables calligraphy
 */
public class BaseApp extends Application {
  @Override public void onCreate() {
    super.onCreate();

    // enabling calligraphy
    CalligraphyConfig.initDefault(
        new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build());
  }
}
