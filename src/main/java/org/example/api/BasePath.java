package org.example.api;

public enum BasePath {
    API_FOLDERS("/api/folders"),
    API_FOLDERS_BY_ID("/api/folders/{id}/project"),
    HOME("/uk/home"),
    API_V2_PROJECTS("/api/v2/projects"),
    API_V2_PROJECT_BY_ID("/api/v2/projects/{id}"),
    API_PROJECTS_FILTER_NO_TRASH("/api/projects/filter/no-trash"),
    //API_PROJECTS_MULTI_IDS("/api/projects/multi/?ids={id}"); //? -> query params
    API_PROJECTS_MULTI("/api/projects/multi/");

    final String path;

    BasePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
