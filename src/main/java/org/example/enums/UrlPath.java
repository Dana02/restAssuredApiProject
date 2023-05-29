package org.example.enums;

public enum UrlPath {
    LOGIN_PAGE_PATH("/login/"),
    SIGNUP_PAGE_PATH("/signup/"),
    MY_PROJECTS_PAGE("/user/projects/");

    final String path;

    UrlPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
