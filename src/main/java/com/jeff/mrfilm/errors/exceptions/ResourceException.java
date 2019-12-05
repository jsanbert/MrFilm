package com.jeff.mrfilm.errors.exceptions;

public class ResourceException extends RuntimeException {
    public static final int NOT_FOUND = 0;
    public static final int ALREADY_EXISTS = 1;

    private Long resourceId;
    private String resourceName;
    private int type;

    public ResourceException(Long resourceId, String resourceName, int type) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.type = type;
    }

    public ResourceException(String s, Long resourceId, String resourceName, int type) {
        super(s);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.type = type;
    }

    public ResourceException(String s, Throwable throwable, Long resourceId, String resourceName, int type) {
        super(s, throwable);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.type = type;
    }

    public ResourceException(Throwable throwable, Long resourceId, String resourceName, int type) {
        super(throwable);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.type = type;
    }

    public ResourceException(String s, Throwable throwable, boolean b, boolean b1, Long resourceId, String resourceName, int type) {
        super(s, throwable, b, b1);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.type = type;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
