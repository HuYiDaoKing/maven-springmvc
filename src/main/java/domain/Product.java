package domain;
import java.io.Serializable;


/**
 * Product类实现了java.io.Serializable接口，其实例可以安全地将数据保存到HttpSession中。
 */
public class Product implements Serializable
{
    private static final long serialVersionUID = 4316534618756633564L;

    private long id;

    private String name;

    private String description;

    private float price;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

}
