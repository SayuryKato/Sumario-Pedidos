package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.OrdemItem;
import entidade.Order;
import entidade.Produto;
import modelo.enums.OrdemStatus;

public class Programa1 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Digite os dados do cliente:\n");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("\nEmail:");
		String email = sc.nextLine();
		System.out.print("\nData de nascimento (DD/MM/YYYY):");
		Date nascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, nascimento);
		
		System.out.println("Entre com os dados: ");
		System.out.print("Status: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, cliente);
		
		System.out.print("Quantidade de Item: ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Digite os dados do item #" + i);
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preco: ");
			double preco = sc.nextDouble();

			Produto produto = new Produto(name, preco);

			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();

			OrdemItem orderItem = new OrdemItem(quantidade, preco, produto); 

			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("SUMARIO:");
		System.out.println(order);
		
		sc.close();

	}

}
