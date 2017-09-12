package zalho.com.br.mypan.service;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zalho.com.br.mypan.model.entities.Login;
import zalho.com.br.mypan.util.Constantes;

/**
 * Created by andrepereira on 11/09/17.
 */

public class ServiceGenerate {
	public static <T> T createService(@NonNull Class<T> serviceClass, Login login) {

		OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
		builder.connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS);
		builder.addInterceptor(chain -> {
			Request request = chain.request().newBuilder()
					.addHeader("user-auth", login.getToken())
					.build();
			return chain.proceed(request);
		});

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constantes.LOCALHOST_BASE_URL)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(builder.build())
				.build();

		return retrofit.create(serviceClass);
	}
}
