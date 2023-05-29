package org.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Setter
@Getter
@NonNull
public class FolderLombokDTO {
    private Long createdAt;
    private Boolean removed;
    private String name;
    private String id;
    private String userId;
    private String folderType;
    private Long updatedAt;
    private Boolean trash;
}