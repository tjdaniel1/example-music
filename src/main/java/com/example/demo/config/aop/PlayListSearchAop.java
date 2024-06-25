package com.example.demo.config.aop;

import com.example.demo.domain.dto.MusicSearchDto;
import com.example.demo.domain.dto.PlaylistSearchDto;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;

@Aspect
@Component
public class PlayListSearchAop {
    @Before("@annotation(PlayListSearchParam) && execution(* com.example.demo.controller.*(..))")
    public PlaylistSearchDto aroundMusicSearch() throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        assert request != null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        String name = parameterMap.get("name") != null ? parameterMap.get("name")[0] : null;
        return new PlaylistSearchDto(name);

    }
}
