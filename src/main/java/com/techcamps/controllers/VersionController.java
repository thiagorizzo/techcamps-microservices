package com.techcamps.controllers;

import com.techcamps.controllers.dto.ApplicationInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/version")
public class VersionController {
    @Value("${application.version}")
    private int applicationVersion = 1;

    private static final UUID UUID = java.util.UUID.randomUUID();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationInfo> getVersion()  {
        ApplicationInfo applicationInfo = new ApplicationInfo(UUID, this.applicationVersion);

        return new ResponseEntity<ApplicationInfo>(applicationInfo, HttpStatus.OK);
    }
}
