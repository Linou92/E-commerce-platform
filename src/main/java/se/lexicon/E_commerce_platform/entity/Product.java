package se.lexicon.E_commerce_platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "products")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    // since the DB has a separate product_images table, elementCollection creates a separate table for the string
    @ElementCollection
    @CollectionTable(name="product_images", joinColumns = @JoinColumn(name="product_id"))
    @Column(name="image_url")
    private List<String> imageUrls;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // many products -> one category
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

}
