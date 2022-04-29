package app;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

import static java.util.Objects.isNull;

public class Client {

    private final  OkHttpClient client;

    public Client() {
        this.client = new OkHttpClient();
    }

    public String get(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            return isNull(body) ? null : body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
