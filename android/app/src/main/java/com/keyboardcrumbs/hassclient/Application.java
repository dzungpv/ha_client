package com.keyboardcrumbs.hassclient;

import io.flutter.app.FlutterApplication;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.PluginRegistrantCallback;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugins.GeneratedPluginRegistrant;
import be.tramckrijte.workmanager.WorkmanagerPlugin;
import android.util.Log;
import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.view.FlutterNativeView;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.view.FlutterView;
import android.app.Activity;
import android.content.Intent;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterNativeView;

public class Application extends FlutterApplication implements PluginRegistrantCallback {
    @Override
    public void onCreate() {
        super.onCreate();
        WorkmanagerPlugin.setPluginRegistrantCallback(this);
    }

    @Override
    public void registerWith(PluginRegistry registry) {
        if (registry instanceof FlutterPluginRegistry) {
            GeneratedPluginRegistrant.registerWith(new FlutterPluginRegistryDelegate(registry));
        } else {
            GeneratedPluginRegistrant.registerWith(registry);
        }
    }
}

class FlutterPluginRegistryDelegate implements PluginRegistry {

    private FlutterPluginRegistry reg;

    public FlutterPluginRegistryDelegate(PluginRegistry registry) {
        this.reg = (FlutterPluginRegistry)registry;
    }

    public void attach(FlutterView flutterView, Activity activity)  {
        reg.attach(flutterView, activity);
    }

    public void destroy() {
        reg.destroy();
    }

    public void	detach() {
        reg.detach();
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return reg.onActivityResult(requestCode, requestCode, data);
    }

    public boolean onNewIntent(Intent intent) {
        return reg.onNewIntent(intent);
    }

    public void	onPreEngineRestart() {
        reg.onPreEngineRestart();
    }

    public boolean	onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        return reg.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void	onUserLeaveHint() {
        reg.onUserLeaveHint();
    }

    public boolean	onViewDestroy(FlutterNativeView view) {
        return reg.onViewDestroy(view);
    }

    PlatformViewsController	getPlatformViewsController() {
        return reg.getPlatformViewsController();
    }

    @Override
    public boolean hasPlugin(String pluginKey) {
        Log.d("PLUGIN REGISTRY", "Registering: "+pluginKey);
        if (pluginKey == "com.flutter_webview_plugin.FlutterWebviewPlugin") {
            return true;
        } else {
            return this.reg.hasPlugin(pluginKey);
        }
    }

    @Override
    public Registrar registrarFor(String pluginKey) {
        return this.reg.registrarFor(pluginKey);
    }

    @Override
    public <T> T valuePublishedByPlugin(String pluginKey) {
        return this.reg.valuePublishedByPlugin(pluginKey);
    }


}