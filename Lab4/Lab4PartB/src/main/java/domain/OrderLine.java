package domain;


import jakarta.persistence.*;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private long id;

	private int quantity;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Product product;

	public OrderLine() {
	}

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderLine{" +
				"id=" + id +
				", quantity=" + quantity +
				", product=" + product +
				'}';
	}
}
