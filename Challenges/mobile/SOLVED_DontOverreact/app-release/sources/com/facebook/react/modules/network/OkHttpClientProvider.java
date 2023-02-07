package com.facebook.react.modules.network;

import android.content.Context;
import java.io.File;
import java.security.Provider;
import java.security.Security;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
/* loaded from: classes.dex */
public class OkHttpClientProvider {
    private static OkHttpClient sClient;
    private static OkHttpClientFactory sFactory;

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    public static void setOkHttpClientFactory(OkHttpClientFactory okHttpClientFactory) {
        sFactory = okHttpClientFactory;
    }

    public static OkHttpClient getOkHttpClient() {
        if (sClient == null) {
            sClient = createClient();
        }
        return sClient;
    }

    public static OkHttpClient createClient() {
        OkHttpClientFactory okHttpClientFactory = sFactory;
        if (okHttpClientFactory != null) {
            return okHttpClientFactory.createNewNetworkModuleClient();
        }
        return createClientBuilder().build();
    }

    public static OkHttpClient createClient(Context context) {
        OkHttpClientFactory okHttpClientFactory = sFactory;
        if (okHttpClientFactory != null) {
            return okHttpClientFactory.createNewNetworkModuleClient();
        }
        return createClientBuilder(context).build();
    }

    public static OkHttpClient.Builder createClientBuilder() {
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());
        try {
            Security.insertProviderAt((Provider) Class.forName("org.conscrypt.OpenSSLProvider").newInstance(), 1);
            return cookieJar;
        } catch (Exception unused) {
            return enableTls12OnPreLollipop(cookieJar);
        }
    }

    public static OkHttpClient.Builder createClientBuilder(Context context) {
        return createClientBuilder(context, 10485760);
    }

    public static OkHttpClient.Builder createClientBuilder(Context context, int i) {
        OkHttpClient.Builder createClientBuilder = createClientBuilder();
        return i == 0 ? createClientBuilder : createClientBuilder.cache(new Cache(new File(context.getCacheDir(), "http-cache"), i));
    }
}
