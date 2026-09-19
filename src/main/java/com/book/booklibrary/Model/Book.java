package com.book.booklibrary.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please enter a book name.")
    @Size(max = 120, message = "Book name must be 120 characters or fewer.")
    private String name;

    @NotBlank(message = "Please enter a description.")
    @Size(max = 1000, message = "Description must be 1000 characters or fewer.")
    private String description;

    @Size(max = 500, message = "Image URL must be 500 characters or fewer.")
    @Pattern(regexp = "^$|https?://.+", message = "Use a valid http:// or https:// image URL.")
    private String imageName;

    @Size(max = 500, message = "Video URL must be 500 characters or fewer.")
    @Pattern(regexp = "^$|https?://.+", message = "Use a valid http:// or https:// video URL.")
    private String videoUrl;
}