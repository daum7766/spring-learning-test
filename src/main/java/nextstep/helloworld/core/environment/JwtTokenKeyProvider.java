package nextstep.helloworld.core.environment;

public class JwtTokenKeyProvider {

    private final String secretKey;

    public JwtTokenKeyProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
