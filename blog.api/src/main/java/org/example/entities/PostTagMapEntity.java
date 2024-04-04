package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tbl_post_tag_map")
@Data
public class PostTagMapEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;

}

