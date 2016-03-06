package test.com.carwash;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.util.ArrayList;


public class ServerRequest_forgot {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://yatnaverma.dx.am/";



    public ServerRequest_forgot(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
    }

    public void orderInBackground(Forgot forgot,
                                  GetForgotCallback forgotCallback) {
        progressDialog.show();
        new orderAsyncTask(forgot, (GetOrderCallback) forgotCallback).execute();
    }

    public class orderAsyncTask extends AsyncTask<Void, Void, Void> {
        Forgot forgot;
        GetOrderCallback orderCallBack;

        public orderAsyncTask(Forgot forgot,
                              GetOrderCallback orderCallBack) {
            this.forgot = forgot;
            this.orderCallBack = orderCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("username", forgot.username));
            dataToSend.add(new BasicNameValuePair("phone", forgot.phone));

            HttpParams httpRequestParams = getHttpRequestParams();

            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS
                    + "ForgotPassword.php");

            try {
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        private HttpParams getHttpRequestParams() {
            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            return httpRequestParams;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            orderCallBack.done(null);
        }

    }
}
