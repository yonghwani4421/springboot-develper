package me.yonghwan.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.yonghwan.springbootdeveloper.domain.RefreshToken;
import me.yonghwan.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected Token") );
    }
}
