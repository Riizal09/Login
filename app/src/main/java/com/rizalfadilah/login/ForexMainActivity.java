package com.rizalfadilah.login;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {

    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView aedTextView, bndTextView, bynTextView, cnyTextView, eurTextView, gbpTextView, hkdTextView, idrTextView, jpyTextView, krwTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);

        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        aedTextView = (TextView) findViewById(R.id.aedTextView);
        bndTextView = (TextView) findViewById(R.id.bndTextView);
        bynTextView = (TextView) findViewById(R.id.bynTextView);
        cnyTextView = (TextView) findViewById(R.id.cnyTextView);
        eurTextView = (TextView) findViewById(R.id.eurTextView);
        gbpTextView = (TextView) findViewById(R.id.gbpTextView);
        hkdTextView = (TextView) findViewById(R.id.hkdTextView);
        idrTextView = (TextView) findViewById(R.id.idrTextView);
        jpyTextView = (TextView) findViewById(R.id.jpyTextView);
        krwTextView = (TextView) findViewById(R.id.krwTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout1.setOnRefreshListener(() -> {
            initForex();
            swipeRefreshLayout1.setRefreshing(false);
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=b3ae952e6b864cf4b61e2d8414908899";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody), ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getRatesModel();

                double aed = ratesModel.getIDR() / ratesModel.getAED();
                double bnd = ratesModel.getIDR() / ratesModel.getBND();
                double byn = ratesModel.getIDR() / ratesModel.getBYN();
                double cny = ratesModel.getIDR() / ratesModel.getCNY();
                double eur = ratesModel.getIDR() / ratesModel.getEUR();
                double gbp = ratesModel.getIDR() / ratesModel.getGBP();
                double hkd = ratesModel.getIDR() / ratesModel.getHKD();
                double idr = ratesModel.getIDR();
                double jpy = ratesModel.getIDR() / ratesModel.getJPY();
                double krw = ratesModel.getIDR() / ratesModel.getKRW();

                aedTextView.setText(formatNumber(aed, "###,##0.##"));
                bndTextView.setText(formatNumber(bnd, "###,##0.##"));
                bynTextView.setText(formatNumber(byn, "###,##0.##"));
                cnyTextView.setText(formatNumber(cny, "###,##0.##"));
                eurTextView.setText(formatNumber(eur, "###,##0.##"));
                gbpTextView.setText(formatNumber(gbp, "###,##0.##"));
                hkdTextView.setText(formatNumber(hkd, "###,##0.##"));
                idrTextView.setText(formatNumber(idr, "###,##0.##"));
                jpyTextView.setText(formatNumber(jpy, "###,##0.##"));
                krwTextView.setText(formatNumber(krw, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}