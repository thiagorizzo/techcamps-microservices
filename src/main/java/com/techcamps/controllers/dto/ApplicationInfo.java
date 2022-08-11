package com.techcamps.controllers.dto;

import java.util.UUID;

public class ApplicationInfo {
    private UUID uuid;
    private int applicationVersion;

    public ApplicationInfo(UUID uuid, int applicationVersion) {
        this.uuid = uuid;
        this.applicationVersion = applicationVersion;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(int applicationVersion) {
        this.applicationVersion = applicationVersion;
    }
}
