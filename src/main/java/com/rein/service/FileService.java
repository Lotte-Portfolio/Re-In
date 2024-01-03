package com.rein.service;

import com.rein.dto.FileDTO;
import com.rein.entity.File;
import com.rein.repository.FileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDTO fileDTO) {
        return fileRepository.save(fileDTO.toEntity()).getId();
    }

    @Transactional
    public FileDTO getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDTO fileDTO = FileDTO.builder()
                .id(id)
                .originFilename(file.getOriginFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDTO;
    }

}
