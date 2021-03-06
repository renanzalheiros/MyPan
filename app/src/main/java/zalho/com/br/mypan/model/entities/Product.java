package zalho.com.br.mypan.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by andrepereira on 04/06/17.
 */

public class Product implements Serializable {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String file;

    public Product() {
    }

    public Product(String id, String name, String description, BigDecimal price, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.file = imagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductImagePath() {
        return file;
    }

    public void setProductImagePath(String productImagePath) {
        this.file = productImagePath;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getDescription() + " " + this.getPrice();
    }
}
