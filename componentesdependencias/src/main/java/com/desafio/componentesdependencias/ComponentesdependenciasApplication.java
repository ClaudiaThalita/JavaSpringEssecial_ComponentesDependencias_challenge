package com.desafio.componentesdependencias;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.componentesdependencias.entities.Order;
import com.desafio.componentesdependencias.services.OrderService;
import com.desafio.componentesdependencias.services.ShippingService;

@SpringBootApplication
public class ComponentesdependenciasApplication {

	public static void main(String[] args) {

		SpringApplication.run(ComponentesdependenciasApplication.class, args);
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		

		
		System.out.print("Código do Pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Valor do pedido: ");
		double basic = sc.nextDouble();
		System.out.print("Valor do desconto: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code,basic,discount);
		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService(shippingService);


		double valorTotal = orderService.total(order);
		System.out.printf("Pedido código = %d%n", code);
		System.out.printf("Valor Total = %.2f%n", valorTotal);
		sc.close();
	}

}
