package nextstep.helloworld.core.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// TODO: 컴포넌트 스캔을 통한 빈 등록
@Component
public class JwtTokenExpireProvider {
    // TODO: application.properties 의 security-jwt-token-expire-length 값을 활용하여 validityInMilliseconds 값 초기화 하기
    private final long validityInMilliseconds;

    public JwtTokenExpireProvider(@Value("${security-jwt-token-expire-length}") long validityInMilliseconds) {
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }
}
