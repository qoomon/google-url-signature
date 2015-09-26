package com.qoomon.google.signature;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Google uri signer.
 *
 * @author b.brodersen
 */
public class UrlValidator {

    private final SignatureGenerator signatureGenerator;

    private final Pattern signaturePattern = Pattern.compile("((.*)&)?signature=(.+)$");

    public UrlValidator(String keyString) {
        this.signatureGenerator = new SignatureGenerator(keyString);
    }

    public boolean validateRequest(String urlString) throws MalformedURLException {
        return validateRequest(new URL(urlString));
    }

    public boolean validateRequest(URL url) {

        Matcher signatureMatcher = signaturePattern.matcher(url.getQuery());
        if (!signatureMatcher.matches()) {
            return false;
        }
        String unsignedQuery = signatureMatcher.group(2);
        String signature = signatureMatcher.group(3);

        // Retrieve the proper URL components to sign

        String resource = url.getPath() + '?' + unsignedQuery;

        String signatureExpected = signatureGenerator.generate(resource);
        return signature.equals(signatureExpected);
    }


}
