package com.example.demo.config.aop;

import com.example.demo.domain.dto.MusicSearchDto;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;

@Aspect
@Component
public class MusicSearchAop {
    @Before("@annotation(MusicSearchParam) && execution(* com.example.demo.controller.*(..))")
    public MusicSearchDto aroundMusicSearch() throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        assert request != null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        String title = parameterMap.get("title") != null ? parameterMap.get("title")[0] : null;
        String artist = parameterMap.get("artist") != null ? parameterMap.get("artist")[0] : null;
        String genre = parameterMap.get("genre") != null ? parameterMap.get("genre")[0] : null;
        return new MusicSearchDto(title, artist, genre);

    }
}
