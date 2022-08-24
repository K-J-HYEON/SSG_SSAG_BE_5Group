package com.ssg.ssg_be.history.presentation;

import com.ssg.ssg_be.history.application.HistoryService;
import com.ssg.utils.jwt.JwtTokenProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HistoryController {

    private final HistoryService historyService;
    private final JwtTokenProvider jwtTokenProvider;

    public HistoryController(HistoryService historyService, JwtTokenProvider jwtTokenProvider) {
        this.historyService = historyService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

}
