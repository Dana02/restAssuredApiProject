package org.example.dto;

public class FolderDTO {
    private final String id;
    private final String userId;
    private final String name;
    private final Boolean removed;
    private final Long createdAt;
    private final Long updatedAt;
    private final String folderType;

    public FolderDTO(String id, String userId, String name, Boolean removed, Long createdAt, Long updatedAt, String folderType) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.removed = removed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.folderType = folderType;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Boolean getRemoved() {
        return removed;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getFolderType() {
        return folderType;
    }
}
