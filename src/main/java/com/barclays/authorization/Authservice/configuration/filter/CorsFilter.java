//package com.barclays.authorization.Authservice.configuration.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//import org.springframework.web.cors.*;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.persistence.PrimaryKeyJoinColumn;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class CorsFilter {
//
////    @Autowired
////    @Qualifier("CorsConfigurationSource")
////    private final CorsConfigurationSource configSource;
////    private CorsProcessor processor = new DefaultCorsProcessor();
////
////    public CorsFilter(CorsConfigurationSource configSource) {
////        Assert.notNull(configSource, "CorsConfigurationSource must not be null");
////        this.configSource = configSource;
////    }
////
////    public void setCorsProcessor(CorsProcessor processor) {
////        Assert.notNull(processor, "CorsProcessor must not be null");
////        this.processor = processor;
////    }
////
////
////    @Override
////    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
////        if (CorsUtils.isCorsRequest(httpServletRequest)) {
////            CorsConfiguration corsConfiguration = this.configSource.getCorsConfiguration(httpServletRequest);
////            if (corsConfiguration != null) {
////                boolean isValid = this.processor.processRequest(corsConfiguration, httpServletRequest, httpServletResponse);
////                if (!isValid || CorsUtils.isPreFlightRequest(httpServletRequest)) {
////                    return;
////                }
////            }
////        }
////
////        filterChain.doFilter(httpServletRequest, httpServletResponse);
////    }
//}
