package com.qoomon.google.signature;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

        UrlValidator urlValidator = new UrlValidator(keyString);

        //WHEN
        final boolean isValid = urlValidator.validateRequest(urlString);

        //THEN
        assertThat(isValid, is(true));
    }

}
