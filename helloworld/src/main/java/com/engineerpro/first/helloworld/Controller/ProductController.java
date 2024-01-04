package com.engineerpro.first.helloworld.Controller;

import com.engineerpro.first.helloworld.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<?> getProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("getProduct here");
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return  ResponseEntity.ok("Product ID:" +productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String productId){
        return ResponseEntity.status(HttpStatus.OK).body("Product delete successfully");
    }
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult result) {
        try {
            if (result.hasErrors()){
                List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errorMessages.toString());
            }
            List<MultipartFile> files = productDTO.getFiles();
            files = files ==null ? new ArrayList<MultipartFile>():files;
            for (MultipartFile file : files){
                if (file.getSize() == 0){
                    continue;
                }
                if (file.getSize() >10*1024*1024){
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File greater than 10MB");
                }
                String contentType = file.getContentType();
                if (contentType == null && !contentType.startsWith("image/")){
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File must be image");
                }
                String fileName = storeFile(file);
                productDTO.setThumbnail(fileName);
            }

            return ResponseEntity.ok("Product create successfully");
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    public String storeFile(MultipartFile file) throws IOException {

        String fileName = "";
        fileName = UUID.randomUUID().toString()+ "_" + StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)){
            Files.createDirectories(uploadDir);
        }
        Path destination = Paths.get(uploadDir.toString(), fileName);
        //Sao chep duong dan
        Files.copy(file.getInputStream(),destination, StandardCopyOption.REPLACE_EXISTING);
        return  fileName;
    }
}
