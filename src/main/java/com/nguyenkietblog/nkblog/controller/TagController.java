package com.nguyenkietblog.nkblog.controller;

import com.nguyenkietblog.nkblog.entity.ServiceResult;
import com.nguyenkietblog.nkblog.entity.Tag;
import com.nguyenkietblog.nkblog.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public ResponseEntity<ServiceResult> findAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(),HttpStatus.OK);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<ServiceResult> getPostsByTag( @PathVariable("id") Long tagId) {
        return new ResponseEntity<>(tagService.getPostByTag(tagId),HttpStatus.OK);
    }

    @PostMapping("/tag")
    public ResponseEntity<ServiceResult> saveTag(@RequestBody Tag tag) {

        return new ResponseEntity<>(tagService.saveTag(tag), HttpStatus.OK);
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<ServiceResult> putTag(
            @PathVariable("id") Long tagId,
            @RequestBody Tag tag
            ) {
        return new ResponseEntity<>(tagService.updateTag(tagId, tag), HttpStatus.OK);
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<ServiceResult>  deleteTag(@PathVariable("id") Long tagId) {
        return new ResponseEntity<>(tagService.deleteTag(tagId), HttpStatus.OK);
    }
}
