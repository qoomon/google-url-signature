package com.qoomon.google.signature;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


/**
 * Tests {@link UrlSigner}
 */
public class SignatureGeneratorTest {

    @Test
    public void sign() throws Exception {
        //GIVEN
        String keyString = "vNIXE0xscrmjlyV-12Nj_BvUPaw=";
        String resource = "/maps/api/geocode/json?address=New+York&client=clientID";

        SignatureGenerator signatureGenerator = new SignatureGenerator(keyString);

        //WHEN
        final String signature = signatureGenerator.generate(resource);

        //THEN
        assertThat(signature, equalTo("chaRF2hTJKOScPr-RQCEhZbSzIE="));
    }

}
