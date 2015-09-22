package com.qoomon.google.signature;


import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.Test;


/**
 * Tests {@link UrlSigner}
 */
public class UrlSignerTest {

    @Test
    public void signRequest() throws Exception {
        //GIVEN
        String keyString = "vNIXE0xscrmjlyV-12Nj_BvUPaw=";
        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=New+York&client=clientID";

        SignatureGenerator signatureGenerator = new SignatureGenerator(keyString);

        UrlSigner urlSigner = new UrlSigner(signatureGenerator);

        //WHEN
        URL url = new URL(urlString);
        final String signedUrl = urlSigner.signRequest(urlString);

        //THEN
        assertThat(signedUrl).isEqualTo("/maps/api/geocode/json?address=New+York&client=clientID&signature=chaRF2hTJKOScPr-RQCEhZbSzIE=");
    }

}
