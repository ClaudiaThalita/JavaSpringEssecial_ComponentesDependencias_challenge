package com.desafio.componentesdependencias.services;

import org.springframework.stereotype.Service;

import com.desafio.componentesdependencias.entities.Order;

@Service
public class OrderService {

	public ShippingService shippingservice;

	public OrderService(ShippingService shippingservice) {
		this.shippingservice = shippingservice;
	}

	public double total(Order order) {
		Double total = order.getBasic() - (order.getBasic()*((order.getDiscount()/100)));
		Double frete = shippingservice.shippement(order.getBasic());
		return  total + frete;
				}

	
}
