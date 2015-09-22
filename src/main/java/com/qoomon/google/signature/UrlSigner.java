package com.qoomon.google.signature;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Google uri signer.
 * <p/>
 *
 * @author b.brodersen
 */
public class UrlSigner {


    private final SignatureGenerator signatureGenerator;

    public UrlSigner(SignatureGenerator signatureGenerator) {
        this.signatureGenerator = signatureGenerator;
    }

    public String signRequest(String urlString) throws MalformedURLException {
        return signRequest(new URL(urlString));
    }

    public String signRequest(URL url) {

        // Retrieve the proper URL components to sign
        String resource = url.getPath() + '?' + url.getQuery();

        String signature = signatureGenerator.generate(resource);
        return resource + "&signature=" + signature;
    }


}
