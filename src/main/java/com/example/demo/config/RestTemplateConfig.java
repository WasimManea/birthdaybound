package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Value("${conntimeout}")
    private Duration connTimeout;
    @Value("${readtimeout}")
    private Duration readTimeout;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(connTimeout)
                .setReadTimeout(readTimeout)
                .build();
    }


    //to disable the certificate for local test
//    @Bean
//    public RestTemplate restTemplate() throws Exception {
//      //   Trust manager that does not validate certificate chains
//        TrustManager[] trustAllCerts = new TrustManager[]{
//                new X509TrustManager() {
//                    public X509Certificate[] getAcceptedIssuers() {
//                        return new X509Certificate[0];
//                    }
//
//                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
//                    }
//
//                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                    }
//                }
//        };
//
//       //  Set up the SSL context to ignore certificate validation
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//
//     //    Create an HttpClient with this SSL context
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
//
//     //    Disable hostname verification
//        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
//
//      //   Use SimpleClientHttpRequestFactory to create RestTemplate
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setBufferRequestBody(false);  // Optional optimization for large requests
//
//        return new RestTemplate(factory);
//    }

}
