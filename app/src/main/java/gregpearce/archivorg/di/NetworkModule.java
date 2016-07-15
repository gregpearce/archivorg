package gregpearce.archivorg.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
  @Provides @Singleton Retrofit provideRetrofit() {
    // add a custom http client to automatically add the output=json query param
    OkHttpClient httpClient =
        new OkHttpClient.Builder().addInterceptor(chain -> {
          HttpUrl originalUrl = chain.request().url();
          HttpUrl url = originalUrl.newBuilder()
              .addQueryParameter("output", "json")
              .build();

          Request.Builder requestBuilder = chain.request().newBuilder().url(url);
          Request request = requestBuilder.build();
          return chain.proceed(request);
        }).build();

    return new Retrofit.Builder()
        .baseUrl("https://archive.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient)
        .build();
  }
}