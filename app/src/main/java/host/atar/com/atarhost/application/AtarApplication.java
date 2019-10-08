package host.atar.com.atarhost.application;

import android.app.Application;

import com.wlqq.phantom.library.BuildConfig;
import com.wlqq.phantom.library.PhantomCore;

import host.atar.com.atarhost.service.HostInfoService;

/**
 * @author：atar
 * @date: 2019/9/23
 * @description:
 */
public class AtarApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initPhantom();
    }

    private void initPhantom() {
        PhantomCore.getInstance().init(this, new PhantomCore.Config()
                .setDebug(BuildConfig.DEBUG)
                .setLogLevel(BuildConfig.DEBUG ? android.util.Log.VERBOSE : android.util.Log.WARN)
                .addPhantomService(new HostInfoService()));
//                .setLogReporter(new LogReporterImpl()));
    }
}
