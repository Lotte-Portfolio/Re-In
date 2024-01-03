package com.rein.dto;

import lombok.*;
import com.rein.entity.File;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDTO {
    private Long id;
    private String originFilename;
    private String filename;
    private String filePath;

    public File toEntity() {
        File build = File.builder()
                .id(id)
                .originFilename(originFilename)
                .filename(filename)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public FileDTO(Long id, String originFilename, String filename, String filePath) {
        this.id = id;
        this.originFilename = originFilename;
        this.filename = filename;
        this.filePath = filePath;
    }
}
