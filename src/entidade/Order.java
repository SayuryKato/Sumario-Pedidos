package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.enums.OrdemStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private OrdemStatus status;
	
	private Cliente cliente;
	private List<OrdemItem> items = new ArrayList<>();

	public Order(Date momento, OrdemStatus status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemItem> getItens() {
		return items;
	}
	
	public void addItem(OrdemItem item) {
		items.add(item);
	}

	public void removeItem(OrdemItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrdemItem item : items) {
			sum += item.SubTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(momento) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(cliente + "\n");
		sb.append("Order items:\n");
		for (OrdemItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
	
	
	
	


	


}
