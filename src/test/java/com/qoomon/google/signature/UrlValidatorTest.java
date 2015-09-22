package com.qoomon.google.signature;


import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.Test;


/**
 * Tests {@link UrlSigner}
 */
public class UrlValidatorTest {

    @Test
    public void validateRequest() throws Exception {
        //GIVEN
        String keyString = "vNIXE0xscrmjlyV-12Nj_BvUPaw=";
        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=New+York&client=clientID&signature=chaRF2hTJKOScPr-RQCEhZbSzIE=";

        SignatureGenerator signatureGenerator = new SignatureGenerator(keyString);

        UrlValidator urlValidator = new UrlValidator(signatureGenerator);

        //WHEN
        URL url = new URL(urlString);
        final boolean isValid = urlValidator.validateRequest(urlString);

        //THEN
        assertThat(isValid).isTrue();
    }

}
